package com.example.dto;
import java.util.ArrayList;
import java.util.List;

public class RegisterUserDTO {
	String name;
	String surname;
	OrganizationDTO organization;
	List<String> resources;

	public RegisterUserDTO() {
		super();
		resources = new ArrayList<String>();
	}

	public RegisterUserDTO(String name, String surname, OrganizationDTO organization, List<String> resources) {
		super();
		this.name = name;
		this.surname = surname;
		this.organization = organization;
		this.resources.addAll(resources);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public OrganizationDTO getOrganization() {
		return organization;
	}
	
	public void setOrganization(OrganizationDTO organization) {
		this.organization = organization;
	}
	
	public List<String> getResources() {
		return resources;
	}
	
	public void setResources(List<String> resources) {
		this.resources = resources;
	}

	@Override
	public String toString() {
		return "RegisterUserDTO [name=" + name + ", surname=" + surname + ", organization=" + organization +", resources=" + resources.toString() +"]";
	}
	
}
