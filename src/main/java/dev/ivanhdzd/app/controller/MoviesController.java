package dev.ivanhdzd.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dev.ivanhdzd.app.model.Movie;
import dev.ivanhdzd.app.service.IDetailsService;
import dev.ivanhdzd.app.service.IMoviesService;
import dev.ivanhdzd.app.service.IStorageService;

@Controller
@RequestMapping(value = "/movies")
class MoviesController {
	/** Storage service instance reference */
	@Autowired
	private IStorageService serviceStorage;

	/** Movies service instance reference */
	@Autowired
	private IMoviesService serviceMovies;

	/** Details service instance reference */
	@Autowired
	private IDetailsService serviceDetails;

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
	public String getMovies(Model model, Pageable page) {
		model.addAttribute("movies", serviceMovies.getAllMovies(page));
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
		serviceDetails.insert(movie.getDetail());
		serviceMovies.insert(movie);
		attributes.addFlashAttribute("message", "New movie registry saved successfully.");
		return "redirect:/movies";
	}

	/**
	 * Edit movie selected.
	 *
	 * @param id    movie get from path variable.
	 * @param model object to pass data to JSP template.
	 * @return JSP template name to render.
	 */
	@GetMapping(value = "/edit/{id}")
	public String editMovie(@PathVariable("id") int id, Model model) {
		model.addAttribute("movie", serviceMovies.searchById(id));
		return "/movies/formMovie";
	}

	/**
	 * Delete a movie by it ID.
	 *
	 * @param id         movie to delete.
	 * @param attributes flash attributes to pass to redirect route.
	 * @return redirect to movies list.
	 */
	@GetMapping(value = "/delete/{id}")
	public String deleteMovie(@PathVariable("id") int id, RedirectAttributes attributes) {
		Movie movie = serviceMovies.searchById(id);
		serviceMovies.delete(id);
		serviceDetails.delete(movie.getDetail().getId());
		attributes.addFlashAttribute("message", "Movie deleted successfully.");
		return "redirect:/movies";
	}

	/**
	 * Set genres in each view inside this controller.
	 *
	 * @return genres list.
	 */
	@ModelAttribute("genres")
	public List<String> populateGenres() {
		return serviceMovies.getGenres();
	}
}