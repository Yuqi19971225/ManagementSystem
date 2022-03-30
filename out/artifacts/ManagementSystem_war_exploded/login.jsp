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
    <script type="text/javascript">
        function noLook() {
            //验证码图片是内存图片，第一次请求生成验证码时，验证码图片会保存在内存中
            //要想要新的图片，需要新的url
            document.getElementById("img1").src = "/CheckCodeServlet?r=" + new Date();

        }
    </script>
</head>
<body>
<%
    Object obj = request.getAttribute("miss");
    if (obj != null) {
        out.write("<h1>" + obj + "</h1>");
    }
%>
<%--获得记住的cookie中用户信息--%>
<%
    Cookie[] cookies = request.getCookies();
    String username = "";
    String password = "";
    //遍历cookie
    for (Cookie cookie : cookies) {
        if (cookie.getName().equals("username")) {
            username = cookie.getValue();
        }
        if (cookie.getName().equals(("password"))) {
            password = cookie.getValue();
        }
    }

%>
<form method="post" action="/LoginServlet">
    <table>
        <tr>
            <td></td>
            <td>登录页面</td>
            <td></td>
        </tr>
        <tr>
            <td>用户名:</td>
            <td><input type="text" name="username" id="username" value="<%=username%>"/></td>
            <td id="uname1"></td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input type="password" name="password" id="password" value="<%=password%>"/></td>
            <td></td>
        </tr>
        <tr>
            <td>验证码:</td>
            <td>
                <input type="text" name="checkCode"/>
                <img id="img1" src="/CheckCodeServlet" alt="验证码加载失败" onclick="noLook()"/>
                <a onclick="noLook()"/>看不清，刷新验证码</a>
            </td>
            <td></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="checkbox" name="rememberMe"/>记住我</td>
            <td></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" value="提交"/>
                <input type="reset" value="重置"/>
            </td>
            <td></td>
        </tr>
    </table>
</form>
</body>
</html>