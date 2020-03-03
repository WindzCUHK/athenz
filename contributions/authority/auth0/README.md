<a id="markdown-athenz-oauth2-access-token-for-auth0" name="athenz-oauth2-access-token-for-auth0"></a>
# Athenz OAuth2 access token for Auth0
Athenz Yahoo Server OAuth2 access token implementation for Auth0

<!-- TOC -->

- [Athenz OAuth2 access token for Auth0](#athenz-oauth2-access-token-for-auth0)
    - [Usage](#usage)
        - [Build](#build)
        - [[WIP] Integrate with Athenz](#wip-integrate-with-athenz)
    - [For developer](#for-developer)
        - [Test coverage](#test-coverage)

<!-- /TOC -->

<a id="markdown-usage" name="usage"></a>
## Usage

<a id="markdown-build" name="build"></a>
### Build
```bash
mvn clean package
ls ./target/athenz_auth_auth0-*.jar
```

<a id="markdown-wip-integrate-with-athenz" name="wip-integrate-with-athenz"></a>
### [WIP] Integrate with Athenz
1. add `athenz_auth_auth0-*.jar` in Athenz server's classpath
1. overwrite existing system property
    ```properties
    # ZMS server
    athenz.zms.metric_factory_class=com.yahoo.athenz.common.metrics.impl.prometheus.PrometheusMetricFactory

    # ZTS server
    athenz.zts.metric_factory_class=com.yahoo.athenz.common.metrics.impl.prometheus.PrometheusMetricFactory
    ```
1. add system property for `PrometheusMetric`
    ```properties
    # enable PrometheusMetric class
    athenz.metrics.prometheus.enable=true
    # export JVM metrics
    athenz.metrics.prometheus.jvm.enable=true
    # the Prometheus /metrics endpoint
    athenz.metrics.prometheus.http_server.enable=true
    athenz.metrics.prometheus.http_server.port=8181
    # Prometheus metric prefix
    athenz.metrics.prometheus.namespace=athenz_zms
    # for dev. env. ONLY, record Athenz domain data as label
    athenz.metrics.prometheus.label.request_domain_name.enable=false
    athenz.metrics.prometheus.label.principal_domain_name.enable=false
    ```

<a id="markdown-for-developer" name="for-developer"></a>
## For developer

<a id="markdown-test-coverage" name="test-coverage"></a>
### Test coverage
```bash
mvn clover:instrument clover:aggregate clover:clover clover:check
open ./target/site/clover/index.html
```
