<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'deptInfo.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  <script type="text/javascript" src="<%=path%>/js/jquery-1.7.2.min.js"></script>
  </head>
  
  <body>
    <form action="" name="myForm" method="post">
       <table align="left" border="0">
         <tr>
           <td>
                                   使用部门:
           </td>
           <td>
                                   部门编号:<input type="text" name="ids" id="ids" value="" /><br/>
                                   部门名称:<input type="text" name="deptname" id="deptname" value="" onclick="openDeptTree();"/>
           </td>
         </tr>
       </table>
    </form>
  </body>
 <script type="text/javascript">
   function openDeptTree(){
        var checkedIds=$("#ids").val();//选好了的部门编号
        var url="<%=path %>/user/deptAction!showDeptTree.action?checkedIds="+checkedIds;
	    var value= window.showModalDialog(url,window,"dialogWidth=600px;dialogHeight=700px;");
	    
	    //赋值方式一：
	   // var idAndName=value.split("_");
	   // $("#ids").val(idAndName[0]);
	   // $("#deptname").val(idAndName[1]);
   } 
 </script>
</html>
