package com.example;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserResourceKey implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Column(name = "iduser")
	int iduser;
	
	@Column(name = "idresource")
	int idresource;

	public UserResourceKey() {
		super();
	}

	public UserResourceKey(int iduser, int isresource) {
		super();
		this.iduser = iduser;
		this.idresource = isresource;
	}

	public int getIduser() {
		return iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}

	public int getIsresource() {
		return idresource;
	}

	public void setIsresource(int isresource) {
		this.idresource = isresource;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + iduser;
		result = prime * result + idresource;
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
		UserResourceKey other = (UserResourceKey) obj;
		if (iduser != other.iduser)
			return false;
		if (idresource != other.idresource)
			return false;
		return true;
	}
	
	

}
