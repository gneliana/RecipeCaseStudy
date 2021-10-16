package com.eliana.betancur.enitity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "recipe")
public class Recipe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	//This is the title of the recipe
	@Column(name = "recp_description")
	private String recipeDescription;
	
	@Column(name = "prep_time")
	private String prepTime;
	
	@Column(name = "cook_time")
	private String cookTime;
	
	@Column(name = "servings")
	private String servings;
	
	@Lob
	@Column(name = "directions")
	private String directions;
	
	
	@Column(name = "image")
	private String Image;
	
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "recipe_category",
    joinColumns = @JoinColumn(name = "recipe_id"),
    inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories;

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    @OneToMany (cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredient;
    
//    @ManyToOne(cascade = CascadeType.ALL)
//    private User user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public Set<Category> getCategories() {
		return categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	public Set<Ingredient> getIngredient() {
		return ingredient;
	}

	public void setIngredient(Set<Ingredient> ingredient) {
		this.ingredient = ingredient;
	}

    
	
    

}
