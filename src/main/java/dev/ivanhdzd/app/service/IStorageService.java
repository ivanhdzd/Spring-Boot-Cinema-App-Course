package dev.ivanhdzd.app.service;

import org.springframework.web.multipart.MultipartFile;

public interface IStorageService {
	public String uploadBannerImage(MultipartFile multipart);
	public String uploadMovieImage(MultipartFile multipart);
}