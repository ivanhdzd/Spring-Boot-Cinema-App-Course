package dev.ivanhdzd.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import dev.ivanhdzd.app.Util;
import dev.ivanhdzd.app.service.IBannersService;
import dev.ivanhdzd.app.service.IMoviesService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
class HomeController {
	/** Banners service reference */
	@Autowired
	private IBannersService serviceBanners;

	/** Movies service reference */
	@Autowired
	private IMoviesService serviceMovies;

	/** Date format object */
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

	/**
	 * Get home page.
	 * Includes a decorator that indicates this method is a route that response to GET method.
	 * @param model object to pass data to JSP template.
	 * @return JSP template name to render.
	 */
	@GetMapping(value = "/")
	public String getHome(Model model) {
		model.addAttribute("banners", serviceBanners.getAll());
		model.addAttribute("movies", serviceMovies.getAllMovies());
		model.addAttribute("searchDate", dateFormat.format(new Date()));
		model.addAttribute("nextDays", Util.getNextDays(4));
		return "home";
	}

	/**
	 * Post search form data.
	 * Includes a decorator that indicates this method is a route that response to GET method.
	 * @param model object to pass data to JSP template.
	 * @return JSP template name to render.
	 */
	@PostMapping(value = "/search")
	public String postSearch(Model model, @RequestParam("searchDate") String searchDate) {
		model.addAttribute("banners", serviceBanners.getAll());
		model.addAttribute("movies", serviceMovies.getAllMovies());
		model.addAttribute("searchDate", searchDate);
		model.addAttribute("nextDays", Util.getNextDays(4));
		return "home";
	}
}