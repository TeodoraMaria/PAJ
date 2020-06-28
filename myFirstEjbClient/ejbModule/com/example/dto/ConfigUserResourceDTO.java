package com.example.dto;

public class ConfigUserResourceDTO {
	private ResourceDTO resource;
	private String userRight;
	private int status;
	public ConfigUserResourceDTO() {
		super();
	}
	public ConfigUserResourceDTO( ResourceDTO resource, String userRight, int status) {
		super();
		this.resource = resource;
		this.userRight = userRight;
		this.status = status;
	}
	
	public ResourceDTO getResource() {
		return resource;
	}
	public void setResource(ResourceDTO resource) {
		this.resource = resource;
	}
	public String getUserRight() {
		return userRight;
	}
	public void setUserRight(String userRight) {
		this.userRight = userRight;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ConfigUserResourceDTO [resource=" + resource + ", userRight=" + userRight + ", status=" + status + "]";
	}
	
}
