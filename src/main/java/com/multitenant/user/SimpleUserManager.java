/**
 * 
 */
package com.multitenant.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.multitenant.domain.SimpleTenantManager;
import com.multitenant.domain.Tenant;
import com.multitenant.domain.TenantManager;

/**
 * @author amol
 *
 */
public class SimpleUserManager implements UserManager {
	
	private Map<Integer, List<User>> userMap = null;
	
	public SimpleUserManager() {
		userMap = new HashMap<Integer, List<User>>();
		
		List<User> t1Users = new ArrayList<User>();
		User t1AdminUser = new User(1, "admin@tenant1.com", "password", 
				"admin@tenant1.com", "Admin");
		t1Users.add(t1AdminUser);
		
		User t1ManagerUser = new User(1, "manager@tenant1.com", "password", 
				"manager@tenant1.com", "Manager");
		t1Users.add(t1ManagerUser);
		
		User t1User = new User(1, "user@tenant1.com", "password", 
				"user@tenant1.com", "User");
		t1Users.add(t1User);
		
		userMap.put(1, t1Users);
		
		List<User> t2Users = new ArrayList<User>();
		User t2AdminUser = new User(2, "admin@tenant2.com", "password", 
				"admin@tenant2.com", "Admin");
		t2Users.add(t2AdminUser);
		
		User t2ManagerUser = new User(2, "manager@tenant2.com", "password", 
				"manager@tenant2.com", "Manager");
		t2Users.add(t2ManagerUser);
		
		User t2User = new User(2, "user@tenant2.com", "password", 
				"user@tenant2.com", "User");
		t2Users.add(t2User);
		
		userMap.put(2, t2Users);
	}
	
	
	public List<User> getUsersByTenantID(int tenantID) {
		return userMap.get(tenantID);
	}
	
	public User getUserByUserName(String userName) {
		TenantManager tntMgr = new SimpleTenantManager();
		int index = userName.indexOf("@");
		String emailDomain = userName.substring(index+1);
		Tenant tenant = tntMgr.getTenantByEmailDomain(emailDomain);

		if (tenant != null) {
			int id = tenant.getTenantID();
			List<User> users = userMap.get(id);
			for (User user : users) {
				if (userName.equalsIgnoreCase(user.getUserName())) {
					return user;
				}
			}
		}
		
		return null;
	}	
}
