<%--
  Created by IntelliJ IDEA.
  User: Administrator1
  Date: 2022/3/29
  Time: 19:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //获得当前网站访问人数
    Object obj = application.getAttribute("count");
    int num = 0;
    if (obj == null) {
        num = 1;
    } else {
        num = Integer.valueOf(obj.toString()) + 1;
    }
    //将人数存在上下文对象中
    application.setAttribute("count", num);
%>
<h1>
    <%="你是第" + application.getAttribute("count") + "个访问者"%>
</h1>
</body>
</html>
