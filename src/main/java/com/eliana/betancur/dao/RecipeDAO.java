package com.eliana.betancur.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eliana.betancur.enitity.Recipe;


@Repository
public interface RecipeDAO extends JpaRepository<Recipe, Long> {

	public Recipe findById(@Param("id") Integer id);

}
