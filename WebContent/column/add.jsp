<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>栏目新增</title>
<link rel="stylesheet" href="../css/add_up.css" type="text/css">
	<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
	<script type="text/javascript">
	function chksubmit() {
		//获取栏目名
		var v1=document.getElementById("col").value;
		if (v1=="") {
			alert("栏目名不能为空...")
			//不允许提交空表单 所有return false
			return false;
		}
		//获取顺序
		var v2=document.getElementById("cor").value;
		if (v2=="") {
			alert("顺序不能为空...")
			//不允许提交空表单 所有return false
			return false;
		}
		
		//都不为空 返回true
		return true;
	};
	/* 判断栏目名 */
	function chkcolumnname() {
		//获取栏目名
		var col=document.getElementById("col").value;
		//创建正则表达式 只能输入2-10个字符
		var rex=/^[\u4e00-\u9fa5A-Za-z0-9]{2,10}$/;
		//使用正则验证
		var flag=rex.test(col);
		if (flag==true) {
			//说明符合正则表达式
			var sp=document.getElementById("sp1");
			sp.innerHTML="√";
			sp.style.color="green";
		}else {
			var sp=document.getElementById("sp1");
			sp.innerHTML="请输入2-10个字符";
			sp.style.color="red";
			document.getElementById("col").value="";
			
		}
	};
	/* 判断顺序 */
	function chkcorder() {
		//获取顺序
		var cor=document.getElementById("cor").value;
		//创建正则表达式 只能输入1位数字
		var rex=/^[0-9]{1}$/;
		//使用正则验证
		var flag=rex.test(cor);
		if (flag==true) {
			//说明符合正则表达式
			var sp=document.getElementById("sp2");
			sp.innerHTML="√";
			sp.style.color="green";
		}else {
			var sp=document.getElementById("sp2");
			sp.innerHTML="请输入1位数字";
			sp.style.color="red";
			document.getElementById("cor").value="";
			
		}
	};
	</script>
</head>
<body>
    <div class="header">
        <div class="img"></div>
        <div class="con">当前位置：栏目管理-新增</div>
        <div>
            <form>
            <input class="return" type="button" value="返回列表" onclick="window.location.href='../columnqueryall.do'">
            </form>
        </div>
    </div>
    <div class="main">
        <form action="../columntableadd.do" method="post" onsubmit="return chksubmit()">
            <table width="100%" border="0" cellspacing="1" class="tab">
            <tr>
                    <td class="t1">
                        <span class="start">*</span>栏目名:
                    </td>
                    <td class="t2">
                        <input type="text" name="columnname" id="col" onblur="chkcolumnname()"/>
                        <span id="sp1"></span>
                    </td>
                </tr>
                <tr>
                    <td class="t1">上级栏目:</td>
                    <td class="t2">
                        <select name="upchannel">
                        <option value="0" selected="selected">无</option>
                        <c:forEach items="${columns }" var="co">
                        	<c:if test="${co.upchannel==0 }">
                            <option value="${co.id}" >${co.columnname }</option>
                            </c:if>
                          </c:forEach>  
                        </select>
                    </td>
                </tr>
                <tr>
                    <td class="t1">
                        <span class="start">*</span>顺序:
                    </td>
                    <td class="t2">
                        <input type="text" name="corder" id="cor" onblur="chkcorder()"/>
                        <span id="sp2"></span>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" class="submit" value="提交"/>&nbsp;&nbsp;
                        <input type="reset"  class="reset" value="重置"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>