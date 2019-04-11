<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
    <head>
		<!--声明当前页面的编码集:charset=gbk,gb2312(中文编码)，utf-8国际编码-->
		<meta charset="UTF-8">
		<meta name="Keywords" content="关键词,关键字">
		<meta name="Description" content="">
		<title>用户管理</title>
		<link rel="stylesheet" href="<%=path%>/css/bootstrap.css" />
		<script type="text/javascript" src="<%=path%>/js/jquery-1.11.0.js" ></script>
		<script type="text/javascript" src="<%=path%>/js/bootstrap.js" ></script>
		<script type="text/javascript" src="<%=path%>/js/util.js" ></script>
		
	</head>
<body>
	<div>			 
			 
			 <ul class = "nav nav-tabs" id = "navTabs"> 
			 	<!--如果不是A标签，就用 data-target属性表示目标内容-->
			 	<li class="active"><a href="#roleTab" data-toggle="tab">角色管理</a></li>  			 	
 			 </ul>
			 
			 <br />
			 <div class = "tab-content">		
			 	<!-- roletab begin -->
			 	<div class ="tab-pane active" id ="roleTab">
				 	<!-- roletab 查询表头 -->
				 	<form name = "roleForm" id = "roleForm">
				 	<div class = "form-inline">
					 	<div class = "form-group">
		            		<label>角色名称:</label>
		            		<input type = "text" class = "form-control" id="roleNameQuery" name="roleName"  placeholder = "请输入角色名称" value="">
		            		<button type="button" class="btn btn-default " id = "queryRoleBtn" onclick="tzQueryRole();">查询</button>
		            		<button class = "btn btn-default" type="button" id="addRoleBtn" onclick = "tzEditRole(1,null)">新增</button>
		            	</div>
		            	<p>
		            	
		            	<!-- 列表begin -->
		            	<div class = "panel panel-default">
							<div class = "panel-heading">角色信息列表</div>
								<div class = "panel-body">
									<table class ="table" id = "roleListTable"> 
										<thead>
											<tr>
												<th>角色名称</th>																								 
 												<th>备注</th>								 
												<th>操作</th>
												
											</tr>
										</thead>
										<tbody>
									    
										</tbody>
									</table>							 
								</div>
								<!-- <div class = "panel-footer">
									
								</div> -->
							</div>		            	 
		            	<!-- 列表end -->
		            	<ul class = "pagination">
			 			 	<li><a href="javascript:void(0);">首页</a></li>
						 	<li><a href="javascript:void(0);">上一页</a></li>
						 	<li><a href="javascript:void(0);">...</a></li>
						 	<li><a href="javascript:void(0);">3</a></li>
						 	<li><a href="javascript:void(0);">4</a></li>
						 	<li><a href="javascript:void(0);">5</a></li>
						 	<li class = "active"><a href="javascript:void(0);">6</a></li>
						 	<li class = "disabled"><a href="javascript:void(0);">下一页</a></li>
						 	<li class = "disabled"><a href="javascript:void(0);">尾页</a></li>
						</ul>
				 	</div>
				 	</form>
				 	<!-- roletab 查询表头 end --> 	
			 	</div>
			 	
			 	<!--用于新增，修改页面  -->
			 	<form name = "editRoleForm" id= "editRoleForm" >
			 	<div class = "modal fade" id = "editRoleModal">
	        		<div class = "modal-dialog modal-lg">
	        			<div class = "modal-content">
	        				<div class ="modal-header">
	        					<button type = "button" class = "close" data-dismiss = "modal">
	        						<span aria-hidden = "true">&times;</span>
	        						<span class = "sr-only">Close</span>
	        					</button>
	        					<h4 class = "modal-title">角色信息编辑</h4>
	        				</div>
	        				<div class = "modal-body">
	        					 <div class="form-inline">
	        					 	<div class= "col-md-6 ">
										<div class="form-group">
											<label>角色名称: </label>
											<input type = "hidden" name = "roleId" id = "roleId">
											<input type = "hidden" name = "editRoleFlag" id ="editRoleFlag">
											<input type="text" class = "form-control" id= "roleName" name = "roleName" />
										</div>
									</div>
									 
									<div class="form-group">
										<label>备注:</label>&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;
										<input type="text" class ="form-control" id ="remark" name = "remark" />
									</div>	
								 </div>
								  
								  
	        				</div>
	        				<div class = "modal-footer">
	        					<button class ="btn btn-default" type="button" onclick="tzSaveRole();">保存</button>
	        					<button id ="myBtnClose" class ="btn btn-default" type="button" data-dismiss = "modal">退出</button>
	        					
	        				</div>
	        			</div>
	        		</div>
	        	</div>
	        	</form>
				<!--用于修改新增页面 end  -->	
			 			 	 
			 </div>
			 
  		
		 
