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

import static org.testng.Assert.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import org.testng.annotations.Test;

public class AuthorityUtilsTest {

	@Test
	public void testSplitPrincipalName() {
		assertEquals(AuthorityUtils.splitPrincipalName("domain.service"), new String[]{"domain", "service"});
	}

	@Test
	public void testGetPrincipalName() {
		assertEquals(AuthorityUtils.getPrincipalName("domain", "service"), "domain.service");
	}

	@Test
	public void testPrivateConstructor() throws Exception {
		Constructor<AuthorityUtils> constructor = AuthorityUtils.class.getDeclaredConstructor();
		assertTrue(Modifier.isPrivate(constructor.getModifiers()));
		constructor.setAccessible(true);
		constructor.newInstance();
	}

}
