package dev.ivanhdzd.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import dev.ivanhdzd.app.service.IMoviesService;
import dev.ivanhdzd.app.service.ITimetablesService;

@Controller
class DetailsController {
	/** Movies service reference */
	@Autowired
	private IMoviesService serviceMovies;

	/** Timetables service instance reference */
	@Autowired
	private ITimetablesService serviceTimetables;

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
	 * Get movie details. Includes a decorator that indicates this method is a route
	 * that response to GET method.
	 *
	 * @param model      object to pass data to JSP template.
	 * @param id         movie to get it data.
	 * @param searchDate to filter movie data.
	 * @return JSP template name to render.
	 */
	@GetMapping(value = "/details/{id}")
	public String getDetails(Model model, @PathVariable("id") int id, @RequestParam("searchDate") Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		System.out.println(id + " " + date);
		model.addAttribute("timetables", serviceTimetables.findByIdMovie(id, date));
		model.addAttribute("searchDate", dateFormat.format(date));
		model.addAttribute("movie", serviceMovies.searchById(id));
		return "details";
	}
}