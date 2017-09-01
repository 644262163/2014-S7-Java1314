<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd 

">
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
	</style>
</head>
<body>
	<div class="head">
		<span class="logo">Video</span>
		<span>
			<input type="text" name="content" style="width:30%"/>
			<input type="submit" value="查询" />
		</span>
		<span class="userInfo">
			<a href="javascript:login()">登录</a>&nbsp;|&nbsp;<a href="">注册</a>
		</span>
	</div>
	
	<div id="shadowDiv">
	</div>
	<div id="login">
		<span class="cancelSpan" onclick="cancel()">x</span>
	</div>
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
</script>



</html>
