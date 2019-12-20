FROM athenz-builder AS builder

FROM openjdk:8-jre-alpine

ARG GID=1001
ARG UID=10001

# add athenz user
RUN addgroup -g ${GID} athenz && \
  adduser -S -D -H -s /sbin/nologin -u ${UID} -G athenz athenz
USER athenz

WORKDIR /opt/athenz/zms

COPY --from=builder /opt/athenz/zms .

ENV JAVA_OPTS=''
ENV CLASSPATH='lib/jars/*'
ENV USER_CLASSPATH='/usr/lib/jars/*'
ENV CONF_PATH='conf/zms_server'

# ENV for passwords
ENV ZMS_DB_ADMIN_PASS=''
ENV ZMS_KEYSTORE_PASS=''
ENV ZMS_TRUSTSTORE_PASS=''

ENTRYPOINT ["sh", "-c", "eval $0 $@", "java"]
CMD [ \
  "${JAVA_OPTS}", \
  "-classpath", "${CLASSPATH}:${USER_CLASSPATH}", \
  "-Dathenz.prop_file=${CONF_PATH}/athenz.properties", \
  "-Dathenz.zms.prop_file=${CONF_PATH}/zms.properties", \
  "-Dlogback.configurationFile=${CONF_PATH}/logback.xml", \
  # system properties for passwords
  "-Dathenz.zms.jdbc_password=${ZMS_DB_ADMIN_PASS}", \
  "-Dathenz.ssl_key_store_password=${ZMS_KEYSTORE_PASS}", \
  "-Dathenz.ssl_trust_store_password=${ZMS_TRUSTSTORE_PASS}", \
  # main class
  "com.yahoo.athenz.container.AthenzJettyContainer" \
]

# ENV for healthcheck
ENV ZMS_PORT='8443'
ENV ZMS_HC_TRUSTSTORE_PATH='/opt/athenz/zms/var/certs/zms_truststore.jks'
ENV ZMS_HC_TRUSTSTORE_TYPE='JKS'
ENV ZMS_HC_TRUSTSTORE_PASS="${ZMS_TRUSTSTORE_PASS}"

HEALTHCHECK --interval=1m --timeout=3s --start-period=30s --retries=3 \
  CMD java \
  -classpath /opt/athenz/zms/lib/jars \
  "-Djavax.net.ssl.trustStore=${ZMS_HC_TRUSTSTORE_PATH}" \
  "-Djavax.net.ssl.trustStoreType=${ZMS_HC_TRUSTSTORE_TYPE}" \
  "-Djavax.net.ssl.trustStorePassword=${ZMS_HC_TRUSTSTORE_PASS}" \
  JavaHttpsClient zms "${ZMS_PORT}"
