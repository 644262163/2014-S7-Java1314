<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Home</title>
	<style>
		body{
			margin:0;
		}
		.head{
			width:100%;
			height:50px;
			background-color:#28FF28;
		}
		.logo{
			color:red;
			font-size:25px;
			font-style:Italic;
			font-weight:bold;
			line-height:50px;
			margin:0 15px 0 20px;
		}
		
		.head input{
			height:25px;
			
		}
		.userInfo{
			float:right;
			line-height:50px;
			font-size:20px;
			margin-right:30px;
		}
		#shadowDiv{
			position:absolute;
			width:100%;
			height:100%;
			top:0;
			left:0;
			background-color:#4D0000;
			opacity:0.3;
			display:none;
			z-index:2;
		}
		#login{
			position:absolute;
			width:400px;
			height:200px;
			top:50%;
			left:50%;
			margin:-100px 0 0 -200px;
			background-color:white;
			display:none;
			z-index:3;
			border-radius:8px;
			box-shadow:10px 10px 5px #000093;
			padding:5px;
		}
		.cancelSpan{
			float:right;
			width:10px;
			height:10px;
			border-radius:5px;
			
		}
		.cancelSpan:hover{
			cursor:pointer;
		}
		.loginInput{
			display:block;
			margin-top:25px;
			font-size:20px;
		}
		.loginInput label{
			width:30%;
			display:inline-block;
		}
		.loginInput input{
			border:none;
			outline:none;
			border-bottom:1px solid red;
			width:65%;
		}
		.submitSpan{
			display:block;
			width:90%;
			height:30px;
			text-align:center;
			background:#2894FF;
			font-size:20px;
			margin:auto;
			margin-top:35px;
			border-radius:5px;
		}
	</style>
	<%
		String username = (String)request.getSession().getAttribute("username");
	%>
</head>
<body>
	<div class="head">
		<span class="logo">Video</span>
		<span>
			<input type="text" name="content" style="width:30%"/>
			<input type="submit" value="查询" />
		</span>
		<span class="userInfo">
			<%if(username == null || "".equals(username)) {%>
				<a href="javascript:login()">登录</a>&nbsp;|&nbsp;<a href="">注册</a>
			<%}else{ %>
				<a href=""><%=username %></a>&nbsp;|&nbsp;<a href="<%=request.getContextPath() %>/logout">登出</a>
			<%} %>
		</span>
	</div>
	
	<div id="shadowDiv">
	</div>
	<form action="<%=request.getContextPath() %>/login" method="post">
		<div id="login">
			<span class="cancelSpan" onclick="cancel()">x</span>
			<span class="loginInput" style="margin-top:40px;">
				<label>用户名：</label>
				<input type="text" name="username" />
			</span>
			<span class="loginInput">
				<label>密码：</label>
				<input type="password" name="pw" />
			</span>
			<span class="submitSpan">
				<a href="javascript:loginSubmit()" style="text-decoration:none">登&nbsp;&nbsp;&nbsp;录</a>
			</span>
		</div>
	</form>
</body>
<script>
function login(){
	document.getElementById("shadowDiv").style.display = "block";
	document.getElementById("login").style.display = "block";
}
function cancel(){
	document.getElementById("shadowDiv").style.display = "none";
	document.getElementById("login").style.display = "none";
	
}
function loginSubmit(){
	//valid
	
	//form submit
	document.forms[0].submit();
}
</script>



</html>