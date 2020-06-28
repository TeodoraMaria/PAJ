package com.example;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Resource")
public class Resource implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idresource")
	private int idresource;

	@Column(name = "name")
	private String name;
	
	@Column(name = "url")
	private String url;
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@OneToMany(
	        mappedBy = "resource",
	        cascade = CascadeType.ALL,
	        orphanRemoval = true,
	        fetch = FetchType.LAZY
	    )
	private List<UserResource> userResources;

	public int getIdresource() {
		return idresource;
	}

	public void setIdresource(int idresource) {
		this.idresource = idresource;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<UserResource> getUserResources() {
		return userResources;
	}

	public void setUserResources(List<UserResource> userResources) {
		this.userResources = userResources;
	}
	
	

}
