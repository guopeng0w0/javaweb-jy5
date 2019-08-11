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
    <title>登录界面</title>
    <link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/login.css">
</head>
<body>
<div id="img">
    <div id="continer">
        <form action="/manage/user/login.do" method="post">
            <h3>欢迎登陆</h3>
            <input type="text" name="username" id="u" placeholder="账户" >
            <input type="password" name="password" id="p" placeholder="密码">
            <input type="submit" value="登录" id="bu">
            <div id="nr"></div>
        </form>
    </div>
</div>
</body>
<%--<script src="js/jquery-3.3.1.js"></script>--%>
<%--<script>--%>
    <%--$("#bu").click(function () {--%>
        <%--var u = ${"#u"}.val();--%>
        <%--var p = ${"#p"}.val();--%>
        <%--$.post(--%>
            <%--"/manage/user/login.do",--%>
            <%--{username:u,password:p},--%>
             <%--function (fun) {--%>
                 <%--if (fun.start !== 0){--%>
                     <%--${"#nr"}.empty()--%>
                     <%--${"#nr"}.append("<p>" + fun.msg + "</p>")--%>
                 <%--}else {--%>
                     <%--window.open("index.html")--%>
                 <%--}--%>
             <%--}--%>
        <%--)--%>
    <%--})--%>
<%--</script>--%>
</html>
