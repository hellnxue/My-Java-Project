package com.anbo.action;


import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.anbo.dao.impl.UserDAOImpl;
import com.anbo.dao.UserDAO;
/**
 * 此处为servlet删除用户，在struts.xml中设置有action与servlet请求共存的代码
 * @author liuxueping
 *
 */
public class delUserServlet extends HttpServlet {

	 private static final Logger logger = Logger.getLogger(UserAction.class);//日志记录
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");//设置输出中文乱码
		PrintWriter out=response.getWriter();
		
		logger.info("跳转到servlet删除action");
		
		//接参(接过Get方式传过来的参数)
		int ID=Integer.parseInt(request.getParameter("id"));
		//根据id删除数据
		UserDAO userDao=new UserDAOImpl();
		boolean flag=userDao.delUser(ID);
		if(flag){
			//删除成功，跳转到显示全部的Servlet
			//request.getRequestDispatcher("allUser.jsp").forward(request, response);
			out.print(1);
		}else{
			out.print(0);
			//删除失败
			//response.sendRedirect("exception.jsp");
		}
		
//      // request.setCharacterEncoding("utf-8");
//       response.setContentType("text/html;charset=utf-8");
//       PrintWriter out=response.getWriter();
//		String id=request.getParameter("id");
//		out.println(id);
	}
//	

}
