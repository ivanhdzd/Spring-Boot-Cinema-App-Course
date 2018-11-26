package dev.ivanhdzd.app.controller;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import dev.ivanhdzd.app.model.Role;
import dev.ivanhdzd.app.model.User;
import dev.ivanhdzd.app.service.IRoleService;
import dev.ivanhdzd.app.service.IUserService;

@Controller
public class LoginController {
	/** Users service instance reference */
	@Autowired
	private IUserService userService;

	/** Roles service instance reference */
	@Autowired
	private IRoleService roleService;

	/**
	 * Get sign in view.
	 *
	 * @return JSP template name to render.
	 */
	@GetMapping(value = "/sign-in")
	public String getSignIn() {
		return "signIn";
	}

	/**
	 * Get sign up view.
	 *
	 * @param model object to pass data to JSP template.
	 * @return JSP template name to render.
	 */
	@GetMapping(value = "/sign-up")
	public String getSignUp(Model model) {
		if (userService.thereAreUsersRegisterd())
			return "redirect:/sign-in";
		User user = new User();
		Role adminRole = roleService.getRole("ADMINISTRATOR");
		user.setRoles(new HashSet<Role>(Arrays.asList(adminRole)));
		model.addAttribute("user", user);
		model.addAttribute("isAdmin", true);
		model.addAttribute("formActionPostUrl", "/sign-up");
		return "users/formUser";
	}

	/**
	 * Create new manager user if there aren't any user already registered.
	 *
	 * @param user request parameter.
	 * @return redirect to sign in route view.
	 */
	@PostMapping(value = "/sign-up")
	public String postSignUp(@ModelAttribute User user) {
		if (userService.thereAreUsersRegisterd())
			return "redirect:/sign-in";
		Role adminRole = roleService.getRole("ADMINISTRATOR");
		user.setRoles(new HashSet<Role>(Arrays.asList(adminRole)));
		user.setActive(1);
		System.out.println("\n" + user + "\n");
		userService.saveUser(user);
		return "redirect:/sign-in";
	}
}