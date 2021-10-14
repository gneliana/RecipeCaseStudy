package com.eliana.betancur.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eliana.betancur.dao.CategoryDAO;
import com.eliana.betancur.dao.IngredientDAO;
import com.eliana.betancur.dao.MeasurementsDAO;
import com.eliana.betancur.dao.RecipeDAO;
import com.eliana.betancur.enitity.Category;
import com.eliana.betancur.enitity.Ingredient;
import com.eliana.betancur.enitity.Measurements;
import com.eliana.betancur.enitity.Recipe;
import com.eliana.betancur.form.CreateRecipeForm;



@Controller
public class CreateRecipeController {
	
	@Autowired
	private RecipeDAO recipeDao;
	
	@Autowired
	private IngredientDAO ingredientDao;
	
	@Autowired
	private MeasurementsDAO measurementsDao;
	
	@Autowired
	private CategoryDAO categoryDao;
	
	
	@RequestMapping(value = "/createRecipe", method = RequestMethod.GET)
	public ModelAndView createRecipePage() {
		ModelAndView result = new ModelAndView("recipe/createRecipe");
		result.addObject("form", new CreateRecipeForm());
		return result;
	}

	@RequestMapping(value = "/createRecipe", method = RequestMethod.POST)
	public ModelAndView createRecipeSumit(@Valid CreateRecipeForm form, BindingResult bindingResult) throws Exception {
		ModelAndView result = new ModelAndView("recipe/createRecipe");

		// form validation
		result.addObject("form", form);

		System.out.println(form);

		if (bindingResult.hasErrors()) {

			List<String> errors = new ArrayList<String>();

			for (FieldError error : bindingResult.getFieldErrors()) {
				System.out.println(error.getField() + " = " + error.getDefaultMessage());
				errors.add(error.getDefaultMessage());
			}

			result.addObject("errorFields", bindingResult.getFieldErrors());
			result.addObject("errors", errors);
			
			return result;
		} 

		// business logic
		Recipe recipe = new Recipe();
		Ingredient ingredient = new Ingredient();
		Measurements measurements = new Measurements();
		Category category = new Category();
		
		//user.setEmail(form.getEmail());
		recipe.setRecipeDescription(form.getRecipeDescription());
		recipe.setPrepTime(form.getPrepTime());
		recipe.setCookTime(form.getCookTime());
		recipe.setServings(form.getServings());
		recipe.setDirections(form.getDirections());
		
		ingredient.setIngredientDescription(form.getIngredientDescription());
		ingredient.setAmount(form.getAmount());
		
		measurements.setMeasureDescription(form.getMeasureDescription());
		
		category.setDescription(form.getDescription());
		
		recipeDao.save(recipe);
		ingredientDao.save(ingredient);
		measurementsDao.save(measurements);
		categoryDao.save(category);

		// goto the next page

		return result;
	}

	

}
