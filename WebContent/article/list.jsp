<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>文章管理-列表</title>
    <link rel="stylesheet" href="../css/list.css" type="text/css">
    
</head>
<body>
    <div class="header">
        <div class="img"></div>
        <div class="con">当前位置：文章管理-列表</div>
        <div class="bt_add">
            <input class="add" type="button" value="添加" onclick="javascript:window.location.href='../channel.do'">
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
                    <th width="4%">
                        <input type="checkbox"/>
                    </th>
                    <th width="8%">文章编号</th>
                    <th width="8%">标题</th>
                    <th width="20%">内容</th>
                    <th width="4%">作者</th>
                    <th width="8%">添加日期</th>
                    <th width="8%">所属栏目</th>
					<!-- <th width="12%">邮箱</th> -->
					<th width="8%">是否推荐</th>
					<th width="8%">是否热点</th>
                    <th width="8%">操作选项</th>
                </tr>
                <c:forEach items="${articles }" var="a">
                <tr bgcolor="#ffffff" onmouseover="this.bgColor='#eeeeee'" onmouseout="this.bgColor='#ffffff'">
                    <td align="center">
                        <input type="checkbox" name="" value=""/></td>
                    <td align="center">${a.id }</td>
                    <td align="center">${a.title }</td>
                    <td align="center">${a.content }</td>
                    <td align="center">${a.author }</td>
                    <td align="center">${a.crtime }</td>
                    <td align="center">${a.channelstring }</td>
					 <td align="center">${a.isremodString }</td>
                    <td align="center">${a.ishotString }</td>
                    <%-- <td align="center">${u.cretmanrealname }</td> --%>
                    <td align="center">
                        <a href="../getarticlebyid.do?aid=${a.id }" class="pn-opt">修改</a> |
                        <a href="../areticledelete.do?aid=${a.id }" onclick="if(!confirm('您确定删除吗？')) {return false;}" class="pn-opt">删除</a>
                    </td>
                </tr>
               </c:forEach>
            </table>
        </div>
        <div style="height: 20px;"></div>
        <div style="float: right;">
        	<a href="../articlequery.do">首页</a>
        	<c:if test="${page>1 }">
        	<a href="../articlequery.do?page=${page-1 }">上一页</a>
        	</c:if>
        	<c:if test="${page<pagecount }">
        	<a href="../articlequery.do?page=${page+1 }">下一页</a>
        	</c:if>
        	<a href="../articlequery.do?page=${pagecount }">尾页</a>
        </div>
    </div>
</body>
</html>