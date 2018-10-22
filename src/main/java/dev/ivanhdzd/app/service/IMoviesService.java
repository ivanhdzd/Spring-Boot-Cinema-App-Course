package dev.ivanhdzd.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import dev.ivanhdzd.app.model.Movie;;

public interface IMoviesService {
	long countMovies();
	List<Movie> getAllMovies();
	Page<Movie> getAllMovies(Pageable page);
	Movie searchById(int id);
	void insert(Movie movie);
	List<String> getGenres();
	void delete(int id);
}