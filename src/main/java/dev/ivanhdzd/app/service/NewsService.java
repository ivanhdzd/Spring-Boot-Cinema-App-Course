package dev.ivanhdzd.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import dev.ivanhdzd.app.enumerator.Status;
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

	/**
	 * Get all news, sort by publication date descending.
	 * @return News list.
	 */
	@Override
	public List<News> getAllNews() {
		return newsRepository.findAll(Sort.by("publicationDate").descending());
	}

	/**
	 * Get a news by it ID.
	 * @return News object.
	 */
	@Override
	public News getNewsById(int id) {
		Optional<News> optional = newsRepository.findById(id);
		if (optional.isPresent()) return optional.get();
		else return null;
	}

	/**
	 * Get a news list by it status order by publication date descending.
	 * @return News list.
	 */
	@Override
	public List<News> getNewsByStatus(Status status) {
		return newsRepository.findByStatusOrderByPublicationDateDesc(status);
	}
}