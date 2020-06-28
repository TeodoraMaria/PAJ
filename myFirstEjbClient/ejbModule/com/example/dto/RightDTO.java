package com.example.dto;

import java.io.Serializable;

public class RightDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	
	public RightDTO() {
		super();
	}

	public RightDTO(int id, String name) {
		super();
		this.setId(id);
		this.setName(name);
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

	@Override
	public String toString() {
		return "RightDTO [id=" + id + ", name=" + name + "]";
	}

}
