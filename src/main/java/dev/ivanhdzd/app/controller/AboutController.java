package dev.ivanhdzd.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {
	/**
	 * Get about view.
	 * @return JSP template name to render.
	 */
	@GetMapping(value = "/about")
	public String getAbout() {
		return "about";
	}
}