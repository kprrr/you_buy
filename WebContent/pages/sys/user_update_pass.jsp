<%@ page contentType="text/html; charset=utf-8" language="java"
         errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<jsp:include page="/inc/head.jsp"></jsp:include>
<script src="/js/sys/userUpdatePass.js"></script>

<link rel="stylesheet" type="text/css" href="/css/sys/allList.css"/>

<head>
    <title></title>
</head>

<body id="mainWin" class="easyui-layout">
<!-- 主界面 -->
<div region="center">
    <form id="form" class="panl" method="post">
        <fieldset class="menus">
            <legend>密码修改</legend>
            <table border="0" cellpadding="5" cellspacing="1" class="table_bg">
                <tr>
                    <td>
                        原密码:
                    </td>
                    <th>
                        <input id="old_padd" name="old_padd" type="password" data-options="required:true">
                    </th>
                </tr>
                <tr>
                    <td>
                        新密码:
                    </td>
                    <th>
                        <input id="new_pass" name="new_pass" type="password" data-options="required:true">
                    </th>
                </tr>

                <tr>
                    <td>
                        确认密码:
                    </td>
                    <th>
                        <input id="_new_pass" name="_new_pass" type="password" data-options="required:true">
                    </th>
                </tr>
                <tr>
                    <th colspan="2">
                        <a href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-save'"
                           onclick="subMit()">修改</a>
                    </th>
                </tr>
            </table>
        </fieldset>
    </form>
</div>

</body>

</html>