package com.multitenant.domain;

public class TenantConfig implements TenantSupportable {
	
	private int tenantID = 0;
	private String backgroundColor = null;
	private String headerColor = null;
	private String textColor = null;
	
	public TenantConfig(int tenantID, String backgroundColor,
			String headerColor, String textColor) {
		super();
		this.tenantID = tenantID;
		this.backgroundColor = backgroundColor;
		this.headerColor = headerColor;
		this.textColor = textColor;
	}

	public String getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public String getHeaderColor() {
		return headerColor;
	}

	public void setHeaderColor(String headerColor) {
		this.headerColor = headerColor;
	}

	public String getTextColor() {
		return textColor;
	}

	public void setTextColor(String textColor) {
		this.textColor = textColor;
	}

	@Override
	public void setTenantID(int tenantID) {
		this.tenantID = tenantID;
		
	}

	@Override
	public int getTenantID() {
		return this.tenantID;
	}
}
