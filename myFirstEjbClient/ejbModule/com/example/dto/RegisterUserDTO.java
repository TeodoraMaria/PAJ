package com.example.dto;
import java.util.ArrayList;
import java.util.List;

public class RegisterUserDTO {
	String username;
	String password;
	String organizationName;
	List<String> resources;

	public RegisterUserDTO() {
		super();
		resources = new ArrayList<String>();
	}

	public RegisterUserDTO(String username, String password, String organizationName, List<String> resources) {
		super();
		this.username = username;
		this.password = password;
		this.organizationName = organizationName;
		this.resources.addAll(resources);
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
	
	public String getOrganizationName() {
		return organizationName;
	}
	
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	
	public List<String> getResources() {
		return resources;
	}
	
	public void setResources(List<String> resources) {
		this.resources = resources;
	}

	@Override
	public String toString() {
		return "RegisterUserDTO [username=" + username + ", password=" + password + ", organizationName=" + organizationName +", resources=" + resources.toString() +"]";
	}
	
}
