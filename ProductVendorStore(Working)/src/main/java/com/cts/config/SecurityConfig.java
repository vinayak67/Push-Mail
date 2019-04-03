package com.cts.config;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	private ProductAuthenticationSuccessHandler successHandler;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.passwordEncoder(passwordEncoder)
		.withUser("Vinayak").password(passwordEncoder.encode("vinayak")).roles("USER");
		
		auth.inMemoryAuthentication()
		.passwordEncoder(passwordEncoder)
		.withUser("vendor").password(passwordEncoder.encode("vendor")).roles("VENDOR");
		
		auth.inMemoryAuthentication()
		.passwordEncoder(passwordEncoder)
		.withUser("admin").password(passwordEncoder.encode("admin")).roles("USER","ADMIN");
		
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/product/**").permitAll()
		.antMatchers("/vendor/**").hasAnyRole("USER","VENDOR")
		.antMatchers("/admin/**").hasRole("ADMIN")
		.antMatchers("/**").hasAnyRole("ADMIN","USER")
		.and().formLogin().successHandler(successHandler)
		.and().logout().logoutSuccessUrl("/login")
		.invalidateHttpSession(true)
		.permitAll()
		.and().csrf().disable();

	}

}
