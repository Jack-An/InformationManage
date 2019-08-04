<%--
  Created by IntelliJ IDEA.
  User: jacka
  Date: 2019/8/1
  Time: 21:55
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <base href="<%=basePath%>"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="js/jquery.js"></script>

    <script type="text/javascript">
        $(document).ready(function () {
            $(".click").click(function () {
                $(".tip").fadeIn(200);
            });

            $(".tiptop a").click(function () {
                $(".tip").fadeOut(200);
            });

            $(".sure").click(function () {
                $(".tip").fadeOut(100);
            });

            $(".cancel").click(function () {
                $(".tip").fadeOut(100);
            });

        });
    </script>


</head>


<body>
<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">首页</a></li>
        <li><a href="#">所有用户信息</a></li>
    </ul>
</div>

<div class="rightinfo">
    <table class="tablelist">
        <thead>
        <tr>
            <th>编号</th>
            <th>用户名</th>
            <th>密码</th>
            <th>性别</th>
            <th>年龄</th>
            <th>生日</th>
        </tr>
        </thead>
        <tbody>
<%--        使用EL表达式和JSTL来实现--%>
        <c:forEach items="${users}" var="u">
            <tr>
                <td>${u.uid}</td>
                <td>${u.uname}</td>
                <td>${u.password}</td>
                <td>${u.sex==0? "女":"男"}</td>
                <td>${u.age==0? "":u.age}</td>
                <td>${empty u.birth? "":u.birth}</td>
            </tr>
        </c:forEach>

<%--        使用Java脚本段--%>
<%--        <%--%>
<%--            ArrayList<User> users = (ArrayList<User>) session.getAttribute("users");--%>
<%--            for (User u : users) {--%>
<%--        %>--%>
<%--        <tr>--%>
<%--            <td><%=u.getUid()%></td>--%>
<%--            <td><%=u.getUname()%></td>--%>
<%--            <td><%=u.getPassword()%></td>--%>
<%--            <td><%=u.getSex() == 0 ? "女" : "男"%></td>--%>
<%--            <td><%=u.getAge() ==0? "":u.getAge()%></td>--%>
<%--            <td><%=u.getBirth()==null? "":u.getBirth()%></td>--%>

<%--            &lt;%&ndash;<td><a href="#" class="tablelink">查看</a> <a href="#" class="tablelink"> 删除</a></td>&ndash;%&gt;--%>
<%--        </tr>--%>
<%--        <%}%>--%>
        </tbody>
    </table>


</div>

<script type="text/javascript">
    $('.tablelist tbody tr:odd').addClass('odd');
</script>

</body>

</html>
