package com.anbo.dao;

import java.util.List;
import java.util.Map;

import com.anbo.po.Article;
import com.anbo.po.UserBean;

public interface UserDAO {

	public boolean loginOrNot(String loginName,String loginPwd);
	
	public List<UserBean> allUser();
	
	public boolean delUser(int id);
	
	public boolean addUser(UserBean user);
	/**
	 * 验证登陆信息
	 * @return
	 */
	public void loginCheck(UserBean user);
	
	/**
	 * 查询
	 */
	public UserBean selectUser(UserBean user);
	
	/**
	 * 查询所有用户数量
	 */
	public int selectUserCount();
	/**
	 * 分页取数据
	 */
	public List<UserBean> getPaginationUsers(Map<String,Integer> map);
	/**
	 * 查询所有用户
	 */
	public List<UserBean> showAllUsers();
	
	/**
	 * 验证用户登录信息，用参数map
	 * @param map
	 * @return
	 */
	public boolean selectUserInfoByParam(Map<String,String> map);
	/**
	 * 添加用户信息
	 */
	public boolean addUsers(UserBean user);
	/**
	 * 查询用户的文章
	 * @param userid
	 * @return
	 */
	public List<Article> selectArticleByUserId(int userid);
	/**
	 * 查询最大的用户编号
	 */
	public int selectMaxUserId();
}
