<%@page import="cn.itcast.myforum.domain.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0">
<title>贴吧</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/client/css/noteessay.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/client/css/before.css" type="text/css" />
</head>
<body id="body">
<div id="head">
<div style="float: left; margin-top: 8px; margin-left: 10px; font-size: 18px;">
<a href="${pageContext.request.contextPath}/index.jsp "  style=""><&nbsp;首页</a>&nbsp;|&nbsp;博文
</div>
</div>
<div id="noteeassy_bodydiv"  >

<div style="font-size: 20px;text-align: left;">
${note.title}
</div>
<br>
<div style="font-size: 10px; text-align: center; color:#0066FF;">
作者：${note.name}
</div>
<br>
<div >
${note.essay}
</div>
<br><br>
<div>
<form action="${pageContext.request.contextPath }/addcommentServlet?note_id=${note.note_id}&user_id=${note.user_id}" method="post">
<table>
<tr>
<td><textarea name="comment" cols="30" rows="3" maxlength="1000" align="center"  placeholder="请输入评论内容！" id="essay"></textarea></td>
<td>&nbsp;<input type="submit" name="submitbutton" value="发表评论" id="eassy_submit"></td>
<td>&nbsp;${msg }</td>
</tr></table>
</form>
</div>
<br>
<div style="padding-left: 20px; padding-right: 20px;">
评论:<br>
<c:forEach items="${comments}" var="cm" varStatus="vs">
<font style="font-size: 14px; color: #DAA520;">${cm.from_name}
<c:if test="${cm.to_name!=note.name}">
回复${cm.to_name }
</c:if> 
:<font color="#000000">${cm.content }</font></font>
<br>
<%
User user=(User)request.getSession().getAttribute("user");
%>
<c:if test="${ cm.from_name==user.name}">
<a href="${pageContext.request.contextPath }/deletecommentServlet?comment_id=${cm.comment_id}&note_id=${note.note_id}" style="font-size: 10px; color: #6495ED;margin-left: 65%; text-decoration: none;" onclick = ' return confirm("确认要撤回吗？"); ' ><img src="${pageContext.request.contextPath }/client/image/delete2.jpg" style="width: 16px; height: 16px;"></a><br>
</c:if>
<c:if test="${cm.from_name!=user.name}" >
<a href="${pageContext.request.contextPath }/shouresponseServlet?from_name=${cm.from_name}&content=${cm.content}&essay=${note.essay}&note_id=${note.note_id}&user_id=${note.user_id}&to_id=${cm.from_id}" style="font-size: 10px; color: #6495ED;margin-left: 65%; text-decoration: none;">
<img src="${pageContext.request.contextPath }/client/image/huifu.jpg" style="width: 15px; height: 15px;"></a><br>
</c:if>
<HR width="100%" size="2px;" color="#FFE4E1">
</c:forEach>
</div>
</div>
</body>
</html>