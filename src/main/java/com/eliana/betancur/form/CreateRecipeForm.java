package com.eliana.betancur.form;



import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;

import com.eliana.betancur.enitity.Difficulty;

public class CreateRecipeForm {
	
	@NotEmpty(message = "Field cannot be empty")
	private String recipeDescription;
	
	@NotEmpty(message = "Field cannot be empty")
	private String prepTime;
	
	@NotEmpty(message = "Field cannot be empty")
	private String cookTime;
	
	@NotEmpty(message = "Field cannot be empty")
	private String servings;
	
	@NotEmpty(message = "Field cannot be empty")
	private String directions;

	private String Image;
	
	//Category
	@NotEmpty(message = "Field cannot be empty")
	private String description;
	
	//Not added
	//private String difficulty;
	@Enumerated(EnumType.STRING)
    private Difficulty difficulty;
	
	@NotEmpty(message = "Field cannot be empty")
	private String measureDescription;
	
	//Ingredient name
	@NotEmpty(message = "Field cannot be empty")
	private String ingredientDescription;
	
	@NotEmpty(message = "Field cannot be empty")
	private String amount;

	public String getRecipeDescription() {
		return recipeDescription;
	}

	public void setRecipeDescription(String recipeDescription) {
		this.recipeDescription = recipeDescription;
	}

	public String getPrepTime() {
		return prepTime;
	}

	public void setPrepTime(String prepTime) {
		this.prepTime = prepTime;
	}

	public String getCookTime() {
		return cookTime;
	}

	public void setCookTime(String cookTime) {
		this.cookTime = cookTime;
	}

	public String getServings() {
		return servings;
	}

	public void setServings(String servings) {
		this.servings = servings;
	}

	public String getDirections() {
		return directions;
	}

	public void setDirections(String directions) {
		this.directions = directions;
	}

	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	public String getMeasureDescription() {
		return measureDescription;
	}

	public void setMeasureDescription(String measureDescription) {
		this.measureDescription = measureDescription;
	}

	public String getIngredientDescription() {
		return ingredientDescription;
	}

	public void setIngredientDescription(String ingredientDescription) {
		this.ingredientDescription = ingredientDescription;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	
}
