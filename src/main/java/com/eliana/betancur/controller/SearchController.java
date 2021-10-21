package com.eliana.betancur.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.eliana.betancur.dao.RecipeDAO;
import com.eliana.betancur.enitity.Recipe;


@Controller
public class SearchController {
	
	@Autowired
	private RecipeDAO recipeDao;
	
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView search1() {
		ModelAndView response = new ModelAndView();
		response.setViewName("search");
		return response;
	}
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView search(@RequestParam(required = false) String search) {
		ModelAndView response = new ModelAndView();
		response.setViewName("search");

		List<Recipe> recipes = new ArrayList<Recipe>();
		if (!StringUtils.isEmpty(search)) {
			if(search.contains(" ")){
		    	search= search.substring(0, search.indexOf(" ")); 
		     } 			
			recipes = recipeDao.findByDescription(search);
		}

		recipes.forEach(
				(n)->System.out.println(n.toString())
				);
		response.addObject("recipe", recipes);
		response.addObject("search", search);

		return response;
	}
	

}
