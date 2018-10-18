package dev.ivanhdzd.app.service;

import org.springframework.stereotype.Service;

import dev.ivanhdzd.app.model.News;

@Service
public class NewsService implements INewsService {
	/**
	 * Save news item.
	 * @param news data.
	 */
	@Override
	public void save(News news) {
		System.out.println("Saving news: " + news);
	}
}