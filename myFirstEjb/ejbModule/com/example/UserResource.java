package com.example;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "UserResource")
public class UserResource implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserResourceKey id;

	@ManyToOne
	@MapsId("iduser")
	@JoinColumn(name = "iduser")
	private User user;

	@ManyToOne
	@MapsId("idresource")
	@JoinColumn(name = "idresource")
	private Resource resource;

	@Column(name = "userRight")
	private String userRight;
	
	@Column(name = "status")
	private int status;

	public UserResource() {
		super();
	}

	public UserResource(UserResourceKey id, User user, Resource resource, String right, int status) {
		super();
		this.id = id;
		this.user = user;
		this.resource = resource;
		this.userRight = right;
		this.status = status;
	}

	public UserResourceKey getId() {
		return id;
	}

	public void setId(UserResourceKey id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public String getRight() {
		return userRight;
	}

	public void setRight(String right) {
		this.userRight = right;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
