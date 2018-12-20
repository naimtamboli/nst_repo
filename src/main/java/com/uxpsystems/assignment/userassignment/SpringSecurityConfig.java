package com.uxpsystems.assignment.userassignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	private static final String USERNAME = "admin";
	private static final String PASSWORD = "password";
	private static final String ROLE = "USER";
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().requireCsrfProtectionMatcher(new AntPathRequestMatcher("**/login"))
		.and().authorizeRequests().antMatchers("/user").hasRole(ROLE)
		.antMatchers("/adduser").hasRole(ROLE)
		.antMatchers("/updateuser/*").hasRole(ROLE)
		.antMatchers("/deleteuser/*").hasRole(ROLE)
		.and().formLogin().defaultSuccessUrl("/user")
				.loginPage("/login").and().logout().permitAll();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser(USERNAME).password("{noop}"+PASSWORD).roles(ROLE);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/*.css");
		web.ignoring().antMatchers("/*.js");
		web.ignoring().antMatchers("/dbconsole/*");
	}
}