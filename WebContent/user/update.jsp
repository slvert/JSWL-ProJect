<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>用户信息-修改</title>
    <link rel="stylesheet" href="css/add_up.css">
    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
	<!-- 引入时间插件 -->
	<script type="text/javascript" src="js/DatePicker/WdatePicker.js"></script>
	<script type="text/javascript">
	function chksubmit() {
		//获取用户名
		var v1=document.getElementById("ln").value;
		if (v1=="") {
			alert("用户名不能为空...")
			//不允许提交空表单 所有return false
			return false;
		}
		//获取密码
		var v2=document.getElementById("pw1").value;
		if (v2=="") {
			alert("密码不能为空...")
			//不允许提交空表单 所有return false
			return false;
		}
		var v3=document.getElementById("pw2").value;
		if (v3=="") {
			alert("密码不能为空...")
			//不允许提交空表单 所有return false
			return false;
		}
		//获取真实姓名
		var v4=document.getElementById("real").value;
		if (v4=="") {
			alert("真实姓名不能为空...")
			//不允许提交空表单 所有return false
			return false;
		}
		//获取出生日期
		var v5=document.getElementById("bir").value;
		if (v5=="") {
			alert("出生日期不能为空...")
			//不允许提交空表单 所有return false
			return false;
		}
		//获取邮箱
		var v6=document.getElementById("em").value;
		if (v6=="") {
			alert("邮箱不能为空...")
			//不允许提交空表单 所有return false
			return false;
		}
		//都不为空 返回true
		return true;
	};
	/* 判断密码 */
	function chkpw() {
		//获取密码
		var pw1=document.getElementById("pw1").value;
		//密码强度正则，最少6位，包括至少1个大写字母，1个小写字母，1个数字，1个特殊字符
		var password=/^.*(?=.{6,})(?=.*\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*? ]).*$/;
		//使用正则验证
		var flag=password.test(pw1);
		if (flag==true) {
			//说明符合正则表达式
			var sp=document.getElementById("sp0");
			sp.innerHTML="√";
			sp.style.color="green";
		}else {
			var sp=document.getElementById("sp0");
			sp.innerHTML="最少6位，包括至少1个大写字母，1个小写字母，1个数字，1个特殊字符";
			sp.style.color="red";
			document.getElementById("pw1").value="";
			
		}
	};
	/* 判断两次密码是否一致 */
	function chkpwd() {
		//获取两次密码
		var pw1=document.getElementById("pw1").value;
		var pw2=document.getElementById("pw2").value;
		
		if (pw1==pw2) {
			var sp=document.getElementById("sp1");
			sp.innerHTML="√";
			sp.style.color="green";
		}else{
			var sp=document.getElementById("sp1");
			sp.innerHTML="两次密码输入不一致，请重新输入";
			sp.style.color="red";
			/* 当两次密码输入不一致时，让两次密码框为空 */
			document.getElementById("pw1").value="";
			document.getElementById("pw2").value="";
		};
	};
	
	/* 判断真实姓名 */
	function chkreal() {
		//获取真实姓名
		var real=document.getElementById("real").value;
		//创建正则表达式 只能输入2-30个字符
		var rex=/^[\u4e00-\u9fa5A-Za-z0-9]{2,30}$/;
		//使用正则验证
		var flag=rex.test(real);
		if (flag==true) {
			//说明符合正则表达式
			var sp=document.getElementById("sp2");
			sp.innerHTML="√";
			sp.style.color="green";
		}else {
			var sp=document.getElementById("sp2");
			sp.innerHTML="请输入2-30个字符";
			sp.style.color="red";
			document.getElementById("real").value="";
			
		}
	};
	/* 使用ajax验证用户名和邮箱 */	
	$(function(){
		//根据id定义鼠标失焦事件 验证用户名
		$("#ln").blur(function(){
			//获取输入框中的value值
			var lin=$("#ln").val();
			//使用ajax
			$.ajax({
				type:"post",
				url:"chkloginname.do",
				data:"loginname="+lin,
				dataType:"text",
				async:true,
				success:function(msg){
					if (msg=="YES") {
						//说明可以进行新增
						$("#sp3").text("√");
						$("#sp3").css("color","green");
					}
					if(msg=="NO1"){
						$("#sp3").text("用户已存在，请重新输入用户名");
						$("#sp3").css("color","blue");
						//将用户名清空
						$("#ln").val("");
					}
					if (msg=="NO2") {
						$("#sp3").text("格式不正确，请输入正确的格式");
						$("#sp3").css("color","red");
						//将用户名清空
						$("#ln").val("");
					}
				},
				error:function(){
					//响应失败
					alert("响应失败，请联系管理员");
				}
			});
			
		});
		/* 验证邮箱 */
		//根据id定义鼠标失焦事件 
		$("#em").blur(function(){
			//获取输入框中的value值
			var em=$("#em").val();
			//使用ajax
			$.ajax({
				type:"post",
				url:"chkemail.do",
				data:"email="+em,
				dataType:"text",
				async:true,
				success:function(msg){
					if (msg=="YES") {
						//说明可以进行新增
						$("#sp4").text("√");
						$("#sp4").css("color","green");
					}
					if(msg=="NO1"){
						$("#sp4").text("此邮箱存在，请重新输入邮箱");
						$("#sp4").css("color","blue");
						//将用户名清空
						$("#em").val("");
					}
					if (msg=="NO2") {
						$("#sp4").text("格式不正确，请输入正确的格式");
						$("#sp4").css("color","red");
						//将用户名清空
						$("#em").val("");
					}
				},
				error:function(){
					//响应失败
					alert("响应失败，请联系管理员");
				}
			});
			
		});
	});
	</script>
