<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户登录</title>
<link rel="stylesheet" type="text/css" href="css/login.css">
<script type="text/javascript">
	function change() {
		document.getElementById("img").src="kap?t="+Math.round(Math.random()*1000);
	}
</script>
</head>
<body>
<div class="all">
       <!--头部-->
       <div class="header"></div>
       <!--主体-->
       <div class="main">
           <div class="m_left">
               <div class="logo">
                   <img src="image/logo.png" alt="">
               </div>
               <div class="info">
                   <li>1- 地区商家信息网门户站建立的首选方案...</li>
                   <li>2- 一站通式的整合方式，方便用户使用...</li>
                   <li>3- 强大的后台系统，管理内容易如反掌...</li>
                   <li>
                       <img src="image/icon-demo.gif" width="16" height="16">
                       <a href="http://www.865171.cn" target="_blank" class="left_txt3"> 使用说明</a>
                       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                       <img src="image/icon-login-seaver.gif" width="16" height="16">
                       <a href="http://www.865171.cn" class="left_txt3"> 在线客服</a>
                   </li>
               </div>
           </div>
           <div class="m_center"></div>
           <div class="m_right">
               <div class="caption">
                   <span>登陆乐橙云商后台管理系统</span>
               </div>
               <div class="form">
                   <form action="login.do" method="post">
                       <li style="color:red;">${err }</li>
                       <li style="color:red;">${msg }</li>
                       <li> 用户名：<input type="text" name="loginname" value="${cookie.loginname.value}"></li>
                       <li> 密&nbsp;码：<input type="password" name="password" value="${cookie.password.value}"></li>
                       <li>验证码：<input type="text" name="yzm">	<img src="kap" onclick="change()" id="img"></li>
                       <li> <input type="checkbox" name="rem" value="1"> 记住密码</li>
                       <li>
                           <input type="submit" value="登陆" class="bt">
                           <input type="reset" value="取消" class="bt">
                       </li>
                   </form>
               </div>
               <!-- <div class="bg">
                   <img src="image/login-wel.gif" width="320px" height="160px" >
               </div> -->
           </div>
       </div>
       <!--底部-->
       <div class="footer">
           <span>Copyright &copy; 2016 www.tjzs.com</span>
       </div>
   </div>
</body>
</html>