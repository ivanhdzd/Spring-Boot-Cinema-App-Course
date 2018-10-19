package dev.ivanhdzd.app.service;

import java.util.List;

import dev.ivanhdzd.app.enumerator.Status;
import dev.ivanhdzd.app.model.News;

public interface INewsService {
	void save(News news);
	List<News> getAllNews();
	News getNewsById(int id);
	List<News> getNewsByStatus(Status status);
}