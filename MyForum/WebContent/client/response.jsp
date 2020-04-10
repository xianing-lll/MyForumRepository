<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>回复</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/client/css/register.css" type="text/css" />
</head>
<body id="body">
<div id="index">
<a href="${pageContext.request.contextPath}/index.jsp " >
<img src="${pageContext.request.contextPath}/client/image/index.png" style="width: 55px; height: 55px;margin-top: 0%; border-radius:50%;"></a></div>
<div id="noteeassy_bodydiv" >

<div style="color:#FFD700; "><!--显示文章  -->
${ essay}
</div>

<br><br>
<div><!--要回复的人和内容  -->
${to_name}:${content}
</div>
<br>
<div>
<form action="${pageContext.request.contextPath }/addcommentServlet?note_id=${note_id}&user_id=${to_id}" method="post">
<table>
<tr>
<td><textarea name="comment" cols="50" rows="3" maxlength="1000" align="center"  placeholder="请输入评论内容！" id="essay"></textarea></td>
<td>&nbsp;<input type="submit" name="submitbutton" value="回复他" id="eassy_submit"></td>
<td>&nbsp;${msg }</td>
</tr></table>
</form>
</div>
</div>
</body>
</html>