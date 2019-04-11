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
	<div >			 
			 
			 <ul class = "nav nav-tabs" id = "navTabs"> 
			 	<!--如果不是A标签，就用 data-target属性表示目标内容-->
			 	<li class="active"><a href="#deptTab" data-toggle="tab">部门管理</a></li>  			 	
 			 </ul>
			 
			 <br />
			 <div class = "tab-content">		
			 	<!-- depttab begin -->
			 	<div class ="tab-pane active" id ="deptTab">
				 	<!-- depttab 查询表头 -->
				 	<form name = "deptForm" id = "deptForm">
				 	<div class = "form-inline">
					 	<div class = "form-group">
		            		<label>部门名称:</label>
		            		<input type = "text" class = "form-control" id="deptNameQuery" name="deptName"  placeholder = "请输入部门名称" value="">
		            		<button type="button" class="btn btn-default " id = "queryDeptBtn" onclick="deptMgr.tzQueryDept();">查询</button>
		            		<button class = "btn btn-default" type="button" id="addDeptBtn" onclick = "deptMgr.tzEditDept(1,null)">新增</button>
		            	</div>
		            	<p>
		            	
		            	<!-- 列表begin -->
		            	<div class = "panel panel-default">
							<div class = "panel-heading">部门信息列表</div>
								<div class = "panel-body">
									<table class ="table" id = "deptListTable"> 
										<thead>
											<tr>
												<th>部门名称</th>												
												<th>上级部门</th>
												<th>部门负责人</th>											
												<th>部门职责</th>
												<th>部门电话</th>
												<th>部门地址</th>
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
				 	<!-- depttab 查询表头 end --> 	
			 	</div>
			 	
			 	<!--用于新增，修改页面  -->
			 	<form name = "editDeptForm" id= "editDeptForm" >
			 	<div class = "modal fade" id = "editDeptModal">
	        		<div class = "modal-dialog modal-lg">
	        			<div class = "modal-content">
	        				<div class ="modal-header">
	        					<button type = "button" class = "close" data-dismiss = "modal">
	        						<span aria-hidden = "true">&times;</span>
	        						<span class = "sr-only">Close</span>
	        					</button>
	        					<h4 class = "modal-title">部门信息编辑</h4>
	        				</div>
	        				<div class = "modal-body">
	        					 <div class="form-inline">
	        					 	<div class= "col-md-6 ">
										<div class="form-group">
											<label>部门名称: </label>
											<input type = "hidden" name = "deptId" id = "deptId">
											<input type = "hidden" name = "editDeptFlag" id ="editDeptFlag">
											<input type="text" class = "form-control" id= "deptName" name = "deptName" />
										</div>
									</div>
									 
									
									<div class="form-group">
										<label>部门描述:</label>&nbsp;&nbsp;&nbsp;
										<input type="text" class ="form-control" id ="deptDesc" name = "deptDesc" />
									</div>	
								 </div>
								 <p>								 								 
								 <div class="form-inline">
								 	<div class= "col-md-6 ">
										<div class="form-group">
											<label>上级部门: </label>
											<select class="form-control" name = "parentDeptId" id = "parentDeptId">
 									 		</select>
										</div>
									</div>
									 
									<div class="form-group">
										<label>部门负责人: </label>
										<select class="form-control" name = "deptManagerId" id = "deptManagerId">
 								 		</select>
									</div>	
								 </div>
								 <p> 
								 <div class="form-inline">
								 	<div class= "col-md-6 ">
										<div class="form-group">
											<label>部门电话: </label>
											<input type="text" class = "form-control" name = "deptPhone" id = "deptPhone"  />
										</div>
									</div>	
									 
									<div class="form-group">
										<label>部门地址: </label>&nbsp;&nbsp;&nbsp;
										<input type="text" class ="form-control" name = "deptAddress" id = "deptAddress" />
									</div>	
								 </div>
								  
	        				</div>
	        				<div class = "modal-footer">
	        					<button class ="btn btn-default" type="button" onclick="deptMgr.tzSaveDept();">保存</button>
	        					<button id ="myBtnClose" class ="btn btn-default" type="button" data-dismiss = "modal">退出</button>
	        					
	        				</div>
	        			</div>
	        		</div>
	        	</div>
	        	</form>
				<!--用于修改新增页面 end  -->	
			 			 	 
			 </div>
			 
  		
		 
