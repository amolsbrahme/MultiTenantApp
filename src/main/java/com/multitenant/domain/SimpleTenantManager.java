package com.multitenant.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SimpleTenantManager implements TenantManager {
	
	private Map<Integer, Tenant> tenantMap = null;
	
	public SimpleTenantManager() {
		tenantMap = new HashMap<Integer, Tenant>();
		tenantMap.put(1, new Tenant(1, "Tenant 1", "TNT1","tenant1.com"));
		tenantMap.put(2, new Tenant(2, "Tenant 2", "TNT2","tenant2.com"));
	}
	
	@Override
	public void createTenant(Tenant tenant) {
		tenantMap.put(tenant.getTenantID(), tenant);
	}

	@Override
	public void updateTenant(Tenant tenant) {
		tenantMap.put(tenant.getTenantID(), tenant);
	}

	@Override
	public void deleteTenant(Tenant tenant) {
		tenantMap.remove(tenant.getTenantID());
	}

	@Override
	public void deleteTenantByID(int tenantID) {
		tenantMap.remove(tenantID);

	}

	@Override
	public Tenant getTenantByID(int ID) {
		return tenantMap.get(ID);
	}

	@Override
	public Tenant getTenantByName(String tenantName) {
		Set<Integer> tenantIDSet = tenantMap.keySet();
		for(int tenantID : tenantIDSet) {
			Tenant tenant = tenantMap.get(tenantID);
			if(tenant.getTenantName().equalsIgnoreCase(tenantName)) {
				return tenant;
			}
		}
		return null;
	}

	@Override
	public Tenant getTenantByAbbrev(String tenantAbbrev) {
		Set<Integer> tenantIDSet = tenantMap.keySet();
		for(int tenantID : tenantIDSet) {
			Tenant tenant = tenantMap.get(tenantID);
			if(tenant.getTenantAbbrev().equalsIgnoreCase(tenantAbbrev)) {
				return tenant;
			}
		}
		return null;
	}

	@Override
	public Tenant getTenantByEmailDomain(String domainName) {
		Set<Integer> tenantIDSet = tenantMap.keySet();
		for(int tenantID : tenantIDSet) {
			Tenant tenant = tenantMap.get(tenantID);
			if(tenant.getTenantEmailDomain().equalsIgnoreCase(domainName)) {
				return tenant;
			}
		}
		return null;
	}

}
