package com.bngferoz.serversidecaching.repository;

import java.util.List;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.bngferoz.serversidecaching.entity.Name;

@Repository
public class NameRepo {

	private RedisTemplate<String, Object> template;
	
	public static final String HASH_KEY = "Name";
	
	public Name save(Name name) {
		template.opsForHash().put(HASH_KEY, name.getId(), name);
		return name;
	}
	
	public List<Object> findAll(){
		return template.opsForHash().values(HASH_KEY);
	}
	
	public Object findNameById(int id) {
		return template.opsForHash().get(HASH_KEY, id);
	}
	
	public String deleteProduct(int id) {
		template.opsForHash().delete(HASH_KEY, id);
		return "deleted";
	}
}
