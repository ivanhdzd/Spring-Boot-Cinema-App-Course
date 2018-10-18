package dev.ivanhdzd.app.service;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import dev.ivanhdzd.app.Enumerator.Status;
import dev.ivanhdzd.app.model.Movie;

@Service
public class MoviesService implements IMoviesService {
	/** Movies list */
	private List<Movie> movies = new LinkedList<Movie>();

	/**
	 * Adds some movies to movies list.
	 */
	public MoviesService() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		try {
			Movie movie1 = new Movie();
			movie1.setId(1);
			movie1.setTitle("Power Rangers");
			movie1.setDuration(120);
			movie1.setClassification("B");
			movie1.setGenre("Adventure");
			movie1.setPremiereDate(formatter.parse("02-05-2017"));

			Movie movie2 = new Movie();
			movie2.setId(2);
			movie2.setTitle("La bella y la bestia");
			movie2.setDuration(132);
			movie2.setClassification("A");
			movie2.setGenre("Childish");
			movie2.setPremiereDate(formatter.parse("20-05-2017"));
			movie2.setImage("bella.png");

			Movie movie3 = new Movie();
			movie3.setId(3);
			movie3.setTitle("Contratiempo");
			movie3.setDuration(106);
			movie3.setClassification("B");
			movie3.setGenre("Thriller");
			movie3.setPremiereDate(formatter.parse("28-05-2017"));
			movie3.setImage("contratiempo.png");

			Movie movie4 = new Movie();
			movie4.setId(4);
			movie4.setTitle("Kong La Isla Calavera");
			movie4.setDuration(118);
			movie4.setClassification("B");
			movie4.setGenre("Action");
			movie4.setPremiereDate(formatter.parse("06-06-2017"));
			movie4.setImage("kong.png");
			movie4.setStatus(Status.INACTIVE);

			Movie movie5 = new Movie();
			movie5.setId(5);
			movie5.setTitle("Life: Vida Inteligente");
			movie5.setDuration(104);
			movie5.setClassification("B");
			movie5.setGenre("Drama");
			movie5.setPremiereDate(formatter.parse("10-06-2017"));
			movie5.setImage("estreno5.png");

			Movie movie6 = new Movie();
			movie6.setId(6);
			movie6.setTitle("Revolver");
			movie6.setDuration(115);
			movie6.setClassification("B");
			movie6.setGenre("Suspense");
			movie6.setPremiereDate(formatter.parse("17-10-2005"));
			movie6.setImage("revolver.jpg");

			Movie movie7 = new Movie();
			movie7.setId(7);
			movie7.setTitle("RocknRolla");
			movie7.setDuration(114);
			movie7.setClassification("B");
			movie7.setGenre("Suspense");
			movie7.setPremiereDate(formatter.parse("27-01-2009"));
			movie7.setImage("rocknrolla.jpg");

			Movie movie8 = new Movie();
			movie8.setId(8);
			movie8.setTitle("Snatch");
			movie8.setDuration(104);
			movie8.setClassification("B");
			movie8.setGenre("Suspense");
			movie8.setPremiereDate(formatter.parse("21-03-2001"));
			movie8.setImage("snatch.jpg");
			movie8.setStatus(Status.INACTIVE);

			movies.add(movie1);
			movies.add(movie2);
			movies.add(movie3);
			movies.add(movie4);
			movies.add(movie5);
			movies.add(movie6);
			movies.add(movie7);
			movies.add(movie8);
		} catch (Exception e) {
			System.out.println("[ERROR] MoviesService.MoviesService(): " + e.getMessage());
		}
	}

	/**
	 * Return all movies list.
	 *
	 * @return movies list.
	 */
	@Override
	public List<Movie> getAllMovies() {
		return movies;
	}

	/**
	 * Search a movie by it ID.
	 *
	 * @param id movie ID.
	 * @return movie.
	 */
	@Override
	public Movie searchById(int id) {
		return movies.stream().filter(movie -> Objects.equals(movie.getId(), id)).findFirst().orElse(null);
	}

	/**
	 * Save new movie registry.
	 *
	 * @param movie data object.
	 */
	@Override
	public void save(Movie movie) {
		System.out.println("Saving movie: " + movie);
		movies.add(movie);
	}

	/**
	 * Get all movie genres.
	 *
	 * @return genres list.
	 */
	@Override
	public List<String> getGenres() {
		List<String> genres = new LinkedList<String>();
		genres.add("Action");
		genres.add("Adventure");
		genres.add("Classic");
		genres.add("Comedy");
		genres.add("Drama");
		genres.add("Terror");
		genres.add("Childish");
		genres.add("Romantic");
		return genres;
	}
}