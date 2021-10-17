package com.eliana.betancur.recipe;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.eliana.betancur.dao.RecipeDAO;
import com.eliana.betancur.enitity.Difficulty;
import com.eliana.betancur.enitity.Recipe;

@DataJpaTest
@TestMethodOrder(OrderAnnotation.class)
public class RecipeDAOTests {

	@Autowired
	private RecipeDAO recipeDAO;

	@Test
	@Order(1)
	@Rollback(value = false)
	public void saveRecipeTest() {

		Recipe recipe = Recipe.builder().recipeDescription("Fajitas").prepTime("1").cookTime("10").servings("2")
				.directions("Cook It").Image("IMAGE URL").categories(null).difficulty(Difficulty.EASY).ingredient(null)
				.build();

		recipeDAO.save(recipe);

		Assertions.assertThat(recipe.getId()).isGreaterThan(0);
	}

	@Test
	@Order(2)
	public void getRecipeTest() {
		Recipe recipe = recipeDAO.findById(1);
		Assertions.assertThat(recipe.getId()).isEqualTo(1);
	}

	@Test
	@Order(3)
	public void getListOfRecipes() {
		List<Recipe> recipes = recipeDAO.findAll();
		Assertions.assertThat(recipes.size()).isGreaterThan(0);
	}

	@Test
	@Order(4)
	@Rollback(value = false)
	public void updateRecipeTest() {
		Recipe recipe = recipeDAO.findById(1);
		recipe.setCookTime("UT_Updated CookTime");
		Assertions.assertThat(recipeDAO.findById(1).getCookTime()).isEqualTo(recipe.getCookTime());
	}

	@Test
	@Order(5)
	@Rollback(value = false)
	public void deleteRecipeTest() {
		Recipe recipe = recipeDAO.findById(1);
		recipeDAO.delete(recipe);
		Optional<Recipe> optionalRecipe = Optional.ofNullable(recipeDAO.findById(recipe.getId()));

		Recipe tempRecipe = null;
		if (optionalRecipe.isPresent()) {
			tempRecipe = optionalRecipe.get();
		}

		Assertions.assertThat(tempRecipe).isNull();
	}
}
