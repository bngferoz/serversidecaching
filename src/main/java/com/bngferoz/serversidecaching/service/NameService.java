package com.bngferoz.serversidecaching.service;

import java.util.List;

import com.bngferoz.serversidecaching.entity.Name;

public interface NameService {

	boolean saveName(Name name);

	List<Name> fetchAllUsers();

}
