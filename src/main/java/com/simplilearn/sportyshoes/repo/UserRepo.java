package com.simplilearn.sportyshoes.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.simplilearn.sportyshoes.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	User findByUsername(String username);
	
	@Query("from User u where u.username like %:uname% and u.emailId like %:email%")
	public List<User> findUserByCriteria(String uname, String email);
	
}
