package com.simplilearn.sportyshoes.service;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.simplilearn.sportyshoes.entity.User;
import com.simplilearn.sportyshoes.exception.SSException;
import com.simplilearn.sportyshoes.repo.UserRepo;

@Service
@Qualifier("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements SSUserDetailsService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUsername(username);
		if (user == null) 
			throw new UsernameNotFoundException("No such user in Database");
		
		List<GrantedAuthority> authorities = Arrays.asList(new GrantedAuthority[] {
			new SimpleGrantedAuthority(user.getRole().toString())	
		});
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(), authorities);
	}

	@Override
	@Transactional
	public User saveUser(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		user.setPasswordConfirm(encoder.encode(user.getPasswordConfirm()));
		return userRepo.save(user);
	}

	@Override
	public User findByUserName(String username) {
		return userRepo.findByUsername(username);
	}

	@Override
	public User savePassword(User user) throws SSException {
		
		if (user == null) 
			throw new UsernameNotFoundException("Invalid User");
		User dbUser = userRepo.findByUsername(user.getUsername());
		if (dbUser == null) 
			throw new UsernameNotFoundException("No Such User in Database");
		if (!encoder.matches(user.getPassword(), dbUser.getPassword()) ) {
			throw new SSException("Old password does not match database password");
		} 
		
		String encodedPwd = encoder.encode(user.getPasswordConfirm());
		dbUser.setPassword(encodedPwd);
		dbUser.setPasswordConfirm(encodedPwd);

		return userRepo.save(dbUser);	

	}
	
	
	public User getUserByUserName(String userName) throws SSException {
		if (userName == null) {
			throw new SSException("Invalid User Name");
		}
		return userRepo.findByUsername(userName);
	}
	
	@Override
	public List<User> getUsers() {
		return userRepo.findAll();
	}

	@Override
	public List<User> getUserByCriteria(String uname, String email) {
		return userRepo.findUserByCriteria(uname, email);
	}

	
}
