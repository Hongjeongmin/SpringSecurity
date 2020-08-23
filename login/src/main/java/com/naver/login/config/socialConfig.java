package com.naver.login.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.google.connect.GoogleConnectionFactory;
import org.springframework.social.oauth2.OAuth2Parameters;

@Configuration
public class socialConfig {

	@Bean
	public GoogleConnectionFactory connectionFactory() {
		return new GoogleConnectionFactory("504055526892-0mmnnv34n2935mnc7u1jk7ukav085r91.apps.googleusercontent.com",
				"Bq6CJAzyM_CSLCFzhPysBDvL");
	}

	@Bean
	public OAuth2Parameters auth2Parameters(){
		OAuth2Parameters googleauth2Parameter = new OAuth2Parameters();
		googleauth2Parameter.setRedirectUri("http://localhost:8080/google/callback");
		googleauth2Parameter.setScope("https://www.googleapis.com/auth/plus.login");
		return googleauth2Parameter;
	}

}
