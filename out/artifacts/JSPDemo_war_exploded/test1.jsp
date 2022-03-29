<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: Administrator1
  Date: 2022/3/29
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>这是h1标签</h1>
<%="Hello,JSP!" %><br>

<!--声明-->
<%!
    //申明一个方法
    String changeDateToString(Date d) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(d);
    }
%>
<!--在表达式中调用声明的方法-->
<h1><%=changeDateToString(new Date())%>
</h1>

<%

    out.write("这是第二种输出内容到浏览器");
%>
</body>
</html>
