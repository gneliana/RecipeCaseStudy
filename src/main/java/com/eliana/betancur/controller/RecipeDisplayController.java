package com.eliana.betancur.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class RecipeDisplayController {
	@RequestMapping(value = "/recipeDisplay", method = RequestMethod.GET)
	public ModelAndView recipeDisplay() {
		ModelAndView response = new ModelAndView();
		response.setViewName("recipeDisplay");
		return response;
	}

}
