package com.primetgi.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.primetgi.org.dao.UserDAO;
import com.primetgi.org.dao.UserDAOImpl;
import com.primetgi.org.model.Users;

@Controller
public class UserController {

	@Autowired
	private UserDAO userDAO;
	
	@RequestMapping(value = "/")
	public ModelAndView home() {
		List<Users> listUsers = userDAO.list();
		ModelAndView model = new ModelAndView("home");
		model.addObject("listOfUsers", listUsers);
		return model;
		
	}
	
}
