package com.fifa.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.fifa.entity.PlayersTable;
import com.fifa.entity.TeamPlayerBid;
import com.fifa.entity.TeamsTable;
import com.fifa.exception.BidException;

public class BidDAO extends DAO {

	public PlayersTable sell(PlayersTable p, Long startBid) throws BidException {
		try {
			begin();
			p.setIsInAuction(true);
			p.setStartTime(new Date());
			p.setStartBid(startBid);
			getSession().update(p);
			commit();
			close();
			return p;

		} catch (HibernateException e) {
			rollback();
			throw new BidException("Exception while selling player: " + e.getMessage());
		}
	}

	public TeamPlayerBid findLatestBidAmount(PlayersTable player) throws BidException {
		try {
			begin();
			Query q = getSession().createQuery("from TeamPlayerBid where player = :player and isActive = true");
			q.setParameter("player", player);
			TeamPlayerBid bid = (TeamPlayerBid) q.uniqueResult();
			commit();
			close();
			return bid;

		} catch (HibernateException e) {
			rollback();
			throw new BidException("Exception while fethcing latest bid: " + e.getMessage());
		}
	}

	public TeamPlayerBid submitBid(PlayersTable player, TeamsTable team, long bidAmount) throws BidException {
		try {
			begin();
			Query q = getSession()
					.createQuery("update TeamPlayerBid set isActive = false where player.playerId = :playerID");
			q.setInteger("playerID", player.getPlayerId());
			q.executeUpdate();

			TeamPlayerBid bid = new TeamPlayerBid(player, team, bidAmount, true);
			getSession().save(bid);

			commit();
			close();
			return bid;

		} catch (HibernateException e) {
			rollback();
			throw new BidException("Exception while fethcing latest bid: " + e.getMessage());
		}
	}

	public List<PlayersTable> listAuctionedPlayers() throws BidException {
		try {
			begin();
			Query q = getSession().createQuery("from PlayersTable p where p.isInAuction = true");
			List<PlayersTable> players = q.list();
			List<PlayersTable> activePlayers = new ArrayList();
			for (PlayersTable player : players) {
				q = getSession().createQuery("from TeamPlayerBid b where b.isActive = true and b.player = :player");
				q.setParameter("player", player);
				TeamPlayerBid bid = (TeamPlayerBid) q.uniqueResult();
				if (bid == null || bid.getBidAmount()<player.getStartBid()) {
					activePlayers.add(player);					
					continue;
				}
				Date date_now = new Date();
				Date start_time = player.getStartTime();
				long diff = Math.abs(date_now.getTime() - start_time.getTime());
				if (TimeUnit.MILLISECONDS.toMinutes(diff)<10) {
					activePlayers.add(player);
				}
			}
			players.removeAll(activePlayers);
			commit();
			close();
			return players;

		} catch (HibernateException e) {
			rollback();
			throw new BidException("Exception while fethcing auctioned player: " + e.getMessage());
		}
	}

	public void transferPlayer(int playerID) throws BidException {
		try {
			begin();
			Query q = getSession().createQuery("from PlayersTable where playerId = :playerID");
			q.setInteger("playerID", playerID);
			PlayersTable player = (PlayersTable) q.uniqueResult();

			q = getSession().createQuery("from TeamPlayerBid where player.playerId = :playerID and isActive = true");
			q.setInteger("playerID", playerID);
			TeamPlayerBid bid = (TeamPlayerBid) q.uniqueResult();

			TeamsTable oldTeam = player.getTeam();
			long debit = 0;

			player.setIsInAuction(false);
			player.setTeam(bid.getTeam());
			getSession().update(player);

			if (oldTeam != null) {
				debit = oldTeam.getAccount().getDebitAmount();
				debit -= bid.getBidAmount();
				oldTeam.getAccount().setDebitAmount(debit);
				getSession().update(oldTeam);
			}

			TeamsTable team = bid.getTeam();
			debit = team.getAccount().getDebitAmount();
			debit += bid.getBidAmount();
			team.getAccount().setDebitAmount(debit);
			getSession().update(team);

			commit();
			close();

		} catch (HibernateException e) {
			rollback();
			throw new BidException("Exception while approving transfer: " + e.getMessage());
		}
	}

	public void returnUnbidPlayers() throws BidException {
		try {
			begin();
			Query q = getSession().createQuery("from PlayersTable p where p.isInAuction = true");
			List<PlayersTable> players = q.list();			
			for (PlayersTable player : players) {
				Date date_now = new Date();
				Date start_time = player.getStartTime();
				long diff = Math.abs(date_now.getTime() - start_time.getTime());
				if (TimeUnit.MILLISECONDS.toMinutes(diff)<10) {					
					continue;
				}
				q = getSession().createQuery("from TeamPlayerBid where isActive = true and player=:player");
				q.setParameter("player", player);
				TeamPlayerBid bids = (TeamPlayerBid) q.uniqueResult();
				if (bids == null) {
					player.setIsInAuction(false);
					getSession().update(player);
				}
				if(player.getTeam() != null && bids.getTeam().getTeamid() == player.getTeam().getTeamid()){
					player.setIsInAuction(false);
					getSession().update(player);
				}
			}
			commit();
			close();

		} catch (HibernateException e) {
			rollback();
			throw new BidException("Exception while returning unsold player: " + e.getMessage());
		}

	}

}
