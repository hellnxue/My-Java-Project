<%@ page language="java" import="com.anbo.po.*,com.anbo.dao.*,com.anbo.dao.impl.*,java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />  
    <title>用户列表</title> 
    <link rel="stylesheet" href="css/pagination/pagination.css" />
    <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
    <script type="text/javascript" src="js/pagination/jquery.pagination.js"></script>
    <script type="text/javascript" src="js/template/template.js"></script>
    <script type="text/javascript" src="js/activebar2/activebar2.js"></script>
    <style type="text/css">
       #myTable tr th{background-color: #ccc}
       .trodd{background-color: #eee}
    </style>
    <script type="text/javascript" language="javascript">
    
    function accept(userid){
	  if(confirm('确认要删除吗？')){
		window.location.href="delUser?id="+userid;
		}
	}
    $(function(){
    	
    	
    	//alert("浏览器的版本是 ="+$.browser.version);
    	
    	//消息通知插件同志信息
    	$("<div></div>").html("这是一个消息通知插件，点击之后还可以跳转链接....").activebar({'font':'serif', 'icon': 'img/activebar-information.png',"button":"img/activebar-closebtn.png"});
    	
    	testPagination();// 用jquery分页插件pagination分页  问题：刷新时不停留在当前页，还没解决呢
    	
    
    });
    function testPagination(){
    	var count=parseInt($("#count").html());//数据总条数
    	var opt = {callback: PageCallback};
    	//alert(opt);
    	//var hehe='${session.pageIndex}';
    	//alert(hehe);
    	//alert(count);
    	$("#pagContent").pagination(count,{
			prev_text: "上一页", 
			next_text: "下一页", 
			items_per_page:3, //每页显示的条目数量
			num_edge_entries: 1, //两侧首尾分页条目数 
			num_display_entries: 2, //连续分页主体部分分页条目数 
			callback: PageCallback,
			current_page:1
    		 //PageCallback() 为翻页调用次函数。 
    	});
    }
    //显示分页内容回调函数
    function PageCallback(pageIndex,jp){
        alert("ok");
    	var url="<%=path %>/user/user!showPageUser.action?pageIndex="+pageIndex;
    	$.ajax({
    		    type:"post",
    		    url:url,
    		    dataType:"json",
			    contentType:"application/x-www-form-urlencoded; charset=utf-8",
    		    success:function(data){
			    		var json=eval(data);
			    		//alert(json[0].loginName);
			    		//渲染模板
			    		var tempData={
			    			list:json
			    		}; 
			    		//传数据给模板
			    		var html=template("ct",tempData);
			    		//显示数据
			    		$("#pagePP").html(html);
    	          }
			    });
    	return false;//必须加上
    }
    
    //ajax删除
    function ajaxDelete(id){
    	$.ajax({
    		type:"post",
    		url:"delUser",
    		data:"id="+id,
    		success:function(data){
    		   
    		   if(data==1){
    			   alert("删除成功");
    			    window.location.reload();
    		   }
    		  
    		}
    		
    	})
    	
    	
    }
</script>   
  </head>
  
  <body>
  <script type="text/html" id="ct">
  {{each list as value}}
     <tr id="hehe">
      <td>{{value.userId}}</td>
	  <td>{{value.loginName}}</td>
      <td>{{value.sex}}</td>
      <td>{{value.birthday}}</td>
      <td>{{value.email}}</td>
      <td><a href="javascript:ajaxDelete({{value.userId}})">删除</a></td>
     </tr>
  {{/each}}
  </script>
  	<a href="addUser/addUser.jsp">&lt;添加用户</a><br/>
    <%
        List<UserBean> usersList=(List<UserBean>)request.getAttribute("usersList");
    %>
    <table id="myTable" width="100%" border="1" >
    	<tr>
    		<th>序号</th>
    		<th>用户名</th>
    		<th>性别</th>
    		<th>生日</th>
    		<th>邮箱</th>
    		<th>操作</th>
    	</tr>
    	<tbody id="pagePP">
    	  
    	</tbody>
    </table>
    <div id="pagContent" class="pagination" style="margin-top: 10px">数据加载中......</div>
    用户总数量：<div id="count">${count}</div>
   <!--  <jsp:include page="error.jsp"></jsp:include> -->
  <script type="text/javascript" language="javascript">
   $(function(){
        	
    	 $("#pagePP tr td").css("color","red");
    	$("#pagePP tr:nth-child(odd)").addClass("trodd").attr("bg","#eee");//表格隔行变色,记录颜色属性到bg
    	$("#pagePP tr:nth-child(even)").attr("bg","#fff");//表格隔行变色
    	$("#pagePP tr td").mouseover(function(){
    		//alert( $(this).parent().find("td")[0].tagName);
                $(this).parent().find("td").css("background-color","#d5f4fe");
            });
    	$("#pagePP tr td").mouseout(function(){
                var bgc = $(this).parent().attr("bg");//获得该行的颜色
                $(this).parent().find("td").css("background-color",bgc);
            });
    });
   </script>
  </body>

</html>
