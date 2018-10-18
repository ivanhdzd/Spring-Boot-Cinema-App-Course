package dev.ivanhdzd.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.ivanhdzd.app.model.News;
import dev.ivanhdzd.app.repository.INewsRepository;

@Service
public class NewsService implements INewsService {
	/** News repository instance reference */
	@Autowired
	private INewsRepository newsRepository;

	/**
	 * Save news item.
	 *
	 * @param news data.
	 */
	@Override
	public void save(News news) {
		System.out.println("Saving news: " + news);
		newsRepository.save(news);
	}
}