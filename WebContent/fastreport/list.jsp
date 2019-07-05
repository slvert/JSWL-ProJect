<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>快报列表-列表</title>
    <link rel="stylesheet" href="../css/list.css" type="text/css">
    
</head>
<body>
    <div class="header">
        <div class="img"></div>
        <div class="con">当前位置：快报管理-列表</div>
        <div class="bt_add">
            <input class="add" type="button" value="添加" onclick="javascript:window.location.href='../fastreport/add.jsp'">
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
                    <th width="8%">快报编号</th>
                    <th width="8%">标题</th>
                    <th width="20%">内容</th>
                    <th width="8%">公告日期</th>
                    <th width="4%">公告人</th>
                    <!-- <th width="8%">所属栏目</th> -->
					<!-- <th width="12%">邮箱</th> -->
					<!-- <th width="8%">是否推荐</th>
					<th width="8%">是否热点</th> -->
                    <th width="8%">操作选项</th>
                </tr>
                <c:forEach items="${fastreports }" var="f">
                <tr bgcolor="#ffffff" onmouseover="this.bgColor='#eeeeee'" onmouseout="this.bgColor='#ffffff'">
                    <td align="center">
                        <input type="checkbox" name="" value=""/></td>
                    <td align="center">${f.id }</td>
                    <td align="center">${f.title }</td>
                    <td align="center">${f.content }</td>
                    <td align="center">${f.ctime }</td>
                    <td align="center">${f.cman }</td>
                    <%-- <td align="center">${a.dname }</td> --%>
					 <%-- <td align="center">${a.isremodString }</td>
                    <td align="center">${a.ishotString }</td> --%>
                    <%-- <td align="center">${u.cretmanrealname }</td> --%>
                    <td align="center">
                        <a href="../getfastreportbyid.do?fid=${f.id }" class="pn-opt">修改</a> |
                        <a href="../fastreportdelete.do?fid=${f.id }" onclick="if(!confirm('您确定删除吗？')) {return false;}" class="pn-opt">删除</a>
                    </td>
                </tr>
               </c:forEach>
            </table>
        </div>
    </div>
</body>
</html>