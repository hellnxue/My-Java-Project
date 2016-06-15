package com.anbo.dao.impl;

import java.sql.*;

import java.util.*;


import com.anbo.dao.StudentDao;
import com.anbo.po.Student;
import com.anbo.util.DBConnection;

public class StudentDaoImpl implements StudentDao {

	@Override
	public List<Student> getAllStudent() {
		List<Student> list=new ArrayList<Student>();
		//获得DBConnection
	   Connection dbc=DBConnection.getCon();
	   PreparedStatement pstmt=null;
	   ResultSet rs=null;
	   String sql="select * from Student";
	   try {
		   pstmt=dbc.prepareStatement(sql);
		  rs=pstmt.executeQuery();
		  while(rs.next()){
			  Student stu=new Student();
			  stu.setId(rs.getString("id"));
			  stu.setName(rs.getString("name"));
			  stu.setSex(rs.getString("sex").charAt(0));
			  stu.setBirthday(rs.getDate("birthday"));
			  stu.setScore(rs.getDouble("score"));
			  list.add(stu);
		  }
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	   
		return list;
	}

}
