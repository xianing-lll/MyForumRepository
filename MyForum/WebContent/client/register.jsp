<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0">
<title>安师论坛注册</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/client/css/before.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/client/css/register.css" type="text/css" />
</head>
<body id="body">

<%-- <div id="index">
<a href="${pageContext.request.contextPath}/index.jsp " >
<img src="${pageContext.request.contextPath}/client/image/index.png" style="width: 55px; height: 55px;margin-top: 0%; border-radius:50%;"></a></div> --%>


<div id="bodydiv">
<img src="${pageContext.request.contextPath}/client/image/anshiIcon.jpg" style="width: 55px; height: 55px;margin-top: 0px; margin-left: 125px;">
<form action="${pageContext.request.contextPath }/registerServlet" method="post"">
<div style="width:100%;">
<table>
<tr><td style="text-align: center; font-size: 40px;">安师论坛注册</td></tr>
<tr><td >邮箱</td></tr>
<tr><td><input type="text" name="emailtext" id="inputtext" placeholder="qq邮箱或其他邮箱" ></td>
<td><font color="#ff0000" style="font-size: 10px;">${requestScope["emailmsg"]}</font></td></tr>
<tr><td>密码</td></tr>
<tr><td><input type="password" name="passwordtext" id="inputtext"  placeholder="请输入密码" ></td>
<td></td></tr>
<tr><td>确认密码</td></tr>
<tr><td><input type="password" name="passwordtext_2" id="inputtext"  placeholder="请再次输入密码" ></td>
<td><font color="#ff0000" style="font-size: 10px;">${requestScope["passwordmsg"]}</font></td></tr>
<tr><td>性别</td></tr>
<tr><td><select name="sextext" style="width: 285px;height: 35px; border: 1px solid #ccc;">
<option value="男">男</option>
<option value="女">女</option>
</select></td></tr>
<tr><td>年龄</td></tr>
<tr><td><select name="agetext" style="width: 285px;height: 35px; border: 1px solid #ccc;">
<c:forEach begin="10" end="80" step="1" var="i">
   <option headerValue="20"> ${i}</option>
 </c:forEach> 
</select></td></tr>
<tr><td>电话号码</td></tr>
<tr><td><input type="text" name="phonetext" id="inputtext" placeholder="请输入电话号码" ></td>
<td><font color="#ff0000" style="font-size: 10px;">${requestScope["phonemsg"]}</font></td></tr>
<tr><td><br><input type="submit" name="submitbutton" value="提交" id="submit" onclick='return confirm("该邮箱将用于密码更改，请确认其真实有效！");'></td></tr>
</table>
</div>
</form>
</div>

</body>
</html>