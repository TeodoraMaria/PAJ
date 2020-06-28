package com.example.util;

import com.example.dto.ConfigUserResourceDTO;
import com.example.dto.OrganizationDTO;
import com.example.dto.ResourceDTO;
import com.example.dto.UserDTO;

import com.example.Organization;
import com.example.Resource;
import com.example.User;
import com.example.UserResource;

public class EntityToDTO {

	public UserDTO convertUser(User user) {
		Organization org = user.getOrganization();
		OrganizationDTO orgDTO = new OrganizationDTO(org.getIdorganization(), org.getName(), org.getExtension(), org.getAdminusername());
		UserDTO globalUserDTO = new UserDTO(user.getName(), user.getSurname(), user.getPassword(),  user.getUsername(),user.isAdmin(), orgDTO);
		for(UserResource ur: user.getUserResources()) {
			globalUserDTO.getConfigs().add(converUserResource(ur));
		}
		globalUserDTO.setId(user.getIduser());
		return globalUserDTO;

	}
	
	public OrganizationDTO convertOrganization(Organization org) {
		OrganizationDTO orgDTO = new OrganizationDTO(org.getIdorganization(), org.getName(), org.getExtension(), org.getAdminusername());
		return orgDTO;
	}
	
	public ResourceDTO convertResource(Resource resource) {
		ResourceDTO resourceDTO = new ResourceDTO(resource.getIdresource(), resource.getName(), resource.getUrl());
		return resourceDTO;
	}
	
	public ConfigUserResourceDTO converUserResource(UserResource userResource) {
		ConfigUserResourceDTO dto = new ConfigUserResourceDTO(convertResource(userResource.getResource()), userResource.getRight(), userResource.getStatus());
		return dto;
	}

}