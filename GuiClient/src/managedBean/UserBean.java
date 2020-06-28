package managedBean;

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
import com.example.dto.ResourceDTO;
import com.example.dto.UserDTO;
import com.example.dto.ConfigUserResourceDTO;
import com.example.exception.RegisterUserException;

@ManagedBean
@SessionScoped
public class UserBean {
	UserDTO user;
	
	ConfigUserResourceDTO config;
	
	public ConfigUserResourceDTO getConfig() {
		return config;
	}

	public void setConfig(ConfigUserResourceDTO config) {
		this.config = config;
	}

	@EJB
	UserDAORemote userDAORemote;
	
	@EJB
	OrganizationDAORemote orgDAORemote;
	
	@PostConstruct
	public void init() {
		user = (UserDTO) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userDTO");
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
	
	public String request()
	{
		FacesContext facesContext = FacesContext.getCurrentInstance();
		try {
//			for(OrganizationDTO org : organizations)
//			{
//				if(org.getName().equalsIgnoreCase(selectedOrg))
//					registerDTO.setOrganization(org);
//			}
//			UserDTO userDTO = userDAORemote.registerUser(registerDTO);
//			facesContext.getExternalContext().getSessionMap().put("userDTO", userDTO);
//			// if userDTO is admin
//			System.out.println("admin logged");
//			StringBuilder result = new StringBuilder();
//			if(userDTO.isAdmin())
//				return "/adminFilter/admin.xhtml?faces-redirect=true";
			return "user-main.xhtml?faces-redirect=true";
		} catch (RegisterUserException e) {
			System.out.println("Invalid username or password");
			facesContext.addMessage("loginForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, e.message(), null));
			return "register.xhtml?faces-redirect=true";
		} catch(Exception e)
		{
			System.out.println(e.getMessage());
			return "index.xhtml?faces-redirect=true";
		}
	}

}
