package me.whiteship.demospringsecurityform.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.access.vote.AffirmativeBased;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.access.expression.WebExpressionVoter;

@Configurable
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	public AccessDecisionManager accessDecisionManager() {
		RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
		roleHierarchy.setHierarchy("ROLE_ADMIN > ROLE_USER");

		DefaultWebSecurityExpressionHandler handler = new DefaultWebSecurityExpressionHandler();
		handler.setRoleHierarchy(roleHierarchy);

		WebExpressionVoter webExpressionVoter = new WebExpressionVoter();
		webExpressionVoter.setExpressionHandler(handler);
		List<AccessDecisionVoter<? extends Object>> voters = Arrays.asList();

		return new AffirmativeBased(voters);

	}

	public SecurityExpressionHandler expressionHandler() {
		RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
		roleHierarchy.setHierarchy("ROLE_ADMIN > ROLE_USER");

		DefaultWebSecurityExpressionHandler handler = new DefaultWebSecurityExpressionHandler();
		handler.setRoleHierarchy(roleHierarchy);

		return handler;

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.mvcMatchers("/","/info","/account/**").permitAll()
			.mvcMatchers("admin").hasRole("ADMIN")
			.mvcMatchers("user").hasRole("USER")
			.anyRequest().authenticated()
//			.accessDecisionManager(accessDecisionManager())
			.expressionHandler(expressionHandler());
		http.formLogin()
			.and()
		.httpBasic();
		
		// and 없이 http.formLogin() 가능
		
	}

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//		.withUser("jeongmin").password("{noop}123").roles("USER").and()
//		.withUser("admin").password("{noop}!@#").roles("ADMIN");
//		//이값들이 DB에들어가고 이값들이 암호화해서 들어간다.
//		//{noop} <- 암호화를 하지않았다. 보통은 암호화를 한다.
//	}

}
