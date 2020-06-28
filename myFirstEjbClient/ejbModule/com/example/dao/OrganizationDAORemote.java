package com.example.dao;

import java.util.List;

import javax.ejb.Remote;

import com.example.dto.ImportOrganizationDbDTO;
import com.example.dto.OrganizationDTO;
import com.example.dto.RegisterOrganizationDTO;
import com.example.dto.ResourceDTO;
import com.example.exception.ImportOrganizationDbException;
import com.example.exception.RegisterOrganizationException;

@Remote
public interface OrganizationDAORemote extends GenericDAO<OrganizationDTO>{
	
	OrganizationDTO register(RegisterOrganizationDTO registerOrganizationDTO) throws RegisterOrganizationException;
	void importOrganizationDb(ImportOrganizationDbDTO importOrganizationDbDTO) throws ImportOrganizationDbException;
	public List<ResourceDTO> findAllResources();
	
}
