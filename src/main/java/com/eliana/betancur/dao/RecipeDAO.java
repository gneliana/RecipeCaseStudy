package com.eliana.betancur.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eliana.betancur.enitity.Recipe;


@Repository
public interface RecipeDAO extends JpaRepository<Recipe, Long> {

	public Recipe findById(@Param("id") Integer id);
	
	@Query(value = "select * from recipe.recipe r where lower(r.recp_description) like lower(concat('%', :recp_description,'%'))", nativeQuery = true)
	public List<Recipe> findByDescription(@Param("recp_description")String recipe);

}
