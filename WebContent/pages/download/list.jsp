<%@ page contentType="text/html; charset=utf-8" language="java"
         errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:include page="/inc/head.jsp"></jsp:include>
<script src="js/list.js"></script>

<link rel="stylesheet" type="text/css" href="/css/sys/allList.css"/>
<head>
    <title></title>
</head>

<body id="mainWin" class="easyui-layout">


<!-- 主界面 -->
<div region="center">
    <table id="list" data-options="toolbar: '#menus'" border="false"></table>
    <div id="menus" style="height:auto">
        <a href="javascript:;" id="edit" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">编辑</a>
        <a href="javascript:;" id="reload" class="easyui-linkbutton"
           data-options="iconCls:'icon-reload',plain:true">刷新</a>

    </div>
</div>

<!-- 弹窗 -->
<div id="win"></div>

</body>

</html>