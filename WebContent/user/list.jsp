<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>用户信息-列表</title>
    <link rel="stylesheet" href="../css/list.css" type="text/css">
    <script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
    
    /* 批量删除 */
   /*  function usersdelete() {
	  	 //获取主选框条件
		  var che=document.getElementById("checkbox1").checked;
		 //获取多选框的name
		   var items=document.getElementsByName('usersid');
		 //遍历checkbox
		 for(var i=0;i<items.length;i++){
		     //当前checkbox实现勾选
		     items[i].checked=che;
		} 
		 if (che==true) {
		//提示是否要删除选中的用户
    	var flag=confirm("是否要删除选中的用户")
			if (flag==true) {
				alert("1")
				
	 			
			}
		}
	}; */ 
	//jquery就绪事件
	$(function() {
		/* $().click(function() {
			//使用ajax请求数据
			$.ajax({
				type:"post",								//提交方式
				url:"getdata.do",								//提交路径
				data:"loginname=aaaddd&password=abc123",	//提交的数据内容
				dataType:"text",							//服务器返回到ajax的数据类型 text文本数据类型
				async:true,									//是否异步，true异步	，false同步
				//成功 执行回调函数方法，回调函数中的参数msg为服务器响应回来的数据
				success:function(msg){
					//把服务器响应回的信息 通过text方式传给页面
					$("#sp").text(msg);
				},
				//服务器响应失败执行的函数方法
				error:function(){
					alert("响应失败！");
				}
			});
		}); */
		//获取多选框中的value值
		/*   var checked = [];
		$('input:checkbox[name='usersid']:checked').each(function() {
            checked.push($(this).val());
        });*/
		
		 
			alert("2");
	});
	</script>
</head>
<body>
    <div class="header">
        <div class="img"></div>
        <div class="con">当前位置：用户管理-列表</div>
        <div class="bt_add">
            <input class="add" type="button" value="添加" onclick="javascript:window.location.href='../dept.do'">
        </div>
    </div>
    <div class="main">
        <div>
            <form action="">
                名称：<input type="text">
                <select name="" id="">
                    <option value="">可用</option>
                    <option value="">不可用</option>
                </select>
                <input class="sub" type="submit" value="查询">
            </form>
        </div>
        <div style="margin-top: 20px">
            <table width="100%" border="0" cellspacing="1" class="tab">
                <tr>
                    <th width="4%" class="ch">
                        <input type="checkbox" id='checkbox1' onclick="usersdelete()"/>
                    </th>
                    <th width="8%">用户编号</th>
                    <th width="8%">用户名</th>
                    <th width="8%">真实姓名</th>
                    <th width="4%">性别</th>
                    <th width="8%">出生日期</th>
                    <th width="8%">部门</th>
					<th width="12%">邮箱</th>
					<th width="8%">是否可用</th>
					<th width="8%">创建者</th>
                    <th width="8%">操作选项</th>
                </tr>
                <c:forEach items="${users }" var="u">
                <tr bgcolor="#ffffff" onmouseover="this.bgColor='#eeeeee'" onmouseout="this.bgColor='#ffffff'">
                    <td align="center">
                        <input type="checkbox" name='usersid' value="${u.id }" id="checkboxs"/></td>
                    <td align="center">${u.id }</td>
                    <td align="center">${u.loginname }</td>
                    <td align="center">${u.realname }</td>
                    <td align="center">${u.sex }</td>
                    <td align="center">${u.birthday }</td>
                    <td align="center">${u.dname }</td>
					 <td align="center">${u.email }</td>
                    <td align="center">${u.enabledtext }</td>
                    <td align="center">${u.cretmanrealname }</td>
                    <td align="center">
                        <a href="../getuserbyid.do?id=${u.id }" class="pn-opt">修改</a> |
                        <a href="../userdelete.do?id=${u.id }" onclick="if(!confirm('您确定删除吗？')) {return false;}" class="pn-opt">删除</a>
                    </td>
                </tr>
               </c:forEach>
            </table>
        </div>
        <div style="height: 20px;"></div>
        <div style="float: right;">
        	<a href="../userquery.do">首页</a>
        	<c:if test="${page>1 }">
        	<a href="../userquery.do?page=${page-1 }">上一页</a>
        	</c:if>
        	<c:if test="${page<pagecount }">
        	<a href="../userquery.do?page=${page+1 }">下一页</a>
        	</c:if>
        	<a href="../userquery.do?page=${pagecount }">尾页</a>
        </div>
    </div>
</body>
</html>