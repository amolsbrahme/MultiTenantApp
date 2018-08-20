package com.multitenant.auth.service;

import com.multitenant.domain.Tenant;
import com.multitenant.user.LDAPUserManager;
import com.multitenant.user.UserManager;
import com.unboundid.ldap.sdk.BindResult;
import com.unboundid.ldap.sdk.LDAPConnection;
import com.unboundid.ldap.sdk.LDAPException;

public class LDAPAuthenticationService implements AuthenticationService {

	@Override
	public AuthenticationResponse authenticate(Tenant tenant, String userName,
			String password) {
		AuthenticationResponse result = new AuthenticationResponse();
		
		if (userName == null || password == null) {
			return result;
		}
		
		LDAPConnection connection = new LDAPConnection();
		try {
			connection.connect("localhost", 10389);
			String dn = "uid="+userName+",ou=users,ou="+tenant.getTenantAbbrev()+",ou=clients,dc=example,dc=com";
			BindResult bindResult = connection.bind(dn, password); 
			System.out.println(bindResult.getResultString());
			result.setResult(true);
			
			UserManager userManager = new LDAPUserManager();
			result.setUser(userManager.getUserByUserName(userName));

			return result;
		} catch (LDAPException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			return result;
		} finally {
			connection.close();
		}
	}
}
