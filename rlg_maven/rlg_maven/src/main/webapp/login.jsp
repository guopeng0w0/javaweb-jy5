<%--
  Created by IntelliJ IDEA.
  User: 郭鹏
  Date: 2019/8/6
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/login.css">
</head>
<body>
<div id="continer">
    <form action="/manage/user/login.do" method="post">
        <h3>欢迎登陆</h3>
        <input type="text" name="username" placeholder="账户" >
        <input type="password" name="password" placeholder="密码" >
        <input type="submit" value="登录" >
    </form>
</div>
</body>
</html>
