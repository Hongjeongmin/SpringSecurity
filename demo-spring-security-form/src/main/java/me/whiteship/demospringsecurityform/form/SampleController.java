package me.whiteship.demospringsecurityform.form;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import me.whiteship.demospringsecurityform.accont.AccountContext;
import me.whiteship.demospringsecurityform.accont.AccountRepository;

@Controller
public class SampleController {

	@Autowired
	public SampleService SampleService;

	@Autowired
	AccountRepository accountRepository;

	@GetMapping("/")
	public String index(Model model, Principal principal) {
		if (principal == null) {
			model.addAttribute("message", "Hello Spring Security");
		} else {
			model.addAttribute("message", "Hello" + principal.getName());

		}
		return "index";
	}

	@GetMapping("/info")
	public String info(Model model) {
		model.addAttribute("message", "info");
		return "info";
	}

	@GetMapping("/admin")
	public String admin(Model model, Principal principal) {
		model.addAttribute("message", "Hello" + principal.getName());
		return "admin";
	}
	@GetMapping("/user")
	public String user(Model model, Principal principal) {
		model.addAttribute("message", "Hello" + principal.getName());
		return "user";
	}

	@GetMapping("/dashboard")
	public String dashboard(Model model, Principal principal) {
		AccountContext.setAccount(accountRepository.findByUsername(principal.getName()));
		SampleService.dashboard();
		model.addAttribute("message", "Hello Admin" + principal.getName());
		return "dashboard";
	}

}
