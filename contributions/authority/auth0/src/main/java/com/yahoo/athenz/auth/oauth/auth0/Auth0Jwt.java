/*
 * Copyright 2020 Yahoo Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.yahoo.athenz.auth.oauth.auth0;

import java.util.LinkedHashMap;
import com.yahoo.athenz.auth.AuthorityConsts;
import com.yahoo.athenz.auth.oauth.token.DefaultOAuthJwtAccessToken;
import com.yahoo.athenz.auth.oauth.token.OAuthJwtAccessToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

/**
 * Custom for Auth0 JWT access token format
 */
public class Auth0Jwt extends DefaultOAuthJwtAccessToken {

	public static final String CLAIM_CLIENT_ID = "https://myapp.example.com/client_id";
	public static final String CLAIM_CONFIRM = "https://myapp.example.com/cnf";

	private static final String USER_DOMAIN = "user";
	final String userDomain;

	/**
	 * Create Auth0 JWT access token object
	 * @param  jws JWS claims
	 */
	public Auth0Jwt(Jws<Claims> jws) {
		super(jws);
		this.userDomain = System.getProperty(AuthorityConsts.ATHENZ_PROP_USER_DOMAIN, USER_DOMAIN);
	}

	@Override
	public String getSubject() {
		// normalize as Athenz principal
		return (this.userDomain + AuthorityConsts.ATHENZ_PRINCIPAL_DELIMITER_CHAR + this.body.getSubject().replace('|', '-')).toLowerCase();
	}

	@Override
	public String getClientId() {
		return this.body.get(Auth0Jwt.CLAIM_CLIENT_ID, String.class);
	}

	@Override
	public String getCertificateThumbprint() {
		LinkedHashMap<?, ?> certConf = this.body.get(Auth0Jwt.CLAIM_CONFIRM, LinkedHashMap.class);
		return (String) certConf.get(OAuthJwtAccessToken.CLAIM_CONFIRM_X509_HASH);
	}

}
