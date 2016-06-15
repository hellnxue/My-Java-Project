<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>树结构</title>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<link rel="stylesheet" href="<%=path%>/js/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="<%=path%>/js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/ztree/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/ztree/js/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="<%=path%>/js/ztree/js/jquery.ztree.excheck-3.5.js"></script>
<script type="text/javascript" src="<%=path%>/js/ztree/js/jquery.ztree.exedit-3.5.js"></script>

<style type="text/css">
		        html,body{ height: 100%;}
				.ztree li span.button.pIcon01_ico_open{margin-right:2px; background: url(<%=path%>/js/ztree/css/zTreeStyle/img/diy/1_open.png) no-repeat scroll 0 0 transparent; vertical-align:top; *vertical-align:middle}
				.ztree li span.button.pIcon01_ico_close{margin-right:2px; background: url(<%=path%>/js/ztree/css/zTreeStyle/img/diy/1_close.png) no-repeat scroll 0 0 transparent; vertical-align:top; *vertical-align:middle}
				.ztree li span.button.pIcon02_ico_open,.ztree li span.button.pIcon02_ico_close{margin-right:2px; background: url(<%=path%>/js/ztree/css/zTreeStyle/img/diy/folder_open_icon.gif) no-repeat scroll 0 0 transparent; vertical-align:top; *vertical-align:middle}
				.ztree li span.button.pIcon02_ico_docu{margin-right:2px; background: url(<%=path%>/js/ztree/css/zTreeStyle/img/diy/leaf_icon.gif)  no-repeat scroll 0 0 transparent; vertical-align:top; *vertical-align:middle}
</style>	
<script type="text/javascript">
			var setting = {
					check: {
						enable: true,
						chkStyle: "checkbox",
						chkboxType: { "Y": "s", "N": "s" }

					},

					data: {
						simpleData: {
							enable: true
						}
					} 
				};
				
				var zNodes = ${zNodes}; //返回后台处理后的json值
				
				//初始化树
				$(document).ready(function(){
					$.fn.zTree.init($("#deptTree"), setting, zNodes);
					
				});
				
				//保存选择的设备信息
				function saveChecked(){
					var nameStr = "";
					var idStr="";
					var zTree = $.fn.zTree.getZTreeObj("deptTree");//获得当前树对象
					var nodes = zTree.getCheckedNodes(true);//获得选中的节点
					if(nodes.length<=0){
						alert("您没有选择部门，请您选择一个的部门！");
						return false;
					}else{
						
						for(var i=0;i<nodes.length;i++){
							//nameStr = nameStr+ nodes[i].name+",";
							if(nodes[i].isRoot!=1){//isRoot是自己加的节点标示，标示这是根节点，不能作为值
							   //将返回值处理成'id,id'的形式
							   if(nameStr==''){//初始化时
							       nameStr=nodes[i].name;
							       idStr=nodes[i].id;
								}else{
								   nameStr=nameStr+","+nodes[i].name;
								   idStr=idStr+","+nodes[i].id;
								}
							}
							
						}
						if(nameStr==""){
						  alert("请选择部门！");
						  return false;
						}	
						//赋值方法一
						//window.returnValue=idStr+"_"+nameStr;
						
						//赋值方法二(在弹出的窗口中直接赋值)
						$("#ids",window.dialogArguments.document).val(idStr);
						$("#deptname",window.dialogArguments.document).val(nameStr);
						window.close();	
					} 
					
				}	
				
		</script>
		<style type="text/css">
			.ztree li span.button.add {margin-left:2px; margin-right: -1px; background-position:-144px 0; vertical-align:top; *vertical-align:middle}
		</style>
</head>
<body>
<form action="<%=path %>/user/deptAction!showDeptTree.action" method="post">
 
  <div id="guideBarPanel" class="bk_cmm_guidePanel" >
		<span class="bk_cmm_guideOpera">部门信息</span>
	</div>
	
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td id="left1" width="300" style="vertical-align:top;">
				<div class="zTreeDemoBackground left">
					<ul id="deptTree" class="ztree"></ul>
				</div>
			</td>
		</tr>
		<tr>
			<td class="bk_am_operCol" colspan="2" align="center" >
				<input  type="button" value="确定" id="saveCheckId"  onclick="saveChecked();" />
				<input  type="button" value="取消" onclick="window.close();"/>
				
			</td>
		</tr>
	</table>
</form>
</body>
</html>