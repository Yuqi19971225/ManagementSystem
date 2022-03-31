<%--
  Created by IntelliJ IDEA.
  User: Administrator1
  Date: 2022/3/31
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <td>编号</td>
        <td>用户名</td>
        <td>年龄</td>
        <td>性别</td>
        <td>爱好</td>
        <td>城市</td>
        <td>生日</td>
        <td>操作</td>
    </tr>
    <c:forEach var="u" items="${requestScope.userList}">
        <tr>
            <td>${u.id}</td>
            <td>${u.username}</td>
            <td>${u.age}</td>
            <td>${u.gender}</td>
            <td>${u.hobby}</td>
            <td>${u.city}</td>
            <td>${u.birthday}</td>
            <td>
                <a>修改</a>
                <a>删除</a>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="8">
            <c:if test="${requestScope.page.curPage>1}">
                <a href="/SelectUsersByPageServlet?cur=${requestScope.page.curPage-1}"><input type="button" value="上一页"></a>
            </c:if>
            当前是第${requestScope.page.curPage}页，
            总共${requestScope.page.totalPage}页
            <c:if test="${requestScope.page.curPage<requestScope.page.totalPage}">
                <a href="/SelectUsersByPageServlet?cur=${requestScope.page.curPage+1}"><input type="button" value="下一页"></a>
            </c:if>
        </td>
    </tr>
    <tr>
        <td colspan="8">
            <c:forEach begin="1" step="1" end="${requestScope.page.totalPage}" varStatus="status">
                <a href="SelectUsersByPageServlet?cur=${status.index}">${status.index}</a>
            </c:forEach>
        </td>
    </tr>
</table>
</body>
</html>
