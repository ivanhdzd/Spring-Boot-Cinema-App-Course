package dev.ivanhdzd.app.service;

import java.util.List;

import dev.ivanhdzd.app.model.Movie;;

public interface IMoviesService {
	List<Movie> getAllMovies();
	Movie searchById(int id);
	void save(Movie movie);
	List<String> getGenres();
}