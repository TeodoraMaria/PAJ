package com.example.dto;

import java.io.Serializable;
import java.util.List;

public class OrganizationDTO implements Serializable{
	

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String extension;
	private String adminUsername;
	
	public OrganizationDTO() {
		super();
	}
	
	public OrganizationDTO(int id, String name, String extension, String adminUsername) {
		super();
		this.setId(id);
		this.setName(name);
		this.setExtension(extension);
		this.setAdminUsername(adminUsername);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdminUsername() {
		return adminUsername;
	}

	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}

	@Override
	public String toString() {
		return "OrganizationDTO [id=" + id + ", name=" + name + ", extension=" + extension + ", adminUsername="
				+ adminUsername + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adminUsername == null) ? 0 : adminUsername.hashCode());
		result = prime * result + ((extension == null) ? 0 : extension.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrganizationDTO other = (OrganizationDTO) obj;
		if (adminUsername == null) {
			if (other.adminUsername != null)
				return false;
		} else if (!adminUsername.equals(other.adminUsername))
			return false;
		if (extension == null) {
			if (other.extension != null)
				return false;
		} else if (!extension.equals(other.extension))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
