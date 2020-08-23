package me.whiteship.demospringsecurityform.form;

import org.springframework.stereotype.Service;

import me.whiteship.demospringsecurityform.accont.Account;
import me.whiteship.demospringsecurityform.accont.AccountContext;

@Service
public class SampleService {
	public void dashboard() {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		// 인증을 한 사용자를 나타낸다
//		// 사용자의 권한은 authentication이
//		Object principal = authentication.getPrincipal();
//		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
//		Object credentials = authentication.getCredentials();
//		boolean authenticated = authentication.isAuthenticated();
		
		Account account = AccountContext.getAccount();
		System.out.println("==========");
		System.out.println(account.getUsername());
	}
}
