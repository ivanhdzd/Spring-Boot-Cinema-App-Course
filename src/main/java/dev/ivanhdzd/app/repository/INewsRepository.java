package dev.ivanhdzd.app.repository;

import org.springframework.data.repository.CrudRepository;

import dev.ivanhdzd.app.model.News;

public interface INewsRepository extends CrudRepository<News, Integer> {}