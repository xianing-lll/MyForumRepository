<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查询商品列表</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/item/queryItem.action" method="post">
查询条件:
<table style="width: 100%; ;" border=1px>
<tr>
<td> <input type="submit" value="查询">
</td>
</tr>
</table>
商品列表
<table style="width: 100%;"  border=1px;>
<tr>
<td>商品名称</td>
<td>商品价格</td>
<td>生产日期</td>
<td>商品描述</td>
<td>操作</td>
</tr>
<c:forEach items="${itemsList}" var="n" varStatus="item">
<tr>
<td>${ item.name}</td>
<td>${item.price }</td>
<td>00:00:00</td>
<td>${item.detail }</td>
<td><a href="${pageContext.request.contextPath }/items/editItem.action?id=${item.id}">修改</a></td>
</tr>
</c:forEach>
</table>
</form>
</body>
</html>