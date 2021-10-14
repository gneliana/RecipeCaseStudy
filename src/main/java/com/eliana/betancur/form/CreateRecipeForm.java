package com.eliana.betancur.form;



import java.util.Arrays;

import javax.validation.constraints.NotEmpty;

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
	
	//Not added
	private Byte[] Image;
	
	//Category
	@NotEmpty(message = "Field cannot be empty")
	private String description;
	
	//Not added
	private String difficulty;
	
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

	public Byte[] getImage() {
		return Image;
	}

	public void setImage(Byte[] image) {
		Image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
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

	@Override
	public String toString() {
		return "CreateRecipeForm [recipeDescription=" + recipeDescription + ", prepTime=" + prepTime + ", cookTime="
				+ cookTime + ", servings=" + servings + ", directions=" + directions + ", Image="
				+ Arrays.toString(Image) + ", description=" + description + ", difficulty=" + difficulty
				+ ", measureDescription=" + measureDescription + ", ingredientDescription=" + ingredientDescription
				+ ", amount=" + amount + "]";
	}


	
	
	
}
