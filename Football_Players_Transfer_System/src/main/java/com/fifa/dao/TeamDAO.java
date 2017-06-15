package com.fifa.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.fifa.entity.TeamAccount;
import com.fifa.entity.TeamDebit;
import com.fifa.entity.TeamsTable;
import com.fifa.entity.UsersTable;
import com.fifa.exception.TeamException;

public class TeamDAO extends DAO {

	public ArrayList<Object> register(TeamsTable t, UsersTable u, TeamAccount a) throws TeamException {
		try {
			begin();
			getSession().save(u);
			t.setUser(u);
			getSession().save(t);
			a.setTeam(t);
			getSession().save(a);
			commit();
			close();

			ArrayList<Object> objs = new ArrayList<Object>();
			objs.add(u);
			objs.add(t);
			objs.add(a);
			return objs;

		} catch (HibernateException e) {
			rollback();
			throw new TeamException("Exception while creating team: " + e.getMessage());
		}
	}

	public List<TeamDebit> displayReports() throws TeamException {
		try {

			List<TeamDebit> teamDebits = new ArrayList<TeamDebit>();

			begin();

			List<TeamsTable> teams = getSession().getNamedQuery("fetchAllTeams").list();

			List<TeamAccount> accounts = getSession().getNamedQuery("fetchAllTeamAccounts").list();

			for (TeamsTable team : teams) {
				teamDebits.add(new TeamDebit(team.getName(), team.getAccount().getDebitAmount()));
			}

			commit();
			close();
			return teamDebits;

		} catch (HibernateException e) {
			rollback();
			throw new TeamException("Exception while creating team: " + e.getMessage());
		}
	}

	public boolean findTeamNameUnique(String name) throws TeamException {
		try {
			begin();
			Query q = getSession().createQuery("from TeamsTable where name = :name");
			q.setString("name", name);
			List<TeamsTable> teams = q.list();
			commit();
			close();
			if (teams.size() == 0)
				return false;
			else
				return true;

		} catch (HibernateException e) {
			rollback();
			throw new TeamException("Exception while validating user: " + e.getMessage());
		}
	}

	public TeamsTable getTeam(UsersTable u) throws TeamException {
		try {
			begin();
			Query q = getSession().createQuery("from TeamsTable where user.userid = :id");
			q.setInteger("id", u.getUserid());
			TeamsTable teams = (TeamsTable) q.uniqueResult();
			commit();
			close();
			return teams;

		} catch (HibernateException e) {
			rollback();
			throw new TeamException("Exception while fetching admin's team: " + e.getMessage());
		}
	}

}
