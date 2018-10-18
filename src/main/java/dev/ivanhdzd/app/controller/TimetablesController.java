package dev.ivanhdzd.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dev.ivanhdzd.app.model.Timetable;
import dev.ivanhdzd.app.service.IMoviesService;

@Controller
@RequestMapping(value = "/timetables")
public class TimetablesController {
	/** Movies service instance reference */
	@Autowired
	private IMoviesService serviceMovies;

	/**
	 * Initialize binder object to set some binding formats.
	 *
	 * @param binder Spring web data binder object.
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	/**
	 * Get new timetable form view.
	 *
	 * @param timetable binding object.
	 * @param model     object to pass data to JSP template.
	 * @return JSP template name to render.
	 */
	@GetMapping(value = "/create")
	public String createTimetable(@ModelAttribute Timetable timetable, Model model) {
		model.addAttribute("movies", serviceMovies.getAllMovies());
		return "timetables/formTimetable";
	}

	/**
	 * Save movie form data.
	 *
	 * @param timetable  binding object.
	 * @param result     binding result metadata.
	 * @param attributes flash attributes to pass to redirect route.
	 * @return JSP template name.
	 */
	@PostMapping(value = "/save")
	public String saveTimetable(@ModelAttribute Timetable timetable, BindingResult result, Model model,
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			System.out.println("There are some errors:");
			result.getAllErrors().forEach(error -> System.out.println(error.getDefaultMessage()));
			model.addAttribute("movies", serviceMovies.getAllMovies());
			return "timetables/formTimetable";
		}
		attributes.addFlashAttribute("message", "New timetable registry saved successfully.");
		return "redirect:/timetables/create";
	}
}