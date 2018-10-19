package dev.ivanhdzd.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.ivanhdzd.app.model.Detail;

public interface IDetailsRepository extends JpaRepository<Detail, Integer> {}