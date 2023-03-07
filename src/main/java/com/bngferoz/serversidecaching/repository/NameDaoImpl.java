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
		System.out.println("Getting users from the database");
		List<Name> users;
		users = redisTemplate.opsForHash().values(KEY);
		return users;
	}

	@Override
	public Name getById(Long id) {
		System.out.println("getById service called!! now connecting to db....");
		Name returnValue = new Name();
		try {
			returnValue = (Name) redisTemplate.opsForHash().get(KEY,id.toString());
		}catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		return returnValue;
	}

	@Override
	public Name getByName(String name) {
		Name returnValue = new Name();
		try {
			returnValue = (Name) redisTemplate.opsForHash().get(KEY,name);
		}catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		return returnValue;
	}

	@Override
	public Name getTopName() {
		List<Name> users;
		users = redisTemplate.opsForHash().values(KEY);
		return users.get(0);
	}

}
