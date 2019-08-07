<%--
  Created by IntelliJ IDEA.
  User: 郭鹏
  Date: 2019/8/6
  Time: 17:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="pojo.Users" %>
<html>
<head>
    <title>首页</title>
</head>
<%--在前端显示是哪个用户登录--%>
<%--<%--%>
    <%--HttpSession hs = request.getSession();--%>
    <%--Users u = (Users) hs.getAttribute("user");--%>
<%--%>--%>
<%--<%= u.getUname()%>--%>
<div>
    ${user.uname}
</div>

<ui>
    <li><a href="/manage/user/list.do">用户列表</a></li>
    <li><a href="">商品列表</a></li>
</ui>

</body>
</html>
