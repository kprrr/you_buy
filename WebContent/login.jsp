<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>平台登录</title>
    <link href="css/login.css" rel="stylesheet" type="text/css">
</head>

<body>
<div class="loginbg">
    <div class="boxh">
        <div class="head">
            <!-- logo
            <img src="" alt="logo" width="601" height="82"/> -->
        </div>
    </div>
    <div class="loginbgbox">
        <div class="login">
            <div  class="userbox">
                <h2 class="logintitle">用户登陆</h2>
                <form id="myform" name="myform" class="loginform" method="post" action="sysUser-login" onsubmit="return checkform();">
                    <ul class="logincon">
                        <li>
                            <label><em>*</em>用户名：</label>
                            <input type="text" name="name" id="user_name" class="txt">

                        </li>

                        <div class="clr"></div>
                        <li  >
                            <label><em>*</em>用户密码：</label>
                            <input type="password" name="password" id="password" class="txt">
                        </li>
                        <div class="clr"></div>


                        <li class="forgot">
                            ${mess }
                        </li>

                    </ul>
                    <div class="clr"></div>
                    <div class="loginFormBtn">
                        <a tabindex="3" href="#" class="loginBtn" onclick="document.getElementById('myform').submit();"></a>
                    </div>




                </form>
            </div>
        </div>
    </div>
    <div class="bottom">
        <p>版权所有：xxx</p>
    </div>
</div>
</body>
</html>
