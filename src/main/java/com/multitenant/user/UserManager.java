package com.multitenant.user;

import java.util.List;

public interface UserManager {
	public List<User> getUsersByTenantID(int TenantID);
	public User getUserByUserName(String userName);
}
