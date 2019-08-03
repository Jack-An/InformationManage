<%--
  Created by IntelliJ IDEA.
  User: jacka
  Date: 2019/7/31
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    $(function () {
        $("#fm").submit(function () {
            if($("#pwd").val()===""|| $("#cfPwd").val()===""){
                alert("密码不能为空");
                return false;
            }else if($("#pwd").val()!==$("#cfPwd").val()){
                alert("新密码与确认密码必须一致");
                return false;
            }else{
                return true;
            }


        })
    })


    </script>
</head>

<body>

<div class="place">
    <span>位置：</span>
    <ul class="placeul">
        <li><a href="#">首页</a></li>
        <li><a href="#">修改密码</a></li>
    </ul>
</div>

<div class="formbody">

    <div class="formtitle"><span>修改密码</span></div>
    <form action="user" method="post" id="fm" target="_top">
        <input type="hidden" name="oper" value="modifyPwd"/>
        <ul class="forminfo">
<%--            <li><label>原密码</label><input name="originPwd" type="text" class="dfinput"/></li>--%>
            <li><label>新密码</label><input name="newPwd"  id="pwd"  type="password" class="dfinput"/><i>密码应该为ASCII字符</i></li>
            <li><label>重复新密码</label><input  type="password" id="cfPwd"  class="dfinput"/><i>密码应该为ASCII字符</i></li>
            <li><input name="oper" type="submit" class="loginbtn" value="提交">
        </ul>
    </form>


</div>


</body>

</html>

