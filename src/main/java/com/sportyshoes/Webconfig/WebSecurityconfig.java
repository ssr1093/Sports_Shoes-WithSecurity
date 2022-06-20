package com.sportyshoes.Webconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityconfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userdetailsservice;

//	@Autowired
//	private BCryptPasswordEncoder passwordencoder;

	@Bean
	AuthenticationProvider authenticationprovider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userdetailsservice);
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		return provider;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "/home","/product").permitAll()
				.antMatchers(HttpMethod.GET,"/order").hasAnyRole("USER", "ADMIN")
				.antMatchers(HttpMethod.PUT).hasRole("ADMIN")
				.antMatchers(HttpMethod.DELETE, "/product/{productid}", "/product/new", "/admin").hasRole("ADMIN")
				.anyRequest().authenticated().and().formLogin() // (5)
				.loginPage("/login") // (5)
				.permitAll().and().logout() // (6)
				.permitAll().and().httpBasic();
		http.cors().disable();
		http.csrf().disable();
		http.headers().frameOptions().disable();

		
	}
	
}
