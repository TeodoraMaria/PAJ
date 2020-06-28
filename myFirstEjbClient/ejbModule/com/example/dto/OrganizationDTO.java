package com.example.dto;

import java.io.Serializable;

public class OrganizationDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String extension;
	private String adminUsername;
	
	public OrganizationDTO() {
		super();
	}

	public OrganizationDTO(int id, String name, String extension, String adminUsername) {
		super();
		this.setId(id);
		this.setName(name);
		this.setExtension(extension);
		this.setAdminUsername(adminUsername);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
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

	@Override
	public String toString() {
		return "OrganizationDTO [id=" + id + ", name=" + name + ", extension=" + extension + ", adminUsername="
				+ adminUsername + "]";
	}

}
