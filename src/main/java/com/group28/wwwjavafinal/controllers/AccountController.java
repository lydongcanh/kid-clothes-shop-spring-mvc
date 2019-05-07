package com.group28.wwwjavafinal.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AccountController {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model,
		@RequestParam("username") String username,
		@RequestParam("password") String password) {
		logger.debug("login: " + username + ", " + password);
		return "home";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register() {
		return "home";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		return "home";
	}	
	
	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public String openLoginPage(Model model) {
		logger.debug("Opening Login Page...");
		return "loginPage";
	}
}
