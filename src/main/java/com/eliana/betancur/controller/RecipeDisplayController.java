package com.eliana.betancur.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eliana.betancur.dao.RecipeDAO;
import com.eliana.betancur.enitity.Recipe;

@Controller
public class RecipeDisplayController {
	
	@Autowired
	private RecipeDAO recipeDao;
	
	@RequestMapping(value = "/recipeDisplay/{id}", method = RequestMethod.GET)
    public ModelAndView Controller(@PathVariable("id") String id) {		
		ModelAndView response = new ModelAndView();
		response.setViewName("recipe/recipeDisplay");
		
		Recipe recipe = recipeDao.findById(Integer.parseInt(id));
		response.addObject("recipe", recipe);

		return response;
    }

}
