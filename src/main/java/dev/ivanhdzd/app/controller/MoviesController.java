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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dev.ivanhdzd.app.model.Movie;
import dev.ivanhdzd.app.service.IMoviesService;
import dev.ivanhdzd.app.service.IStorageService;

@Controller
@RequestMapping(value = "/movies")
class MoviesController {
	@Autowired
	private IStorageService serviceStorage;

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
	 * Get all movies list view.
	 *
	 * @param model object to pass data to JSP template.
	 * @return JSP template name to render.
	 */
	@GetMapping(value = "")
	public String getMovies(Model model) {
		model.addAttribute("movies", serviceMovies.getAllMovies());
		return "movies/listMovies";
	}

	/**
	 * Get new movie form view.
	 *
	 * @param movie binding object.
	 * @param model object to pass data to JSP template.
	 * @return JSP template name to render.
	 */
	@GetMapping(value = "/create")
	public String createMovie(@ModelAttribute Movie movie, Model model) {
		model.addAttribute("genres", serviceMovies.getGenres());
		return "movies/formMovie";
	}

	/**
	 * Save new movie.
	 *
	 * @param movie      request parameter.
	 * @param result     binding result metadata.
	 * @param attributes flash attributes to pass to redirect route.
	 * @param multipart  file get from form.
	 * @return redirect to /movies
	 */
	@PostMapping(value = "/save")
	public String saveMovie(@ModelAttribute Movie movie, BindingResult result, RedirectAttributes attributes,
			@RequestParam("imageFile") MultipartFile multipart) {
		if (result.hasErrors()) {
			System.out.println("There are some errors:");
			result.getAllErrors().forEach(error -> System.out.println(error.getDefaultMessage()));
			return "movies/formMovie";
		}
		if (!multipart.isEmpty()) {
			movie.setImage(serviceStorage.uploadMovieImage(multipart));
		}
		serviceMovies.save(movie);
		attributes.addFlashAttribute("message", "New movie registry saved successfully.");
		return "redirect:/movies";
	}
}