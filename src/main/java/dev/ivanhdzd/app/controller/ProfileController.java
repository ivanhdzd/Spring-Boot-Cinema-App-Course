package dev.ivanhdzd.app.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dev.ivanhdzd.app.model.User;
import dev.ivanhdzd.app.service.IUserService;

@Controller
@RequestMapping(value = "/profile")
public class ProfileController {
	/** Users service instance reference */
	@Autowired
	private IUserService userService;

	/**
	 * Get user form.
	 *
	 * @param principal user authenticated.
	 * @param model     object to pass data to JSP template.
	 * @return JSP template name to render.
	 */
	@GetMapping(value = "")
	public String getProfile(Principal principal, Model model) {
		User user = userService.findUserByEmail(principal.getName());
		user.setPassword(null);
		model.addAttribute("user", user);
		model.addAttribute("showChangePassword", true);
		model.addAttribute("formUserUrl", "/profile");
		return "/users/formUser";
	}

	/**
	 * Save user data.
	 *
	 * @param principal user authenticated.
	 * @param user      request parameter.
	 * @return JSP template name to render.
	 */
	@PostMapping(value = "/save")
	public String saveUser(Principal principal, @ModelAttribute User user) {
		User user2validate = userService.findUserByEmail(principal.getName());
		if (user2validate.getId() == user.getId())
			userService.saveUser(user);
		return "redirect:/users";
	}

	/**
	 * Return form user to change user password.
	 *
	 * @return JSP template name to render.
	 */
	@GetMapping(value = "/change-password")
	public String getChangePassword() {
		return "/users/formPassword";
	}

	/**
	 * Change password.
	 *
	 * @param principal user authenticated.
	 * @param oldPassword to validate.
	 * @param password to update.
	 * @return JSP template name to render.
	 */
	@PostMapping(value = "/change-password")
	public String updatePassword(Principal principal, @RequestParam("old-password") String oldPassword,
			@RequestParam("password") String password) {
		System.out.println("\nOld password: " + oldPassword);
		System.out.println("New password: " + password + "\n");
		return "redirect:/profile";
	}
}