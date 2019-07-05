<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>栏目管理-列表</title>
    <link rel="stylesheet" href="../css/list.css" type="text/css">
    
</head>
<body>
    <div class="header">
        <div class="img"></div>
        <div class="con">当前位置：栏目管理-列表</div>
        <div class="bt_add">
            <input class="add" type="button" value="添加" onclick="javascript:window.location.href='../upchannelquery.do'">
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
                    <th width="8%">栏目</th>
                    <th width="20%">上级栏目</th>
                    <th width="4%">级别</th>
                    <th width="8%">是否叶子</th>
                    <th width="8%">顺序</th>
					<!-- <th width="12%">邮箱</th> -->
					<!-- <th width="8%">是否推荐</th> -->
					<!-- <th width="8%">是否热点</th> -->
                    <th width="8%">操作选项</th>
                </tr>
                <c:forEach items="${columns }" var="c" >
              <tr bgcolor="#ffffff" onmouseover="this.bgColor='#eeeeee'" onmouseout="this.bgColor='#ffffff'">
                    <td align="center">
                        <input type="checkbox" name="" value=""/></td>
                    <td align="center">${c.id }</td>
                    <td align="center">${c.columnname }</td>
                    <td align="center">${c.upchannelstring }</td>
                   <td align="center">${c.rank }</td>
                    <td align="center">${c.isleafstring }</td>
                    <td align="center">${c.corder }</td>
					<td align="center">
                        <a href="../getcolumnbyid.do?cid=${c.id }" class="pn-opt">修改</a> |
                        <a href="../columndelete.do?cid=${c.id }" onclick="if(!confirm('您确定删除吗？')) {return false;}" class="pn-opt">删除</a>
                    </td>
                </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</body>
</html>