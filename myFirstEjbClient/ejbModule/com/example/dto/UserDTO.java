package com.example.dto;

import java.io.Serializable;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String username;
	private String password;
	private boolean isAdmin;
	private OrganizationDTO organization;

	public UserDTO() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserDTO(String username, String password, boolean isAdmin, OrganizationDTO organization) {
		super();
		this.username = username;
		this.password = password;
		this.isAdmin = isAdmin;
		this.organization = organization;
	}
	
	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", username=" + username + ", password=" + password + "]";
	}

	public OrganizationDTO getOrganization() {
		return organization;
	}

	public void setOrganization(OrganizationDTO organization) {
		this.organization = organization;
	}

}