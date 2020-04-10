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
	color: black;
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

<div id="bodydiv" style="width: 45%;position:absolute; padding-left:3%;margin-left:33%; margin-top: 1.3%;">
<br><div>当前我的头像</div><br>
<div style="color: #444444;font-size: 13px;">如果您还没有设置自己的头像，系统会显示为默认头像，您需要自己上传一张新照片来作为自己的个人头像</div><br>
<div>
<%
User user=new User();
%>
<img src="${pageContext.request.contextPath}/client/user_image/${user.imgurl}" style="width: 55px; height: 55px;margin-top: 0px; margin-left: 125px; border-radius:50%;">55*55
</div><br>
<div>设置我的新头像</div><br>
<form action="${pageContext.request.contextPath }/updateheadServlet" method="post" enctype="multipart/form-data">
<table>
<tr><td><input type="file" name="myhead"><br></td></tr>
<tr><td><br><input type="submit" name="submitbutton" value="上传" id="submit" style="width: 150%;margin-left: 20%;"></td></tr>
</table>
</form>
<br><div style="margin-left: 20%;">${msg }</div>
</div>


</body>
</html>