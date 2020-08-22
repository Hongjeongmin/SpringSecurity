package me.whiteship.demospringsecurityform.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configurable
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.mvcMatchers("/","/info").permitAll()
			.mvcMatchers("admin").hasRole("ADMIN")
			.anyRequest().authenticated()
			.and()
		.formLogin()
			.and()
		.httpBasic();
	}

}
