<a id="markdown-helm" name="helm"></a>
# helm

<!-- TOC -->

- [helm](#helm)
    - [concerns](#concerns)
    - [preparation](#preparation)
    - [run helm](#run-helm)

<!-- /TOC -->

<a id="markdown-concerns" name="concerns"></a>
## concerns

- [concerns](./concerns.md)

<a id="markdown-preparation" name="preparation"></a>
## preparation

Generate the certificates (you can copy from `./docker/sample`)
```bash
$ tree ./k8s/athenz-zms/files
./k8s/athenz-zms/files
├── conf
│   ├── authorized_client_ids.txt
│   ├── authorized_services.json
│   ├── logback.xml
│   └── solution_templates.json
├── properties
│   ├── athenz.properties
│   └── zms.properties
├── schema
│   └── zms_server.sql
├── script
│   └── wait-for-mysql.sh
└── secrets
    ├── athenz
    │   ├── private.pem
    │   └── public.pem
    └── tls
        ├── CAs
        │   ├── athenz_ca.pem
        │   ├── service_ca.pem
        │   └── user_ca.pem
        ├── zms_cert.pem
        └── zms_key.pem
```


<a id="markdown-run-helm" name="run-helm"></a>
## run helm

```bash
BASE_DIR="`git rev-parse --show-toplevel`"
cd ${BASE_DIR}/docker

# download dependency (exec. once)
helm dependency update ./k8s/athenz-zms
helm lint ./k8s/athenz-zms

# dry run
helm upgrade --install wzzms --namespace default ./k8s/athenz-zms -f ./k8s/athenz-zms/my-values.yaml --dry-run --debug > ./k8s/zms_gen.yaml

# install
helm upgrade --install wzzms --namespace default ./k8s/athenz-zms -f ./k8s/athenz-zms/my-values.yaml
# helm upgrade --install wzzms --namespace default --values <values file> ./k8s/athenz-zms

# uninstall
helm delete --namespace default wzzms

# debug ZMS
kubectl describe $(kubectl get pod -l "app=athenz-zms" -o name)
kubectl logs --tail=30 --all-containers $(kubectl get pod -l "app=athenz-zms" -o name)
kubectl exec -it $(kubectl get pod -l "app=athenz-zms" -o name) -- /bin/sh
less /opt/athenz/zms/logs/zms_server/server.log
# grep "ERROR" /opt/athenz/zms/logs/zms_server/server.log
# ls -l -R /opt/athenz/zms/var
# wget localhost:8181/metrics

# restart ZMS
kubectl delete $(kubectl get pod -l "app=athenz-zms" -o name)
```
```bash
# debug DB
kubectl exec -it wzzms-zms-db-master-0 -- /bin/sh
kubectl logs wzzms-zms-db-master-0
```

```bash
# test ingress
BASE_DIR="`git rev-parse --show-toplevel`"

# ZMS status
ZMS_URL=https://kmaster.wfan.ssk.ynwm.yahoo.co.jp:30007
curl --silent --fail --show-error --request GET -k \
    --url "${ZMS_URL}/zms/v1/status" | jq

# ZMS mTLS
DOMAIN_ADMIN_CERT_KEY_PATH=${BASE_DIR}/docker/sample/domain-admin/domain_admin_key.pem
DOMAIN_ADMIN_CERT_PATH=${BASE_DIR}/docker/sample/domain-admin/domain_admin_cert.pem
curl --silent --fail --show-error --request GET -k \
    --key "${DOMAIN_ADMIN_CERT_KEY_PATH}" \
    --cert "${DOMAIN_ADMIN_CERT_PATH}" \
    --url "${ZMS_URL}/zms/v1/domain/sys.auth/service/zms" | jq

# export DEV_DOMAIN_ADMIN=user.github-1234567
```
