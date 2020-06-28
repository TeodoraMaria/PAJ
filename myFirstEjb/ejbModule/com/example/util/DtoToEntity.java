package com.example.util;

import com.example.dto.OrganizationDTO;
import com.example.dto.ResourceDTO;
import com.example.dto.UserDTO;
import com.example.Organization;
import com.example.Resource;
import com.example.User;

public class DtoToEntity {

	// all classes doesn't take primary key in account

	public User convertUser(UserDTO userDTO) {
		Organization org = convertOrganization(userDTO.getOrganization());
		User user = new User(userDTO.getName(), userDTO.getSurname(), userDTO.getPassword(), userDTO.getUsername(),userDTO.isAdmin(), org);

		return user;
	}
	
	public Organization convertOrganization(OrganizationDTO organizationDTO) {
		Organization org = new Organization(organizationDTO.getId(), organizationDTO.getName(), organizationDTO.getExtension(), organizationDTO.getAdminUsername());

		return org;
	}
	
	public Resource convertResource(ResourceDTO resourceDTO) {
		Resource res = new Resource();
		res.setName(resourceDTO.getName());
		res.setUrl(resourceDTO.getUrl());
		return res;
	}

}