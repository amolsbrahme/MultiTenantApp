package com.multitenant.auth.service;

public class AuthenticationManager {

	public static AuthenticationService getAuthenticationService(String userName) {
		return new LDAPAuthenticationService();
	}
}
