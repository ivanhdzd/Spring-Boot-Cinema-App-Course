package dev.ivanhdzd.app.service;

import dev.ivanhdzd.app.model.Detail;

public interface IDetailsService {
	void insert(Detail detail);
	void delete(int id);
}