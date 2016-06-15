package com.anbo.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.anbo.dao.UserDAO;
import com.anbo.dao.impl.UserDAOImpl;
import com.anbo.po.UserBean;


public class AllUserServlet extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method=request.getParameter("method");
		if(method.equals("showUser")){
			System.out.println("显示全部==");
			UserDAO userDao=new UserDAOImpl();
			List<UserBean> ls=userDao.allUser();
			request.setAttribute("ls", ls);
			request.getRequestDispatcher("allUser.jsp").forward(request, response);
		}else if(method.equals("addUser")){
			this.addUser(request, response);
		}
	
	}
	public void addUser(HttpServletRequest request, HttpServletResponse response){
		System.out.println("跳转到添加页面添加========");
		
	}
}
