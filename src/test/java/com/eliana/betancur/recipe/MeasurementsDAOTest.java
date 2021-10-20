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

import com.eliana.betancur.dao.MeasurementsDAO;
import com.eliana.betancur.enitity.Measurements;



@DataJpaTest
@TestMethodOrder(OrderAnnotation.class)
public class MeasurementsDAOTest {
	
	@Autowired
	private MeasurementsDAO measurementsDAO;
	
	@Test
	@Order(1)
	@Rollback(value = false)
	public void saveMeasurementsTest() {

		Measurements recipe = Measurements.builder().measureDescription("Pound")
				.build();

		measurementsDAO.save(recipe);

		Assertions.assertThat(recipe.getId()).isGreaterThan(0);
	}
	
	@Test
	@Order(2)
	public void getIngredientTest() {
		Measurements measurements = measurementsDAO.findById(1);
		Assertions.assertThat(measurements.getId()).isEqualTo(1);
	}
	
	@Test
	@Order(3)
	public void getListOfMeasurements() {
		List<Measurements> measurements = measurementsDAO.findAll();
		Assertions.assertThat(measurements.size()).isGreaterThan(0);
	}
	
	@Test
	@Order(4)
	@Rollback(value = false)
	public void updateMeasurementsTest() {
		Measurements measurements = measurementsDAO.findById(1);
		measurements.setMeasureDescription("tomato");
		Assertions.assertThat(measurementsDAO.findById(1).getMeasureDescription()).isEqualTo(measurements.getMeasureDescription());
	}
	
	@Test
	@Order(5)
	@Rollback(value = false)
	public void deleteMeasurementsTest() {
		Measurements measurements = measurementsDAO.findById(1);
		measurementsDAO.delete(measurements);
		Optional<Measurements> optionalMeasurements = Optional.ofNullable(measurementsDAO.findById(measurements.getId()));

		Measurements tempMeasurements = null;
		if (optionalMeasurements.isPresent()) {
			tempMeasurements = optionalMeasurements.get();
		}

		Assertions.assertThat(tempMeasurements).isNull();
	}
	

}
