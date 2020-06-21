package com.example.util;

import com.example.dto.UserDTO;

import com.example.User;

public class EntityToDTO {

	public UserDTO convertUser(User user) {
		UserDTO globalUserDTO = new UserDTO(user.getUsername(), user.getPassword());

		globalUserDTO.setId(user.getIduser());
		return globalUserDTO;

	}

}