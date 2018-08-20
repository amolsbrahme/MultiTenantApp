package com.multitenant.auth.service;

import com.multitenant.domain.Tenant;
import com.multitenant.user.SimpleUserManager;
import com.multitenant.user.User;
import com.multitenant.user.UserManager;

public class SimpleAuthenticationService implements AuthenticationService {
	
	private UserManager userManager = null;
	
	public SimpleAuthenticationService() {
		this.userManager = new SimpleUserManager();
	}
	
	@Override
	public AuthenticationResponse authenticate(Tenant tenant, String userName, String password) {
		
		AuthenticationResponse result = new AuthenticationResponse();
		
		if (userName == null || password == null) {
			return result;
		}
		
		User user = userManager.getUserByUserName(userName);
		if(user == null) {
			result.setFailuerReason("User does not exist");
			return result;

		}
		if (password.equals(user.getPassword())) {
			result.setResult(true);
			result.setUser(user);
			return result;
		}
		return result;
	}
}
