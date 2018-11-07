package dev.ivanhdzd.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.ivanhdzd.app.model.Timetable;

@Repository
public interface ITimetablesRepository extends JpaRepository<Timetable, Integer> {
	/** movie.id = ${ idMovie } AND date = ${ date } ORDER BY time */
	public List<Timetable> findByMovie_IdAndDateOrderByTime(int idMovie, Date date);
}