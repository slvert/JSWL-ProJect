<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>快报信息-修改</title>
    <link rel="stylesheet" href="css/add_up.css">
    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
	<!-- 引入时间插件 -->
	<script type="text/javascript" src="js/DatePicker/WdatePicker.js"></script>
	<script type="text/javascript">
function chksubmit() {
	//获取标题
	var v1=document.getElementById("ti").value;
	if (v1=="") {
		alert("标题不能为空...")
		//不允许提交空表单 所有return false
		return false;
	}
	//获取内容
	var v2=document.getElementById("co").value;
	if (v2=="") {
		alert("内容不能为空...")
		//不允许提交空表单 所有return false
		return false;
	}
	//获取公告时间
	var v4=document.getElementById("bir").value;
	if (v4=="") {
		alert("公告时间不能为空...")
		//不允许提交空表单 所有return false
		return false;
	}
	//获取公告人
	var v3=document.getElementById("cman").value;
	if (v3=="") {
		alert("公告人不能为空...")
		//不允许提交空表单 所有return false
		return false;
	}
	
	//都不为空 返回true
	return true;
};
/* 判断标题 */
function chktitle() {
	//获取标题
	var title=document.getElementById("ti").value;
	//创建正则表达式 只能输入2-10个字符
	var rex=/^[\u4e00-\u9fa5A-Za-z0-9]{2,10}$/;
	//使用正则验证
	var flag=rex.test(title);
	if (flag==true) {
		//说明符合正则表达式
		var sp=document.getElementById("sp1");
		sp.innerHTML="√";
		sp.style.color="green";
	}else {
		var sp=document.getElementById("sp1");
		sp.innerHTML="请输入2-10个字符";
		sp.style.color="red";
		document.getElementById("ti").value="";
		
	}
};
/* 判断内容 */
function chkcontent() {
	//获取内容
	var content=document.getElementById("co").value;
	//创建正则表达式 只能输入2-200个字符
	var rex=/^[\u4e00-\u9fa5A-Za-z0-9]{2,200}$/;
	//使用正则验证
	var flag=rex.test(content);
	if (flag==true) {
		//说明符合正则表达式
		var sp=document.getElementById("sp2");
		sp.innerHTML="√";
		sp.style.color="green";
	}else {
		var sp=document.getElementById("sp2");
		sp.innerHTML="请输入2-200个字符";
		sp.style.color="red";
		document.getElementById("co").value="";
		
	}
};
/* 判断公告人 */
function chkcman() {
	//获取公告人
	var cman=document.getElementById("cman").value;
	//创建正则表达式 只能输入2-10个字符
	var rex=/^[\u4e00-\u9fa5A-Za-z0-9]{2,10}$/;
	//使用正则验证
	var flag=rex.test(cman);
	if (flag==true) {
		//说明符合正则表达式
		var sp=document.getElementById("sp3");
		sp.innerHTML="√";
		sp.style.color="green";
	}else {
		var sp=document.getElementById("sp3");
		sp.innerHTML="请输入2-10个字符";
		sp.style.color="red";
		document.getElementById("cman").value="";
		
	}
};
</script>
</head>
<body>
<div class="header">
    <div class="img"></div>
    <div class="con">当前位置：快报管理-修改</div>
    <div class="bt_return">
        <input class="return" type="button" value="返回列表" onclick="window.location.href='fastreportquery.do'">
    </div>
</div>
<div class="main">
    <form action="fastreporeupdate.do?fid=${fb.id }" method="post" onsubmit="return chksubmit()">
        <table width="100%" border="0" cellspacing="1" class="tab">
            <tr>
                <td class="t1">
                    <span class="start">*</span>标题:
                </td>
                <td class="t2">
                    <input type="text" value="${fb.title }" name="title" id="ti" onblur="chktitle()"/>
                    <span id="sp1"></span>
                </td>
            </tr>
            <tr>
                <td class="t1">
                    <span class="start">*</span>内容:
                </td>
                <td class="t2">
                    <input type="text" value="${fb.content }" name="content" id="co" onblur="chkcontent()"/>
                    <span id="sp2"></span>
                </td>
            </tr>
            <tr>
                <td class="t1">
                    <span class="start">*</span>公告日期:
                </td>
                <td class="t2">
                    <input type="text" value="${fb.ctime }" name="ctime"
                    readonly="readonly" onclick="WdatePicker()" id="bir"
                    />
                </td>
            </tr>
            <tr>
                <td class="t1">
                    <span class="start">*</span>公告人:
                </td>
                <td class="t2">
                    <input type="text" value="${fb.cman }" name="cman" id="cman" onblur="chkcman()"/>
                    <span id="sp3"></span>
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