<script type="text/javascript">

	function tzQueryRole(){
		var roleNameQuery = $("#roleNameQuery").val();	 
 		$.ajax({
			type:'post',//请求方式
			url:'<%=path%>/pages/role/roleAction?method=queryRoleList', 
			dataType:'json', //有几种格式 xml html json text 等常用
			//data传值的另外一种方式 form的序列化
			data:{"roleNameQuery":roleNameQuery},//传递给服务器的参数
			beforeSend:function(){
					
			},
			success:function(data){//与服务器交互成功调用的回调函数
				//data就是out.print输出的内容
				if(data=='error'){
					alert("查询角色记录失败");
				}else{					 
					var htmlTable = "";
					for(var i=0;i<data.length;i++){
						htmlTable = htmlTable+"<tr>";
						htmlTable = htmlTable+"<td>";
						htmlTable = htmlTable+data[i].roleName;
						htmlTable = htmlTable+"</td>";	
						htmlTable = htmlTable+"<td>";
						htmlTable = htmlTable+data[i].remark;
						htmlTable = htmlTable+"</td>";	
						 
						htmlTable = htmlTable+"<td>";
			    		var editButton = "<button type='button' class='btn btn-default' id = 'editRoleBtn' onclick='tzEditRole(2,"+data[i].roleId+");'>修改</button>";
						var delButton = "<button type='button' class='btn btn-default ' id = 'delRoleBtn' onclick='tzDelRole("+data[i].roleId+");'>删除</button>";
						htmlTable = htmlTable+editButton+delButton;
						htmlTable = htmlTable+"</td>";	
						
						htmlTable = htmlTable+"</tr>";
					}
					 
					 $('#roleListTable').find('tbody').html(htmlTable);
 
				}
			},
			complete:function(data){//当请求完成以后,可以执行其他的动作	 
			}
		});
	};
 
  function tzEditRole(editFlag,roleId){
	  //如果是新增用户信息，弹开新增页面，给editFlag赋值 ，清空所有form元素的值
	  //如果是进入修改页面，掉用修改js方法
	  if(editFlag==1){
		  $("#editRoleModal").modal("toggle");
		  $("#editRoleForm")[0].reset();
		  $("#editRoleFlag").val(1);
	  }else{
		  $("#editRoleFlag").val(2);
		  tzUpdateRole(roleId);
	  }
  }
	
  function tzDelRole(roleId){
	  if(confirm("您确定要删除此角色吗?")){
 		  $.ajax({
				type:'post',//请求方式
				url:'<%=path%>/pages/role/roleAction?method=delRole', 
				dataType:'text', //有几种格式 xml html json text 等常用
				//data传值的另外一种方式 form的序列化
				data: {"roleId":roleId},//传递给服务器的参数
				beforeSend:function(){
						
				},
				success:function(data){//与服务器交互成功调用的回调函数
					//data就是out.print输出的内容
					if(data=='error'){
						//$("#password").val("").focus();//清空密码
						alert("删除角色失败");
						//$("#errormessage").show().html("用户名和密码不正确").fadeOut(3000);
					}else{
						//返回成功后，给出信息提示，并关闭模态对话框，重新查询记录
						alert("删除角色记录成功");
	                    tzQueryRole();
					}
				},
				complete:function(data){//当请求完成以后,可以执行其他的动作	 
				}
			});
	  }
  }
  
  
  
  function tzSaveRole(){
	  	var editFlag = $("#editRoleFlag").val();
		var editMsg ="新增角色";
		if(editFlag==2){
			editMsg = "修改角色";
		}
		 
  		var roleName = $("#roleName").val();
		//document.getElementById("roleName").value; --原生的js方式
	  
		if(isEmpty(roleName)){
			alert("请输入角色名称");		 
			return;
		};
				
		$.ajax({
			type:'post',//请求方式
			url:'<%=path%>/pages/role/roleAction?method=saveRole', 
			dataType:'text', //有几种格式 xml html json text 等常用
			//data传值的另外一种方式 form的序列化
			data: $("#editRoleForm").serialize(),//传递给服务器的参数
			beforeSend:function(){
					
			},
			success:function(data){//与服务器交互成功调用的回调函数
				//data就是out.print输出的内容
				if(data=='error'){
					//$("#password").val("").focus();//清空密码
					alert(editMsg+"记录失败");
					//$("#errormessage").show().html("用户名和密码不正确").fadeOut(3000);
				}else{
					//返回成功后，给出信息提示，并关闭模态对话框，重新查询记录
					alert(editMsg+"记录成功");
                    $("#editRoleModal").modal("hide");
                    tzQueryRole();
				}
			},
			complete:function(data){//当请求完成以后,可以执行其他的动作	 
			}
		});
	};
 
	
	function tzUpdateRole(roleId){
		//修改页面流程
		//1:打开弹窗
		//2:去后台根据id查询用户信息，并赋值到页面
		//3：修改后保存
		//4:保存成功关闭弹窗
		$("#editRoleModal").modal("toggle");
		$.ajax({
			type:'post',//请求方式
			url:'<%=path%>/pages/role/roleAction?method=queryRoleDetail', 
			dataType:'json', //有几种格式 xml html json text 等常用
			//data传值的另外一种方式 form的序列化
			data: {"roleId":roleId},//传递给服务器的参数
			beforeSend:function(){
					
			},
			success:function(data){//与服务器交互成功调用的回调函数
				if(data=='error'){
					alert("修改角色信息失败");
				}else{				    
					alert("data="+JSON.stringify(data));
					$("#roleId").val(data.roleId);
					$("#roleName").val(data.roleName);			
					$("#remark").val(data.remark);
					
				}
			},
			complete:function(data){//当请求完成以后,可以执行其他的动作	 
			}
		});
 	};
 
</script>	
  		
</body>
</html>

