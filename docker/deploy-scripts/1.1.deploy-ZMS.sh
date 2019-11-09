#!/bin/sh

# to script directory
cd "$(dirname "$0")"

# to ${PROJECT_ROOT}/docker
cd ../

# variables
DOCKER_NETWORK=${DOCKER_NETWORK:-athenz}
ZMS_DB_HOST=${ZMS_DB_HOST:-athenz-zms-db}
ZMS_DB_PORT=${ZMS_DB_PORT:-3306}
ZMS_HOST=${ZMS_HOST:-athenz-zms-server}
ZMS_PORT=${ZMS_PORT:-4443}

# check password
[[ -z "$ZMS_DB_ROOT_PASS" ]] && echo "ZMS_DB_ROOT_PASS not set" && exit 1
[[ -z "$ZMS_DB_ADMIN_PASS" ]] && echo "ZMS_DB_ADMIN_PASS not set" && exit 1

# start ZMS DB
printf "\nWill start ZMS DB...\n"
docker run -d -h "${ZMS_DB_HOST}" \
  -p "${ZMS_DB_PORT}:${ZMS_DB_PORT}" \
  --network="${DOCKER_NETWORK}" \
  --user mysql:mysql \
  -v "`pwd`/db/zms/zms-db.cnf:/etc/mysql/conf.d/zms-db.cnf" \
  -e "MYSQL_ROOT_PASSWORD=${ZMS_DB_ROOT_PASS}" \
  --name "${ZMS_DB_HOST}" athenz-zms-db

# wait for ZMS DB ready
docker run --rm \
  --network="${DOCKER_NETWORK}" \
  --user "$(id -u):$(id -g)" \
  -v "`pwd`/deploy-scripts/common/wait-for-mysql/wait-for-mysql.sh:/bin/wait-for-mysql.sh" \
  -v "`pwd`/db/zms/zms-db.cnf:/etc/my.cnf" \
  -e "MYSQL_PWD=${ZMS_DB_ROOT_PASS}" \
  --name wait-for-mysql athenz-zms-db \
  /bin/wait-for-mysql.sh ${ZMS_DB_HOST}

# add zms_admin
printf "\nWill add zms_admin user to DB and remove root user with wildcard host...\n"
docker exec --user "$(id -u):$(id -g)" "${ZMS_DB_HOST}" mysql \
  --database=zms_server \
  --user=root --password="${ZMS_DB_ROOT_PASS}" \
  --execute="CREATE USER 'zms_admin'@'${ZMS_HOST}.${DOCKER_NETWORK}' IDENTIFIED BY '${ZMS_DB_ADMIN_PASS}'; GRANT ALL PRIVILEGES ON zms_server.* TO 'zms_admin'@'${ZMS_HOST}.${DOCKER_NETWORK}'; FLUSH PRIVILEGES;"
docker exec --user "$(id -u):$(id -g)" "${ZMS_DB_HOST}" mysql \
  --database=mysql \
  --user=root --password="${ZMS_DB_ROOT_PASS}" \
  --execute="DELETE FROM user WHERE user = 'root' AND host = '%';"
docker exec --user "$(id -u):$(id -g)" "${ZMS_DB_HOST}" mysql \
  --database=mysql \
  --user=root --password="${ZMS_DB_ROOT_PASS}" \
  --execute="SELECT host, user FROM user;"

# start ZMS
printf "\nWill start ZMS server...\n"
docker run -d -h "${ZMS_HOST}" \
  -p "${ZMS_PORT}:${ZMS_PORT}" \
  --network="${DOCKER_NETWORK}" \
  --user "$(id -u):$(id -g)" \
  -v "`pwd`/zms/var:/opt/athenz/zms/var" \
  -v "`pwd`/zms/conf:/opt/athenz/zms/conf/zms_server" \
  -v "`pwd`/logs/zms:/opt/athenz/zms/logs/zms_server" \
  -v "`pwd`/jars:/usr/lib/jars" \
  -e "ZMS_DB_ADMIN_PASS=${ZMS_DB_ADMIN_PASS}" \
  -e "ZMS_KEYSTORE_PASS=${ZMS_KEYSTORE_PASS}" \
  -e "ZMS_TRUSTSTORE_PASS=${ZMS_TRUSTSTORE_PASS}" \
  --name "${ZMS_HOST}" athenz-zms-server

# wait for ZMS to be ready
printf "\nWill wait for ZMS to be ready...\n"
until docker run --rm --entrypoint curl \
  --network="${DOCKER_NETWORK}" \
  --user "$(id -u):$(id -g)" \
  --name athenz-curl appropriate/curl \
  -k --silent --output /dev/null "https://${ZMS_HOST}:${ZMS_PORT}/zms/v1/status" \
  ; do
  echo 'ZMS is unavailable - will sleep 3s...'
  sleep 3
done
echo 'ZMS is up!'
