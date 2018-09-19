package com.bin.auth.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bin.auth.dao.UserDao;
import com.bin.auth.dao.entity.User;
import com.bin.auth.dto.CustomUserDetails;
import com.bin.auth.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		System.out.println("===================获取到token已进入自定义验证：" + username);

		User user = userDao.findUserByUsername(username);

		Set<GrantedAuthority> dbAuthsSet = new HashSet<GrantedAuthority>();

		dbAuthsSet.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

		List<GrantedAuthority> dbAuths = new ArrayList<GrantedAuthority>(dbAuthsSet);

		if (user == null) {
			System.out.println("===================" + username);
			throw new UsernameNotFoundException("Could not find the user '" + username + "'");
		}

		return new CustomUserDetails(user, true, true, true, true, dbAuths);

	}

}
