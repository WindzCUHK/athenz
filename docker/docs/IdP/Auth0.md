<a id="markdown-setup-auth0-as-athenz-oauth-idp" name="setup-auth0-as-athenz-oauth-idp"></a>
# Setup Auth0 as Athenz OAuth IdP

<!-- TOC -->

- [Setup Auth0 as Athenz OAuth IdP](#setup-auth0-as-athenz-oauth-idp)
    - [Target](#target)
    - [Setup Auth0](#setup-auth0)
    - [Setup custom claims](#setup-custom-claims)
    - [Setup Athenz Authority](#setup-athenz-authority)
    - [Get access token](#get-access-token)
    - [[WIP] Verify access token against ZMS](#wip-verify-access-token-against-zms)
    - [Reference](#reference)

<!-- /TOC -->

<a id="markdown-target" name="target"></a>
## Target
1. Use Github for user management.
1. Get access token from Auth0.
1. Authorize access token issued by Auth0 to access ZMS API
1. OAuth2 Terminology
    | Terminology | Actual Party |
    |---|---|
    | Resource owner | Github account |
    | Authorization server | Auth0 |
    | Client | My-Athenz-SPA |
    | Resource server | Athenz-ZMS-API |

<a id="markdown-setup-auth0" name="setup-auth0"></a>
## Setup Auth0
1. [Auth0 Sign Up](https://auth0.com/signup)
    1. copy your domain (e.g. `athenz-oauth-example.auth0.com`)
1. Connect to Github. [Connect your app to GitHub](https://auth0.com/docs/connections/social/github)
1. Create an application in auth0. [Register a Single-Page Application](https://auth0.com/docs/dashboard/guides/applications/register-app-spa)
    1. sample configuration
        ```
        Name: My-Athenz-SPA
        Application Type: Single Page Web Applications

        Allowed Callback URLs: http://localhost:3000
        Allowed Web Origins: http://localhost:3000
        ```
    1. make sure to click `SAVE CHANGES` button at the bottom
    1. copy `Client ID` in `Settings` (e.g. `hpnaS7d6NmBHx4QdejenfY4kgx4RdTPH`)
    1. make sure `Connections > github` is `ON`
1. Setup an API in auth0. [Set Up an API](https://auth0.com/docs/getting-started/set-up-api)
    1. sample configuration
        ```
        Name: Athenz-ZMS-API
        Identifier: https://zms.athenz.io
        ```

<a id="markdown-setup-custom-claims" name="setup-custom-claims"></a>
## Setup custom claims

1. [Create Rules](https://auth0.com/docs/dashboard/guides/rules/create-rules)
1. [optional] [Store Configuration for Rules](https://auth0.com/docs/rules/guides/configuration)
    - add `{ "Key": "CERT_THUMB", "Value": "<certificate_thumbprint>" }`  
        - For the specification of `<certificate_thumbprint>`, please refer to [RFC 8705 - OAuth 2.0 Mutual-TLS Client Authentication and Certificate-Bound Access Tokens#section-3.1](https://tools.ietf.org/html/rfc8705#section-3.1)
    - Note:
        - Auth0 does not support certificate bound access token currently. To support it, you need to manually manage and inject your client's certificate thumbprint.
        - To simplify the setup, we are going to disable the certificate thumbprint verification in Athenz ZMS server.
1. [Customize the Tokens](https://auth0.com/docs/api-auth/tutorials/authorization-code-grant-pkce#optional-customize-the-tokens)
    ```js
    // sample rules
    function (user, context, callback) {
        const namespace = 'https://myapp.example.com/';
        const athenzDomain = 'testing-domain';
        const req = context.request;

        // 1. append request scopes
        // Get requested scopes
        let scopes = (req.query && req.query.scope) || (req.body && req.body.scope);
        // Normalize scopes into an array
        scopes = (scopes && scopes.split(" ")) || [];
        // append
        context.accessToken.scope = scopes;

        // 2. add client ID
        // azp === client_id
        context.accessToken[namespace + 'client_id'] = (athenzDomain + '.' + context.clientName).toLowerCase();

        // 3. [optional] inject certificate thumbprint
        // const CERT_THUMB = configuration.CERT_THUMB;
        // context.accessToken[namespace + 'cnf'] = { 'x5t#S256': CERT_THUMB };

        callback(null, user, context);
    }
    ```

<a id="markdown-setup-athenz-authority" name="setup-athenz-authority"></a>
## Setup Athenz Authority

> Reference: [contributions/authority/auth0](../../../contributions/authority/auth0)

1. build `athenz_auth_auth0-*.jar` and move it to `"${DOCKER_DIR}/jars/"`
1. append the below sample properies to [zms.properies](../../zms/conf/zms.properties) (Update the following `https://athenz-oauth-example.auth0.com/` domain to your own domain)
    ```properties
    athenz.auth.oauth.jwt.authn_challenge_realm=registered_users@athenz.io
    athenz.auth.oauth.jwt.cert.exclude_role_certificates=false
    athenz.auth.oauth.jwt.cert.excluded_principals=

    # Auth0 does not support certificate bound access token currently
    athenz.auth.oauth.jwt.verify_cert_thumbprint=false
    athenz.auth.oauth.jwt.client_id_map_path=

    ### setting for Auth0 JWT validator
    athenz.auth.oauth.jwt.claim.iss=https://athenz-oauth-example.auth0.com/
    athenz.auth.oauth.jwt.claim.aud=https://zms.athenz.io
    athenz.auth.oauth.jwt.claim.scope=openid https://zms.athenz.io/zms/v1

    ### setting for Auth0 JWT parser
    athenz.auth.oauth.jwt.parser_factory_class=com.yahoo.athenz.auth.oauth.auth0.Auth0JwtParserFactory
    athenz.auth.oauth.jwt.parser.jwks_url=https://athenz-oauth-example.auth0.com/.well-known/jwks.json
    athenz.auth.oauth.jwt.auth0.claim_client_id=https://athenz-oauth-example.auth0.com/client_id
    athenz.auth.oauth.jwt.auth0.claim_confirm=https://athenz-oauth-example.auth0.com/cnf
    athenz.auth.oauth.jwt.athenz.user_domain=user
    ```
1. update the `DOMAIN_ADMIN` value in [env.sh](../../env.sh) to your github user ID
    1. If you are using `DEV` deployment, please update the `DEV_DOMAIN_ADMIN` value in [env.dev.sh](../../sample/env.dev.sh)
1. re-deploy ZMS

<a id="markdown-get-access-token" name="get-access-token"></a>
## Get access token
1. For `code_challenge`, please refer to [Execute an Authorization Code Grant Flow with PKCE](https://auth0.com/docs/api-auth/tutorials/authorization-code-grant-pkce).
    - sample values
        ```
        verifier: LQoKwSy9djyuHHqr6h3yOYaEA9Mq9uap_u8mXpk1fBM
        challenge: soLgG9cEekJtNh23GxQ1hB4AbqKjcVrkOTWVXMqiUMY
        ```
1. Create request URL to get the authorization code.
    ```bash
    DOMAIN='athenz-oauth-example.auth0.com'
    CLIENT_ID='hpnaS7d6NmBHx4QdejenfY4kgx4RdTPH'
    REDIRECT_URI='http%3A%2F%2Flocalhost%3A3000'

    API_AUDIENCE='https%3A%2F%2Fzms.athenz.io'
    SCOPE='openid%20https%3A%2F%2Fzms.athenz.io%2Fzms%2Fv1' # openid https://zms.athenz.io/zms/v1
    CODE_CHALLENGE='soLgG9cEekJtNh23GxQ1hB4AbqKjcVrkOTWVXMqiUMY'

    tr -d '[:space:]' << CURL_EOF; echo "";
    https://${DOMAIN}/authorize?
        audience=${API_AUDIENCE}&
        scope=${SCOPE}&
        response_type=code&
        client_id=${CLIENT_ID}&
        code_challenge=${CODE_CHALLENGE}&
        code_challenge_method=S256&
        redirect_uri=${REDIRECT_URI}
    CURL_EOF
    ```
    ```bash
    # sample output
    https://athenz-oauth-example.auth0.com/authorize?audience=athenz%2Fzms&scope=openid%20zms%2Fv1&response_type=code&client_id=hpnaS7d6NmBHx4QdejenfY4kgx4RdTPH&code_challenge=soLgG9cEekJtNh23GxQ1hB4AbqKjcVrkOTWVXMqiUMY&code_challenge_method=S256&redirect_uri=http%3A%2F%2Flocalhost%3A3000
    ```
1. Open your browser in incognito mode (prevent messing up the cookies).
    1. Paste the URL.
    1. The `Sign In with Auth0` page should show up.
    1. Choose `LOG IN WITH GITHUB` and login with the connected Github account.
    1. Authorize the app by clicking the `YES` button.
    1. The browser will be redirected to the callback URL.
    1. Showing error? Don't panic. It is normal for the browser to show error like `ERR_CONNECTION_REFUSED`, as we do not have a server to handle the callback.
    1. Check the browser's address bar. It should have the callback URL with the authorization code (e.g. `http://localhost:3000/?code=NJDuaMpm1R4A6vL4`).
1. Copy the authorization code at the end of the redirected URL (e.g. `NJDuaMpm1R4A6vL4`).
1. Update the authorization code in below code block and execute the command to exchange for the access token. (duplicated env. variables are skipped.)
    ```bash
    YOUR_GENERATED_CODE_VERIFIER='LQoKwSy9djyuHHqr6h3yOYaEA9Mq9uap_u8mXpk1fBM'
    YOUR_AUTHORIZATION_CODE='NJDuaMpm1R4A6vL4'

    curl --request POST \
        --url "https://${DOMAIN}/oauth/token" \
        --header 'content-type: application/x-www-form-urlencoded' \
        --data grant_type=authorization_code \
        --data "client_id=${CLIENT_ID}" \
        --data "code_verifier=${YOUR_GENERATED_CODE_VERIFIER}" \
        --data "code=${YOUR_AUTHORIZATION_CODE}" \
        --data "redirect_uri=${REDIRECT_URI}"; echo "";
    ```
    ```bash
    # sample output
    {
        "access_token": "...",
        "scope": "openid https://zms.athenz.io/zms/v1",
        "expires_in": 86400,
        "token_type": "Bearer"
    }
    ```
1. You can check the JWT and its claims in [JWT.IO](https://jwt.io/)
1. To get the JWKS to verify your JWT, `curl "https://${DOMAIN}/.well-known/jwks.json"; echo "";`

<a id="markdown-wip-verify-access-token-against-zms" name="wip-verify-access-token-against-zms"></a>
## [WIP] Verify access token against ZMS

`WIP`

<a id="markdown-reference" name="reference"></a>
## Reference
- [Auth0 JavaScript SDK Quickstarts: Login](https://auth0.com/docs/quickstart/spa/vanillajs/01-login)
- [Auth0 JavaScript SDK Quickstarts: Calling an API](https://auth0.com/docs/quickstart/spa/vanillajs/02-calling-an-api)
- [Execute an Authorization Code Grant Flow with PKCE](https://auth0.com/docs/api-auth/tutorials/authorization-code-grant-pkce)
- [Authentication API Explorer](https://auth0.com/docs/api/authentication?http#social)
