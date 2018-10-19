package dev.ivanhdzd.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.ivanhdzd.app.model.Movie;

@Repository
public interface IMoviesRepository extends JpaRepository<Movie, Integer> {}