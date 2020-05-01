# domain admin
export DOMAIN_ADMIN="${DOMAIN_ADMIN:-user.github-7654321}"
### ZMS passwords
export ZMS_DB_ROOT_PASS="${ZMS_DB_ROOT_PASS:-mariadb}"
export ZMS_DB_ADMIN_PASS="${ZMS_DB_ADMIN_PASS:-mariadbmariadb}"
export ZMS_KEYSTORE_PASS="${ZMS_KEYSTORE_PASS:-athenz}"
export ZMS_TRUSTSTORE_PASS="${ZMS_TRUSTSTORE_PASS:-athenz}"
### ZTS passwords
export ZTS_DB_ROOT_PASS="${ZTS_DB_ROOT_PASS:-mariadb}"
export ZTS_DB_ADMIN_PASS="${ZTS_DB_ADMIN_PASS:-mariadbmariadb}"
export ZTS_KEYSTORE_PASS="${ZTS_KEYSTORE_PASS:-athenz}"
export ZTS_TRUSTSTORE_PASS="${ZTS_TRUSTSTORE_PASS:-athenz}"
export ZTS_SIGNER_KEYSTORE_PASS="${ZTS_SIGNER_KEYSTORE_PASS:-athenz}"
export ZTS_SIGNER_TRUSTSTORE_PASS="${ZTS_SIGNER_TRUSTSTORE_PASS:-athenz}"
export ZMS_CLIENT_KEYSTORE_PASS="${ZMS_CLIENT_KEYSTORE_PASS:-athenz}"
export ZMS_CLIENT_TRUSTSTORE_PASS="${ZMS_CLIENT_TRUSTSTORE_PASS:-athenz}"
# export ZTS_JAVAX_TRUSTSTORE_PASS="${ZTS_JAVAX_TRUSTSTORE_PASS:-athenz}"



kubectl apply -f ./secret-pod.yaml

kubectl exec -it secret-test-pod -- /bin/bash
ls /etc/secret-volume

exit

### actual script
kubectl create namespace athenz-dev
kubectl config set-context --current --namespace=athenz-dev

# kubectl delete secret
kubectl create secret generic athenz-zms-db-root-secret \
  --from-literal=password='mariadb'
kubectl create secret generic athenz-zms-db-admin-secret \
  --from-literal=username='zms_admin' \
  --from-literal=password='mariadbmariadb'
kubectl create secret generic athenz-zms-server-secret \
  --from-literal=domain_admin='user.github-7654321' \
  --from-literal=keystore_pass='athenz' \
  --from-literal=truststore_pass='athenz'

# kubectl delete cm
kubectl create cm athenz-zms-db-config --from-file=./db/zms/zms-db.cnf


