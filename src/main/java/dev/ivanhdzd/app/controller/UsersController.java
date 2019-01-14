package dev.ivanhdzd.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.ivanhdzd.app.model.User;
import dev.ivanhdzd.app.service.IRoleService;
import dev.ivanhdzd.app.service.IUserService;

@Controller
@RequestMapping(value = "/users")
public class UsersController {
	/** Users service instance reference */
	@Autowired
	private IUserService userService;

	/** Roles service instance reference */
	@Autowired
	private IRoleService roleService;

	/**
	 * Return users list view.
	 *
	 * @param model object to pass data to JSP template.
	 * @return JSP template name to render.
	 */
	@GetMapping(value = "")
	public String getUsersList(Model model) {
		model.addAttribute("users", userService.getAllUsersWithoutAdmin());
		return "users/listUsers";
	}

	/**
	 * Return form user to create new user.
	 *
	 * @param user  binding object.
	 * @param model object to pass data to JSP template.
	 * @return JSP template name to render.
	 */
	@GetMapping(value = "/create")
	public String createUser(@ModelAttribute User user, Model model) {
		model.addAttribute("rolesList", roleService.getAllRolesWithoutAdmin());
		model.addAttribute("formUserUrl", "/users");
		return "users/formUser";
	}

	/**
	 * Return form user to update an user.
	 *
	 * @param id    user get from path variable.
	 * @param model object to pass data to JSP template.
	 * @return JSP template name to render.
	 */
	@GetMapping(value = "/edit/{id}")
	public String editUser(@PathVariable("id") int id, Model model) {
		User user = userService.findUserById(id);
		if (user == null)
			return "redirect:/users";

		user.setPassword(null);
		model.addAttribute("user", user);
		model.addAttribute("rolesList", roleService.getAllRolesWithoutAdmin());
		model.addAttribute("formUserUrl", "/users");
		return "users/formUser";
	}

	/**
	 * Delete an user and redirect to users list view.
	 *
	 * @param id user get from path variable.
	 * @return JSP template name to render.
	 */
	@GetMapping(value = "/delete/{id}")
	public String deleteUser(@PathVariable("id") int id) {
		userService.delete(id);
		return "redirect:/users";
	}

	/**
	 * Save user data.
	 *
	 * @param user request parameter.
	 * @return JSP template name to render.
	 */
	@PostMapping(value = "/save")
	public String saveUser(@ModelAttribute User user) {
		userService.saveUser(user);
		return "redirect:/users";
	}
}