package dev.ivanhdzd.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.ivanhdzd.app.model.Detail;
import dev.ivanhdzd.app.repository.IDetailsRepository;

@Service
public class DetailsService implements IDetailsService {
	/** Details repository instance reference */
	@Autowired
	private IDetailsRepository detailsRepository;

	/**
	 * Insert details registry into database.
	 *
	 * @param detail data to save.
	 */
	@Override
	public void insert(Detail detail) {
		detailsRepository.save(detail);
	}

	/**
	 * Delete a details registry by it ID.
	 *
	 * @param id details to delete.
	 */
	@Override
	public void delete(int id) {
		detailsRepository.deleteById(id);
	}
}