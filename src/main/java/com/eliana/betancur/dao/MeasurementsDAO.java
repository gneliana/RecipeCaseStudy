package com.eliana.betancur.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eliana.betancur.enitity.Measurements;

@Repository
public interface MeasurementsDAO extends JpaRepository<Measurements, Long>{
	
	public Measurements findById(@Param("id") Integer id);

}
