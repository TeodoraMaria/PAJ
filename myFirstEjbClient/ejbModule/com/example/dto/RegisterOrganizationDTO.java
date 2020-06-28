package com.example.dto;

public class RegisterOrganizationDTO {
	
	private String name;
	private String extension;
	private String adminUsername;
	
	public RegisterOrganizationDTO() {
		super();
	}
	
	public RegisterOrganizationDTO(String name, String extension, String adminUsername) {
		super();
		this.name = name;
		this.extension = extension;
		this.adminUsername = adminUsername;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAdminUsername() {
		return adminUsername;
	}
	
	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	@Override
	public String toString() {
		return "RegisterOrganizationDTO [name=" + name + ", extension=" + extension + ", adminUsername=" + adminUsername
				+ "]";
	}
	
	
}
