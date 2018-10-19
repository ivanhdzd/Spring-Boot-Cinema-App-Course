package dev.ivanhdzd.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.ivanhdzd.app.model.Timetable;

public interface ITimetablesRepository extends JpaRepository<Timetable, Integer> {}