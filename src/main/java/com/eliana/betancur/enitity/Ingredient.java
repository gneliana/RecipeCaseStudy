package com.eliana.betancur.enitity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "ingredients")
public class Ingredient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "ing_description", nullable = false)
	private String ingredientDescription;
	
	@Column(name = "amount", nullable = false)
	private String amount;
	
	@OneToOne(fetch = FetchType.EAGER)
	private Measurements uom;
	
	@ManyToOne
	private Recipe recipe;
	

	public Ingredient() {
		// TODO Auto-generated constructor stub
	}

	public Ingredient(String ingredientDescription, String amount, Measurements uom, Recipe recipe) {
		super();
		this.ingredientDescription = ingredientDescription;
		this.amount = amount;
		this.uom = uom;
		this.recipe = recipe;
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

	public Measurements getUom() {
		return uom;
	}

	public void setUom(Measurements uom) {
		this.uom = uom;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	

}
