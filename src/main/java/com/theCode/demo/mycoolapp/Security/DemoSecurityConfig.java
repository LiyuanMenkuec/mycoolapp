package com.theCode.demo.mycoolapp.Security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/*
 * use Spring Security with user accounts stored in the database:
 * 1. create the appropriate tables with predefined schemas;
 * 2. set up the configuration;
 * 
 * or custom the tables:
 * 1. we'll create our custom tables with SQL.
 * 2. the Spring Security Configuration: provide a query to find a user by username, provide a query to find authorities/roles
 * 
 * */


@Configuration
public class DemoSecurityConfig {
	
	//add support for JDBC,
	@Bean
	public UserDetailsManager UserDetailsManager(DataSource dataSource) {
		JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
		
		//define query to retrieve a user by username
		jdbcUserDetailsManager.setUsersByUsernameQuery(
				"SELECT user_id,pw,active FROM members WHERE user_id=?");
		
		//define query to retrieve the authorities/roles by username
		jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
				"SELECT user_id,role FROM roles WHERE user_id=?");
		
		return jdbcUserDetailsManager;
		//return directly this object when using the default table form
		//return new JdbcUserDetailsManager(dataSource);
	}
	
	
	
	//Set access permissions for different user roles
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests(Configurer -> 
		Configurer
		.requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
		.requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
		.requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
		.requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
		.requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
		);
		
		//use HTTP Basic authentication
		http.httpBasic(Customizer.withDefaults());
		
		//disable Cross Site Request Forgery (CSRF)
		//ingeneral, not required for stateless REST APIs that usePOST, PUT, DELETE and/or PATCH
		http.csrf(csrf -> csrf.disable());
		
		return http.build();
	}
	
	/*
	//Set the information of login: user's name, password, role, etc. <-> hard coded in-memory data source
	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {
		
		UserDetails john = User.builder()
				.username("John")
				.password("{noop}test1")
				.roles("EMPLOYEE")
				.build();
		
		UserDetails kira = User.builder()
				.username("Kira")
				.password("{noop}test11")
				.roles("EMPLOYEE","MANAGER")
				.build();
		
		UserDetails jane = User.builder()
				.username("Jane")
				.password("{noop}test111")
				.roles("EMPLOYEE","MANAGER","ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(john,kira,jane);
		
	}*/

}
