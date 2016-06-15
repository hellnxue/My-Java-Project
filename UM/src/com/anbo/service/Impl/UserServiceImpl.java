package com.anbo.service.Impl;

import java.util.List;
import java.util.Map;

import com.anbo.dao.impl.UserDAOImpl;
import com.anbo.po.Article;
import com.anbo.po.UserBean;
import com.anbo.service.UserService;

public class UserServiceImpl implements UserService{
  private  UserDAOImpl userDao;
   
	public UserDAOImpl getUserDao() {
	return userDao;
}

public void setUserDao(UserDAOImpl userDao) {
	this.userDao = userDao;
}

	@Override
	public boolean selectUserInfoByParam(Map<String, String> map) {
		
		return userDao.selectUserInfoByParam(map);
	}

	@Override
	public List<UserBean> showAllUsers() {
		// TODO Auto-generated method stub
		return userDao.showAllUsers();
	}

	@Override
	public boolean addUsers(UserBean user) {
		// TODO Auto-generated method stub
		return userDao.addUsers(user);
	}

	@Override
	public List<Article> selectArticleByUserId(int userid) {
		// TODO Auto-generated method stub
		return userDao.selectArticleByUserId(userid);
	}

	@Override
	public int selectUserCount() {
		// TODO Auto-generated method stub
		return userDao.selectUserCount();
	}

	@Override
	public List<UserBean> getPaginationUsers(Map<String, Integer> map) {
		// TODO Auto-generated method stub
		return userDao.getPaginationUsers(map);
	}

	@Override
	public int selectMaxUserId() {
		// TODO Auto-generated method stub
		return userDao.selectMaxUserId();
	}

}
