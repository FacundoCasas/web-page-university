package com.ProyectoSpring.backendProyect.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ProyectoSpring.backendProyect.constant.ViewConstant;

@Controller
public class LoginController {

	private static final Log LOG = LogFactory.getLog(LoginController.class);

	@GetMapping("/login")
	public String showLoginForm(Model model, 
			@RequestParam(name = "error", required = false) String error,
			@RequestParam(name = "logout", required = false) String logout) {
		LOG.info("METHOD: showLoginForm() -- PARAMS: error=" + error + ", logout=" + logout);
		model.addAttribute("error", error);
		model.addAttribute("logout", logout);
		LOG.info("Returning to login view");
		return ViewConstant.LOGIN;
	}

	@GetMapping({ "/loginsuccess", "/" })
	public String loginCheck() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		LOG.info("ROL SELECCIONADO: " + auth.getAuthorities().toString() + " detail: " + auth.getPrincipal()
				+ " credentials: " + auth.getCredentials());
		if (auth.getAuthorities().toString().equals("[ROLE_ADMIN]")) {
			LOG.info("METHOD: loginCheck() ROLE: admin");
			return "redirect:/subjects/showsubjects";
		} else if (auth.getAuthorities().toString().equals("[ROLE_STUDENT]")) {
			LOG.info("METHOD: loginCheck() ROLE: student");
			return "redirect:/students/showsubjectsforstudent";
		} else {
			LOG.info("error");
			return "redirect:/login";
		}
	}
}
