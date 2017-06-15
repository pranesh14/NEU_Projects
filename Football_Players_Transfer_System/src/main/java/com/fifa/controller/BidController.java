package com.fifa.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

@Controller
public class BidController {

	@Autowired
	PlayerDAO playerDao;

	@Autowired
	BidDAO bidDao;

	// Close Transfers - FIFA
	@RequestMapping(value = "/org/closedeals", method = RequestMethod.GET)
	protected ModelAndView approveTransfer(HttpServletRequest request) throws Exception {

		HttpSession session = (HttpSession) request.getSession();

		try {

			bidDao.returnUnbidPlayers();
			List<PlayersTable> p = bidDao.listAuctionedPlayers();
			int pages = p.size() / 10;
			if ((p.size() % 10) != 0)
				pages += 1;
			request.getSession().setAttribute("pages", pages);

			int start = 0;
			int end = p.size() < 10 ? p.size() : 10;
			session.setAttribute("transferredPlayers", p);

			List<PlayersTable> pl = new ArrayList<PlayersTable>();
			for (int i = start; i < end; i++) {
				pl.add(p.get(i));
			}
			session.setAttribute("transferredPlayersByPage", pl);

			return new ModelAndView("approve_transfer", "", null);

		} catch (BidException e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while bidding on player");
		}
	}

	// paging
	@RequestMapping(value = "/org/approvalpage", method = RequestMethod.GET)
	protected ModelAndView showUnsoldPlayersPages(HttpServletRequest request) throws Exception {
		HttpSession session = (HttpSession) request.getSession();
		int pagenumber = request.getParameter("number") == "" ? 1 : Integer.parseInt(request.getParameter("number"));
		int start = (pagenumber - 1) * 10;
		int end = (pagenumber * 10);
		List<PlayersTable> p = bidDao.listAuctionedPlayers();
		if (end > p.size())
			end = p.size();
		List<PlayersTable> pl = new ArrayList<PlayersTable>();
		for (int i = start; i < end; i++) {
			pl.add(p.get(i));
		}
		session.setAttribute("transferredPlayersByPage", pl);
		return new ModelAndView("approve_transfer", "", null);
	}

	@RequestMapping(value = "/org/transfercomplete", method = RequestMethod.GET)
	protected ModelAndView completeTransfer(HttpServletRequest request) throws Exception {

		HttpSession session = (HttpSession) request.getSession();

		Integer playerID = Integer.parseInt(request.getParameter("playerid"));
		try {

			bidDao.transferPlayer(playerID);
			PlayersTable p = playerDao.findPlayer(playerID);
			PlayersTable pl = new PlayersTable();
			List<PlayersTable> players = (List<PlayersTable>) session.getAttribute("transferredPlayersByPage");
			for (PlayersTable p1 : players) {
				if (p1.getPlayerId() == p.getPlayerId())
					pl = p1;
			}
			players.remove(pl);
			int pages = players.size() / 10;
			if ((players.size() % 10) != 0)
				pages += 1;
			request.getSession().setAttribute("pages", pages);
			session.setAttribute("transferredPlayersByPage", players);

			return new ModelAndView("approve_transfer", "", null);

		} catch (BidException e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while bidding on player");
		}
	}

	@RequestMapping(value = "/player/sell", method = RequestMethod.POST)
	protected ModelAndView sellNewPlayer(HttpServletRequest request) throws Exception {

		HttpSession session = (HttpSession) request.getSession();

		UsersTable user = (UsersTable) session.getAttribute("user");
		Long start_bid = Long.parseLong(request.getParameter("startBid"));
		int id = 0;
		if (request.getParameter("id") != "" && request.getParameter("id") != "null"
				&& request.getParameter("id") != null)
			id = Integer.parseInt(request.getParameter("id"));

		try {

			PlayersTable p = (PlayersTable) session.getAttribute("selling_player");
			if (p == null)
				p = playerDao.findPlayer(id);
			p = bidDao.sell(p, start_bid);
			request.getSession().setAttribute("player", p);

			if (user.getRole().equalsIgnoreCase("ORGANIZATION_ADMIN"))
				return new ModelAndView("org_home", "", null);
			else
				return new ModelAndView("team_home", "", null);

		} catch (BidException e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while selling player");
		}
	}

