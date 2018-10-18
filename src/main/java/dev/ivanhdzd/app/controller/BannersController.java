package dev.ivanhdzd.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dev.ivanhdzd.app.model.Banner;
import dev.ivanhdzd.app.service.IBannersService;
import dev.ivanhdzd.app.service.IStorageService;

@Controller
@RequestMapping(value = "/banners")
public class BannersController {
	@Autowired
	private IStorageService serviceStorage;

	/** Banner service instance reference */
	@Autowired
	private IBannersService serviceBanners;

	/**
	 * Get banners list view.
	 *
	 * @param model object to pass data to JSP template.
	 * @return JSP template name to render.
	 */
	@GetMapping("")
	public String getBanners(Model model) {
		model.addAttribute("banners", serviceBanners.getAll());
		return "banners/listBanners";
	}

	/**
	 * Get banner form view.
	 *
	 * @param banner model attribute binded.
	 * @return JSP template name to render.
	 */
	@GetMapping(value = "/create")
	public String createBanner(@ModelAttribute Banner banner) {
		return "banners/formBanner";
	}

	/**
	 * Save new banner.
	 *
	 * @param banner     request parameter.
	 * @param result     binding result metadata.
	 * @param attributes flash attributes to pass to redirect route.
	 * @param multipart  file get from form.
	 * @return redirect to /banners
	 */
	@PostMapping(value = "/save")
	public String saveBanner(@ModelAttribute Banner banner, BindingResult result, RedirectAttributes attributes,
			@RequestParam("imageFile") MultipartFile multipart) {
		if (result.hasErrors()) {
			System.out.println("There are some errors:");
			result.getAllErrors().forEach(error -> System.out.println(error.getDefaultMessage()));
			return "banners/formBanner";
		}
		if (!multipart.isEmpty()) {
			banner.setImage(serviceStorage.uploadBannerImage(multipart));
		}
		serviceBanners.save(banner);
		attributes.addFlashAttribute("message", "New banner registry saved successfully.");
		return "redirect:/banners";
	}
}