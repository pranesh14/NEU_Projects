package com.fifa.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import com.fifa.entity.PlayerAttributes;
import com.fifa.entity.PlayerPositionCnfg;
import com.fifa.entity.PlayerTypeCnfg;
import com.fifa.entity.PlayersTable;
import com.fifa.entity.TeamPlayerBid;
import com.fifa.entity.TeamsTable;
import com.fifa.exception.PlayerException;

public class PlayerDAO extends DAO {

	public PlayersTable add(PlayersTable p) throws PlayerException {
		try {
			begin();

			PlayerAttributes attributes = new PlayerAttributes(p, p.getPlayerAttributes().getPace(), p.getPlayerAttributes().getShooting(),
					p.getPlayerAttributes().getPassing(), p.getPlayerAttributes().getDribbling(), p.getPlayerAttributes().getDefending(),
					p.getPlayerAttributes().getPhysical());	
			
			p.setPlayerAttributes(attributes);
			getSession().save(p);
			
			attributes.setPlayer(p);
			getSession().save(attributes);
			
			commit();
			close();
			return p;

		} catch (HibernateException e) {
			rollback();
			throw new PlayerException("Exception while adding player: " + e.getMessage());
		}
	}

	public PlayersTable updatePlayerFile(PlayersTable p) throws PlayerException {
		try {
			begin();
			getSession().update(p);
			commit();
			close();
			return p;

		} catch (HibernateException e) {
			rollback();
			throw new PlayerException("Exception while updating file location: " + e.getMessage());
		}
	}	

	public List<PlayersTable> showUnsold() throws PlayerException {
		try {
			begin();

			Criteria crit = getSession().createCriteria(PlayersTable.class);
			crit.add(Restrictions.isNull("team"));
			Criterion issue = Restrictions.isNull("isInAuction");
			Criterion newPlayer = Restrictions.eq("isInAuction",false);
			LogicalExpression exp = Restrictions.or(issue, newPlayer);
			crit.add(exp);
			List<PlayersTable> players = crit.list();
			
			commit();
			close();
			return players;

		} catch (HibernateException e) {
			rollback();
			throw new PlayerException("Exception while listing unsold players: " + e.getMessage());
		}
	}

	public List<PlayersTable> showTeamPlayers(TeamsTable team) throws PlayerException {
		try {
			begin();
			Query q = getSession().createQuery("from PlayersTable where team.teamid = :id and isInAuction = false");
			q.setInteger("id", team.getTeamid());
			List<PlayersTable> players = q.list();
			commit();
			close();
			return players;

		} catch (HibernateException e) {
			rollback();
			throw new PlayerException("Exception while listing team players: " + e.getMessage());
		}
	}

	public List<PlayersTable> showAuctionedPlayers(TeamsTable team) throws PlayerException {
		try {
			begin();			
			Query q = getSession().createQuery("from PlayersTable where team = :team and isInAuction = true");
			q.setParameter("team", team);
			List<PlayersTable> players = q.list();
			List<PlayersTable> activePlayers = new ArrayList();
			for(PlayersTable player: players){
				Date date_now = new Date();
				Date start_time = player.getStartTime();
				long diff = Math.abs(date_now.getTime() - start_time.getTime());
				if(TimeUnit.MILLISECONDS.toMinutes(diff)>10){
					activePlayers.add(player);					
				}
			}
			players.removeAll(activePlayers);
			commit();
			close();
			return players;

		} catch (HibernateException e) {
			rollback();
			throw new PlayerException("Exception while listing auctioned team players: " + e.getMessage());
		}
	}

