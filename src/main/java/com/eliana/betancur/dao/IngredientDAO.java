package com.eliana.betancur.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eliana.betancur.enitity.Ingredient;



@Repository
public interface IngredientDAO extends JpaRepository<Ingredient, Long> {

	public Ingredient findById(@Param("id") Integer id);

}
