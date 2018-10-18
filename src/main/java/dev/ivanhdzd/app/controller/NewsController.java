package dev.ivanhdzd.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dev.ivanhdzd.app.model.News;
import dev.ivanhdzd.app.service.INewsService;

@Controller
@RequestMapping(value = "/news")
public class NewsController {
	/** News service instance reference */
	@Autowired
	private INewsService serviceNews;

	/**
	 * Get news form view.
	 *
	 * @param news model attribute binded.
	 * @return JSP template name to render.
	 */
	@GetMapping(value = "/create")
	public String createNews(@ModelAttribute News news) {
		return "news/formNews";
	}

	/**
	 * Save new news data registry.
	 *
	 * @param news       model attribute binded.
	 * @param attributes flash to send feedback messages.
	 * @return JSP template name to render.
	 */
	@PostMapping(value = "/save")
	public String saveNews(@ModelAttribute News news, RedirectAttributes attributes) {
		serviceNews.save(news);
		attributes.addFlashAttribute("message", "New news registry saved successfully.");
		return "redirect:/news/create";
	}
}