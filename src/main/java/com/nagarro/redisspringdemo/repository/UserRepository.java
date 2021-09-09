package com.nagarro.redisspringdemo.repository;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.nagarro.redisspringdemo.model.User;

@Repository
public class UserRepository {

	private List<User> users;

	@PostConstruct
	private void startRepo() {
		this.users = new ArrayList<User>();
		this.users.add(new User(1, "sahil", "123"));
		this.users.add(new User(2, "ankit", "123"));
		this.users.add(new User(3, "kshtiz", "123"));
		this.users.add(new User(4, "sandeep", "123"));
		
		
		System.out.println(this.users);
	}

	public void save(User user) {
		this.users.add(user);
	}
	
	public List<User> getUsers() {
		System.out.println("from repo");
		return this.users;
	}

	public User get(int id) {
		System.out.println("-----------  finding user " + id +" ------------");
		for (int i = 0; i < this.users.size(); i++) {
			if (this.users.get(i).getId() == id) {
				return this.users.get(i);
			}
		}
		return null;
	}
	
	public User update(User user) {
		System.out.println("-----------  finding user for update " + user.getId() + " ------------");
		
		User oldUser = get(user.getId());
		oldUser.setId(user.getId());
		oldUser.setName(user.getName());
		oldUser.setPassword(user.getPassword());
		
		return oldUser;
	}
	
	public void delete(int id) {
		System.out.println("-----------  finding user delete " + id + "------------");
		for (int i = 0; i < this.users.size(); i++) {
			if (this.users.get(i).getId() == id) {
				this.users.remove(i);
			}
		}
	}
}
