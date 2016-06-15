<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'testJSPPage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
   
  <body>
      <table id="myTable" width="100%" border="1" >
    	<tr>
    		<th>序号</th>
    		<th>用户名</th>
    		<th>性别</th>
    		<th>生日</th>
    		<th>邮箱</th>
    		<th>操作</th>
    	</tr>
    	<c:forEach items="${usersList}" var="user">
    	   <tr>
    	   <td>${user.userId}</td>
    	   <td>${user.loginName}</td>
	       <td>${user.sex}</td>
	       <td>${user.birthday}</td>
	       <td>${user.email}</td>
	       <td><a href="delUser?id=${user.userId}">删除</a></td>
    	   </tr>
    	</c:forEach>
    </table>
  </body>
</html>
