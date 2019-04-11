<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import ="com.tz.jspstudy.sysmanage.bean.User" %>
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
			<!--
            	作者：896913570@qq.com
            	时间：2016-04-27
            	描述：导航JS知识点
            -->
            <!--tab页样式导航 nav-tabs样式作用：水平方向展示 出现边框-->
            
			 <ul class = "nav nav-tabs" id = "navTabs"> 
			 	<!--如果不是A标签，就用 data-target属性表示目标内容-->
			 	<li class="active"><a href="#userTab" data-toggle="tab">用户管理</a></li>  			 	
			 	<li><a href="#password" data-toggle="tab">修改密码</a></li>			  
			 </ul>
			 
			 <br />
			 <div class = "tab-content">
			
			 	<!-- usertab begin -->
			 	<div class ="tab-pane active" id ="userTab">
				 	<!-- usertab 查询表头 -->
				 	<form name = "userForm"  method = "post"  action ="/studyJsp/pages/user/queryUser">
				 	<div class = "form-inline">
					 	<div class = "form-group">
		            		<label>用户名称:</label>
		            		<input type = "text" class = "form-control" id="userNameQuery" name="userNameQuery"  placeholder = "请输入用户名称" value="">
		            		<button type="button" class="btn btn-default " id = "queryBtn" onclick="userMgr.tzQueryUser();">查询</button>
		            		<button class = "btn btn-default" type="button" id="addBtn" onclick = "userMgr.tzEditUser(1,null)">新增</button>
		            	</div>
		            	<p>
		            	
		            	<!-- 列表begin -->
		            	<div class = "panel panel-default">
							<div class = "panel-heading">用户信息列表</div>
								<div class = "panel-body">
									<table class ="table" id = "userListTable"> 
										<thead>
											<tr>
												<th>序号</th>
												<th>用户姓名</th>
												<!--<th>密码</th>-->
												<!--<th>账号状态</th>-->
												<th>部门</th>
												<th>角色</th>
												<!--<th>手机号码</th>-->
												<!--<th>办公电话</th>-->
												<!--<th>家庭电话</th>-->
												<th>备注</th>
												<th>更改时间</th>
												<th>操作</th>
											</tr>
										</thead>
										<tbody>
									  	<!-- <div id ="userList" >
									  		 	      
									  	</div> -->
										<!--用jstl核心标签实现列表  -->		
										<%-- <c:forEach items="${requestScope.userList }" var="user">
											<tr>
												<!--<td>${pageScope.user.userId}</td>-->
												<td>${pageScope.user.userName}</td>
												<!--<td>${pageScope.user.password}</td>-->
												<!--<td>${pageScope.user.status}</td>	-->											
												<td>${pageScope.user.deptId}</td>
												<td>${pageScope.user.roleId}</td>
												<!--<td>${pageScope.user.mobile}</td>-->
												<!--<td>${pageScope.user.otelephone}</td>-->
												<!--<td>${pageScope.user.htelephone}</td>	-->											
												<td>${pageScope.user.remark}</td>
												<td>${pageScope.user.tvUpdate}</td>													
											</tr>	    			
						    			</c:forEach> --%>
									 
										</tbody>
									</table>							 
								</div>
								<!-- <div class = "panel-footer">
									
								</div> -->
							</div>		            	 
		            	<!-- 列表end -->
		            	<ul class = "pagination">
			 			 	<li><a href="javascript:userMgr.gotoFirst();">首页</a></li>
						 	<li><a href="javascript:userMgr.gotoBefore();">上一页</a></li>						 	 
						 	<li><a href="javascript:userMgr.gotoNext();">下一页</a></li>
						 	<li><a href="javascript:userMgr.gotoLast();">尾页</a></li>
						</ul>
				 	</div>
				 	</form>
				 	<!-- usertab 查询表头 end --> 	
			 	</div>
			 	
			 	<!--用于新增，修改页面  -->
			 	<form name = "editForm" id= "editForm" method = "post" action="/studyJsp/pages/user/editUser">
			 	<div class = "modal fade" id = "editModal">
	        		<div class = "modal-dialog modal-lg">
	        			<div class = "modal-content">
	        				<div class ="modal-header">
	        					<button type = "button" class = "close" data-dismiss = "modal">
	        						<span aria-hidden = "true">&times;</span>
	        						<span class = "sr-only">Close</span>
	        					</button>
	        					<h4 class = "modal-title">用户信息编辑页面</h4>
	        				</div>
	        				<div class = "modal-body">
	        					 <div class="form-inline">
	        					 	<div class= "col-md-6 ">
										<div class="form-group">
											<label>用户名称: </label>
											<input type = "hidden" name = "userId" id = "userId">
											<input type = "hidden" name = "editFlag" id ="editFlag">
											<input type="text" class = "form-control" id= "userName" name = "userName" />
										</div>
									</div>
									 
									
									<div class="form-group">
										<label>密码:</label>&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;
										<input type="password" class ="form-control" id ="password" name = "password" />
									</div>	
								 </div>
								 <p>								 								 
								 <div class="form-inline">
								 	<div class= "col-md-6 ">
										<div class="form-group">
											<label>所属部门: </label>
											<select class="form-control" name = "deptId" id = "deptId">
									 			<option value= 3 >潭州学院</option>							 			 
									 		</select>
										</div>
									</div>
									 
									<div class="form-group">
										<label>所属角色: </label>
										<select class="form-control" name = "roleId" id = "roleId">
								 			<option value=2>超级管理员</option>							 			 
								 		</select>
									</div>	
								 </div>
								 <p>
								 <div class="form-inline">
								 	<div class= "col-md-6 ">
										<div class="form-group">
											<label>手机号码: </label>
											<input type="text" class = "form-control" name = "mobile" id = "mobile"  />
										</div>
									</div>	
									 
									<div class="form-group">
										<label>办公电话: </label>
										<input type="text" class ="form-control" name = "otelephone" id = "otelephone" />
									</div>	
								 </div>
								 <p>
								 <div class="form-inline">
								 	<div class= "col-md-6 ">
										<div class="form-group">
											<label>家庭电话: </label>
											<input type="text" class = "form-control" name = "htelephone" id="htelephone" />
										</div>
									</div>	
									 
									<div class="form-group">
										<label>备注: </label>&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;
										<input type="text" class ="form-control" name = "remark" id = "remark"/>
									</div>	
								 </div>
	        				</div>
	        				<div class = "modal-footer">
	        					<button class ="btn btn-default" type="button" onclick="userMgr.tzSaveUser();">保存</button>
	        					<button id ="myBtnClose" class ="btn btn-default" type="button" data-dismiss = "modal">退出</button>
	        					
	        				</div>
	        			</div>
	        		</div>
	        	</div>
	        	</form>
				<!--用于修改新增页面 end  -->	
			 	
 			 	<div class ="tab-pane" id ="password">
			 		修改密码代码			 		 
			 	</div>			 	 
			 </div>
			 
  		</div>
  		
		 
