package com.multitenant.domain;

public interface TenantSupportable {	
	public void setTenantID(int tenantID);
	public int getTenantID();
}
