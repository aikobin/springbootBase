package com.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.dao.entity.User;

public interface UserDao extends JpaRepository<User,Integer>{

	public User findUserById(Integer id);
}
