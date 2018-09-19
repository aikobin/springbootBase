package com.bin.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bin.springboot.dao.entity.User;

public interface UserDao extends JpaRepository<User,Integer>{

	public User findUserById(Integer id);
}
