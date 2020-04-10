<%@page import="cn.itcast.myforum.domain.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>信息修改</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/client/css/register.css" type="text/css" />
<style type="text/css">
a{
color: #666666;
}
a:hover {
	color:black;
}
</style>
</head>
<body id="body">

<div style="width: 16.5%;height: 22%; background-color: #fff; margin-top: 1.3%;margin-left: 16%;position: absolute;">
<div style="margin-left: 15%;margin-top:5%; "><a href="${pageContext.request.contextPath}/index.jsp " style="text-decoration: none;">首页</a>-><font style="font-size: 13px;">修改账户</font></div>
<HR width="91%" size="2px;" color="#FFE4E1">
<div style="margin-left: 15%;margin-top:5%; "><a href="${pageContext.request.contextPath}/client/updateUser.jsp " style="text-decoration: none; ">个人资料</a></div>
<div style="margin-left: 15%; margin-top:5%;"><a href="${pageContext.request.contextPath }/client/updatehead.jsp" style="text-decoration: none; ">上传头像</a></div>
<div style="margin-left: 15%; margin-top:5%;"><a href="${pageContext.request.contextPath }/client/updatepassword.jsp" style="text-decoration: none; ">修改密码</a></div>
</div>

<div id="bodydiv" style="width: 34%;position:absolute; padding-left:10%;margin-left:33%; margin-top: 1.3%;">

<img src="${pageContext.request.contextPath}/client/image/anshiIcon.jpg" style="width: 55px; height: 55px;margin-top: 0px; margin-left: 125px;">
<form action="${pageContext.request.contextPath }/updateServlet" method="post"">

<table>
<tr><td style="text-align: center; font-size: 40px;">个人信息修改</td></tr>
<%
User user=new User();
%>
<tr><td colspan="2"><br>账&nbsp;&nbsp;&nbsp;号:&nbsp;&nbsp;${user.email }</td></tr>
<tr><td ><br>用户名:
<input type="text" name="nametext" id="inputtext" value=${user.getName()}></td>
<td><font color="#ff0000">${requestScope["namemsg"]}</font></td></tr>
<tr><td colspan="2"><br>性&nbsp;&nbsp;&nbsp;别:&nbsp;&nbsp;${user.sex }</td></tr>
<tr><td colspan="2"><br>年&nbsp;&nbsp;&nbsp;龄:&nbsp;&nbsp;${user.age }</td></tr>
<tr><td><br>手机号:
<input type="text" name="phonetext" id="inputtext" value=${user.phone}></td>
<td><font color="#ff0000">${requestScope["phonemsg"]}</font></td></tr>
<tr>
<td colspan="2"><br><input type="submit" name="submitbutton" value="修改" id="submit" style="width: 341px;"></td></tr>
<tr><td colspan="2"><font color="#ff0000" style="text-align: center;">${requestScope["updatemsg"]}</font></td></tr>
</table>
</form>

</div>


</body>
</html>