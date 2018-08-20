package com.multitenant.auth.service;

import com.multitenant.user.User;

public class AuthenticationResponse {
	
	private boolean result = false;
	private String failuerReason = "";
	private User user = null;
	
	public AuthenticationResponse() {
		result = false;
		failuerReason = "";
		user = null;
	}
	
	public AuthenticationResponse(boolean result, String failuerReason,
			User user) {
		super();
		this.result = result;
		this.failuerReason = failuerReason;
		this.user = user;
	}



	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String getFailuerReason() {
		return failuerReason;
	}

	public void setFailuerReason(String failuerReason) {
		this.failuerReason = failuerReason;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
