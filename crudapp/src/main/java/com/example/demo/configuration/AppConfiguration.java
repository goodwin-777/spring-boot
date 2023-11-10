package com.example.demo.configuration;
//
//import javax.sql.DataSource;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//import org.springframework.security.provisioning.UserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class AppConfiguration {
//	
//	
//	public String passwordEncryptor(String password) {
//		return new BCryptPasswordEncoder().encode(password);
//		
//	}
//	@Bean
//	public UserDetailsManager uDetailsManager(DataSource source) {
//		JdbcUserDetailsManager manager = new JdbcUserDetailsManager(source);
//		manager.setUsersByUsernameQuery("select name,password,status from employee where name=?");
//		manager.setAuthoritiesByUsernameQuery("select name, role from Role where name=?");
//		return manager;
//	}
//
//	@Bean
//	public SecurityFilterChain role(HttpSecurity security) throws Exception {
//		security.authorizeHttpRequests(
//				http-> {http
////							.requestMatchers(HttpMethod.GET, "/**").hasRole("ADMIN")
////							.requestMatchers(HttpMethod.PUT, "/**").hasRole("ADMIN")
////							.requestMatchers(HttpMethod.POST, "/**").hasRole("ADMIN")
////							.requestMatchers(HttpMethod.DELETE, "/**").hasRole("ADMIN")
////							
//							.requestMatchers(HttpMethod.GET, "/apple/macbooks").hasRole("STAFF")
//							.requestMatchers(HttpMethod.GET, "/apple/macbooks/**").hasRole("STAFF")
//							.requestMatchers(HttpMethod.POST, "/apple/macbooks").hasRole("MANAGER")
//							.requestMatchers(HttpMethod.PUT, "/apple/macbooks").hasRole("MANAGER")
//							.requestMatchers(HttpMethod.DELETE, "/apple/macbooks/**").hasRole("ADMIN")
//							
//							.requestMatchers(HttpMethod.GET, "/apple/employees").hasRole("STAFF")
//							.requestMatchers(HttpMethod.GET, "/apple/employees/**").hasRole("STAFF")
//							.requestMatchers(HttpMethod.POST, "/apple/employees").hasRole("MANAGER")
//							.requestMatchers(HttpMethod.PUT, "/apple/employees").hasRole("MANAGER")
//							.requestMatchers(HttpMethod.DELETE, "/apple/employees/**").hasRole("ADMIN");
//				
//				});
//		security.csrf(csrf->csrf.disable());
//		security.httpBasic(Customizer.withDefaults());
//		return security.build();
//	}
//}
