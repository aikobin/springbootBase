package com.bin.springboot.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.bin.springboot.core.PageInfo;
import com.bin.springboot.dao.entity.User;

public interface UserService {
	
	public User saveUser(User user);
	
	public User findUser(Integer id);
	
	public void removeUser(Integer id);
	
	public List<User> findAllUser(User user);
	
	public Page<User> findUserPage(User user,PageInfo pageInfo);
}
