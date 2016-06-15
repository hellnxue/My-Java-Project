<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
      String path=request.getContextPath();
     %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=path %>/js/jquery-1.7.2.min.js"></script>
</head>
<body>
<a href="<%=path %>/login.html">登录</a><br/>
<form action="<%=path %>/user/user!addUsers.action" method="post">
<table border="0" align="center">
    	<tr>
       	  <td>用户名：</td>
            <td><input type="text" name="user.loginName" /></td>
        </tr>
        <tr>
        	<td>密码：</td>
            <td><input type="password" name="user.loginPwd" /></td>
        </tr>
        <tr>
        	<td>sex：</td>
            <td>
               <input type="radio" name="user.sex" value="0">女
               <input type="radio" name="user.sex" value="1">男
            </td>
        </tr>
        <%--<tr>
        	<td>birthday：</td>
            <td><input type="text" name="user.birthday" /></td>
        </tr>
        --%><tr>
        	<td>email：</td>
            <td><input type="text" name="user.email" /></td>
        </tr>
        <tr>
            <td align="center"><input type="button" value="导入用户" onclick="selectUser();"/></td>
        	<td align="right"><input type="submit" value="提交"/></td>
        </tr>
    </table>
</form>
</body>
<script type="text/javascript">
 //jQuery(function($){
  // alert("hehe");
 //});
 function selectUser(){
   var url="<%=path%>/user/user!showAllUser.action";
   window.showModalDialog(url,null,"dialogWidth:500px;dialogHeight:20px;");
 }
</script>
</html>