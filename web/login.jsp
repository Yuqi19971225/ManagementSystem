<%--
  Created by IntelliJ IDEA.
  User: Administrator1
  Date: 2022/3/29
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
</head>
<body>
<%
    Object obj = request.getAttribute("miss");
    if (obj != null) {
        out.write("<h1>" + obj + "</h1>");
    }
%>

<form action="/LoginServlet" method="post">
    用户名：<input type="text" name="username"><br>
    密码：<input type="password" name="password"><br>
    <input type="submit" value="登录">
    <input type="reset" value="重置"/>
</form>
</body>
</html>