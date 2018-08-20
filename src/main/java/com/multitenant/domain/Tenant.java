/**
 * 
 */
package com.multitenant.domain;

/**
 * @author amol
 *
 */
public class Tenant {
	private int tenantID = 0;
	private String tenantName = null;
	private String tenantAbbrev = null;
	private String tenantEmailDomain = null;
	
	public Tenant() {
		super();
		this.tenantID = 0;
		this.tenantName = "";
		this.tenantAbbrev = "";
		this.tenantEmailDomain = "";
	}
	
	public Tenant(int tenantID, String tenantName, String tenantAbbrev,
			String tenantEmailDomain) {
		super();
		this.tenantID = tenantID;
		this.tenantName = tenantName;
		this.tenantAbbrev = tenantAbbrev;
		this.tenantEmailDomain = tenantEmailDomain;
	}

	public int getTenantID() {
		return tenantID;
	}

	public void setTenantID(int tenantID) {
		this.tenantID = tenantID;
	}

	public String getTenantName() {
		return tenantName;
	}

	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}

	public String getTenantAbbrev() {
		return tenantAbbrev;
	}

	public void setTenantAbbrev(String tenantAbbrev) {
		this.tenantAbbrev = tenantAbbrev;
	}

	public String getTenantEmailDomain() {
		return tenantEmailDomain;
	}

	public void setTenantEmailDomain(String tenantEmailDomain) {
		this.tenantEmailDomain = tenantEmailDomain;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + tenantID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tenant other = (Tenant) obj;
		if (tenantID != other.tenantID)
			return false;
		return true;
	}
}
