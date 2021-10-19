package com.eliana.betancur.controller;

import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.eliana.betancur.dao.UserDAO;
import com.eliana.betancur.enitity.Recipe;
import com.eliana.betancur.enitity.User;

@Controller
public class UserController {

	@Autowired
	private UserDAO userDao;
	
	
//	@RequestMapping(value = "/login/userPortal", method = RequestMethod.GET)
//	public ModelAndView userPortal1() {
//		ModelAndView response = new ModelAndView();
//		response.setViewName("/login/userPortal");
//		return response;
//	}
	@RequestMapping(value = "/login/userPortal")
	public ModelAndView userPortal() {
		ModelAndView response = new ModelAndView();
		response.setViewName("login/userPortal");

		User user = userDao.findByEmail(getUserEmail());
		Set<Recipe> recipes = user.getRecipes();

		response.addObject("recipe", recipes);
		response.addObject("user", user);

		return response;
	}
	
	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		ModelAndView result = new ModelAndView("redirect:/home");
		return result;
	}
	
	public String getUserEmail() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			String username = ((UserDetails)principal).getUsername();
			return username;
		} else {
			String username = principal.toString();
			return "";
		}
	}
}
