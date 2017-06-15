package com.fifa.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.fifa.entity.UsersTable;
import com.fifa.exception.TeamException;
import com.fifa.exception.UserException;

public class UserDAO extends DAO {

	public UsersTable get(String userName, String password) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from UsersTable where username = :userName and password = :password");
			q.setString("userName", userName);
			q.setString("password", password);
			UsersTable user = (UsersTable) q.uniqueResult();
			commit();
			close();
			return user;

		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while validating user: " + e.getMessage());
		}
	}

	public boolean findUsernamePasswordUnique(String username, String password) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from UsersTable where username = :username and password = :password");
			q.setString("username", username);
			q.setString("password", password);
			List<UsersTable> users = q.list();
			commit();
			close();
			if (users.size()==0)
				return false;
			else
				return true;

		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while validating user: " + e.getMessage());
		}
	}

}
