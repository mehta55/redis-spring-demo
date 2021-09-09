package com.nagarro.redisspringdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.redisspringdemo.model.User;
import com.nagarro.redisspringdemo.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("redis/user")
	public User saveUser(@RequestBody User user) {
		userRepository.save(user);
		return user;
	}
	
	@Cacheable(value="users")
	@GetMapping("redis/users")
	public List<User> getUser() {
		return userRepository.getUsers();
	}
	
	@CachePut(value = "users", key = "#user.id")
	@PutMapping("redis/user")
	public User updatePersonByID(@RequestBody User user) {
	  userRepository.update(user);
	  return user;
	}
	
	@CacheEvict(value = "users")
	@DeleteMapping("redis/users")
	public void deleteUserByID(@PathVariable int id) {
	  userRepository.delete(id);
	}
	
	@CacheEvict(value = "users", allEntries = true)
	@DeleteMapping("redis/user")
	public String deleteAllUsers() {
	  return "Cache cleared";
	}
}
