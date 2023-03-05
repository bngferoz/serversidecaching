package com.bngferoz.serversidecaching.repository;

import java.util.List;

import com.bngferoz.serversidecaching.entity.Name;

public interface NameDao {

	boolean saveName(Name name);

	List<Name> getAllUsers();

}
