<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />  
    <title>异常页面</title>      
  </head>
  
  <body>
    登录失败 ，请<a href="login.html">重新登录</a><br/>
    
    <h1>aa${result}</h1>
    <c:if test="${!empty result}">
                          异常错误信息：<div style="color:blue">${exceptionStack }</div>
    </c:if>
    <c:if test="${empty result}">
                         地址栏输入错误！请仔细检查
    </c:if>
  </body>
</html>
