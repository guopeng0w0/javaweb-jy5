<%--
  Created by IntelliJ IDEA.
  User: 郭鹏
  Date: 2019/8/6
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>用户列表</title>
</head>
<body>
<table>
    <%--头部--%>
    <tr>
        <th>ID</th>
        <th>用户名</th>
        <th>密码</th>
        <th>电话</th>
        <th>权限</th>
        <th>状态</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${userlist.data}" var="user">
        <tr>
            <td>${user.uid}</td>
            <td>${user.uname}</td>
            <td>${user.upsw}</td>
            <td>${user.phone}</td>
            <td>${user.type}</td>
            <td>${user.stats}</td>
            <td>
                <a href="">编辑</a>
                <a href="">删除</a>
                <a href="/manage/user/disableuser.do?uid=${user.uid}">禁用</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
