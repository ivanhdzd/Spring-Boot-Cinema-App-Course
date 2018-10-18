package dev.ivanhdzd.app.controller;

import java.util.List;
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dev.ivanhdzd.app.model.Contact;
import dev.ivanhdzd.app.service.IMoviesService;

@Controller
public class ContactController {
	/** Movies service instance reference */
	@Autowired
	private IMoviesService serviceMovies;

	/**
	 * Get contact form view.
	 *
	 * @param contact model attribute binded.
	 * @param model   object to pass data to JSP template.
	 * @return JSP template name to render.
	 */
	@GetMapping(value = "/contact")
	public String createContact(@ModelAttribute Contact contact, Model model) {
		model.addAttribute("genresList", serviceMovies.getGenres());
		model.addAttribute("typeNotifications", getTypeNotifications());
		return "formContact";
	}

	/**
	 * Save new contact data registry.
	 *
	 * @param contact    model attribute binded.
	 * @param model      object to pass data to JSP template.
	 * @param attributes flash to send feedback messages.
	 * @return JSP template name to render.
	 */
	@PostMapping(value = "/contact")
	public String saveContact(@ModelAttribute Contact contact, Model model, RedirectAttributes attributes) {
		model.addAttribute("genresList", serviceMovies.getGenres());
		model.addAttribute("typeNotifications", getTypeNotifications());
		attributes.addFlashAttribute("message", "Your contact information was saved successfully.");
		System.out.println("\n" + contact + "\n");
		return "redirect:/contact";
	}

	/**
	 * Get type notifications list.
	 *
	 * @return Type notifications list
	 */
	private List<String> getTypeNotifications() {
		List<String> typeNotifications = new LinkedList<String>();
		typeNotifications.add("Premieres");
		typeNotifications.add("Promotions");
		typeNotifications.add("News");
		typeNotifications.add("Presales");
		return typeNotifications;
	}
}