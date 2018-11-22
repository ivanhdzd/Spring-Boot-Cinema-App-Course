package dev.ivanhdzd.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import dev.ivanhdzd.app.Util;
import dev.ivanhdzd.app.enumerator.Status;
import dev.ivanhdzd.app.service.IBannersService;
import dev.ivanhdzd.app.service.IMoviesService;
import dev.ivanhdzd.app.service.INewsService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
class HomeController {
	/** Banners service instance reference */
	@Autowired
	private IBannersService serviceBanners;

	/** Movies service instance reference */
	@Autowired
	private IMoviesService serviceMovies;

	/** News service instance reference */
	@Autowired
	private INewsService serviceNews;

	/**
	 * Get home page. Includes a decorator that indicates this method is a route
	 * that response to GET method.
	 *
	 * @param model object to pass data to JSP template.
	 * @return JSP template name to render.
	 */
	@GetMapping(value = { "/", "/home" })
	public String getHome(Model model) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		try {
			model.addAttribute("banners", serviceBanners.getAll());
			model.addAttribute("searchDate", dateFormat.format(new Date()));
			model.addAttribute("nextDays", Util.getNextDays(4));
			model.addAttribute("movies", serviceMovies.getActiveMoviesByDate(new Date()));
			model.addAttribute("newsList", serviceNews.getTop3NewsByStatus(Status.ACTIVE));
		} catch (Exception ex) {
			System.out.println("[ERROR]: HomeController.postSearch: " + ex.getMessage());
		}
		return "home";
	}

	/**
	 * Post search form data. Includes a decorator that indicates this method is a
	 * route that response to GET method.
	 *
	 * @param model object to pass data to JSP template.
	 * @return JSP template name to render.
	 */
	@PostMapping(value = "/search")
	public String postSearch(Model model, @RequestParam("searchDate") String date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		try {
			model.addAttribute("banners", serviceBanners.getAll());
			model.addAttribute("searchDate", date);
			model.addAttribute("nextDays", Util.getNextDays(4));
			model.addAttribute("movies", serviceMovies.getActiveMoviesByDate(dateFormat.parse(date)));
			model.addAttribute("newsList", serviceNews.getTop3NewsByStatus(Status.ACTIVE));
		} catch (Exception ex) {
			System.out.println("[ERROR]: HomeController.postSearch: " + ex.getMessage());
		}
		return "home";
	}
}