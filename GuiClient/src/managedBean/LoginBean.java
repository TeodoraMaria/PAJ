package managedBean;

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

import com.example.dao.UserDAORemote;
import com.example.dto.LoginDTO;
import com.example.dto.UserDTO;
import com.example.exception.LoginException;

@ManagedBean
@SessionScoped
public class LoginBean {

	LoginDTO loginDTO = new LoginDTO();

	@EJB
	UserDAORemote userDAORemote;

	UserDTO userDTO;

	public LoginDTO getLoginDTO() {
		return loginDTO;
	}

	public void setLoginDTO(LoginDTO loginDTO) {
		this.loginDTO = loginDTO;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	public String loginUser() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		try {
			userDTO = userDAORemote.loginUser(loginDTO);
			facesContext.getExternalContext().getSessionMap().put("userDTO", userDTO);
			// if userDTO is admin
			System.out.println("admin logged");
			StringBuilder result = new StringBuilder();
			if(userDTO.isAdmin())
				return "/adminFilter/admin.xhtml?faces-redirect=true";
			return "user-main.xhtml";
		} catch (LoginException e) {
			System.out.println("Invalid username or password");
			facesContext.addMessage("loginForm", new FacesMessage(FacesMessage.SEVERITY_ERROR, e.message(), null));
			return null;
		}

	}

	public String logout() {

		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		userDTO = null;

		return "/index?faces-redirect=true";
	}

}