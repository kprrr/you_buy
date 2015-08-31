<%@ page contentType="text/html; charset=utf-8" language="java"
         errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<jsp:include page="/inc/head.jsp"></jsp:include>
<script src="/js/sys/menuList.js"></script>

<link rel="stylesheet" type="text/css" href="/css/sys/menuList.css"/>

<head>
    <title></title>
</head>

<body id="mainWin" class="easyui-layout">
<fieldset>
    <legend>操作</legend>
    <a href="javascript:;" id="add" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新建节点</a>
    <a href="javascript:;" id="edit" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">编辑</a>
    <a href="javascript:;" id="remove" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
    <a href="javascript:;" id="reload" class="easyui-linkbutton" data-options="iconCls:'icon-reload',plain:true">刷新</a>
</fieldset>

<fieldset>
    <legend>当前菜单列表</legend>
    <ul id="tree_menu"></ul>
</fieldset>

<!-- 弹窗 -->
<div id="win"></div>

</body>

</html>