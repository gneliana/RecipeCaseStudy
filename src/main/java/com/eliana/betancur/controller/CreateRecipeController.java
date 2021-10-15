package com.eliana.betancur.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.eliana.betancur.aws.S3;
import com.eliana.betancur.dao.CategoryDAO;
import com.eliana.betancur.dao.IngredientDAO;
import com.eliana.betancur.dao.MeasurementsDAO;
import com.eliana.betancur.dao.RecipeDAO;
import com.eliana.betancur.dao.UserDAO;
import com.eliana.betancur.enitity.Category;
import com.eliana.betancur.enitity.Ingredient;
import com.eliana.betancur.enitity.Measurements;
import com.eliana.betancur.enitity.Recipe;
import com.eliana.betancur.enitity.User;
import com.eliana.betancur.form.CreateRecipeForm;


@Controller
public class CreateRecipeController {
	@Autowired
	private S3 s3;
	
	@Autowired
	private UserDAO userDao;
	
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
	public ModelAndView createRecipeSumit(@RequestParam("file") MultipartFile file, @Valid CreateRecipeForm form, BindingResult bindingResult) throws Exception {
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
		
		//Image Upload to S3
		
			// get the official temp directory from the OS
	    String tmpdir = System.getProperty("java.io.tmpdir");
        System.out.println("Temp file path: " + tmpdir);
	    
        	// create a filename that consists of the full path of the temp dir and the original uploaded file name
        File targetFile = new File(tmpdir + File.separator + file.getOriginalFilename());
	    
        	// commons io utility that will stream the uploaded file into the target file.  
        	// essenitally saves it to the hard drive.
        FileUtils.copyInputStreamToFile(file.getInputStream(), targetFile);
		
	    	// use our S3 libaray to write the file to S3
		s3.writeFile("case-study-recipe/images", file.getOriginalFilename(), targetFile);

			// business logic
		User user = new User();
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
		recipe.setImage("https://case-study-recipe.s3.us-east-2.amazonaws.com/images/" + file.getOriginalFilename());
		recipe.setDifficulty(form.getDifficulty());
		
		
		ingredient.setIngredientDescription(form.getIngredientDescription());
		ingredient.setAmount(form.getAmount());
		
		measurements.setMeasureDescription(form.getMeasureDescription());
		
		category.setDescription(form.getDescription());
		
		recipeDao.save(recipe);
		ingredientDao.save(ingredient);
		measurementsDao.save(measurements);
		categoryDao.save(category);
		user = userDao.getById(1);
		user.getRecipes().add(recipe);
		userDao.save(user);

		// goto the next page

		return result;
	}

	

}
