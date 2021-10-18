package com.eliana.betancur.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.eliana.betancur.enitity.Recipe;




public class SearchController {
	
	@RequestMapping("/search")
	public ModelAndView search(@RequestParam(required = false) String search) {
		ModelAndView response = new ModelAndView();
		response.setViewName("search");

		List<Recipe> recipe = new ArrayList<Recipe>();

		if (!StringUtils.isEmpty(search)) {
		
			recipe = recipeDao.findByEmailStartsWith(search);
		}

		response.addObject("recipe", recipe);
		response.addObject("search", search);

		return response;
	}
	

}
