package com.anbo.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.anbo.dao.UserDAO;
import com.anbo.po.Article;
import com.anbo.po.UserBean;
import java.sql.*;
import com.anbo.util.DBConnection;
import com.anbo.util.MybatisFactory;

import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
public class UserDAOImpl implements UserDAO {

    private SqlSession sqlSessionTemplate;
 	public SqlSession getSqlSessionTemplate() {
		return sqlSessionTemplate;
	}

	public void setSqlSessionTemplate(SqlSession sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

	

	public boolean addUser(UserBean user) {
		boolean flag=false;
		Connection con=DBConnection.getCon();
		PreparedStatement pstmt=null;
		String sql="insert into t_user values(?,?,?,?,?,?)";
		try{
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, user.getUserId());
			pstmt.setString(2, user.getLoginName());
			pstmt.setString(3,user.getLoginPwd());
			pstmt.setInt(4, user.getSex());
			pstmt.setTimestamp(5,new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()));
			pstmt.setString(6, user.getEmail());
			flag=pstmt.execute();
			System.out.println("flag==========="+flag);
			//con.commit();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.closeStmt(pstmt);
			DBConnection.closeCon(con);
		}
		return flag;
	}

	public List<UserBean> allUser() {
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		List<UserBean> ls=new ArrayList<UserBean>();
		String sql="select * from t_user order by userId desc";
		con=DBConnection.getCon();
		try {
			stmt=con.createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				UserBean user=new UserBean();
				user.setUserId(rs.getInt("USERID"));
				user.setLoginName(rs.getString("loginname"));
				user.setLoginPwd(rs.getString("loginpwd"));
				user.setSex(rs.getInt("sex"));
				user.setEmail(rs.getString("email"));
				user.setBirthday(rs.getString("birthday"));
				ls.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBConnection.closeRs(rs);
			DBConnection.closeStmt(stmt);
			DBConnection.closeCon(con);
		}
		return ls;
	}

	public boolean delUser(int id) {
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql="delete from t_user where userId=?";
		con=DBConnection.getCon();
		int flag=0;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,id);
			flag=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBConnection.closeStmt(pstmt);
			DBConnection.closeCon(con);
		}
		if(flag>=1){
			return true;
		}else{
			return false;
		}
	}

	public boolean loginOrNot(String loginName, String loginPwd) {
		
		boolean flag=false;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from t_user where loginname=? and loginpwd=?";
		//String sql="select * from t_user where loginname='"+loginName+"' and loginpwd='"+loginPwd+"'";
		con=DBConnection.getCon();
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, loginName);
			pstmt.setString(2, loginPwd);
			rs=pstmt.executeQuery();
			if(rs.next()){
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//閿熼ズ鍖℃嫹閿熸枻鎷烽敓锟�			dbCon.closeRs(rs);
			DBConnection.closeStmt(pstmt);
			DBConnection.closeCon(con);
		}
		return flag;
	}
	
	/**
	 * 没有经spring整合的Mybatis操作数据库用法
	 */
	@Override
	public void loginCheck(UserBean user) {
		System.out.println("welcome to here~~~");
		int flag=0;
		SqlSession session=null;
		try{
			session=MybatisFactory.getSqlSession();
			//UserDAO userDao=session.getMapper(UserDAO.class);
			
			flag=session.selectOne("com.anbo.po.UserBean.loginCheck",user);
			System.out.println("------------------------------------------------"+flag);
		}finally{
			session.commit();
			session.close();
		}
		
		
		
	}
	
	@Override
	public UserBean selectUser(UserBean user) {
		System.out.println("--------------------heihei--------------------");
		UserBean users=null;
		SqlSession session=null;
		try{
			session=MybatisFactory.getSqlSession();
			users=session.selectOne("com.anbo.po.UserBean.selectUser",user);
			System.out.println("birthday   "+users.getBirthday());
		}finally{
			session.commit();
			session.close();
		}
		return users;
	}
	
	@Override
	public List<UserBean> showAllUsers() {
		System.out.println("--------------------showAllUsers--------------------"+sqlSessionTemplate);
		List<UserBean> ls=new ArrayList<UserBean>();
		 ls=sqlSessionTemplate.selectList("com.anbo.po.UserBean.showAllUsers");
		System.out.println("hhhhhhhhhhhhhhhhhh = "+ls.get(0).getBirthday());
		return ls;
	}

	@Override
	public List<Article> selectArticleByUserId(int userid) {
		
		return sqlSessionTemplate.selectList("com.anbo.po.Article.selectArticleByUserId",userid);
	}
	
  
	@Override
	public boolean selectUserInfoByParam(Map<String, String> map) {
		//SqlSession session=MybatisFactory.getSqlSession();
		boolean flag=false;
		
		System.out.println("sqlSessionTemplate= "+sqlSessionTemplate);
		//System.out.println("MybatisFactory= "+MybatisFactory.getSqlSession());
		System.out.println("map ="+map);
		//flag=(Integer)session.selectOne("com.anbo.po.UserBean.selectUserInfoByParam", map)>0?true:false;
		
		UserBean a=sqlSessionTemplate.selectOne("com.anbo.po.UserBean.selectUserInfoByParam", map);
		System.out.println("a===  "+a.getLoginName());
		return a!=null?true:false;
	}

	@Override
	public boolean addUsers(UserBean user) {
		//SqlSession session=MybatisFactory.getSqlSession();
		boolean flag=false;
		flag=sqlSessionTemplate.insert("com.anbo.po.UserBean.addUser",user)>0?true:false;
		//session.commit();
		//session.close();
		return flag;
		
		
		
	}

	@Override
	public int selectUserCount() {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectOne("com.anbo.po.UserBean.selectUserCount");
	}

	@Override
	public List<UserBean> getPaginationUsers(Map<String,Integer> map) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.selectList("com.anbo.po.UserBean.getPaginationUsers",map);
	}

	@Override
	public int selectMaxUserId() {
		
		return sqlSessionTemplate.selectOne("com.anbo.po.UserBean.selectMaxUserId");
	}

		
}
