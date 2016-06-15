<%@ page language="java" import="com.anbo.dao.*,com.anbo.dao.impl.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />  
		<%-- <link rel="stylesheet" type="text/css" href="styles.css"/>--%>  
		<%-- <script type="text/javascript" src="d.js"></script>--%>  
    <title>set your title</title>      
  </head>
  
  <body>
    <%
    	int id=Integer.parseInt(request.getParameter("id"));
    	UserDAO userDao=new UserDAOImpl();
    	boolean flag=userDao.delUser(id);
    	if(flag){
    		response.sendRedirect("allUser.jsp");
    	}else{
    		response.sendRedirect("error.jsp");
    	}
    %>
  </body>
</html>
