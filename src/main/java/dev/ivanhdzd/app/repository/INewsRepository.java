package dev.ivanhdzd.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.ivanhdzd.app.enumerator.Status;
import dev.ivanhdzd.app.model.News;

@Repository
public interface INewsRepository extends JpaRepository<News, Integer> {
	/** SELECT * FROM news WHERE status = ? ORDER BY publication_date DESC */
	List<News> findByStatusOrderByPublicationDateDesc(Status status);
}