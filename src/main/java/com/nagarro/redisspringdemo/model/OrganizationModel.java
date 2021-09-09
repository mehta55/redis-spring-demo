package com.nagarro.redisspringdemo.model;

import java.io.Serializable;

import org.springframework.data.annotation.TypeAlias;

@TypeAlias("organization")
public class OrganizationModel implements Serializable {

	private String id;

	private String orgName;

	private String displayName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	@Override
	public String toString() {
		return "OrganizationModel [id=" + id + ", orgName=" + orgName + ", displayName=" + displayName + "]";
	}

}
