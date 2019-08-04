<%--
  Created by IntelliJ IDEA.
  User: jacka
  Date: 2019/7/29
  Time: 19:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>欢迎登录后台管理系统</title>
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <script language="JavaScript" src="js/jquery.js"></script>
    <script src="js/cloud.js" type="text/javascript"></script>

    <script language="javascript">
        $(function () {
            $('.loginbox').css({'position': 'absolute', 'left': ($(window).width() - 692) / 2});
            $(window).resize(function () {
                $('.loginbox').css({'position': 'absolute', 'left': ($(window).width() - 692) / 2});
            })
        });
    </script>

</head>

<body style="background-color:#df7611; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">


<div id="mainBody">
    <div id="cloud1" class="cloud"></div>
    <div id="cloud2" class="cloud"></div>
</div>


<div class="logintop">
    <span>欢迎登录后台管理界面平台</span>
</div>

<div class="loginbody">
    <span class="systemlogo"></span>
    <br/>
    <c:choose>
        <c:when test="${flag==0}">
            <div style="text-align: center">
                <span style="font-size: 15px;color: darkred;font-weight: bold">用户名或者密码错误</span>
            </div>
        </c:when>
        <c:when test="${flag==1}">
            <div style="text-align: center">
                <span style="font-size: 15px;color: darkred;font-weight: bold">密码修改成功，请重新登陆</span>
            </div>
        </c:when>
        <c:when test="${flag==2}">
            <div style="text-align: center">
                <span style="font-size: 15px;color: darkred;font-weight: bold">注册成功，请登陆</span>
            </div>

        </c:when>
    </c:choose>
    <c:remove var="flag" scope="session" />




    <div class="loginbox">
        <form action="user" method="post">
            <input type="hidden" name="oper" value="login"/>
            <ul>
                <li><input name="uname" type="text" placeholder="用户名" class="loginuser"/></li>
                <li><input name="pwd" type="text" placeholder="密码" class="loginpwd"/></li>
                <li><input name="oper" type="submit" class="loginbtn" value="登录"/>
<%--                    <label><input name="" type="checkbox" value="" checked="checked"/>记住密码</label>--%>
                    <label><a href="reg.jsp">注册</a></label></li>
            </ul>
        </form>

    </div>

</div>


<div class="loginbm">版权所有 2019 <a href="http://www.uimaker.com">uimaker.com</a> 仅供学习交流，勿用于任何商业用途</div>


</body>

</html>

