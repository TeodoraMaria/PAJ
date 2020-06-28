package com.example.dto;

import java.io.Serializable;

public class ResourceDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;

	public ResourceDTO() {
		super();
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
		return "ResoureDTO [id=" + id + ", name=" + name + "]";
	}
}
