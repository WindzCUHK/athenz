/*
 * Copyright 2020 Yahoo Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.yahoo.athenz.auth.oauth.auth0;

import com.yahoo.athenz.auth.KeyStore;
import com.yahoo.athenz.auth.oauth.parser.DefaultOAuthJwtAccessTokenParserFactory;
import com.yahoo.athenz.auth.oauth.parser.OAuthJwtAccessTokenParser;

/**
 * Factory class load Auth0 customized system properties
 */
public class Auth0JwtParserFactory extends DefaultOAuthJwtAccessTokenParserFactory {

	@Override
	public OAuthJwtAccessTokenParser create(KeyStore keyStore) throws IllegalArgumentException {
		String jwksUrl = getProperty.apply(JWKS_URL, "https://athenz.io/jwks.json");

		return new Auth0JwtParser(keyStore, jwksUrl);
	}

}
