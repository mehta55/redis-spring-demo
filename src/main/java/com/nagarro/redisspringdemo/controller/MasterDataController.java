package com.nagarro.redisspringdemo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.redisspringdemo.model.OrganizationModel;

@RestController
public class MasterDataController {
	
	
	private RedisTemplate<String, OrganizationModel> redisTemplate;
	private HashOperations<String, String, OrganizationModel> hashOps;
	
	@Autowired
	public MasterDataController(RedisTemplate<String, OrganizationModel> redisTemplate) {
		this.redisTemplate = redisTemplate;
		this.hashOps = this.redisTemplate.opsForHash();
	}
	
	@GetMapping("redis/orgs")
	public List<OrganizationModel> getData() {
		return hashOps.entries("Organization").values().stream().collect(Collectors.toList());
	}
}
