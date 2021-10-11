package com.simplilearn.sportyshoes.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.simplilearn.sportyshoes.entity.User;
import com.simplilearn.sportyshoes.exception.SSException;

@Service
public interface SSUserDetailsService extends UserDetailsService {

	public User saveUser(User user);
	
	public User savePassword(User user)  throws SSException;
	
	public User findByUserName(String username);
	
	public List<User> getUsers();
	
	
	public List<User> getUserByCriteria(String uname, String email);

}
