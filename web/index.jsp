<%@ page import="javax.jws.soap.SOAPBinding" %>
<%@ page import="com.qf.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Administrator1
  Date: 2022/3/13
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
</head>
<body>
<h1>首页</h1>
<h2>欢迎你，
    <%
        User user = (User) request.getAttribute("loginUser")
    %>
</h2>
</body>
</html>
