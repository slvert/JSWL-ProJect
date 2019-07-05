<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>文章信息-修改</title>
    <link rel="stylesheet" href="css/add_up.css">
<%
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
%>
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
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
		//获取作者
		var v3=document.getElementById("au").value;
		if (v3=="") {
			alert("作者不能为空...")
			//不允许提交空表单 所有return false
			return false;
		}
		//获取添加日期
		var v4=document.getElementById("cr").value;
		if (v4=="") {
			alert("添加日期不能为空...")
			//不允许提交空表单 所有return false
			return false;
		}
		//都不为空 返回true
		return true;
	};
	/* 判断作者 */
	function chkauthor() {
		//获取作者
		var author=document.getElementById("au").value;
		//创建正则表达式 只能输入2-10个字符
		var rex=/^[\u4e00-\u9fa5A-Za-z0-9]{2,10}$/;
		//使用正则验证
		var flag=rex.test(author);
		if (flag==true) {
			//说明符合正则表达式
			var sp=document.getElementById("sp2");
			sp.innerHTML="√";
			sp.style.color="green";
		}else {
			var sp=document.getElementById("sp2");
			sp.innerHTML="请输入2-10个字符";
			sp.style.color="red";
			document.getElementById("au").value="";
			
		}
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
			var sp=document.getElementById("sp3");
			sp.innerHTML="√";
			sp.style.color="green";
		}else {
			var sp=document.getElementById("sp3");
			sp.innerHTML="请输入2-200个字符";
			sp.style.color="red";
			document.getElementById("co").value="";
			
		}
	};
</script>
</head>
<body>
<div class="header">
    <div class="img"></div>
    <div class="con">当前位置：文章管理-修改</div>
    <div class="bt_return">
        <input class="return" type="button" value="返回列表" onclick="window.location.href='articlequery.do'">
    </div>
</div>
<div class="main">
    <form action="articleupdate.do?aid=${ab.id }" method="post" onsubmit="return chksubmit()">
        <table width="100%" border="0" cellspacing="1" class="tab">
            <tr>
                <td class="t1">
                    <span class="start">*</span>标题:
                </td>
                <td class="t2">
                    <input type="text" value="${ab.title }" name="title" id="ti" onblur="chktitle()"/>
                    <span id="sp1"></span>
                </td>
            </tr>
            <tr>
                <td class="t1">
                    <span class="start">*</span>内容:
                </td>
                <td class="t2">
                    <input type="text" value="${ab.content }" name="content" id="co" onblur="chkcontent()"/>
                    <span id="sp3"></span>
                </td>
            </tr>
            <tr>
                <td class="t1">
                    <span class="start">*</span>作者:
                </td>
                <td class="t2">
                    <input type="text" value="${ab.author }" name="author" id="au" onblur="chkauthor()"/>
                    <span id="sp2"></span>
                </td>
            </tr>
            <tr>
                <td class="t1">
                    <span class="start">*</span>添加日期:
                </td>
                <td class="t2">
                    <input type="text" value="<%=sdf.format(new Date())%>" id="cr" name="crtime"/>
                </td>
            </tr>
            <tr>
                <td class="t1">所属栏目:</td>
                <td class="t2">
                    <select name="channel">
                    <!-- forEach循环遍历所有部门 -->
                    <c:forEach items="${columns }" var="c">
                    	<!-- 将要修改的部门显示第一位 -->
                    	<c:if test="${ab.channel==c.id }">
                        	<option value="${c.id }" selected="selected">${c.columnname }</option>
                        </c:if>
                        <!-- 将剩余部门显示出来 -->
                        <c:if test="${ab.channel!=d.id }">
                       		<option value="${c.id }">${c.columnname }</option>
                         </c:if>
                    </c:forEach>    
                    </select>
                </td>
            </tr>
            <tr>
                <td class="t1">是否推荐:</td>
                <td class="t2">
                <c:if test="${ab.isremod==1 }">
                    <input  type="radio" name="isremod" value="1" checked="checked"/>是
                    <input  type="radio" name="isremod" value="0"/>	否
                </c:if>
                <c:if test="${ab.isremod==0 }">
                    <input  type="radio" name="isremod" value="1" />是
                    <input  type="radio" name="isremod" value="0" checked="checked"/>否
                </c:if>
                </td>
            </tr>
            <tr>
                <td class="t1">是否热点:</td>
                    <td class="t2">
                    <c:if test="${ab.ishot==1 }">
                        <input  type="radio" name="ishot" value="1" checked="checked"/>是
                        <input  type="radio" name="ishot" value="0"/>	否
                    </c:if>
                    <c:if test="${ab.ishot==0 }">
                        <input  type="radio" name="ishot" value="1" />是
                        <input  type="radio" name="ishot" value="0" checked="checked"/>否
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