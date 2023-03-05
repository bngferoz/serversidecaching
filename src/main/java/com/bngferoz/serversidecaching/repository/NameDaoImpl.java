package com.bngferoz.serversidecaching.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.bngferoz.serversidecaching.entity.Name;

@Repository
public class NameDaoImpl implements NameDao {
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	private static final String KEY = "NAME";

	@Override
	public boolean saveName(Name name) {
		try {
			redisTemplate.opsForHash().put(KEY, name.getId(), name);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Name> getAllUsers() {
		List<Name> users;
		users = redisTemplate.opsForHash().values(KEY);
		return users;
	}

}
