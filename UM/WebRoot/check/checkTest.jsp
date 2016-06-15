<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'checkTest.jsp' starting page</title>
    
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
      <table border="0">
       <tr>
          <td>设备编号</td>
          <td>
              <input type="text" name="equipNo" id="equipNo" onblur="checkEquipNo(this)"/>
          </td>
          <td>
            <div style="color:gray;">只允许填写字母、数字、下划线！</div>
          </td>
        </tr>
        <tr>
          <td>设备条形码</td>
          <td>
              <input type="text" name="barcode" id="barcode" onblur="checkBarcode(this)"/>
          </td>
          <td>
            <div style="color:gray;">只允许填写字母或数字！</div>
          </td>
        </tr>
        <tr>
          <td>设备单位</td>
          <td>
              <input type="text" name="units" id="units" onblur="checkUnits(this)"/>
          </td>
          <td>
            <div style="color:gray;">只能填写汉字！</div>
          </td>
        </tr>
         <tr>
          <td>设备造价</td>
          <td>
              <input type="text" name="cost" id="cost" onblur="checkCost(this);"/>
          </td>
          <td>
            <div style="color:gray;">只能填写数字或小数！</div>
          </td>
        </tr>
         <tr>
          <td>折旧年限(年)</td>
          <td>
              <input type="text" name="depreciationYear" id="depreciationYear" onblur="checkDepreciactionYear(this);"/>
          </td>
          <td>
            <div style="color:gray;">只能填写数字,没有小数！</div>
          </td>
        </tr>
        <tr>
          <td>备注</td>
          <td>
             <textarea rows="3" cols="45" onkeyup="checkLength(this)"></textarea>
          </td>
          <td>
            <div style="color:gray;">不得超过50字！</div>
          </td>
        </tr>
        <tr>
          <td>hehe</td>
          <td>hehe</td>
          <td>hehe</td>
        </tr>
      </table>
    </form>
  </body>
<script type="text/javascript">
//jQuery加载页面的三种方式
//第一种
//$(document).ready(function(){
//  alert("just one!");
//});
//第二种
//$(function(){
// alert("thank you");
//});
//网上搜的第三种
//jQuery(function($){
//  alert("three");
//});

//验证设备编号，字母或数字，允许有下划线
function checkEquipNo(which){
   
   var charts=which.value;
   var chartGroup=charts.split("_");
   if(which.value!=""){
      if(chartGroup.length>=3){//只能有一条下划线
     alert("格式不正确1！");
     which.value="";
     //注：这样写-->charts=""不管用;
     return false;
   }else if(chartGroup[0]==""||chartGroup[1]==""){//下划线两边不能为空
     alert("格式不正确2！");
     which.value="";
     return false;
   }else{//循环验证每个字符是不是字母或数字
      for(var i=0;i<charts.length;i++){
         if(/[a-zA-z_0-9]/.test(charts.substr(i,1))==false){
           alert("格式不正确3！");
           which.value="";
           return false;
         }
      }
   }
   }
   

   //倒序获得字符串中的每个字符
   //for(var i=charts.length-1;i>=0;i--){
   //  alert(i);
   //  var ch=charts.substr(i,1);
    // alert(ch);
   //}
   //正序获得字符串中的每个字符
   //for(var i=0;i<charts.length;i++){
   //   var ch=charts.substr(i,1);
   //   alert(i+"  "+ch);
      
   //}
  
}

//验证物资条形码：只允许填写字母或数字，无下划线
function checkBarcode(which){
  for(var i=0;i<which.value.length;i++){
     if(/[a-zA-Z0-9]/.test(which.value.substr(i,1))==false){
        alert("格式不正确，只能填写字母或数字！");
        which.value="";
        return false;
     }
  }
}
//验证设备单位：只能填写汉字
function checkUnits(which){
  for(var i=0;i<which.value.length;i++){
    if(/[\u4e00-\u9fa5]/.test(which.value.substr(i,1))==false){
       alert("只能填写汉字！");
       which.value="";
       return false;
    }
  }
}

//验证设备造价：只能填写数字，可以有小数
function checkCost(which){
  var costGroup=which.value.split(".");
  if(which.value!=""){
    if(costGroup.length>=3){
      alert("格式不正确！");
      which.value="";
      return false;
    }else{
      for(var i=0;i<costGroup.length;i++){
         if(/^\d+$/.test(costGroup[i])==false){//  /^\d+$/ 这个正则表达式就是匹配一整行1个以上的数字
            alert("只能填写数字！");
            which.value="";
            return false;
         }
      }
    }
  }
}

//折旧年限：只能填写数字，没有小数
function checkDepreciactionYear(which){
   if(which.value!=""){
      if(/^\d+$/.test(which.value)==false){
          alert("只能填写数字！");
          which.value="";
          return false;
      }
   }
}
//验证备注不得超过50个字
function checkLength(which){
  var maxChr=50;//最大字数限制
  if(which.value.length>maxChr){
    alert("不得超过50字！");
    which.value=which.value.substring(0,maxChr);
  }
  
}
</script>
</html>
  
