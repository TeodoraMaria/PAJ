package com.example.dao;

import java.util.List;

import javax.ejb.Remote;

import com.example.dto.LoginDTO;
import com.example.dto.OrganizationDTO;
import com.example.dto.RegisterUserDTO;
import com.example.dto.ResourceDTO;
import com.example.dto.UserDTO;

import com.example.exception.LoginException;
import com.example.exception.RegisterUserException;
import com.example.exception.UsersException;


@Remote
public interface UserDAORemote extends GenericDAO<UserDTO> {

	UserDTO loginUser(LoginDTO loginDTO) throws LoginException;
	UserDTO registerUser(RegisterUserDTO registerDTO) throws RegisterUserException;
	List<UserDTO> getAllUsers() throws UsersException;
	List<UserDTO> getAllUsersByOrganization(OrganizationDTO organizationDTO);
	List<UserDTO> getAllUsersByResource(ResourceDTO resourceDTO);
}
