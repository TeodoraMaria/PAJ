package com.example;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="User")
@NamedQueries({
	@NamedQuery(name = "findAllUsers", query = "SELECT u FROM User u"),
	@NamedQuery(name = "findUserByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),
})
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "iduser")
	private int iduser;

	@Column(name = "password")
	private String password;

	@Column(name = "username")
	private String username;
	
	@Column(name = "isadmin")
	private boolean isadmin;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "organizationId")
	private Organization organization;

	public User() {
	}

	public User(String password, String username, boolean isAdmin) {
		super();
		this.password = password;
		this.username = username;
	}

	public int getIduser() {
		return this.iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isAdmin() {
		return isadmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isadmin = isAdmin;
	}
	
	public Organization getOrganization() {
		return organization;
	}
	
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

}