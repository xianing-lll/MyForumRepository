<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="cn.itcast.myforum.domain.User" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0">

<title>安师论坛</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/client/css/user.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/client/css/index.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/client/css/before.css" type="text/css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/client/css/register.css" type="text/css" />


<body id="body">
<div id="head">
<div style="float: left; margin-left: 1%; margin-top: 0px;">
<img src="${pageContext.request.contextPath}/client/image/anshiIcon.jpg" style="width: 50px; height: 50px; ">
</div>
<div style="float: left; margin-top: 10px;">
<a id="login">&nbsp;安师论坛</a>
</div>
<div >
<% 
User user = (User) request.getSession().getAttribute("user");
if(null == user){
%>
<div style="margin-top: 13px; float: right;">
<a href="${pageContext.request.contextPath}/client/login.jsp " id="head_2">登录|</a>
<a href="${pageContext.request.contextPath}/client/register.jsp " id="head_3">注册</a>	
</div>						
<% 
}else{
%>               
<%--  <select name="usertext"  id="user">
<option >${user.email}</option>
<option ><a href="">修改账户</a></option>
<option ><a href="">注销</a></option>
</select>	 --%> 

<div class="dropdown" style="float: right;padding-right: 2%;padding-left: 2%;" >
  <button class="dropbtn">
  <table>
  <tr>
  <td><img src="${pageContext.request.contextPath }/client/user_image/${user.imgurl }" style="width: 32px;height: 32px; border-radius:50%; margin-top: 5px;"></td>
  <td>&nbsp;${user.name}</td>
  </tr>
  </table>
  </button>
  <div class="dropdown-content">
    <a href="${pageContext.request.contextPath}/client/updateUser.jsp ">修改账户</a>
    <a href="${pageContext.request.contextPath}/logoutServlet " onclick = 'return confirm("确认要退出登录吗？");'>注销</a>
  </div>
</div>			
<% 	
}
%>	
</div>
</div >



<div style="margin-top: 10px; width: 100%;"> <!-- 搜索框 -->
<form action="${pageContext.request.contextPath }/shoufindServlet" method="post">
<div style="float: left; width: 70%;">
<input type="text"  name="findtext" id="inputtext"  placeholder="  请输入任意相关的关键字" style="font-size: 16px;margin-left:5%; width: 97%; border-radius:50px;text-align: center; "></td>
</div>
<div style="float: left; width: 25%; margin-left: 2%;">
<input type="submit" name="submitbutton" value="搜索" id="submit" style="width:70px; height: 30px;background-color: #5555FF; color: white; border-radius:10px;">
</div>
</form> 
</div>





<!-- <div style="margin-left:92.5%;"><script id="_wausmo">var _wau = _wau || []; _wau.push(["dynamic", "uicoo5t0o2", "smo", "b6d7a8fff2cc", "small"]);</script><script async src="//waust.at/d.js"></script></div> -->
<div id="note">
<HR width="91%" size="0px;" color="#FFE4E1" style="margin-top: 0px;margin-bottom: 0px;opacity:0.0 ;">
<div style="margin-left: 4%; margin-bottom: 33px;">
<div style="float: left;">
<a href="${pageContext.request.contextPath }/index.jsp" style=" text-decoration: none; margin-bottom: 20px;">贴吧社区</a>
</div>
<div style="float: left;  margin-left: 5%; ">
<a href="${pageContext.request.contextPath }/shoumynoteServlet" style=" text-decoration: none;  margin-bottom: 20px;">我的贴吧</a>
</div>

<div style=" float: right;width: 30%;height: 35px;  background-color: #FFBB00; padding-top: 2%;padding-left: 5%; ">
<a href="${pageContext.request.contextPath }/shouaddnoteServlet" style=" text-decoration: none;">发表新主题</a></div>
</div>
<div style="margin-left: 10px; padding-top: 3px;">
<HR width="91%" size="2px;" color="#FFE4E1" style="margin-top: 8px;margin-bottom: 8px;">
<c:forEach items="${pageBean.notes}" var="n" varStatus="vs">

<table>
<tr>
<td rowspan="3"><img src="${pageContext.request.contextPath }/client/user_image/${n.imgurl}" style="width: 45px;height: 45px; border-radius:50%;"></td>
<td>
<a href="${pageContext.request.contextPath }/shouessayServlet?note_id=${n.note_id}" style="text-decoration: none;">&nbsp;&nbsp;&nbsp;${n.title }</a></td>
</tr>
<tr>
<td><font size="2px;" color="#888888" >&nbsp;&nbsp;&nbsp;&nbsp;${n.name} &nbsp;&nbsp;&nbsp;<img src="${pageContext.request.contextPath }/client/image/time2.jpg" style="width: 15px; height: 14px; ">&nbsp;${n.timesString} 
</font>
</td>
</tr>
<tr>
<td colspan="1">
<font size="2px;" color="#888888" style="margin-left: 10px;">
<a href="${pageContext.request.contextPath }/shouupdatenoteServlet?note_id=${n.note_id}" style="text-decoration: none; color: #00A600;font-size: 13px;">${update}</a>&nbsp;
<a href="${pageContext.request.contextPath }/deletemynoteServlet?note_id=${n.note_id}" style="text-decoration: none; color:#00A600; font-size: 13px;">${delete}</a>
</font>
</td>
</tr>
</table>

<HR width="91%" size="2px;" color="#FFE4E1" style="margin-top: 0px;margin-bottom: 8px;">

</c:forEach>
</div>

<!-- 页码 -->
<div style="margin-left: 45%">						
<c:if test="${pageBean.currentPage!=1}">
<a href="${pageContext.request.contextPath}/${category}?currentPage=${pageBean.currentPage-1}" style="text-decoration: none;"><-&nbsp;</a>
</c:if>

<c:if test="${pageBean.currentPage==1}">
<-
</c:if>

${pageBean.currentPage}/${pageBean.totalPage}
<c:if test="${pageBean.currentPage==pageBean.totalPage||pageBean.totalPage==0}">
->
</c:if>

<c:if test="${pageBean.currentPage!=pageBean.totalPage&&pageBean.totalPage!=0}">
<a href="${pageContext.request.contextPath}/${category}?currentPage=${pageBean.currentPage+1}" style="text-decoration: none;"> -></a>
</c:if>	
							
</div>
</div>

</body>
</html>