	// Team
	@RequestMapping(value = "/team/playerbid", method = RequestMethod.GET)
	protected ModelAndView listPlayer(HttpServletRequest request) throws Exception {

		HttpSession session = (HttpSession) request.getSession();

		Integer playerID = Integer.parseInt(request.getParameter("playerid"));
		TeamsTable team = (TeamsTable) session.getAttribute("team");

		try {

			PlayersTable p = playerDao.findPlayer(playerID);
			TeamPlayerBid bid = bidDao.findLatestBidAmount(p);
			PlayerAttributes a = p.getPlayerAttributes();
			PlayerPositionCnfg pos = p.getPlayerPositionCnfg();
			PlayerTypeCnfg type = p.getPlayerTypeCnfg();
			session.setAttribute("player", p);
			session.setAttribute("attributes", a);
			session.setAttribute("position", pos);
			session.setAttribute("type", type);

			if (bid == null || bid.getBidAmount() < p.getStartBid())
				session.setAttribute("bid", p.getStartBid());
			else if (bid.getBidAmount() >= p.getStartBid())
				session.setAttribute("bid", bid.getBidAmount());

			Date date_now = new Date();
			Date start_time = p.getStartTime();
			long diff = Math.abs(date_now.getTime() - start_time.getTime());
			if (TimeUnit.MILLISECONDS.toMinutes(diff) > 10) {
				session.setAttribute("bidOver", "true");
			}

			if (bid != null && bid.getTeam().getTeamid() == team.getTeamid())
				request.setAttribute("sameTeam", "true");

			return new ModelAndView("players_listing", "player", p);

		} catch (PlayerException e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while bidding player");
		}
	}

	@RequestMapping(value = "/ajaxcall", method = RequestMethod.GET)
	public void handleAjaxCall(HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.setContentType("text/html;charset=UTF-8");

		PlayersTable p = (PlayersTable) request.getSession().getAttribute("player");
		if (p != null) {

			Calendar cal = Calendar.getInstance();
			cal.setTime(p.getStartTime());
			cal.add(Calendar.MINUTE, 10);

			Date d = new Date();

			long diff = Math.abs(d.getTime() - cal.getTime().getTime());
			long diffSeconds = diff / 1000 % 60;
			long diffMinutes = diff / (60 * 1000) % 60;

			if (cal.getTime().getTime() - d.getTime() > 0)
				response.getWriter().write(String.valueOf(diffMinutes) + ":" + String.valueOf(diffSeconds));
		}

	}

	// Team
	@RequestMapping(value = "/team/playerbid", method = RequestMethod.POST)
	protected ModelAndView bidListPlayer(HttpServletRequest request) throws Exception {

		HttpSession session = (HttpSession) request.getSession();

		PlayersTable player = (PlayersTable) session.getAttribute("player");
		TeamPlayerBid bid = bidDao.findLatestBidAmount(player);
		Long bidAmount = Long.parseLong(request.getParameter("bidAmount"));
		TeamsTable team = (TeamsTable) session.getAttribute("team");

		if (bid != null && bid.getBidAmount() > bidAmount)
			return new ModelAndView("players_listing", "", null);

		try {

			bid = bidDao.submitBid(player, team, bidAmount);
			session.setAttribute("bid", bid.getBidAmount());

			Date date_now = new Date();
			Date start_time = player.getStartTime();
			long diff = Math.abs(date_now.getTime() - start_time.getTime());
			if (TimeUnit.MILLISECONDS.toMinutes(diff) > 10) {
				session.setAttribute("bidOver", true);
			}

			if (bid != null && bid.getTeam().getTeamid() == team.getTeamid())
				request.setAttribute("sameTeam", "true");

			return new ModelAndView("players_listing", "", null);

		} catch (BidException e) {
			System.out.println("Exception: " + e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while bidding on player");
		}
	}

}