	public List<PlayersTable> searchPlayers(TeamsTable team, String type, String position) throws PlayerException {
		try {
			begin();			
			Query q = null;
			PlayerTypeCnfg playerType = null;
			PlayerPositionCnfg playerPosition = null;
			
			if (type != null && type !="") {
				q = getSession().createQuery("from PlayerTypeCnfg where type=:type");
				q.setString("type", type);
				playerType = (PlayerTypeCnfg) q.uniqueResult();
			}
			if (position != null && position!="") {
				q = getSession().createQuery("from PlayerPositionCnfg where position=:position");
				q.setString("position", position);
				playerPosition = (PlayerPositionCnfg) q.uniqueResult();
			}

			if (playerPosition == null && playerType == null)
				q = getSession().createQuery("from PlayersTable where isInAuction = true");
			else if (playerPosition != null && playerType != null) {
				q = getSession().createQuery(
						"from PlayersTable where isInAuction = true and playerTypeCnfg = :type and playerPositionCnfg = :position");
				q.setParameter("type", playerType);
				q.setParameter("position", playerPosition);
			} else if (playerPosition != null) {
				q = getSession().createQuery(
						"from PlayersTable where isInAuction = true and playerPositionCnfg = :position");
				q.setParameter("position", playerPosition);
			} else if (playerType != null) {
				q = getSession().createQuery(
						"from PlayersTable where isInAuction = true and playerTypeCnfg = :type");
				q.setParameter("type", playerType);
			}
			
			List<PlayersTable> players = q.list();
			List<PlayersTable> activePlayers = new ArrayList();
			for(PlayersTable player: players){
				if(player.getTeam()!=null && player.getTeam().getTeamid()==team.getTeamid()){
					activePlayers.add(player);
					continue;
				}
				Date date_now = new Date();
				Date start_time = player.getStartTime();
				long diff = Math.abs(date_now.getTime() - start_time.getTime());
				if(TimeUnit.MILLISECONDS.toMinutes(diff)>10){					
					activePlayers.add(player);
				}
			}
			players.removeAll(activePlayers);
			commit();
			close();
			return players;

		} catch (HibernateException e) {
			rollback();
			throw new PlayerException("Exception while searching auctioned players: " + e.getMessage());
		}
	}

	public PlayersTable findPlayer(int playerID) throws PlayerException {
		try {
			begin();
			Query q = getSession().getNamedQuery("findPlayerById");
			q.setInteger("playerID", playerID);
			PlayersTable player = (PlayersTable) q.uniqueResult();
			commit();
			close();
			return player;

		} catch (HibernateException e) {
			rollback();
			throw new PlayerException("Exception while fethcing unsold player: " + e.getMessage());
		}
	}

	public List<PlayerPositionCnfg> getAllPositions() throws PlayerException {
		try {
			begin();
			Query q = getSession().createQuery("from PlayerPositionCnfg");			
			List<PlayerPositionCnfg> positions = q.list();
			commit();
			close();
			return positions;

		} catch (HibernateException e) {
			rollback();
			throw new PlayerException("Exception while searching players: " + e.getMessage());
		}		
	}

	public List<PlayerTypeCnfg> getAllTypes() throws PlayerException {
		try {
			begin();
			Query q = getSession().createQuery("from PlayerTypeCnfg");			
			List<PlayerTypeCnfg> types = q.list();
			commit();
			close();
			return types;

		} catch (HibernateException e) {
			rollback();
			throw new PlayerException("Exception while searching players: " + e.getMessage());
		}
	}

	public PlayerPositionCnfg findPositionByPlayer(String position) throws PlayerException {		
		try {
			begin();
			Query q = getSession().createQuery("from PlayerPositionCnfg where position= :position");
			q.setString("position", position);
			PlayerPositionCnfg positions = (PlayerPositionCnfg) q.uniqueResult();
			commit();
			close();
			return positions;

		} catch (HibernateException e) {
			rollback();
			throw new PlayerException("Exception while fethcing unsold player: " + e.getMessage());
		}
	}

	public PlayerTypeCnfg findTypeByPlayer(String type) throws PlayerException {
		try {
			begin();
			Query q = getSession().createQuery("from PlayerTypeCnfg where type = :type");			
			q.setString("type", type);
			PlayerTypeCnfg types = (PlayerTypeCnfg) q.uniqueResult();
			commit();
			close();
			return types;

		} catch (HibernateException e) {
			rollback();
			throw new PlayerException("Exception while fethcing unsold player: " + e.getMessage());
		}
	}
	
	public PlayerPositionCnfg findPosition(String position) throws PlayerException {		
		try {
			begin();
			Query q = getSession().createQuery("from PlayerPositionCnfg where position= :position");
			q.setString("position", position);
			PlayerPositionCnfg positions = (PlayerPositionCnfg) q.uniqueResult();
			commit();
			close();
			return positions;

		} catch (HibernateException e) {
			rollback();
			throw new PlayerException("Exception while fethcing unsold player: " + e.getMessage());
		}
	}

	public PlayerTypeCnfg findType(String type) throws PlayerException {
		try {
			begin();
			Query q = getSession().createQuery("from PlayerTypeCnfg where type = :type");			
			q.setString("type", type);
			PlayerTypeCnfg types = (PlayerTypeCnfg) q.uniqueResult();
			commit();
			close();
			return types;

		} catch (HibernateException e) {
			rollback();
			throw new PlayerException("Exception while fethcing unsold player: " + e.getMessage());
		}
	}

}
