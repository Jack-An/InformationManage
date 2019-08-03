<%@ page import="cn.jackan.domain.User" %><%--
  Created by IntelliJ IDEA.
  User: jacka
  Date: 2019/7/29
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="cn.jackan.domain.User" language="java" pageEncoding="UTF-8" %>
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
    <script language="JavaScript" src="js/jquery.js"></script>
    <script type="text/javascript">
        $(function () {
            //顶部导航切换
            $(".nav li a").click(function () {
                $(".nav li a.selected").removeClass("selected")
                $(this).addClass("selected");
            })

            $("#out").click(function () {
                var flag = window.confirm("你真的要退出吗?");
                if (flag) {
                    window.top.location.href = "user?oper=out";
                }
            })

        })


    </script>


</head>

<body style="background:url(/images/topbg.gif) repeat-x;">

<div class="topleft">
    <a href="main/main.jsp" target="_parent"><img src="images/logo.png" title="系统首页"/></a>
</div>


<div class="topright">
    <ul>
        <li><a href="javascript:void(0)" id="out" target="_top">退出</a></li>
    </ul>

    <div class="user">
        <span><%=request.getSession().getAttribute("user") == null ? "" : ((User) request.getSession().getAttribute("user")).getUname()%></span>
    </div>
</div>

</body>
</html>
