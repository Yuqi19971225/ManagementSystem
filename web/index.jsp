<%@ page import="javax.jws.soap.SOAPBinding" %>
<%@ page import="com.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: Administrator1
  Date: 2022/3/13
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
</head>
<body>
<h1>首页</h1>
<h2>欢迎你，${sessionScope.loginUser.username}</h2>
<c:choose>
    <c:when test="${sessionScope.loginUser.role=='student'}">
        <h2>
            <a>退出</a>
            <a>修改密码</a>
            <a>修改用户信息</a>
        </h2>

    </c:when>
    <c:when test="${sessionScope.loginUser.role=='admin'}">
        <h2>
            <a>退出</a>
            <a>修改密码</a>
            <a href="SelectUsersByPageServlet?cur=1">管理普通用户信息</a>
        </h2>

    </c:when>
    <c:otherwise>
        <h1>未登录，五秒后跳转到登录页面！</h1>
        <meta http-equiv="refresh" content="5;url=login.jsp"/>
    </c:otherwise>
</c:choose>
</body>
</html>
