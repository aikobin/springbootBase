package com.bin.auth.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bin.auth.dao.entity.User;

public interface UserDao extends JpaRepository<User, Integer>{

	public User findUserByUsername(String name);
}