<script type="text/javascript">
	//顶一个js对象
	var userMgr = {
		currPage : 1, //当前页
		pageSize : 2, //每页记录数
		totalRows :-1, //总的记录数
		totalPage :null, //总页数
		
		//对应的按钮写对应的方法响应
		gotoFirst : function(){
 			if(userMgr.currPage==1){
				alert("已经是第一页了");
				return;
			}
 			userMgr.currPage =1;
		 	userMgr.tzQueryUser(); 
 			},
		gotoBefore : function(){
			userMgr.currPage--;
			if(userMgr.currPage<1){
				alert("已经第一页了");
				return;
			} 
			userMgr.tzQueryUser();
 			
 		},
		gotoNext : function(){
			userMgr.currPage++;
 			if(userMgr.currPage>userMgr.totalPage){
				alert("已经是最后一页了");
				return;
			}
		 
			userMgr.tzQueryUser();
 			 
		},
		gotoLast : function(){
			if(userMgr.currPage==userMgr.totalPage){
				alert("已经是最后一页了");
				return;
			}				
			userMgr.currPage = userMgr.totalPage;
		 	userMgr.tzQueryUser();
 			 
		},
		
		//查询用户方法
		tzQueryUser :function(){
			var userNameQuery = $("#userNameQuery").val();		 
	 		$.ajax({
				type:'post',//请求方式
				url:'<%=path%>/pages/user/userAction?method=queryUserList', 
				dataType:'json', //有几种格式 xml html json text 等常用
				//data传值的另外一种方式 form的序列化
				data:{"userNameQuery":userNameQuery,"pageNo":userMgr.currPage,
				      "pageSize" :userMgr.pageSize,"totalRows" :userMgr.totalRows
				      },//传递给服务器的参数
				beforeSend:function(){				
					 
				},
				success:function(data){//与服务器交互成功调用的回调函数
					//data就是out.print输出的内容
					if(data=='error'){
						alert("查询用户记录失败");
					}else{					
						var htmlTable = "";
			 			 
		 				//页数：currPage = 1  每页记录条数：pageSize = 2
						//通过页数和每页记录条数，计算显示返回数据数组的那几条记录 
						userMgr.totalPage = data.totalRows;//json对象里面的总记录数
		 				var userList = data.dataList;//json对象里面详细记录信息
						var dataNo = (userMgr.currPage-1)*userMgr.pageSize+1;
						for(var i = 0;i<userList.length;i++){
							htmlTable = htmlTable+"<tr>";
							htmlTable = htmlTable+"<td>";
							htmlTable = htmlTable+(i+dataNo);
							htmlTable = htmlTable+"</td>";
							htmlTable = htmlTable+"<td>";
							htmlTable = htmlTable+userList[i].userName;
							htmlTable = htmlTable+"</td>";	
							htmlTable = htmlTable+"<td>";
							htmlTable = htmlTable+userList[i].deptName;
							htmlTable = htmlTable+"</td>";	
							htmlTable = htmlTable+"<td>";
							htmlTable = htmlTable+userList[i].roleName;
							htmlTable = htmlTable+"</td>";	
							htmlTable = htmlTable+"<td>";
							htmlTable = htmlTable+userList[i].remark;
							htmlTable = htmlTable+"</td>";	
							htmlTable = htmlTable+"<td>";
							htmlTable = htmlTable+getFormatDateByLong(userList[i].tvUpdate.time,null);
							htmlTable = htmlTable+"</td>";	
							htmlTable = htmlTable+"<td>";
							
				    		var editButton = "<button type='button' class='btn btn-default' id = 'editBtn' onclick='userMgr.tzEditUser(2,"+userList[i].userId+");'>修改</button>";
							var delButton = "<button type='button' class='btn btn-default ' id = 'delBtn' onclick='userMgr.tzDelUser("+userList[i].userId+");'>删除</button>";
							htmlTable = htmlTable+editButton+delButton;
							htmlTable = htmlTable+"</td>";	
							
							htmlTable = htmlTable+"</tr>";
					} 
					$('#userListTable').find('tbody').html(htmlTable);					
					}
				},
				complete:function(data){//当请求完成以后,可以执行其他的动作	 
				}
			});
		},
		
		tzFillUserListTable : function(data){
			
		},
		
		//编辑用户方法
		tzEditUser :function (editFlag,userId){
		  //如果是新增用户信息，弹开新增页面，给editFlag赋值 ，清空所有form元素的值
		  //如果是进入修改页面，掉用修改js方法
		  if(editFlag==1){
			  $("#editModal").modal("toggle");
			  $("#editForm")[0].reset();
			  $("#editFlag").val(1);
			  userMgr.getDeptList();
			  userMgr.getRoleList();
		  }else{
			  $("#editFlag").val(2);
			  userMgr.updateUser(userId);
		  }
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
						 $("#deptId").empty(); //清空省份SELECT控件
						 $.each(data, function(i, item) {
			                $("<option></option>")
			                    .val(item["deptId"])
			                    .text(item["deptName"])
			                    .appendTo($("#deptId"));
						 });  
						//alert(data);
					}
				});
		},
		//获取角色方法
		getRoleList : function (){
		 $.ajax({
				type:'post',//请求方式
				url:'<%=path%>/pages/role/roleAction?method=queryRoleList', 
				dataType:'json', //有几种格式 xml html json text 等常用
				//data传值的另外一种方式 form的序列化
				data: {"roleName":""},//传递给服务器的参数					
				success:function(data){//与服务器交互成功调用的回调函数
					 $("#roleId").empty(); //清空角色下拉框
					 //填充xialakuang
					 $.each(data, function(i, item) {
		                $("<option></option>").val(item["roleId"]).text(item["roleName"]).appendTo($("#roleId"));
					 });  
					//alert(data);
				}
			});
		},
		
		//删除用户方法
		tzDelUser : function (userId){
			if(confirm("您确定要删除此用户吗?")){
	 		  $.ajax({
					type:'post',//请求方式
					url:'<%=path%>/pages/user/userAction?method=delUser', 
					dataType:'text', //有几种格式 xml html json text 等常用
					//data传值的另外一种方式 form的序列化
					data: {"userId":userId},//传递给服务器的参数
					beforeSend:function(){
							
					},
					success:function(data){//与服务器交互成功调用的回调函数
						//data就是out.print输出的内容
						if(data=='error'){
							//$("#password").val("").focus();//清空密码
							alert("删除用户失败");
							//$("#errormessage").show().html("用户名和密码不正确").fadeOut(3000);
						}else{
							//返回成功后，给出信息提示，并关闭模态对话框，重新查询记录
							alert("删除用户记录成功");
							userMgr.initParams();	
							userMgr.tzQueryUser();
						}
					},
					complete:function(data){//当请求完成以后,可以执行其他的动作	 
					}
				});
			}
		},
		
		//保存用户方法
		tzSaveUser :function (){
			var userName = $("#userName").val();
			//document.getElementById("userName").value; --原生的js方式
			var password = $("#password").val();
			
			var editFlag = $("#editFlag").val();
			var editMsg ="新增用户";
			if(editFlag==2){
				editMsg = "修改用户";
			}
			//document.getElementById("password").value;--原生的js方式
			if(isEmpty(userName)){
				alert("请输入用户名称");
				//$("#username").focus();
				//$("#errormessage").show().html("请输入账号!").fadeOut(3000);
				return;
			};
				
			if(isEmpty(password)){
				alert("请输入用户密码");
				//$("#password").focus();
				//$("#errormessage").show().html("请输入密码!").fadeOut(3000);
				return;
			};
					
			$.ajax({
				type:'post',//请求方式
				url:'<%=path%>/pages/user/userAction?method=saveUser', 
				dataType:'text', //有几种格式 xml html json text 等常用
				//data传值的另外一种方式 form的序列化
				data: $("#editForm").serialize(),//传递给服务器的参数
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
	                    $("#editModal").modal("hide");
	                    userMgr.initParams();        
	                    userMgr.tzQueryUser();
					}
				},
				complete:function(data){//当请求完成以后,可以执行其他的动作	 
				}
			});
			
		},
		
		initParams : function(){
			userMgr.currPage = 1;
			userMgr.totalPage = null ;
			userMgr.userData = null ;
		},
		
		updateUser : function(userId){
			//修改页面流程
			//1:打开弹窗
			//加载部门列表和角色列表 
			//2:去后台根据id查询用户信息，并赋值到页面
			//3：修改后保存
			//4:保存成功关闭弹窗
 			$("#editModal").modal("toggle");
			$.ajax({
				type:'post',//请求方式
				url:'<%=path%>/pages/user/userAction?method=queryUserDetail', 
				dataType:'json', //有几种格式 xml html json text 等常用
				//data传值的另外一种方式 form的序列化
				data: {"userId":userId},//传递给服务器的参数
				 
				success:function(data){//与服务器交互成功调用的回调函数
					if(data=='error'){
						alert("修改用户记录失败");
					}else{				
						alert("data="+JSON.stringify(data));
						$("#userId").val(data.userId);
						$("#userName").val(data.userName);
						$("#deptId").val(data.deptId);
						$("#roleId").val(data.roleId);
						$("#mobile").val(data.mobile);
						$("#htelephone").val(data.htelephone);
						$("#otelephone").val(data.otelephone);
						$("#remark").val(data.remark);	
					}
				} 
			});
		}	
	};	
	
  
</script>	
  		
</body>
</html>

