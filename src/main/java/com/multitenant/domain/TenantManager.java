/**
 * 
 */
package com.multitenant.domain;

/**
 * @author amol
 *
 */
public interface TenantManager {
	public void createTenant(Tenant tenant);
	public void updateTenant(Tenant tenant);
	public void deleteTenant(Tenant tenant);
	public void deleteTenantByID(int tenantID);
	public Tenant getTenantByID(int ID);
	public Tenant getTenantByName(String tenantName);
	public Tenant getTenantByAbbrev(String tenantAbbrev); 
	public Tenant getTenantByEmailDomain(String domainName);
}
