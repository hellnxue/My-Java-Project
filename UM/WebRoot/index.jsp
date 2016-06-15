<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="<%=path%>/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/jquery.form.js"></script>
	<script type="text/javascript" src="<%=path%>/js/cookie/jquery.cookie.js"></script>
	<style type="text/css">
	   .ss{color:#FFF}
	</style>
	<script type="text/javascript">
	$(function(){
		
	//测试prompt	
	 $("#prompt").click(function(){
		var name=prompt("请输入名字","");
		document.getElementById("prt").innerHTML=name;
		})
	  // alert("读取cookie 用户名"+$.cookie("username"));
      //读取cookie
      if($.cookie("username")!="null"&&$.cookie("username")!=undefined){
         $("#username").val($.cookie("username"));
        
       }
      if($.cookie("pwd")!="null"&&$.cookie("pwd")!=undefined){
     
         $("#pwd").val($.cookie("pwd"));
       }
   
     });
	
	//写入cookie
	function testCookie(){
     
     if($("#chkSave").attr("checked")){
        $.cookie("username",$("#username").val(),{path:"/",expires:1});//expires:有限日期，可以是一个整数或一个日期(单位：天)。　　这个地方也要注意，如果不设置这个东西，浏览器关闭之后此cookie就失效了
        $.cookie("pwd",$("#pwd").val(),{path:"/",expires:1});//path: cookie值保存的路径，默认与创建页路径一致。
        //alert("已写入cookie!");
     }else{
        $.cookie("username",null,{path:"/"});
        $.cookie("pwd",null,{path:"/"});
     }
  }
	function subForms(){
		
		$("#forms").submit();
		
	}
	</script>
  </head>
  
  <body>
  
  	<%
	    request.setAttribute("xin","小新");
	  %>
   <form action="<%=path %>/user/user!checkUserInfo.action"  method="post" id="forms">
   <!-- 验证ajax提交表单专用 -->
  	<!--<form action="#"  method="post" id="forms">-->
    用户名:<input type="text" name="user.loginName" id="username" value="小新"><span>写小新奥</span><br/> 
    密码&nbsp;&nbsp;&nbsp;:<input type="password" name="user.loginPwd" id="pwd" value="123"><br/>
     
    <input id="chkSave" type="checkbox"/>是否记住用户名和密码<br>
     <input type="button" value="测试cookie" onclick="testCookie()"> <br>
    <input type="button" value="提交" onclick="subForms()"> <br>
    <input type="button" value="ajax提交" onclick="ajaxSub();"> <br><br>
    <input type="button" value="prompt可以输入参数的弹出窗口" id="prompt"><div id="prt"></div><br>
    <a href="<%=path %>/user/user!checkUserInfo.action?name=123&id=1">超链接也是get请求方式</a>
    
    <%! int i=0; %>
   <%
     if(session.isNew()){
    	 i++;
    	 session.setAttribute("kiss",i);
     }
   %>
 <p> 第： <%=session.getAttribute("kiss") %></p>
    </form>
    <%out.print("out out"); %>
<script type="text/javascript">
 
	  

 //用ajax提交表单
 function ajaxSub(){
	
    $("#forms").ajaxSubmit({
    	//不设置url时，默认按照action地址提交，设置后覆盖掉action
    	url:"<%=path %>/user/user!tests.action",
    	type:"post",
    	//clearForm:true,//提交成功后，清空表单中的字段值
    	restForm:true,//提交成功后，将表单所有的字段内容恢复到页面加载的默认值
    	//dataType:null,//服务器返回的数据类型
    	//target:target,//将返回的数据显示在指定id的div中
    	timeout:5000,//设置请求时间，超过该时间后，自动退出请求
        success:function(data){
           alert(data);
           
        }
    });
 }
 
 $(function(){
	 //$("#tip").html("hello world").show(1000);
	 $("#tip").bind("click",function(){
		$("#tip").html("hello world").show(10000);
		 
	 });
	 
 });
</script>
<br/>
链式jquery:
<div id="tip">ffff</div><br/>
jquery控制CSS：
<div id="tip2">hhhh</div>

<h1>ss<%=request.getAttribute("xin") %></h1>
<h1>ss<%=pageContext.getRequest().getAttribute("xin") %></h1>
<%=pageContext.getAttributesScope("xin")%>
<%@include file="error.jsp"%>
  </body>
</html>
