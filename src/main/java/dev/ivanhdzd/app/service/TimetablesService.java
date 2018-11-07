package dev.ivanhdzd.app.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.ivanhdzd.app.model.Timetable;
import dev.ivanhdzd.app.repository.ITimetablesRepository;

@Service
public class TimetablesService implements ITimetablesService {
	/** Timetables repository instance reference */
	@Autowired
	private ITimetablesRepository timetablesRepository;

	/**
	 * Get all movie timetables.
	 *
	 * @param idMovie to filter timetables.
	 * @param date    to filter timetables.
	 * @return timetables list.
	 */
	@Override
	public List<Timetable> findByIdMovie(int idMovie, Date date) {
		return timetablesRepository.findByMovie_IdAndDateOrderByTime(idMovie, date);
	}
}