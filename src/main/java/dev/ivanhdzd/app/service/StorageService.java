package dev.ivanhdzd.app.service;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
		return saveFile(multipart, context.getRealPath("resources") + "/img/banners/");
	}

	/**
	 * Upload a movie image file into server.
	 *
	 * @param multipart file to save into server.
	 * @return filename.
	 */
	@Override
	public String uploadMovieImage(MultipartFile multipart) {
		return saveFile(multipart, context.getRealPath("resources") + "/img/movies/");
	}

	/**
	 * Save an image into server.
	 *
	 * @param multipart file get from form.
	 * @param path where file will be saved.
	 * @return image name.
	 */
	private String saveFile(MultipartFile multipart, String path) {
		String name = randomAlphaNumeric(8) + multipart.getOriginalFilename().replace(" ", "-");
		try {
			File imageFile = new File(path + name);
			multipart.transferTo(imageFile);
			return name;
		} catch (Exception e) {
			System.out.println("[ERROR] Util.saveFile:" + e.getMessage());
			return null;
		}
	}

	/**
	 * Generate a random alpha numeric string.
	 *
	 * @param count number of characters to generate.
	 * @return random string generated.
	 */
	private String randomAlphaNumeric(int count) {
		String CHARACTERS = "ABCDEFGHIJKLMNOPQESTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		StringBuilder builder = new StringBuilder();
		while (count-- > 0) {
			int index = (int) (Math.random() * CHARACTERS.length());
			builder.append(CHARACTERS.charAt(index));
		}
		return builder.toString();
	}
}