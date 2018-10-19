package dev.ivanhdzd.app.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import dev.ivanhdzd.app.enumerator.Status;
import dev.ivanhdzd.app.model.Banner;

@Service
public class BannersService implements IBannersService {
	/** Banners list */
	private List<Banner> banners = new LinkedList<Banner>();

	/**
	 * Adds some banners to banners list.
	 */
	public BannersService() {
		try {
			Banner banner1 = new Banner();
			banner1.setId(1);
			banner1.setTitle("Kong skull island");
			banner1.setImage("slide1.jpg");

			Banner banner2 = new Banner();
			banner2.setId(2);
			banner2.setTitle("Beauty and the beast");
			banner2.setImage("slide2.jpg");

			Banner banner3 = new Banner();
			banner3.setId(3);
			banner3.setTitle("Fast and furious 8");
			banner3.setImage("slide3.jpg");

			Banner banner4 = new Banner();
			banner4.setId(4);
			banner4.setTitle("The boss baby");
			banner4.setImage("slide4.jpg");

			banners.add(banner1);
			banners.add(banner2);
			banners.add(banner3);
			banners.add(banner4);
		} catch (Exception e) {
			System.out.println("[ERROR] BannerService.BannerService(): " + e.getMessage());
		}
	}

	/**
	 * Return all banners list.
	 *
	 * @return banners list.
	 */
	@Override
	public List<Banner> getAll() {
		return banners.stream()
			.filter(banner -> Objects.equals(banner.getStatus(), Status.ACTIVE))
			.collect(Collectors.toList());
	}

	/**
	 * Save new banner registry.
	 *
	 * @param banner data object.
	 */
	@Override
	public void save(Banner banner) {
		System.out.println("Saving banner: " + banner);
		banners.add(banner);
	}
}