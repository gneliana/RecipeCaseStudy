package com.eliana.betancur.recipe;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.eliana.betancur.dao.UserDAO;
import com.eliana.betancur.enitity.Recipe;
import com.eliana.betancur.enitity.User;

@DataJpaTest
@TestMethodOrder(OrderAnnotation.class)
public class UserDAOTests {

	@Autowired
	private UserDAO userDao;

	@Test
	@Order(1)
	@Rollback(value = false)
	public void saveUserTest() {

		Recipe recipe = new Recipe();
		Set<Recipe> recipes = new HashSet<Recipe>();
		recipes.add(recipe);
		User user1 = User.builder().email("UT_e@gmail.com").password("UT_!Password123").fullName("UT_First Last")
				.recipes(recipes).build();

		userDao.save(user1);

		//Assertions.assertThat(user1.getId()).isGreaterThan(0);
		Assertions.assertThat(userDao.getById(user1.getId()).getId()).isEqualTo(1);
	}

	@Test
	@Order(2)
	public void getUserTest() {
		User user = userDao.getById(1);
		Assertions.assertThat(user.getId()).isEqualTo(1);
	}

	@Test
	@Order(3)
	public void getListOfUsers() {
		List<User> users = userDao.findAll();
		Assertions.assertThat(users.size()).isGreaterThan(0);
	}

	@Test
	@Order(4)
	@Rollback(value = false)
	public void updateUserTest() {
		User user = userDao.getById(1);
		user.setFullName("UT_Updated FullName");
		Assertions.assertThat(userDao.getById(1).getFullName()).isEqualTo(user.getFullName());
	}

	@Test
	@Order(5)
	@Rollback(value = false)
	public void deleteUserTest() {
		User user = userDao.findById(1).get();
		userDao.delete(user);
		Optional<User> optionalUser = Optional.ofNullable(userDao.findByEmail(user.getEmail()));

		User tempUser = null;
		if (optionalUser.isPresent()) {
			tempUser = optionalUser.get();
		}

		Assertions.assertThat(tempUser).isNull();
	}
}
