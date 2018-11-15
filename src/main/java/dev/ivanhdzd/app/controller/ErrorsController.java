package dev.ivanhdzd.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorsController implements ErrorController {
	/**
	 * Get error path.
	 *
	 * @return route to redirect.
	 */
	@Override
	public String getErrorPath() {
		return "/error";
	}

	/**
	 * Handle route error.
	 *
	 * @param request Http servlet request data.
	 * @param model   object to pass data to JSP template.
	 * @return JSP template name to render.
	 */
	@RequestMapping(value = "/error")
	public String handleError(HttpServletRequest request, Model model) {
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
		model.addAttribute("statusCode", statusCode);
		model.addAttribute("exception", exception);
		return "error";
	}
}