</head>
<body>
<div class="header">
    <div class="img"></div>
    <div class="con">当前位置：用户管理-修改</div>
    <div class="bt_return">
        <input class="return" type="button" value="返回列表" onclick="window.location.href='userquery.do'">
    </div>
</div>
<div class="main">
    <form action="updateuser.do?id=${ub.id }" method="post" onsubmit="return chksubmit()">
        <table width="100%" border="0" cellspacing="1" class="tab">
            <tr>
                <td class="t1">
                    <span class="start">*</span>用户名:
                </td>
                <td class="t2">
                    <input type="text" value="${ub.loginname }" name="loginname" id="ln"/>
                    <span id="sp3"></span>
                </td>
            </tr>
            <tr>
                <td class="t1">
                    <span class="start">*</span>密码:
                </td>
                <td class="t2">
                    <input type="password" value="${ub.password }" name="pwd1" id="pw1" onblur="chkpw()"/>
                    <span id="sp0"></span>
                </td>
            </tr>
            <tr>
                <td class="t1">
                    <span class="start">*</span>确认密码:
                </td>
                <td class="t2">
                    <input type="password" value="${ub.password }" name="pwd2" id="pw2" onblur="chkpwd()"/>
                    <span id="sp1"></span>
                </td>
            </tr>
            <tr>
                <td class="t1">
                    <span class="start">*</span>真实姓名:
                </td>
                <td class="t2">
                    <input type="text" value="${ub.realname }" name="realname" id="real" onblur="chkreal()"/>
                    <span id="sp2"></span>
                </td>
            </tr>
            <tr>
                <td class="t1">性别:</td>
                <td class="t2">
                <c:if test="${ub.sex=='男' }">
                    <input  type="radio" name="sex" value="男" checked="checked"/>男
                    <input  type="radio" name="sex" value="女"/>	女
                </c:if>
                <c:if test="${ub.sex=='女' }">
                    <input  type="radio" name="sex" value="男" />男
                    <input  type="radio" name="sex" value="女" checked="checked"/>女
                </c:if>
                </td>
            </tr>
            <tr>
                <td class="t1">
                    <span class="start">*</span>出生日期:
                </td>
                <td class="t2">
                    <input type="text" value="${ub.birthday }" name="birthday"
                    readonly="readonly" onclick="WdatePicker()" id="bir"
                    />
                </td>
            </tr>
            <tr>
                <td class="t1">部门:</td>
                <td class="t2">
                    <select name="dep">
                    <!-- forEach循环遍历所有部门 -->
                    <c:forEach items="${depts }" var="d">
                    	<!-- 将要修改的部门显示第一位 -->
                    	<c:if test="${ub.dep==d.id }">
                        	<option value="${d.id }" selected="selected">${d.dname }</option>
                        </c:if>
                        <!-- 将剩余部门显示出来 -->
                        <c:if test="${ub.dep!=d.id }">
                       		<option value="${d.id }">${d.dname }</option>
                         </c:if>
                    </c:forEach>    
                    </select>
                </td>
            </tr>
            <tr>
                <td class="t1">
                    <span class="start">*</span>邮箱:
                </td>
                <td class="t2">
                    <input type="text" value="${ub.email }" name="email" id="em"/>
                    <span id="sp4"></span>
                </td>
            </tr>
            <tr>
                <td class="t1">是否可用:</td>
                    <td class="t2">
                    <c:if test="${ub.enabled==1 }">
                        <input  type="radio" name="enabled" value="1" checked="checked"/>是
                        <input  type="radio" name="enabled" value="0"/>	否
                    </c:if>
                    <c:if test="${ub.enabled==0 }">
                        <input  type="radio" name="enabled" value="1" />是
                        <input  type="radio" name="enabled" value="0" checked="checked"/>否
                    </c:if>
                    </td>
                </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" class="submit" value="提交"/>&nbsp;&nbsp;
                    <input type="reset" class="reset" value="重置"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>