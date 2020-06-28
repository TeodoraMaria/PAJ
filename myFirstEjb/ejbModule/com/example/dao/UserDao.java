package com.example.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.example.Resource;
import com.example.User;
import com.example.UserResource;
import com.example.dto.ConfigUserResourceDTO;
import com.example.dto.LoginDTO;
import com.example.dto.OrganizationDTO;
import com.example.dto.RegisterUserDTO;
import com.example.dto.ResourceDTO;
import com.example.dto.UserDTO;
import com.example.exception.LoginException;
import com.example.exception.RegisterUserException;
import com.example.exception.UsersException;
import com.example.util.DtoToEntity;
import com.example.util.EntityToDTO;

/**
 * Session Bean implementation class UserDAO
 */
@Stateless
@LocalBean
public class UserDao implements UserDAORemote {

	static final Logger LOGGER = Logger.getLogger(UserDao.class.getName());

	@PersistenceContext
	private EntityManager entityManager;

	public UserDao() {

	}

	private EntityToDTO entityToDTO = new EntityToDTO();

	private DtoToEntity dtoToEntity = new DtoToEntity();

	@Override
	public UserDTO findById(int id) {
		User user = entityManager.find(User.class, id);
		UserDTO userDTO = entityToDTO.convertUser(user);
		return userDTO;
	}

	@Override
	public List<UserDTO> findAll() {
		Query query = entityManager.createQuery("SELECT u FROM User u");
		@SuppressWarnings("unchecked")
		List<User> users = query.getResultList();
		System.out.println(users.toString());
		List<UserDTO> dtoUsers = new ArrayList<>();
		for (User user : users) {
			dtoUsers.add(entityToDTO.convertUser(user));
		}
		return dtoUsers;
	}

	@Override
	public UserDTO create(UserDTO userDTO) {
		User user = dtoToEntity.convertUser(userDTO);
		entityManager.persist(user);
		entityManager.flush();
		userDTO.setId(user.getIduser());
		return userDTO;
	}

	@Override
	public UserDTO update(UserDTO userDTO) {
		User user = dtoToEntity.convertUser(userDTO);
		user.setIduser(userDTO.getId());
		user = entityManager.merge(user);
		return userDTO;
	}

	@Override
	public void delete(int id) {
		User user = entityManager.find(User.class, id);
		entityManager.remove(user);

	}

	@Override
	public UserDTO loginUser(LoginDTO loginDTO) throws LoginException {
		User user = null;
		try {
			user = entityManager.createNamedQuery("findUserByUsername", User.class)
					.setParameter("username", loginDTO.getUsername()).getSingleResult();
		} catch (NoResultException e) {
			throw new LoginException("Wrong authentication!");
		}
		if (!loginDTO.getPassword().equals(user.getPassword())) {
			throw new LoginException("Wrong authentication!");
		}

		UserDTO userDTO = findById(user.getIduser());
		return userDTO;

	}

	@Override
	public UserDTO registerUser(RegisterUserDTO registerDTO, List<ConfigUserResourceDTO> configs) throws RegisterUserException {
		StringBuilder usernameBuilder = new StringBuilder();
		usernameBuilder.append(registerDTO.getName());
		usernameBuilder.append(".");
		usernameBuilder.append(registerDTO.getSurname());
		usernameBuilder.append(registerDTO.getOrganization().getExtension());
		String username = usernameBuilder.toString();
		String password = generatePassword();
		User user = new User(registerDTO.getName(),registerDTO.getSurname(), password, username, false, dtoToEntity.convertOrganization(registerDTO.getOrganization()));
		List<UserResource> userres = new ArrayList<UserResource>();
		System.out.println("ok2");
		for(ConfigUserResourceDTO config: configs)
		{
			System.out.println(config);
			UserResource ur = new UserResource();
			ur.setUser(user);
			Resource r = dtoToEntity.convertResource(config.getResource());
			r.setIdresource(config.getResource().getId());
			ur.setResource(r);
			ur.setRight(config.getUserRight());
			ur.setStatus(config.getStatus());
			userres.add(ur);
		}
		user.setUserResources(userres);
		System.out.println("ok3");
		try {
			entityManager.persist(user);
			System.out.println("ok4");
			
		} catch (RegisterUserException e) {
			throw new LoginException("Registration failed!");
		}
		System.out.println("after try catch");

		UserDTO userDTO = entityToDTO.convertUser(user);
		return userDTO;
	}

	@Override
	public List<UserDTO> getAllUsersByOrganization(OrganizationDTO organizationDTO) {
		List<User> users = null;
		try {
			users = entityManager.createNamedQuery("findUsersByOrganization", User.class).getResultList();
		}
		catch (NoResultException e) {
			throw new UsersException("No users found!");
		}
		List<UserDTO> usersDTO = new ArrayList<UserDTO>();
		for(User user : users)
			usersDTO.add(entityToDTO.convertUser(user));
		return usersDTO;
	}

	@Override
	public List<UserDTO> getAllUsersByResource(ResourceDTO resourceDTO) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private String generatePassword() {
	    int leftLimit = 48; // numeral '0'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 10;
	    Random random = new Random(System.currentTimeMillis());
	 
	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();
	 
	    return generatedString;
	}

	@Override
	public void requestAccess(ConfigUserResourceDTO configDTO) {
//		User user = dtoToEntity.convertUser(configDTO.getUser());
//		user.setIduser(configDTO.getUser().getId());
//		
//		Resource res = dtoToEntity.convertResource(configDTO.getResource());
//		res.setIdresource(configDTO.getResource().getId());
//		
//		UserResource ur = new UserResource();
//		ur.setResource(res);
//		ur.setUser(user);
//		ur.setRight(configDTO.getUserRight().getName());
//		ur.setStatus(0); //pending request
//		
//		try {
//			entityManager.persist(ur);
//			
//		} catch (Exception e) {
//			throw new LoginException("Request access failed!");
//		}
		
	}

}