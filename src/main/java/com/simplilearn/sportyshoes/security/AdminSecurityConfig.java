package com.simplilearn.sportyshoes.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.simplilearn.sportyshoes.entity.UserRole;

@EnableWebSecurity
@Configuration
@Order(1)
public class AdminSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("userDetailsServiceImpl")
	private UserDetailsService ssUserDetailsService;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder () {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManager();
	}
	
	protected void configure(AuthenticationManagerBuilder builder) throws Exception {
		builder.userDetailsService(ssUserDetailsService).passwordEncoder(passwordEncoder());
	}
	
	
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.antMatcher("/admin/**")
			.authorizeRequests().antMatchers("/admin/login","/admin/register","/admin/changePassword").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin().loginPage("/admin/login").permitAll().defaultSuccessUrl("/admin/products",true)
			.and()
			.logout().logoutUrl("/admin/logout").logoutSuccessUrl("/admin/login");
	}
	
	
	
}
