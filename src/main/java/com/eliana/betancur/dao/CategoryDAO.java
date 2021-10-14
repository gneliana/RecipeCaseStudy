package com.eliana.betancur.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eliana.betancur.enitity.Category;

@Repository
public interface CategoryDAO extends JpaRepository<Category, Long>{
	
	public Category findById(@Param("id") Integer id);

}
