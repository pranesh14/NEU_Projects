package com.fifa.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fifa.dao.TeamDAO;
import com.fifa.dao.UserDAO;
import com.fifa.entity.TeamAccount;
import com.fifa.entity.TeamsTable;
import com.fifa.entity.UsersTable;
import com.fifa.exception.TeamException;
import com.fifa.validator.TeamValidator;

@Controller
public class TeamController {

	@Autowired
	TeamValidator teamValidator;

	@Autowired
	UserDAO userDao;

	@Autowired
	TeamDAO teamDao;

	@InitBinder("team")
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(teamValidator);
	}

	// register user,team and account - team
	@RequestMapping(value = "/team/register", method = RequestMethod.POST)
	protected ModelAndView registerNewTeam(HttpServletRequest request, @ModelAttribute("team") TeamsTable team,
			BindingResult result) throws Exception {

		try {
			if (teamDao.findTeamNameUnique(team.getName())) {
				result.rejectValue("name", "invalid.name", "Entered team name exists");
			}
		} catch (TeamException e) {
			System.out.println("Exception: " + e.getMessage());
		}

		teamValidator.validate(team, result);

		if (result.hasErrors()) {
			return new ModelAndView("add_team", "team", team);
		}

		HttpSession session = (HttpSession) request.getSession();

		UsersTable u = (UsersTable) session.getAttribute("user");
		try {

			File directory;
			CommonsMultipartFile photoInMemory = null;
			File localFile = null;
			String path = "E:\\Softwares\\sts-bundle\\Football_Players_Transfer_Software\\Teams\\";

			directory = new File(path);
			boolean temp = directory.exists();
			System.out.println("before:" + temp);
			if (!temp) {
				temp = directory.mkdir();
			}
			if (temp) {
				photoInMemory = team.getPhoto();

				localFile = new File(directory.getPath(), team.getName() + ".jpg");
				team.setLogo(team.getName() + ".jpg");

				photoInMemory.transferTo(localFile);

			} else {
				System.out.println("Failed to create directory!");
			}

			TeamAccount account = new TeamAccount();
			account.setAccountNumber(team.getAccount().getAccountNumber());
			long l = 0;
			account.setDebitAmount(l);

			ArrayList<Object> objs = teamDao.register(team, u, account);
			request.getSession().setAttribute("team", objs.get(1));
			request.getSession().setAttribute("user", objs.get(0));
			request.getSession().setAttribute("account", objs.get(2));

			return new ModelAndView("team_home", "", null);

		} catch (TeamException e) {
			System.out.println("Team Registeration Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while creating account");
		} catch (IllegalStateException e) {
			System.out.println("*** IllegalStateException: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while uploading image");
		} catch (IOException e) {
			System.out.println("*** IOException: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while uploading image");

		}

	}

	// go to home - Team
	@RequestMapping(value = "/team/home", method = RequestMethod.GET)
	protected String redirectHome(HttpServletRequest request) throws Exception {
		return "team_home";

	}

}
