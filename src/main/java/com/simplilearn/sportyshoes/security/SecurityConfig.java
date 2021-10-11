package com.simplilearn.sportyshoes.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
@Order(2)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("userDetailsServiceImpl")
	private UserDetailsService ssUserDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	
	protected void configure(AuthenticationManagerBuilder builder) throws Exception {
		builder.userDetailsService(ssUserDetailsService).passwordEncoder(encoder);
	}
	
	
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.antMatcher("/**")
			.authorizeRequests().antMatchers("/login","/register","/changePassword").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/user/products", true)
			.and()
			.logout().logoutUrl("/logout").logoutSuccessUrl("/login");
	}
	
	
	
}
