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
<div style="width: 460px; height: 350px;">
<img src="${pageContext.request.contextPath}/client/image/anshiIcon.jpg" style="width: 55px; height: 55px;margin-top: 0px; margin-left: 125px;">
<%
User user=new User();
%>
<form action="${pageContext.request.contextPath }/updatepasswordServlet?email=${user.email}" method="post"">

<table>
<tr><td style="text-align: center; font-size: 40px;">密码修改</td></tr>

<tr><td colspan="2"><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;账号:&nbsp;&nbsp;${user.email }</td></tr>
<tr>
<td>
<br>&nbsp;&nbsp;&nbsp;&nbsp;验证码:<input type="text" name="indentifytext" id="inputtext" placeholder="请输入来自邮件的验证码">
</td>
<td><a href="${pageContext.request.contextPath }/sendmailServlet" style="text-decoration: none;" >邮箱验证</a></td>
</tr>

<tr><td ><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;密码:
<input type="password" name="passwordtext" id="inputtext" placeholder="请输入新密码" value=${password }></td>
<tr><td><br>确认密码:
<input type="password" name="again_passwordtext" id="inputtext" placeholder="请再次输入密码" value=${again_password }></td>
<td><font color="#ff0000">${msg}</font></td></tr>

<tr>
<td colspan="2"><br><input type="submit" name="submitbutton" value="修改" id="submit" style="width: 341px;" onclick='return confirm("确认修改密码吗？");'></td></tr>
<tr><td colspan="2"><font color="#ff0000" style="text-align: center;">${msg_2 }</font></td></tr>
</table>
</form>
</div>
</div>


</body>
</html>