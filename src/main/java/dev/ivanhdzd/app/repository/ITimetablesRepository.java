package dev.ivanhdzd.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dev.ivanhdzd.app.model.Timetable;

@Repository
public interface ITimetablesRepository extends JpaRepository<Timetable, Integer> {
	/** movie.id = ? AND date = ? ORDER BY time */
	public List<Timetable> findByMovie_IdAndDateOrderByTime(int idMovie, Date date);

	/** SELECT * FROM timetables AS T JOIN movies AS M ON T.id_movie = M.id WHERE T.date = ? AND M.status = 'ACTIVE' GROUP BY T.id_movie ORDER BY M.id ASC */
	@Query("SELECT T FROM Timetable T WHERE T.date = :date AND T.movie.status = 'ACTIVE' GROUP BY T.movie ORDER BY T.movie.id ASC")
	public List<Timetable> findByDateWithActiveMovies(@Param("date") Date date);
}