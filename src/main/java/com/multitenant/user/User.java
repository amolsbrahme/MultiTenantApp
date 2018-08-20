package com.multitenant.user;

import com.multitenant.domain.TenantSupportable;

public class User implements TenantSupportable {
	private int tenantID = 0;
	private String userName = null;
	private String password = null;
	private String email = null;
	// private List<String> group = null;
	private String group = null;
	
	public User() {
		super();
		this.tenantID = 0;
		this.userName = null;
		this.password = null;
		this.email = "";
		// this.group = new ArrayList<String>();
		this.group = null;
	}

	public User(int tenantID, String userName, String password, String email,
			String group) {
		super();
		this.tenantID = tenantID;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.group = group;
	}

	@Override
	public void setTenantID(int tenantID) {
		this.tenantID = tenantID;
	}

	@Override
	public int getTenantID() {
		return this.tenantID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}
	
}
