package dev.ivanhdzd.app.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class HomeController {
	@Value("${messages.hello}")
	private String helloMessage;

	@GetMapping("/")
	public String getHome(Model model) {
		model.addAttribute("helloMessage", helloMessage);
		return "index";
	}
}