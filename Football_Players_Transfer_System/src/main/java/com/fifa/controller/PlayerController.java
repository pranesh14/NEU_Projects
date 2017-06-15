package com.fifa.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fifa.dao.BidDAO;
import com.fifa.dao.PlayerDAO;
import com.fifa.entity.PlayerAttributes;
import com.fifa.entity.PlayerPositionCnfg;
import com.fifa.entity.PlayerTypeCnfg;
import com.fifa.entity.PlayersTable;
import com.fifa.entity.TeamPlayerBid;
import com.fifa.entity.TeamsTable;
import com.fifa.entity.UsersTable;
import com.fifa.exception.BidException;
import com.fifa.exception.PlayerException;
import com.fifa.validator.PlayerValidator;

@Controller
public class PlayerController {

	@Autowired
	PlayerDAO playerDao;

	@Autowired
	BidDAO bidDao;

	@Autowired
	PlayerValidator playerValidator;

	@InitBinder("player")
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(playerValidator);
	}

	// Adding Player - FIFA
	@RequestMapping(value = "/org/playeradd", method = RequestMethod.GET)
	protected ModelAndView addPlayer(HttpServletRequest request) throws Exception {
		HttpSession session = (HttpSession) request.getSession();
		List<PlayerPositionCnfg> positions = null;
		List<PlayerTypeCnfg> types = null;
		try {
			positions = playerDao.getAllPositions();
			types = playerDao.getAllTypes();
		} catch (PlayerException e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while searching players");
		}
		session.setAttribute("positions", positions);
		session.setAttribute("types", types);
		return new ModelAndView("add_player", "player", new PlayersTable());

	}

	// FIFA
	@RequestMapping(value = "/org/playeradd", method = RequestMethod.POST)
	protected ModelAndView addNewPlayer(HttpServletRequest request, @ModelAttribute("player") PlayersTable player,
			BindingResult result) throws Exception {

		PlayerPositionCnfg position = null;
		PlayerTypeCnfg type = null;

		playerValidator.validate(player, result);

		if (result.hasErrors()) {
			return new ModelAndView("add_player", "player", player);
		}

		try {
			position = playerDao.findPosition(player.getPlayerPositionCnfg().getPosition());
			type = playerDao.findType(player.getPlayerTypeCnfg().getType());
		} catch (PlayerException e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while adding player");
		}

		try {

			File directory;
			CommonsMultipartFile photoInMemory = null;
			File localFile = null;
			PlayersTable p = null;
			String path = "E:\\Softwares\\sts-bundle\\Football_Players_Transfer_Software\\Players\\";

			directory = new File(path);
			boolean temp = directory.exists();
			if (!temp) {
				temp = directory.mkdir();
			}
			if (temp) {
				photoInMemory = player.getPhoto();
				localFile = new File(directory.getPath(), player.getName());

				player.setPlayerPositionCnfg(position);
				player.setPlayerTypeCnfg(type);
				player.setImage(localFile.getPath());
				p = playerDao.add(player);

				localFile = new File(directory.getPath(), p.getName() + "_" + p.getPlayerId().toString() + ".jpg");
				p.setImage(p.getName() + "_" + p.getPlayerId().toString() + ".jpg");
				photoInMemory.transferTo(localFile);
				p = playerDao.updatePlayerFile(p);

			} else {
				System.out.println("Failed to create directory!");
			}

			request.getSession().setAttribute("player", p);
			request.getSession().setAttribute("selling_player", p);

			return new ModelAndView("sell_player", "player", p);

		} catch (IllegalStateException e) {
			System.out.println("*** IllegalStateException: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("*** IOException: " + e.getMessage());
		} catch (PlayerException e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while adding player");
		}

		return null;
	}

	// sell added player - FIFA
	@RequestMapping(value = "/org/playersell", method = RequestMethod.GET)
	protected ModelAndView sellUnsoldPlayer(HttpServletRequest request) throws Exception {

		HttpSession session = (HttpSession) request.getSession();

		Integer playerID = Integer.parseInt(request.getParameter("playerid"));

		try {

			PlayersTable p = playerDao.findPlayer(playerID);
			session.setAttribute("selling_player", p);

			return new ModelAndView("sell_player", "player", p);

		} catch (PlayerException e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while fetching  player");
		}
	}

	// listing unsold players - FIFA
	@RequestMapping(value = "/org/unsoldplayers", method = RequestMethod.GET)
	protected ModelAndView showUnsoldPlayers(HttpServletRequest request) throws Exception {

		HttpSession session = (HttpSession) request.getSession();

		try {

			List<PlayersTable> players = playerDao.showUnsold();
			request.getSession().setAttribute("unsoldPlayers", players);
			int pages = players.size() / 10;
			if ((players.size() % 10) != 0)
				pages += 1;
			request.getSession().setAttribute("pages", pages);
			int start = 0;
			int end = players.size() < 10 ? players.size() : 10;

			List<PlayersTable> pl = new ArrayList<PlayersTable>();
			for (int i = start; i < end; i++) {
				pl.add(players.get(i));
			}
			session.setAttribute("unsoldPlayersByPage", pl);
			return new ModelAndView("show_unsold_players", "", null);

		} catch (PlayerException e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while showing unsold players");
		}
	}

	// paging
	@RequestMapping(value = "/org/unsoldpage", method = RequestMethod.GET)
	protected ModelAndView showUnsoldPlayersPages(HttpServletRequest request) throws Exception {
		HttpSession session = (HttpSession) request.getSession();
		int pagenumber = request.getParameter("number") == "" ? 1 : Integer.parseInt(request.getParameter("number"));
		int start = (pagenumber - 1) * 10;
		int end = (pagenumber * 10);
		List<PlayersTable> p = playerDao.showUnsold();
		if (end > p.size())
			end = p.size();
		List<PlayersTable> pl = new ArrayList<PlayersTable>();
		for (int i = start; i < end; i++) {
			pl.add(p.get(i));
		}
		session.setAttribute("unsoldPlayersByPage", pl);
		return new ModelAndView("show_unsold_players", "", null);
	}

	// show team players - Team
	@RequestMapping(value = "/team/players", method = RequestMethod.GET)
	protected ModelAndView showTeamPlayers(HttpServletRequest request) throws Exception {

		HttpSession session = (HttpSession) request.getSession();

		UsersTable user = (UsersTable) session.getAttribute("user");
		if (user == null) {
			session.setAttribute("errorMessage", "You were logged out!");
			return new ModelAndView("error", "errorMessage", "You were logged out!");
		}
		TeamsTable t = (TeamsTable) session.getAttribute("team");

		try {

			List<PlayersTable> players = playerDao.showTeamPlayers(t);
			session.setAttribute("team_players", players);
			int pages = players.size() / 10;
			if ((players.size() % 10) != 0)
				pages += 1;
			request.getSession().setAttribute("pages", pages);
			int start = 0;
			int end = players.size() < 10 ? players.size() : 10;

			List<PlayersTable> pl = new ArrayList<PlayersTable>();
			for (int i = start; i < end; i++) {
				pl.add(players.get(i));
			}
			session.setAttribute("teamPlayersByPage", pl);
			return new ModelAndView("team_players", "", null);

		} catch (PlayerException e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while listing team players");
		}
	}

	// paging
	@RequestMapping(value = "/team/playerspage", method = RequestMethod.GET)
	protected ModelAndView showTeamPlayersPages(HttpServletRequest request) throws Exception {
		HttpSession session = (HttpSession) request.getSession();
		int pagenumber = request.getParameter("number") == "" ? 1 : Integer.parseInt(request.getParameter("number"));
		int start = (pagenumber - 1) * 10;
		int end = (pagenumber * 10);
		List<PlayersTable> p = (List<PlayersTable>) session.getAttribute("team_players");
		if (end > p.size())
			end = p.size();
		List<PlayersTable> pl = new ArrayList<PlayersTable>();
		for (int i = start; i < end; i++) {
			pl.add(p.get(i));
		}
		session.setAttribute("teamPlayersByPage", pl);
		return new ModelAndView("team_players", "", null);
	}

	// show auctioned team players - Team
	@RequestMapping(value = "/team/auction", method = RequestMethod.GET)
	protected ModelAndView showAuctionedPlayers(HttpServletRequest request) throws Exception {

		HttpSession session = (HttpSession) request.getSession();

		UsersTable user = (UsersTable) session.getAttribute("user");
		if (user == null) {
			session.setAttribute("errorMessage", "You were logged out!");
			return new ModelAndView("error", "errorMessage", "You were logged out!");
		}
		TeamsTable t = (TeamsTable) session.getAttribute("team");

		try {

			List<PlayersTable> players = playerDao.showAuctionedPlayers(t);
			session.setAttribute("auctionedPlayers", players);
			int pages = players.size() / 10;
			if ((players.size() % 10) != 0)
				pages += 1;
			request.getSession().setAttribute("pages", pages);
			int start = 0;
			int end = players.size() < 10 ? players.size() : 10;

			List<PlayersTable> pl = new ArrayList<PlayersTable>();
			for (int i = start; i < end; i++) {
				pl.add(players.get(i));
			}
			session.setAttribute("auctionedPlayersByPage", pl);
			return new ModelAndView("auctioned_players", "", null);

		} catch (PlayerException e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while showing auctioned players");
		}
	}

	// paging
	@RequestMapping(value = "/team/auctionpage", method = RequestMethod.GET)
	protected ModelAndView showAuctionPlayersPages(HttpServletRequest request) throws Exception {
		HttpSession session = (HttpSession) request.getSession();
		int pagenumber = request.getParameter("number") == "" ? 1 : Integer.parseInt(request.getParameter("number"));
		int start = (pagenumber - 1) * 10;
		int end = (pagenumber * 10);
		List<PlayersTable> p = (List<PlayersTable>) session.getAttribute("auctionedPlayers");
		if (end > p.size())
			end = p.size();
		List<PlayersTable> pl = new ArrayList<PlayersTable>();
		for (int i = start; i < end; i++) {
			pl.add(p.get(i));
		}
		session.setAttribute("auctionedPlayersByPage", pl);
		return new ModelAndView("auctioned_players", "", null);
	}

	// Team
	@RequestMapping(value = "/team/searchplayers", method = RequestMethod.GET)
	protected ModelAndView searchPage(HttpServletRequest request) throws Exception {
		HttpSession session = (HttpSession) request.getSession();
		List<PlayerPositionCnfg> positions = null;
		List<PlayerTypeCnfg> types = null;
		try {
			positions = playerDao.getAllPositions();
			types = playerDao.getAllTypes();
		} catch (PlayerException e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while searching players");
		}
		session.setAttribute("positions", positions);
		session.setAttribute("types", types);

		return new ModelAndView("player_search", "", null);
	}

	// Team
	@RequestMapping(value = "/team/searchplayers", method = RequestMethod.POST)
	protected ModelAndView searchPlayers(HttpServletRequest request) throws Exception {

		HttpSession session = (HttpSession) request.getSession();

		UsersTable user = (UsersTable) session.getAttribute("user");
		if (user == null) {
			session.setAttribute("errorMessage", "You were logged out!");
			return new ModelAndView("error", "errorMessage", "You were logged out!");
		}
		TeamsTable t = (TeamsTable) session.getAttribute("team");
		String type = request.getParameter("type");
		String position = request.getParameter("position");

		try {

			List<PlayersTable> players = playerDao.searchPlayers(t, type, position);
			session.setAttribute("searchedPlayers", players);
			int pages = players.size() / 10;
			if ((players.size() % 10) != 0)
				pages += 1;
			request.getSession().setAttribute("pages", pages);
			int start = 0;
			int end = players.size() < 10 ? players.size() : 10;

			List<PlayersTable> pl = new ArrayList<PlayersTable>();
			for (int i = start; i < end; i++) {
				pl.add(players.get(i));
			}
			session.setAttribute("searchedPlayersByPage", pl);

			return new ModelAndView("search_list", "", null);

		} catch (PlayerException e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while searching players");
		}
	}

	// paging
	@RequestMapping(value = "/team/searchpage", method = RequestMethod.GET)
	protected ModelAndView showSearchedPlayersPages(HttpServletRequest request) throws Exception {
		HttpSession session = (HttpSession) request.getSession();
		int pagenumber = request.getParameter("number") == "" ? 1 : Integer.parseInt(request.getParameter("number"));
		int start = (pagenumber - 1) * 10;
		int end = (pagenumber * 10);
		List<PlayersTable> p = (List<PlayersTable>) session.getAttribute("searchedPlayers");
		if (end > p.size())
			end = p.size();
		List<PlayersTable> pl = new ArrayList<PlayersTable>();
		for (int i = start; i < end; i++) {
			pl.add(p.get(i));
		}
		session.setAttribute("searchedPlayersByPage", pl);

		return new ModelAndView("search_list", "", null);
	}

	// Team
	@RequestMapping(value = "/team/playerview", method = RequestMethod.GET)
	protected ModelAndView viewPlayer(HttpServletRequest request) throws Exception {

		HttpSession session = (HttpSession) request.getSession();

		UsersTable user = (UsersTable) session.getAttribute("user");
		if (user == null) {
			session.setAttribute("errorMessage", "You were logged out!");
			return new ModelAndView("error", "errorMessage", "You were logged out!");
		}
		Integer playerID = Integer.parseInt(request.getParameter("playerid"));

		try {

			PlayersTable p = playerDao.findPlayer(playerID);
			PlayerAttributes a = p.getPlayerAttributes();
			PlayerPositionCnfg pos = p.getPlayerPositionCnfg();
			PlayerTypeCnfg type = p.getPlayerTypeCnfg();
			// findLocation(p.getCountry(), request);
			session.setAttribute("player", p);
			session.setAttribute("attributes", a);
			session.setAttribute("position", pos);
			session.setAttribute("type", type);

			return new ModelAndView("player_profile", "player", p);

		} catch (PlayerException e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while searching player");
		}
	}

	// Team
	@RequestMapping(value = "/team/playercontract", method = RequestMethod.GET)
	public void downloadPdfReport(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = (HttpSession) request.getSession(false);
		TeamsTable team = (TeamsTable) session.getAttribute("team");
		PlayersTable player = (PlayersTable) session.getAttribute("player");
		Long bidAmount = null;

		try {
			TeamPlayerBid bid = bidDao.findLatestBidAmount(player);
			bidAmount = bid.getBidAmount();
		} catch (BidException e) {
			System.out.println("Exception: " + e.getMessage());
		}

		String fileName = "Contract_" + player.getName() + "_" + player.getPlayerId() + ".pdf";
		response.setContentType("application/pdf");
		response.setHeader("Content-disposition", "attachment; filename=" + fileName);

		try {

			CreatePDF.createPDF(fileName, player, team, bidAmount);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			baos = convertPDFToByteArrayOutputStream(fileName);
			OutputStream os = response.getOutputStream();
			baos.writeTo(os);
			os.flush();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}

	private ByteArrayOutputStream convertPDFToByteArrayOutputStream(String fileName) {

		InputStream inputStream = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {

			inputStream = new FileInputStream(fileName);
			byte[] buffer = new byte[1024];
			baos = new ByteArrayOutputStream();

			int bytesRead;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				baos.write(buffer, 0, bytesRead);
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return baos;
	}

}
