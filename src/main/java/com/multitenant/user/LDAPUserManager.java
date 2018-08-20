package com.multitenant.user;

import java.util.List;

import com.multitenant.domain.SimpleTenantManager;
import com.multitenant.domain.Tenant;
import com.multitenant.domain.TenantManager;
import com.unboundid.ldap.sdk.Attribute;
import com.unboundid.ldap.sdk.BindResult;
import com.unboundid.ldap.sdk.LDAPConnection;
import com.unboundid.ldap.sdk.LDAPConnectionPool;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.ResultCode;
import com.unboundid.ldap.sdk.SearchRequest;
import com.unboundid.ldap.sdk.SearchResult;
import com.unboundid.ldap.sdk.SearchResultEntry;
import com.unboundid.ldap.sdk.SearchScope;

public class LDAPUserManager implements UserManager {
	
	private LDAPConnectionPool connectionPool = null;
	
	public LDAPUserManager() throws LDAPException {
		/*try {
			LDAPConnection connection = new LDAPConnection("localhost", 10389);
			BindResult bindResult = connection.bind("uid=admin,ou=system",
					"Test@1234");
			LDAPConnectionPool connectionPool = new LDAPConnectionPool(
					connection, 10);
		} catch (LDAPException e) {
			//String es = e.getExceptionMessage();
			//System.out.println(es);
			throw e;
		}*/
	}

	@Override
	public List<User> getUsersByTenantID(int TenantID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByUserName(String userName) {
		LDAPConnection conn = new LDAPConnection();
		User user = new User(); 
		try {

			conn.connect("localhost", 10389);
			
			BindResult bindResult = conn.bind("uid=admin,ou=system", "Test@1234"); 
			
			// LDAPConnection conn = connectionPool.getConnection();
			TenantManager tntMgr = new SimpleTenantManager();
			int index = userName.indexOf("@");
			String emailDomain = userName.substring(index+1);
			Tenant tenant = tntMgr.getTenantByEmailDomain(emailDomain);
			
			String baseDN = "ou=users,ou="+tenant.getTenantAbbrev()+",ou=clients,dc=example,dc=com";
			String lookup = "(uid="+userName+")";
			
			SearchRequest searchRequest = new SearchRequest(baseDN, SearchScope.SUB, lookup);

			
			
		    SearchResult sr = conn.search(searchRequest);

		    if (sr.getEntryCount() == 0) {
		      throw new LDAPException(ResultCode.INVALID_CREDENTIALS);
		    }
		    
		    if (sr.getEntryCount() > 1) {
		    	throw new LDAPException(ResultCode.CONSTRAINT_VIOLATION);
		    }
		    
		    List<SearchResultEntry> srEntries = sr.getSearchEntries();
			
		    for (SearchResultEntry srEntry : srEntries) {
		    	Attribute att = srEntry.getAttribute("cn");
		    	String cn = att.getValue();
		    }
		    
		    user.setTenantID(tenant.getTenantID());
		    user.setUserName(userName);
		    user.setEmail(userName);
		    user.setGroup(getUserGroup(conn, userName));
		    
	    
		} catch (LDAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return user;
	}

	private String getUserGroup(LDAPConnection conn, String userName) throws LDAPException {
		String baseDN = "ou=roles,ou="+"TNT1"+",ou=clients,dc=example,dc=com";
		String lookupFilter = "(member=uid=admin@tenant1.com,ou=users,ou=TNT1,ou=clients,dc=example,dc=com)";
		
		SearchRequest searchRequest = new SearchRequest(baseDN, SearchScope.SUB, lookupFilter);
		
	    SearchResult sr = conn.search(searchRequest);

	    if (sr.getEntryCount() == 0) {
	      throw new LDAPException(ResultCode.INVALID_CREDENTIALS);
	    }
	    
	    if (sr.getEntryCount() > 1) {
	    	throw new LDAPException(ResultCode.CONSTRAINT_VIOLATION);
	    }
	    
	    List<SearchResultEntry> srEntries = sr.getSearchEntries();
		
	    for (SearchResultEntry srEntry : srEntries) {
	    	Attribute att = srEntry.getAttribute("cn");
	    	String cn = att.getValue();
	    	return cn;
	    }
		return null;
	}


	

}
