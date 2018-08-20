package com.multitenant.domain;

public interface TenantConfigManger {
	public TenantConfig getTenantConfigByID(int tenantID);
	public void updateTenantConfig(TenantConfig tenantConfig);
	public void resetTenantConfig(Tenant tenant);
}
