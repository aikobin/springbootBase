package com.bin.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bin.springboot.core.PageInfo;
import com.bin.springboot.dao.UserDao;
import com.bin.springboot.dao.entity.User;
import com.bin.springboot.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	// @CachePut表示缓存新添加的数据或者更新的数据到缓存中，两个参数value表示缓存的名称为user，key表示缓存的user为person的id
	@CachePut(value = "user", key = "#user.id")
	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return userDao.save(user);
	}

	// @CacheEvict表示从缓存user中删除key为id的数据
	@CacheEvict(value = "user")
	@Override
	public void removeUser(Integer id) {
		userDao.delete(id);
	}

	// @Cacheable表示添加数据到缓存中，缓存名称为user，缓存key为参数id
	@Cacheable(value = "user")
	@Override
	public User findUser(Integer id) {
		// TODO Auto-generated method stub
		// 创建匹配器，即如何使用查询条件
		User user = new User();
		user.setId(id);
		ExampleMatcher matcher = ExampleMatcher.matching();
		Example<User> ex = Example.of(user, matcher);
		userDao.findAll(ex);
		// User returnUser = userDao.findUserById(id);
		return userDao.findAll(ex).get(0);
	}
	
	@Override
	public List<User> findAllUser(User user) {
		ExampleMatcher matcher = ExampleMatcher.matching();
		Example<User> ex = Example.of(user, matcher);
		return userDao.findAll(ex);
	}

	@Override
	public Page<User> findUserPage(User user, PageInfo pageInfo) {
		ExampleMatcher matcher = ExampleMatcher.matching();
		Example<User> ex = Example.of(user, matcher);
		Pageable pageable = new PageRequest(pageInfo.getPageNum() - 1, pageInfo.getPageSize());
		return userDao.findAll(ex, pageable);
	}

}
