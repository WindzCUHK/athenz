```bash
helm install mariadb-test \
  ./k8s/helm-TEST/mariadb/mariadb \
  -f ./k8s/helm-TEST/mariadb/mariadb_values.yaml \
  --set-file initdbScripts."zms_server\.sql"=/Users/wfan/Desktop/dev/oss/athenz.docker/docker/k8s/athenz-zms/files/schema/zms_server.sql \
  --dry-run --debug

# helm --debug install -f mariadb_values.yaml mariadb-test bitnami/mariadb
# helm --debug upgrade -f mariadb_values.yaml mariadb-test bitnami/mariadb
helm --debug uninstall mariadb-test

kkk logs mariadb-test-master-0

helm template --namespace www bitnami/mariadb | kubectl create -f -
```


```bash
kubectl run mariadb-test-client --rm --tty -i --restart='Never' --image  docker.io/bitnami/mariadb:10.3.22-debian-10-r60 --namespace default --command -- bash
# root
mysql -h mariadb-test.default.svc.cluster.local -uroot -p'mariadb'
# zms_admin
mysql -h mariadb-test.default.svc.cluster.local -uzms_admin -p'athenz'
mysql -h mariadb-test-slave.default.svc.cluster.local -uzms_admin -p'athenz'

# kubectl get secret --namespace default mariadb-test -o jsonpath="{.data.mariadb-root-password}" | base64 --decode; echo
```


```sql
-- show all tables
select table_schema as database_name, table_name
from information_schema.tables
where table_type = 'BASE TABLE'
and table_schema not in ('information_schema','mysql', 'performance_schema','sys')
order by database_name, table_name;

-- show users
SELECT user, host FROM mysql.user;

-- show grants
show grants;
```
