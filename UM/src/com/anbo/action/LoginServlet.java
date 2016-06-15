package com.anbo.action;


import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anbo.dao.UserDAO;
import com.anbo.dao.impl.UserDAOImpl;
import com.anbo.po.UserBean;

public class LoginServlet extends HttpServlet {

	String s=this.getInitParameter("");
	
	

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("hhhhhhhhhhhhhhhhhhhhhh");
		//设置传参乱码
		request.setCharacterEncoding("utf-8");
		String username=request.getParameter("loginName");
		String userpwd=request.getParameter("loginPwd");
		UserDAO userDao=new UserDAOImpl();
		
		//查询
		boolean flag=userDao.loginOrNot(username, userpwd);
		if(flag){
			//登陆成功
			request.getRequestDispatcher("main.html").forward(request, response);
		}else{
			response.sendRedirect("error.jsp");
		}
	}
}
