package dev.ivanhdzd.app.service;

import java.util.Date;
import java.util.List;

import dev.ivanhdzd.app.model.Timetable;

public interface ITimetablesService {
	public List<Timetable> findByIdMovie(int id, Date date);
}