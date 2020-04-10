<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>更改帖子</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/client/css/register.css" type="text/css" />
</head>
<body id="body">
<div id="index">
<a href="${pageContext.request.contextPath}/index.jsp " >
<img src="${pageContext.request.contextPath}/client/image/index.png" style="width: 55px; height: 55px;margin-top: 0%; border-radius:50%;"></a></div>
<div id="notebodydiv" style="margin-top: -30px;">
<img src="${pageContext.request.contextPath}/client/image/anshiIcon.jpg" style="width: 55px; height: 55px;margin-top: 30px; margin-left: 35%;">
<form action="${pageContext.request.contextPath }/updatenoteServlet?note_id=${note.note_id}" method="post">
<div style="width: 250px; height: 350px;">
<table>
<tr><td style="text-align: center; font-size: 40px;">编辑我的帖子</td></tr>
<tr><td ><br>标题&nbsp;&nbsp;<input type="text" name="titletext" id="inputtext" value=${note.title} >&nbsp;&nbsp;<font color="#ff0000">${requestScope["msg"]}</font></td></tr>
<tr><td>内容</td></tr>
<tr><td><textarea name="essaytext" cols="70" rows="20" maxlength="1000" align="center" id="essay" >${note.essay }</textarea></td></tr>
<tr><td><br><input type="submit" name="submitbutton" value="重新发布" id="submit" style="margin-left: 22%;"></td></tr>
</table>
</div>
</form>
</div>
</body>
</html>