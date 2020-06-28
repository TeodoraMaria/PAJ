package com.example.dto;

import java.io.Serializable;

public class ResourceDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String url;

	public ResourceDTO() {
		super();
	}
	
	public ResourceDTO(int id, String name, String url) {
		super();
		this.id = id;
		this.name = name;
		this.setUrl(url);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ResourceDTO(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "ResourceDTO [id=" + id + ", name=" + name + ", url=" + url + "]";
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
