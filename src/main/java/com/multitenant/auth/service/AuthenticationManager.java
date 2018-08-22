package com.multitenant.auth.service;

import com.multitenant.domain.Tenant;

public class AuthenticationManager {

	public static AuthenticationService getAuthenticationService(Tenant tenant) {
		return new LDAPAuthenticationService();
	}
}
