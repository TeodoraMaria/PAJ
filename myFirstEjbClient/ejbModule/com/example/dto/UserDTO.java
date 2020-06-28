package com.example.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String username;
	private String password;
	private String name;
	private String surname;
	private boolean isAdmin;
	private OrganizationDTO organization;
	private List<ConfigUserResourceDTO> configs;

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

	public UserDTO(String name, String surname, String password, String username, boolean isAdmin, OrganizationDTO organization) {
		super();
		this.username = username;
		this.password = password;
		this.isAdmin = isAdmin;
		this.organization = organization;
		this.name = name;
		this.surname = surname;
		this.configs = new ArrayList<ConfigUserResourceDTO>();
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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ConfigUserResourceDTO> getConfigs() {
		return configs;
	}

	public void setConfigs(List<ConfigUserResourceDTO> configs) {
		this.configs = configs;
	}

}