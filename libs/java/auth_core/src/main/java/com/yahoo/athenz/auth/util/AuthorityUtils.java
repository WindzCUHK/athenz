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
package com.yahoo.athenz.auth.util;

import com.yahoo.athenz.auth.AuthorityConsts;

/**
 * Utility class for Authority
 */
public class AuthorityUtils {

	/**
	 * split principal to domain and service
	 * @param  name principal
	 * @return      [domain, service]
	 */
	public static final String[] splitPrincipalName(String name) {
		// all the role members in Athens are normalized to lower case
		String principalName = name.toLowerCase();
		int idx = principalName.lastIndexOf(AuthorityConsts.ATHENZ_PRINCIPAL_DELIMITER_CHAR);
		if (idx == -1) {
			return null;
		}

		return new String[]{principalName.substring(0, idx), principalName.substring(idx + 1)};
	}

	/**
	 * join domain and service to principal format
	 * @param  domain
	 * @param  service
	 * @return principal
	 */
	public static final String getPrincipalName(String domain, String service) {
		return domain + AuthorityConsts.ATHENZ_PRINCIPAL_DELIMITER + service;
	}

	// prevent object creation
	private AuthorityUtils() {}

}
