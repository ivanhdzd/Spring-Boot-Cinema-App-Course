package dev.ivanhdzd.app.service;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import dev.ivanhdzd.app.Util;

@Service
public class StorageService implements IStorageService {
	/** Servlet context service reference */
	@Autowired
	private ServletContext context;

	/**
	 * Upload a banner image file into server.
	 *
	 * @param multipart file to save into server.
	 * @return filename.
	 */
	@Override
	public String uploadBannerImage(MultipartFile multipart) {
		return Util.saveFile(multipart, context.getRealPath("resources") + "/img/banners/");
	}

	/**
	 * Upload a movie image file into server.
	 *
	 * @param multipart file to save into server.
	 * @return filename.
	 */
	@Override
	public String uploadMovieImage(MultipartFile multipart) {
		return Util.saveFile(multipart, context.getRealPath("resources") + "/img/movies/");
	}
}