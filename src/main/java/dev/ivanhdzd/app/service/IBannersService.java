package dev.ivanhdzd.app.service;

import java.util.List;

import dev.ivanhdzd.app.model.Banner;

public interface IBannersService {
	public List<Banner> getAll();
	public void save(Banner banner);
}