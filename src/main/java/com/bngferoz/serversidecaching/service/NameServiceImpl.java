package com.bngferoz.serversidecaching.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.bngferoz.serversidecaching.entity.Name;
import com.bngferoz.serversidecaching.repository.NameDao;

@Service
public class NameServiceImpl implements NameService {

	@Autowired
	private NameDao nameDao;
	
	@Override
	public boolean saveName(Name name) {
		return nameDao.saveName(name);
	}

	@Override
	@Cacheable("names")
	public List<Name> fetchAllUsers() {
		return nameDao.getAllUsers();
	}

	@Override
	public Name getById(Long id) {
		return nameDao.getById(id);
	}

	@Override
	public Name getByName(String name) {
		return nameDao.getByName(name);
	}

	@Override
	public Name fetchTopName() {
		return nameDao.getTopName();
	}

}
