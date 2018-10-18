package dev.ivanhdzd.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import dev.ivanhdzd.app.service.IMoviesService;

@Controller
class DetailsController {
	/** Movies service reference */
	@Autowired
	private IMoviesService serviceMovies;

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
	public String getDetails(Model model, @PathVariable("id") int id, @RequestParam("searchDate") String searchDate) {
		model.addAttribute("movie", serviceMovies.searchById(id));
		return "details";
	}
}