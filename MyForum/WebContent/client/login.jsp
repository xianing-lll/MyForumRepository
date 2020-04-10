<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0">
<title>安师论坛登录</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/client/css/before.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/client/css/login.css" type="text/css" />
</head>
<body id="body">

<div style="">
<form action="${pageContext.request.contextPath }/loginServlet" method="post">
<div style="float: left; margin-top: 80px; margin-left: 28%;"><img src="${pageContext.request.contextPath}/client/image/anshiIcon.jpg" style="width: 55px; height: 55px;"></div>
<div style="float: left;margin-top: 90px; margin-left: 2%; font-size: 25px;">
安师论坛
</div>
<div style="padding-left: 12%; padding-right: 12%; padding-top: 170px;">
<input type="text" name="emailtext" id="inputtext" placeholder="qq邮箱/其他邮箱" >
</div>
<div style="padding-left: 12%; padding-right: 12%; margin-top: 10px;">
<input type="password" name="passwordtext" id="inputtext"  placeholder="请输入密码" >
</div>
<div style="margin-left: 40%; margin-top: 25px;">
<input type="submit" name="submitbutton" value="→" id="submit">
</div>
<div style="text-align: center; margin-top: 10px;">
<font color="#ff0000">${requestScope["msg"]}</font>
</div>

</form>
</div>
</body>
</html>