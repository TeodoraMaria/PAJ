package com.example.util;

import com.example.dto.OrganizationDTO;
import com.example.dto.UserDTO;
import com.example.Organization;
import com.example.User;

public class EntityToDTO {

	public UserDTO convertUser(User user) {
		Organization org = user.getOrganization();
		OrganizationDTO orgDTO = new OrganizationDTO(org.getIdorganization(), org.getName(), org.getExtension(), org.getAdminusername());
		UserDTO globalUserDTO = new UserDTO(user.getUsername(), user.getPassword(), user.isAdmin(), orgDTO);

		globalUserDTO.setId(user.getIduser());
		return globalUserDTO;

	}

}