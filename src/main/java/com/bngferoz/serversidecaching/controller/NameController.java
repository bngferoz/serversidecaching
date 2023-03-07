package com.bngferoz.serversidecaching.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bngferoz.serversidecaching.entity.Name;
import com.bngferoz.serversidecaching.service.NameService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/name")
@Tag(name = "1. Server Side Cache Controller", description = "Server Side Cache Related APIs")
@CrossOrigin("*")
@EnableCaching
public class NameController {
	
	
	@Autowired
	private NameService nameService;
	
	@PostMapping("/saveName")
	public ResponseEntity<String> saveName(@RequestBody Name name){
		
		boolean result = nameService.saveName(name);
		if(result) {
			return ResponseEntity.ok("Name Inserted!");
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping("/getAllName")
	public ResponseEntity<List<Name>> fetchAllName(){
	
		List<Name> nameList = new ArrayList<>();
		nameList = nameService.fetchAllUsers();
		return ResponseEntity.ok(nameList);
	}
	
	@GetMapping("/getTopName")
	@Cacheable(value = "NAME")
	public ResponseEntity<Name> fetchTopName(){
	
		Name topName = new Name();
		topName = nameService.fetchTopName();
		return ResponseEntity.ok(topName);
	}
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Name> getById(@PathVariable("id") Long id){
	
		Name returnValue = new Name();
		returnValue = nameService.getById(id);
		return ResponseEntity.ok(returnValue);
	}
	
	@GetMapping("/getbyname/{name}")
	public ResponseEntity<Name> getByName(@PathVariable("name") String name){
	
		Name returnValue = new Name();
		returnValue = nameService.getByName(name);
		return ResponseEntity.ok(returnValue);
	}
	

}
