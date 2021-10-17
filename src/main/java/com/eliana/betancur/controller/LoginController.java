package com.eliana.betancur.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eliana.betancur.dao.UserDAO;
import com.eliana.betancur.enitity.User;
import com.eliana.betancur.form.CreateUserForm;


@Service
@RequestMapping("/")
public class LoginController {
	
	@Autowired
	private UserDAO userDao;
	
	public LoginController() {
		System.out.println("PostConstruct Reference to UserDAO = " + userDao);
	}
	
	@PostConstruct
	public void init() {
		System.out.println("PostConstruct Reference to UserDAO = " + userDao);
	}
	
	@RequestMapping(value = "/createUser", method = RequestMethod.GET)
	public ModelAndView createUserPage() {
		ModelAndView result = new ModelAndView("login/createUser");
		result.addObject("form", new CreateUserForm());
		return result;
	}

	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public ModelAndView createUserSubmit(@Valid CreateUserForm form, BindingResult bindingResult) throws Exception {
		ModelAndView result = new ModelAndView("login/login");

		// form validation
		result.addObject("form", form);

		System.out.println(form);

		if (bindingResult.hasErrors()) {

			List<String> errors = new ArrayList<String>();

			for (FieldError error : bindingResult.getFieldErrors()) {
				System.out.println(error.getField() + " = " + error.getDefaultMessage());
				errors.add(error.getDefaultMessage());
			}

			result.addObject("errorFields", bindingResult.getFieldErrors());
			result.addObject("errors", errors);
			
			return result;
		} 

		// business logic
		User user = new User();
		
		user.setEmail(form.getEmail());
		user.setPassword(form.getPassword());
		user.setFullName(form.getFullName());	
		
		userDao.save(user);

		// goto the next page

		return result;
	}

	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		ModelAndView result = new ModelAndView("redirect:/login");
		return result;
	}


	@RequestMapping(value = "/login")
	public ModelAndView login() {
		ModelAndView result = new ModelAndView("login/login");
		return result;
	}
	
	@RequestMapping(value = "/login/login")
	public ModelAndView login2() {
		ModelAndView result = new ModelAndView("login/login");
		return result;
	}
 //Eliana!1234
}
