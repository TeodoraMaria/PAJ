package com.example.dao;

import javax.ejb.Remote;

import com.example.dto.ResourceDTO;

@Remote
public interface ResourceDAORemote extends GenericDAO<ResourceDTO> {

}
