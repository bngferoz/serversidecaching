package com.bngferoz.serversidecaching.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bngferoz.serversidecaching.entity.Name;
import com.bngferoz.serversidecaching.repository.NameRepo;

@RestController
@RequestMapping("/name")
public class NameController {
	
	@Autowired
	private NameRepo nameRepo;
	
	@PostMapping
	public Name save(@RequestBody Name name) {
		return nameRepo.save(name);
	}
	
	@GetMapping
	public List<Object> getAllName(){
		return nameRepo.findAll();
	}
	
	public Object findNameById(@PathVariable int id) {
		return  nameRepo.findNameById(id);
	}
}
