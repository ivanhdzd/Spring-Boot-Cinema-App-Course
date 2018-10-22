package dev.ivanhdzd.app.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import dev.ivanhdzd.app.model.Movie;
import dev.ivanhdzd.app.repository.IMoviesRepository;

@Service
public class MoviesService implements IMoviesService {
	/** Movies repository instance reference */
	@Autowired
	private IMoviesRepository moviesRepository;

	/**
	 * Get movies count.
	 *
	 * @return movies count.
	 */
	@Override
	public long countMovies() {
		return moviesRepository.count();
	}

	/**
	 * Return all movies list.
	 *
	 * @return movies list.
	 */
	@Override
	public List<Movie> getAllMovies() {
		return moviesRepository.findAll();
	}

	/**
	 * Get all movies implementing pagination.
	 *
	 * @param page Spring object.
	 * @return movies list page.
	 */
	@Override
	public Page<Movie> getAllMovies(Pageable page) {
		return moviesRepository.findAll(page);
	}

	/**
	 * Search a movie by it ID.
	 *
	 * @param id movie ID.
	 * @return movie.
	 */
	@Override
	public Movie searchById(int id) {
		Optional<Movie> optional = moviesRepository.findById(id);
		if (optional.isPresent()) return optional.get();
		else return null;
	}

	/**
	 * Insert new movie registry.
	 *
	 * @param movie data object.
	 */
	@Override
	public void insert(Movie movie) {
		moviesRepository.save(movie);
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
		genres.add("Childish");
		genres.add("Classic");
		genres.add("Comedy");
		genres.add("Drama");
		genres.add("Romantic");
		genres.add("Terror");
		genres.add("Thriller");
		return genres;
	}

	/**
	 * Delete a movie by it ID.
	 *
	 * @param id movie to delete.
	 */
	@Override
	public void delete(int id) {
		moviesRepository.deleteById(id);
	}
}