<script type="text/javascript">
	var deptMgr = {
		tzQueryDept:function(){
			var deptNameQuery = $("#deptNameQuery").val();	 
	 		$.ajax({
				type:'post',//请求方式
				url:'<%=path%>/pages/dept/deptAction?method=queryDeptList', 
				dataType:'json', //有几种格式 xml html json text 等常用
				//data传值的另外一种方式 form的序列化
				data:{"deptNameQuery":deptNameQuery},//传递给服务器的参数
				beforeSend:function(){
						
				},
				success:function(data){//与服务器交互成功调用的回调函数
					//data就是out.print输出的内容
					if(data=='error'){
						//$("#password").val("").focus();//清空密码
						alert("查询部门记录失败");
						//$("#errormessage").show().html("用户名和密码不正确").fadeOut(3000);
					}else{
						//转换为json对象 
						//var dataObj=eval("("+data+")");//转换为json对象 
						//alert("dataObj="+dataObj);
						//由于json是以”{}”的方式来开始以及结束的，在JS中，它会被当成一个语句块来处理，所以必须强制性的将它转换成一种表达式
						//alert("data="+JSON.stringify(data));
					 
						var htmlTable = "";
						for(var i=0;i<data.length;i++){
							htmlTable = htmlTable+"<tr>";
							htmlTable = htmlTable+"<td>";
							htmlTable = htmlTable+data[i].deptName;
							htmlTable = htmlTable+"</td>";	
							htmlTable = htmlTable+"<td>";
							htmlTable = htmlTable+data[i].parentDeptName;
							htmlTable = htmlTable+"</td>";	
							htmlTable = htmlTable+"<td>";
							htmlTable = htmlTable+data[i].deptManagerName;
							htmlTable = htmlTable+"</td>";	
							htmlTable = htmlTable+"<td>";
							htmlTable = htmlTable+data[i].deptDesc;
							htmlTable = htmlTable+"</td>";	
							htmlTable = htmlTable+"<td>";
							htmlTable = htmlTable+data[i].deptPhone;
							htmlTable = htmlTable+"</td>";	
							htmlTable = htmlTable+"<td>";
							htmlTable = htmlTable+data[i].deptAddress;
							htmlTable = htmlTable+"</td>";	
							htmlTable = htmlTable+"<td>";
							
				    		var editButton = "<button type='button' class='btn btn-default' id = 'editDeptBtn' onclick='deptMgr.tzEditDept(2,"+data[i].deptId+");'>修改</button>";
							var delButton = "<button type='button' class='btn btn-default ' id = 'delDeptBtn' onclick='deptMgr.tzDelDept("+data[i].deptId+");'>删除</button>";
							htmlTable = htmlTable+editButton+delButton;
							htmlTable = htmlTable+"</td>";	
							
							htmlTable = htmlTable+"</tr>";
						}
						/* var htmlTable = "";
						$.each(data, function() {
							htmlTable = htmlTable+"<tr>";
							htmlTable = htmlTable+"<td>";
							htmlTable = htmlTable+this.userName;
							htmlTable = htmlTable+"</td>";	
							htmlTable = htmlTable+"<td>";
							htmlTable = htmlTable+this.deptId;
							htmlTable = htmlTable+"</td>";	
							htmlTable = htmlTable+"<td>";
							htmlTable = htmlTable+this.roleId;
							htmlTable = htmlTable+"</td>";	
							htmlTable = htmlTable+"<td>";
							htmlTable = htmlTable+this.remark;
							htmlTable = htmlTable+"</td>";	
							htmlTable = htmlTable+"<td>";
							htmlTable = htmlTable+this.tvUpdate;
							htmlTable = htmlTable+"</td>";	
							htmlTable = htmlTable+"</tr>";
					     }); */
						 $('#deptListTable').find('tbody').html(htmlTable);
						 //$("#userList").html(htmlTable);

					}
				},
				complete:function(data){//当请求完成以后,可以执行其他的动作	 
				}
			});
		},
		
		tzEditDept :function(editFlag,deptId){
			 //如果是新增用户信息，弹开新增页面，给editFlag赋值 ，清空所有form元素的值
			  //如果是进入修改页面，掉用修改js方法
			  if(editFlag==1){
				  $("#editDeptModal").modal("toggle");
				  $("#editDeptForm")[0].reset();
				  $("#editDeptFlag").val(1);
				  deptMgr.getDeptList();
				  deptMgr.getUserList();
			  }else{
				  $("#editDeptFlag").val(2);
				  deptMgr.tzUpdateDept(deptId);
			  }
		},
		
		tzDelDept :function(deptId){
			if(confirm("您确定要删除此部门吗?")){
		 		  $.ajax({
						type:'post',//请求方式
						url:'<%=path%>/pages/dept/deptAction?method=delDept', 
						dataType:'text', //有几种格式 xml html json text 等常用
						//data传值的另外一种方式 form的序列化
						data: {"deptId":deptId},//传递给服务器的参数
						beforeSend:function(){
								
						},
						success:function(data){//与服务器交互成功调用的回调函数
							//data就是out.print输出的内容
							if(data=='error'){
								//$("#password").val("").focus();//清空密码
								alert("删除部门失败");
								//$("#errormessage").show().html("用户名和密码不正确").fadeOut(3000);
							}else{
								//返回成功后，给出信息提示，并关闭模态对话框，重新查询记录
								alert("删除部门记录成功");
								deptMgr.tzQueryDept();
							}
						},
						complete:function(data){//当请求完成以后,可以执行其他的动作	 
						}
					});
			  }
		},
		
		tzSaveDept :function(){
			var editFlag = $("#editDeptFlag").val();
			var editMsg ="新增部门";
			if(editFlag==2){
				editMsg = "修改部门";
			}
			 
	  		var deptName = $("#deptName").val();
			//document.getElementById("deptName").value; --原生的js方式
		  
			if(isEmpty(deptName)){
				alert("请输入部门名称");		 
				return;
			};
					
			$.ajax({
				type:'post',//请求方式
				url:'<%=path%>/pages/dept/deptAction?method=saveDept', 
				dataType:'text', //有几种格式 xml html json text 等常用
				//data传值的另外一种方式 form的序列化
				data: $("#editDeptForm").serialize(),//传递给服务器的参数
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
	                    $("#editDeptModal").modal("hide");
	                    deptMgr.tzQueryDept();
					}
				},
				complete:function(data){//当请求完成以后,可以执行其他的动作	 
				}
			});
		},
		
		//获取部门列表方法
		getDeptList : function(){
			 $.ajax({
					type:'post',//请求方式
					url:'<%=path%>/pages/dept/deptAction?method=queryDeptList', 
					dataType:'json', //有几种格式 xml html json text 等常用
					//data传值的另外一种方式 form的序列化
					data: {"deptNameQuery":""},//传递给服务器的参数					
					success:function(data){//与服务器交互成功调用的回调函数
						 $("#parentDeptId").empty(); //清空省份SELECT控件
						 $.each(data, function(i, item) {
			                $("<option></option>")
			                    .val(item["deptId"])
			                    .text(item["deptName"])
			                    .appendTo($("#parentDeptId"));
						 });  
						//alert(data);
					}
				});
		},
		//获取用户方法
		getUserList : function (){
		 $.ajax({
				type:'post',//请求方式
				url:'<%=path%>/pages/user/userAction?method=queryUserList', 
				dataType:'json', //有几种格式 xml html json text 等常用
				//data传值的另外一种方式 form的序列化
				data: {"userNameQuery":""},//传递给服务器的参数					
				success:function(data){//与服务器交互成功调用的回调函数
					 $("#deptManagerId").empty(); //清空角色下拉框
					 //填充xialakuang
					 $.each(data, function(i, item) {
		                $("<option></option>").val(item["userId"]).text(item["userName"]).appendTo($("#deptManagerId"));
					 });  
					//alert(data);
				}
			});
		},
		
		tzUpdateDept :function(deptId){
			//修改页面流程
			//1:打开弹窗
			//2:去后台根据id查询用户信息，并赋值到页面
			//3：修改后保存
			//4:保存成功关闭弹窗
			$("#editDeptModal").modal("toggle");
			$.ajax({
				type:'post',//请求方式
				url:'<%=path%>/pages/dept/deptAction?method=queryDeptDetail', 
				dataType:'json', //有几种格式 xml html json text 等常用
				//data传值的另外一种方式 form的序列化
				data: {"deptId":deptId},//传递给服务器的参数
				beforeSend:function(){
					deptMgr.getDeptList();
					deptMgr.getUserList();	
				},
				success:function(data){//与服务器交互成功调用的回调函数
					if(data=='error'){
						alert("修改用户记录失败");
					}else{				    
						alert("data="+JSON.stringify(data));
						$("#deptId").val(data.deptId);
						$("#deptName").val(data.deptName);
						$("#deptDesc").val(data.deptDesc);
						$("#parentDeptId").val(data.parentDeptId);
						$("#deptManagerId").val(data.deptManagerId);
						$("#deptPhone").val(data.deptPhone);
						$("#deptAddress").val(data.deptAddress);
						
					}
				},
				complete:function(data){//当请求完成以后,可以执行其他的动作	 
				}
			});
		} 
	};
	 
	 
 
</script>	
  		
</body>
</html>

