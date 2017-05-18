<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户操作</title>
<% String basePath = request.getContextPath(); %>
<script type="text/javascript" src="<%=basePath%>/script/jquery-1.11.2.min.js"></script>
<script type="text/javascript">

	function $(id) {
		return document.getElementById(id);
	}
	
	function deleteUser(id) {
		if (confirm("确定删除吗?")) {
			location.href = "<%=basePath%>/deleteUser?id="+id;
		}
	}
	
	function openDiv(id,name,pwd,dept_name) {
		$("uid").value = id;
		$("uname").value = name;
		$("upwd").value = pwd;
		$("deptVal").innerHTML = dept_name;
		$("updateDiv").style.display = "block";
		$("bigDiv").style.display = "block";
		
	}
	
	function updateUser() {
		var index = $("sel").selectedIndex;
		var nameLength = $("uname").value.trim().length;
		var pwdLength = $("upwd").value.trim().length;
		var result = true;
		if (index == 0) {
			alert("请选择部门!");
			result = false;
		} 
		if (nameLength == 0) {
			alert("用户名不能为空");
			result = false;
		}
		if (pwdLength == 0) {
			alert("密码不能为空");
			result = false;
		}
		if (result) {
			location.href = "<%=basePath%>/updateUser?id="+$("uid").value+"&name="+$("uname").value+"&pwd="+$("upwd").value+"&dept_id="+$("dept_id_div").value;
		}
	}
	
	function openAddUser() {
		$("addDiv").style.display = "block";
		$("bigDiv").style.display = "block";
	}
	
	function addUser() {
		var index = $("sel2").selectedIndex;
		var nameLength = $("addName").value.trim().length;
		var pwdLength = $("addPwd").value.trim().length;
		var result = true;
		if (index == 0) {
			alert("请选择部门!");
			result = false;
		} 
		if (nameLength == 0) {
			alert("用户名不能为空");
			result = false;
		}
		if (pwdLength == 0) {
			alert("密码不能为空");
			result = false;
		}
		if (result) {
			location.href = "<%=basePath%>/addUser?name="+$("addName").value+"&pwd="+$("addPwd").value+"&dept_id="+$("add_dept_id_div").value;
		}
	}
	
	function change(id) {
		$("dept_id_div").value = id;
		$("add_dept_id_div").value = id;
	}
	
	function closeDiv() {
		$("updateDiv").style.display = "none";
		$("addDiv").style.display = "none";
		$("bigDiv").style.display = "none";
	}
	
	
</script>
<style type="text/css">
body{
    margin:0 auto;
}
#userTable{
	float: left;
}
td {
	border: 1px solid;
}
#updateDiv{
	border: 1px solid;
	border-radius:5px;
	float:left;
	width:205px;
	height:190px;
	position:absolute;
	left:30%;
	top:20%;
	line-height:30px;
	display:none;
	z-index:10001;
}
#addDiv{
	border: 1px solid;
	border-radius:5px;
	float:left;
	width:200px;
	height:160px;
	position:absolute;
	left:30%;
	top:20%;
	line-height:30px;
	display:none;
	z-index:10001;
}
#bigDiv{
	width: 1400px;
	height: 750px;
	background: white;
	opacity:0.85;
	position:absolute;
  	display:none; 
	z-index:1000;
}
a{
	text-decoration: none;
	color:#c60001;
}
a:HOVER {
	color:red;
	font-weight: 600;
}
</style>
</head>
<body>
	<table id="userTable">
		<tr><th>用户名</th><th>密码</th><th>部门</th><th>操作</th></tr>
		<c:choose>
			<c:when test="${fn:length(allUser)==0}">
				<font color="red">没有任何用户信息</font>
			</c:when>
			<c:otherwise>
				<c:forEach var="users" items="${allUser}">
					<tr>
						<td>${users.name}</td>
						<td>${users.pwd}</td>
						<td>${users.dept.dept_name}</td>
						<td><a href="javascript:openDiv(${users.id},'${users.name}','${users.pwd}','${users.dept.dept_name}')">编辑</a> |
							<a href="javascript:deleteUser(${users.id})">删除</a></td>
					</tr>
				</c:forEach>
					<tr><td colspan="4" align="center"><a href="javascript:openAddUser()">添加用户</a></td></tr>
			</c:otherwise>
		</c:choose>
	</table></div>
	<div id="bigDiv"></div>
	<div id="updateDiv">
		&nbsp;&nbsp;<font size="5">用户修改</font><br/>
		<input type="hidden" id="uid" value="" /> 
		&nbsp;&nbsp;账号:<input type="text" id="uname" /><br/> 
		&nbsp;&nbsp;密码:<input type="text" id="upwd" /><br/> 
		&nbsp;&nbsp;部门:<span id="deptVal"></span><br/>
		&nbsp;&nbsp;移至:<select id="sel">
							<option>请选择部门...</option>
							<c:forEach var="dept" items="${allDept}">
								<option value="${dept.id}" id="dept${dept.id}" onclick="javascript:change(${dept.id})">${dept.dept_name}</option>
							</c:forEach>
						</select><br/>
		<input type="hidden" id="dept_id_div" value="" />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<button onclick="javascript:updateUser()">修改</button>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<button onclick="javascript:closeDiv()">关闭</button>
	</div>
	<div id="addDiv">
		&nbsp;&nbsp;<font size="5">添加用户</font><br/>
		&nbsp;&nbsp;账号:<input type="text" id="addName" placeholder="请输入用户名"/><br/>
		&nbsp;&nbsp;密码:<input type="text" id="addPwd" placeholder="请输入密码"/><br/>
		&nbsp;&nbsp;部门:<select id="sel2">
							<option>请选择部门...</option>
							<c:forEach var="dept" items="${allDept}">
								<option value="${dept.id}" id="dept${dept.id}" onclick="javascript:change(${dept.id})">${dept.dept_name}</option>
							</c:forEach>
						</select><br/> 
		<input type="hidden" id="add_dept_id_div" value="" />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<button onclick="javascript:addUser()">添加</button>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<button onclick="javascript:closeDiv()">关闭</button>
	</div>
	


</body>
</html>