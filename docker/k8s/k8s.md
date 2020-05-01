https://github.com/WindzCUHK/athenz/blob/zms-on-external-IdP/docker/docs/zms-setup.md


export ZMS_DB_ROOT_PASS=<your_password>
export ZMS_DB_ADMIN_PASS=<your_password>
export ZMS_KEYSTORE_PASS=<your_password>
export ZMS_TRUSTSTORE_PASS=<your_password>



# copy your file in the following paths
echo "${ZMS_CERT_KEY_PATH}"
echo "${ZMS_CERT_PATH}"

ls -l "${ATHENZ_CA_PATH}"
ls -l "${USER_CA_PATH}"
ls -l "${SERVICE_CA_PATH}"

```
/zms.properties
```
