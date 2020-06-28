package com.example;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "UserResource")
public class UserResource {
	
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
	
	private String right;

	public UserResource() {
		super();
	}

	public UserResource(UserResourceKey id, User user, Resource resource, String right) {
		super();
		this.id = id;
		this.user = user;
		this.resource = resource;
		this.right = right;
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
		return right;
	}

	public void setRight(String right) {
		this.right = right;
	}
	
}
