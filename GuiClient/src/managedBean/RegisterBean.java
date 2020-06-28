package managedBean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.URL;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.example.dao.OrganizationDAORemote;
import com.example.dao.UserDAORemote;
import com.example.dto.RegisterUserDTO;
import com.example.dto.ResourceDTO;
import com.example.dto.UserDTO;
import com.example.dto.ConfigUserResourceDTO;
import com.example.dto.OrganizationDTO;
import com.example.exception.RegisterUserException;

@ManagedBean
@SessionScoped
public class RegisterBean {

	RegisterUserDTO registerDTO = new RegisterUserDTO();

	@EJB
	UserDAORemote userDAORemote;

	@EJB
	OrganizationDAORemote orgDAORemote;

	String selectedOrg;

	List<OrganizationDTO> organizations;

	List<ResourceDTO> resources;

	boolean resourceOneRead;
	boolean resourceOneWrite;
	boolean resourceOneEdit;

	boolean resourceTwoRead;
	boolean resourceTwoWrite;
	public boolean isResourceTwoWrite() {
		return resourceTwoWrite;
	}

	public void setResourceTwoWrite(boolean resourceTwoWrite) {
		this.resourceTwoWrite = resourceTwoWrite;
	}

	boolean resourceTwoEdit;

	boolean resourceThreeRead;
	boolean resourceThreeWrite;
	boolean resourceThreeEdit;

	public List<ResourceDTO> getResources() {
		return resources;
	}

	public void setResources(List<ResourceDTO> resources) {
		this.resources = resources;
	}

	public List<OrganizationDTO> getOrganizations() {
		return organizations;
	}

	public void setOrganizations(List<OrganizationDTO> organizations) {
		this.organizations = organizations;
	}

	@PostConstruct
	public void init() {
		organizations = orgDAORemote.findAll();
		resources = orgDAORemote.findAllResources();
	}

	public RegisterUserDTO getRegisterDTO() {
		return registerDTO;
	}

	public void setRegisterDTO(RegisterUserDTO registerDTO) {
		this.registerDTO = registerDTO;
	}

	public String getSelectedOrg() {
		return selectedOrg;
	}

	public void setSelectedOrg(String selectedOrg) {
		this.selectedOrg = selectedOrg;
	}

	public String registerUser() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		try {
			for (OrganizationDTO org : organizations) {
				if (org.getName().equalsIgnoreCase(selectedOrg))
					registerDTO.setOrganization(org);
			}
			List<ConfigUserResourceDTO> configs = new ArrayList<ConfigUserResourceDTO>();
			if(resourceOneRead) {
				System.out.println(resourceOneRead);
				configs.add(new ConfigUserResourceDTO(resources.get(0),"read",0));
			}
			if(resourceOneWrite) {
				System.out.println(resourceOneWrite);
				configs.add(new ConfigUserResourceDTO(resources.get(0),"write",0));
			}
			if(resourceOneEdit) {
				System.out.println(resourceOneEdit);
				configs.add(new ConfigUserResourceDTO(resources.get(0),"edit",0));
			}
			if(resourceTwoRead) {
				System.out.println(resourceTwoRead);
				configs.add(new ConfigUserResourceDTO(resources.get(1),"read",0));
			}
			if(resourceTwoWrite) {
				System.out.println(resourceTwoWrite);
				configs.add(new ConfigUserResourceDTO(resources.get(1),"write",0));
			}
			if(resourceTwoEdit) {
				System.out.println(resourceTwoEdit);
				configs.add(new ConfigUserResourceDTO(resources.get(1),"edit",0));
			}
			if(resourceThreeRead) {
				System.out.println(resourceThreeRead);
				configs.add(new ConfigUserResourceDTO(resources.get(2),"read",0));
			}
			if(resourceThreeWrite) {
				System.out.println(resourceThreeWrite);
				configs.add(new ConfigUserResourceDTO(resources.get(2),"write",0));
			}
			if(resourceThreeEdit) {
				System.out.println(resourceThreeEdit);
				configs.add(new ConfigUserResourceDTO(resources.get(2),"edit",0));
			}
			System.out.println("ok1");
			UserDTO userDTO = userDAORemote.registerUser(registerDTO, configs);
			facesContext.getExternalContext().getSessionMap().put("userDTO", userDTO);
			// if userDTO is admin
			System.out.println("admin logged");
			StringBuilder result = new StringBuilder();
			if (userDTO.isAdmin())
				return "/adminFilter/admin.xhtml?faces-redirect=true";
			return "user-main.xhtml?faces-redirect=true";
		} catch (RegisterUserException e) {
			System.out.println("Invalid username or password");
			facesContext.addMessage("loginForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, e.message(), null));
			return "register.xhtml?faces-redirect=true";
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return "index.xhtml?faces-redirect=true";
		}

	}

	public boolean isResourceOneRead() {
		return resourceOneRead;
	}

	public void setResourceOneRead(boolean resourceOneRead) {
		this.resourceOneRead = resourceOneRead;
	}

	public boolean isResourceOneWrite() {
		return resourceOneWrite;
	}

	public void setResourceOneWrite(boolean resourceOneWrite) {
		this.resourceOneWrite = resourceOneWrite;
	}

	public boolean isResourceOneEdit() {
		return resourceOneEdit;
	}

	public void setResourceOneEdit(boolean resourceOneEdit) {
		this.resourceOneEdit = resourceOneEdit;
	}

	public boolean isResourceTwoRead() {
		return resourceTwoRead;
	}

	public void setResourceTwoRead(boolean resourceTwoRead) {
		this.resourceTwoRead = resourceTwoRead;
	}

	public boolean isResourceTwoEdit() {
		return resourceTwoEdit;
	}

	public void setResourceTwoEdit(boolean resourceTwoEdit) {
		this.resourceTwoEdit = resourceTwoEdit;
	}

	public boolean isResourceThreeRead() {
		return resourceThreeRead;
	}

	public void setResourceThreeRead(boolean resourceThreeRead) {
		this.resourceThreeRead = resourceThreeRead;
	}

	public boolean isResourceThreeWrite() {
		return resourceThreeWrite;
	}

	public void setResourceThreeWrite(boolean resourceThreeWrite) {
		this.resourceThreeWrite = resourceThreeWrite;
	}

	public boolean isResourceThreeEdit() {
		return resourceThreeEdit;
	}

	public void setResourceThreeEdit(boolean resourceThreeEdit) {
		this.resourceThreeEdit = resourceThreeEdit;
	}

	public String logout() {

		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		registerDTO = null;

		return "/index?faces-redirect=true";
	}

	public void setOrg() {
		setSelectedOrg(selectedOrg);
	}

}