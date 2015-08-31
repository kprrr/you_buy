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

<!-- 查询条件 -->
<div data-options="region:'north',title:'数据检索',iconCls:'icon-search'"
     style="height:100px; min-width: 300px; overflow:hidden">
    <fieldset>
        <legend>数据检索</legend>
        <table border="0" cellpadding="5" cellspacing="1" class="table_bg">
            <tr>
                <td>场馆名称:</td>
                <th>
                    <input class="easyui-validatebox textbox" type="text" id="s_title"/>
                </th>
                <th>
                    <a href="javascript:;" id="search" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
                       onclick=""> 检索 </a>
                </th>
            </tr>
        </table>

    </fieldset>
</div>

<!-- 主界面 -->
<div region="center">
    <table id="list" data-options="toolbar: '#menus'" border="false"></table>
    <div id="menus" style="height:auto">
        <a href="javascript:;" id="add" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新建</a>
        <a href="javascript:;" id="edit" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">编辑</a>
        <a href="javascript:;" id="remove" class="easyui-linkbutton"
           data-options="iconCls:'icon-remove',plain:true">删除</a>
        <a href="javascript:;" id="reload" class="easyui-linkbutton"
           data-options="iconCls:'icon-reload',plain:true">刷新</a>
    </div>
</div>

<!-- 弹窗 -->
<div id="win"></div>

</body>

</html>