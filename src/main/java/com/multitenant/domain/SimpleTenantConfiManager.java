package com.multitenant.domain;

import java.util.HashMap;
import java.util.Map;

public class SimpleTenantConfiManager implements TenantConfigManger {
	
	private Map<Integer, TenantConfig> tenantConfigMap = null;
	
	public SimpleTenantConfiManager() {
		tenantConfigMap = new HashMap<Integer, TenantConfig>();
		tenantConfigMap.put(1, new TenantConfig(1, "#737CA1", "blue","test"));
		tenantConfigMap.put(2, new TenantConfig(2, "#617C58", "blue","test"));
		// #E0E0E0
	}

	@Override
	public TenantConfig getTenantConfigByID(int tenantID) {
		return tenantConfigMap.get(tenantID);
	}

	@Override
	public void updateTenantConfig(TenantConfig tenantConfig) {
		tenantConfigMap.put(tenantConfig.getTenantID(), tenantConfig);

	}

	@Override
	public void resetTenantConfig(Tenant tenant) {
		// TODO Auto-generated method stub
	}

}
