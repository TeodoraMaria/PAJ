package com.example;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Organization")
@NamedQueries ({
	@NamedQuery(name = "findAllOrganizations", query = "SELECT o FROM Organization o")
})
public class Organization implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idorganization")
	private int idorganization;

	@Column(name = "name")
	private String name;
	
	@Column(name = "extension")
	private String extension;
	
	@Column(name = "adminusername")
	private String adminusername;
	
	@OneToMany(
	        mappedBy = "organization",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true,
	        fetch = FetchType.LAZY
	    )
	private List<User> users;

	public Organization() {
	}

	public Organization(int idorganization, String name, String extension, String adminusername) {
		super();
		this.idorganization = idorganization;
		this.name = name;
		this.extension = extension;
		this.adminusername = adminusername;
	}
	
	public int getIdorganization() {
		return idorganization;
	}

	public void setIdorganization(int idorganization) {
		this.idorganization = idorganization;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getAdminusername() {
		return adminusername;
	}

	public void setAdminusername(String adminusername) {
		this.adminusername = adminusername;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}
