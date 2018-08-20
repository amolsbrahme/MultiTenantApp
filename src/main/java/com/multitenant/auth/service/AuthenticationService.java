package com.multitenant.auth.service;

import com.multitenant.domain.Tenant;

public interface AuthenticationService {
	public AuthenticationResponse authenticate(Tenant tenant, String userName, String password);

	/*public Map<String, String> getAttributes(String userName, String password,
			Set<String> name);*/
}
