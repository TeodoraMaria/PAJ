package com.example.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.*;
import javax.persistence.criteria.*;

import com.example.Organization;
import com.example.Resource;
import com.example.User;
import com.example.dto.ImportOrganizationDbDTO;
import com.example.dto.LoginDTO;
import com.example.dto.OrganizationDTO;
import com.example.dto.RegisterOrganizationDTO;
import com.example.dto.RegisterUserDTO;
import com.example.dto.ResourceDTO;
import com.example.dto.UserDTO;
import com.example.exception.ImportOrganizationDbException;
import com.example.exception.LoginException;
import com.example.exception.RegisterOrganizationException;
import com.example.exception.RegisterUserException;
import com.example.exception.UsersException;
import com.example.util.DtoToEntity;
import com.example.util.EntityToDTO;

/**
 * Session Bean implementation class UserDAO
 */
@Stateless
@LocalBean
public class OrganizationDAO implements OrganizationDAORemote {

	static final Logger LOGGER = Logger.getLogger(OrganizationDAO.class.getName());

	@PersistenceContext
	private EntityManager entityManager;

	public OrganizationDAO() {

	}

	private EntityToDTO entityToDTO = new EntityToDTO();

	private DtoToEntity dtoToEntity = new DtoToEntity();

	@Override
	public OrganizationDTO findById(int id) {
		Organization org = entityManager.find(Organization.class, id);
		OrganizationDTO orgDTO = entityToDTO.convertOrganization(org);
		return orgDTO;
	}

	@Override
	public List<OrganizationDTO> findAll() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
	    CriteriaQuery<Organization> cq = cb.createQuery(Organization.class);
	    Root<Organization> rootEntry = cq.from(Organization.class);
	    CriteriaQuery<Organization> all = cq.select(rootEntry);
	    TypedQuery<Organization> allQuery = entityManager.createQuery(all);
	    List<Organization> orgs= allQuery.getResultList();
	    List<OrganizationDTO> orgDTOs = new ArrayList<OrganizationDTO>();
	    for(Organization org : orgs)
	    {
	    	orgDTOs.add(entityToDTO.convertOrganization(org));
	    }
	    return orgDTOs;
	}

	@Override
	public OrganizationDTO create(OrganizationDTO entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrganizationDTO update(OrganizationDTO entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OrganizationDTO register(RegisterOrganizationDTO registerOrganizationDTO)
			throws RegisterOrganizationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void importOrganizationDb(ImportOrganizationDbDTO importOrganizationDbDTO)
			throws ImportOrganizationDbException {
		// TODO Auto-generated method stub
		
	}
	
	public List<ResourceDTO> findAllResources() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
	    CriteriaQuery<Resource> cq = cb.createQuery(Resource.class);
	    Root<Resource> rootEntry = cq.from(Resource.class);
	    CriteriaQuery<Resource> all = cq.select(rootEntry);
	    TypedQuery<Resource> allQuery = entityManager.createQuery(all);
	    List<Resource> resources= allQuery.getResultList();
	    List<ResourceDTO> resDTOs = new ArrayList<ResourceDTO>();
	    for(Resource res : resources)
	    {
	    	resDTOs.add(entityToDTO.convertResource(res));
	    }
	    return resDTOs;
	}
}
