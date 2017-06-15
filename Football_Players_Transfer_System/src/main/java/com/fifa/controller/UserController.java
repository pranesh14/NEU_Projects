package com.fifa.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fifa.dao.BidDAO;
import com.fifa.dao.TeamDAO;
import com.fifa.dao.UserDAO;
import com.fifa.entity.TeamDebit;
import com.fifa.entity.TeamsTable;
import com.fifa.entity.UsersTable;
import com.fifa.exception.TeamException;
import com.fifa.exception.UserException;
import com.fifa.validator.UserValidator;

@Controller
public class UserController {

	@Autowired
	UserValidator userValidator;

	@Autowired
	UserDAO userDao;

	@Autowired
	TeamDAO teamDao;
	
	@Autowired
	BidDAO bidDao;

	@InitBinder("user")
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(userValidator);
	}

	// user login - FIFA, Team
	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	protected ModelAndView loginUser(HttpServletRequest request) throws Exception {

		HttpSession session = (HttpSession) request.getSession();

		try {

			String username = request.getParameter("username");
			String password = request.getParameter("password");
			UsersTable u = userDao.get(username, password);
			TeamsTable team = null;

			if (u == null) {
				System.out.println("UserName/Password does not exist");
				session.setAttribute("errorMessage", "UserName/Password does not exist");
				return new ModelAndView("error", "errorMessage", "UserName/Password does not exist");
			}

			if (!u.getRole().equalsIgnoreCase("ORGANIZATION_ADMIN")) {
				team = teamDao.getTeam(u);
			}

			session.setAttribute("user", u);
			session.setAttribute("team", team);

			List<String> countries = new ArrayList();
			countries.add("India");
			countries.add("England");
			countries.add("Germany");
			countries.add("Italy");
			countries.add("Spain");
			countries.add("France");
			countries.add("Argentina");
			countries.add("Brazil");
			countries.add("Netherland");
			countries.add("Belgium");
			countries.add("Sweden");
			countries.add("Portugal");
			countries.add("Wales");
			countries.add("Ivory Coast");
			countries.add("Ecuador");
			countries.add("Columbia");
			countries.add("Chile");
			countries.add("North Korea");
			countries.add("Switzerland");
			countries.add("Russia");
			countries.add("Ireland");
			countries.add("Scotland");
			request.getSession().setAttribute("countries", countries);

			if (u.getRole().equalsIgnoreCase("ORGANIZATION_ADMIN")) {
				bidDao.returnUnbidPlayers();
				return new ModelAndView("org_home", "", null);
			} else
				return new ModelAndView("team_home", "", null);

		} catch (UserException e) {
			System.out.println("Exception: " + e.getMessage());
			session.setAttribute("errorMessage", "error while login");
			return new ModelAndView("error", "errorMessage", "error while login");
		}

	}

	// user logout - FIFA/Team
	@RequestMapping(value = "/user/logout", method = RequestMethod.GET)
	protected void logoutUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = (HttpSession) request.getSession();
		session.invalidate();
		response.sendRedirect("/transfer/login.jsp");

	}

	// user register - Team
	@RequestMapping(value = "/user/register", method = RequestMethod.GET)
	protected ModelAndView registerUser(HttpServletRequest request) throws Exception {
		List<String> countries = new ArrayList();
		countries.add("India");
		countries.add("England");
		countries.add("Germany");
		countries.add("Italy");
		countries.add("Spain");
		countries.add("France");
		countries.add("Argentina");
		countries.add("Brazil");
		countries.add("Netherland");
		countries.add("Belgium");
		countries.add("Sweden");
		countries.add("Portugal");
		countries.add("Wales");
		countries.add("Ivory Coast");
		countries.add("Ecuador");
		countries.add("Columbia");
		countries.add("Chile");
		countries.add("North Korea");
		countries.add("Switzerland");
		countries.add("Russia");
		countries.add("Ireland");
		countries.add("Scotland");
		request.getSession().setAttribute("countries", countries);
		return new ModelAndView("register", "user", new UsersTable());

	}

	// user register - Team
	@RequestMapping(value = "/user/register", method = RequestMethod.POST)
	protected ModelAndView registerNewUser(HttpServletRequest request, @ModelAttribute("user") UsersTable user,
			BindingResult result) throws Exception {

		user.setRole("TEAM_ADMIN");

		try {
			if (userDao.findUsernamePasswordUnique(user.getUsername(), user.getPassword())) {
				result.rejectValue("username", "invalid.username", "Entered username/password exists");
			}
		} catch (UserException e) {
			System.out.println("Exception: " + e.getMessage());
		}

		userValidator.validate(user, result);

		if (result.hasErrors()) {
			return new ModelAndView("register", "user", user);
		}

		request.getSession().setAttribute("user", user);

		return new ModelAndView("add_team", "team", new TeamsTable());

	}

	// Sales Reports FIFA
	@RequestMapping(value = "/org/reports", method = RequestMethod.GET)
	protected ModelAndView displayReports(HttpServletRequest request) throws Exception {

		HttpSession session = (HttpSession) request.getSession();

		try {
			List<TeamDebit> teamAccounts = teamDao.displayReports();
			session.setAttribute("debits", teamAccounts);
			return new ModelAndView("reports", "debits", teamAccounts);
		} catch (TeamException e) {
			System.out.println("Exception: " + e.getMessage());
			session.setAttribute("errorMessage", "error while login");
			return new ModelAndView("error", "errorMessage", "error while showing reports");
		}
	}

	// go to home - FIFA
	@RequestMapping(value = "/org/home", method = RequestMethod.GET)
	protected String redirectHome(HttpServletRequest request) throws Exception {
		return "org_home";

	}

}
