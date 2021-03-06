/*
 * Copyright 2012 SURFnet bv, The Netherlands
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package uk.ac.edukapp.shibboleth;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.PrincipalCollection;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import uk.ac.edukapp.model.Useraccount;
import uk.ac.edukapp.service.UserAccountService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

/**
 * Tests for ShibbolethRealm.
 *
 * @author Geert van der Ploeg
 */
public class ShibbolethRealmTest {

  @Mock
  private UserAccountService userAccountService;

  @InjectMocks
  private ShibbolethRealm realm;

  @Before
  public void before() {
    realm = new ShibbolethRealm();
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void testSupports() {
    assertFalse(realm.supports(new UsernamePasswordToken()));
    assertTrue(realm.supports(new ShibbolethToken("user", null)));
  }

  @Test
  public void getAuthInfo() {
    final Useraccount user = new Useraccount();
    when(userAccountService.getUserAccount("testuser")).thenReturn(user);
    final AuthenticationInfo authenticationInfo = realm.doGetAuthenticationInfo(new ShibbolethToken("testuser", null));
    final PrincipalCollection principals = authenticationInfo.getPrincipals();
    assertEquals(user, principals.getPrimaryPrincipal());
  }
}
