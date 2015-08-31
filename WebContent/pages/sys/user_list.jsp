<%@ page contentType="text/html; charset=utf-8" language="java"
         errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<jsp:include page="/inc/head.jsp"></jsp:include>
<script src="/js/sys/userList.js"></script>

<link rel="stylesheet" type="text/css" href="/css/sys/allList.css"/>

<head>
    <title></title>
</head>

<body id="mainWin" class="easyui-layout">

<!-- 查询条件 -->
<div data-options="region:'north',title:'数据检索',iconCls:'icon-search'" style="height:100px; min-width: 700px">
    <fieldset>
        <legend>数据检索</legend>
        <table cellpadding="1">
            <tr>
                <td>用户名:</td>
                <td>
                    <input class="easyui-validatebox textbox" type="text" id="s_user_name"></input>
                </td>
                <td>角色:</td>
                <td>
                    <select class="easyui-combobox" data-options="panelHeight: 'auto',editable:false" id="s_role"
                            style="width:100px;">
                        <option value="">全部</option>
                        <option value="1">管理员</option>
                        <option value="0">普通用户</option>
                    </select>
                </td>
                <td>状态:</td>
                <td>
                    <select class="easyui-combobox" data-options="panelHeight: 'auto',editable:false" id="s_isdelete"
                            style="width:100px;">
                        <option value="">全部</option>
                        <option value="1">启用</option>
                        <option value="0">失效</option>
                    </select>
                </td>

                <td>
                    <a href="javascript:;" id="search" class="easyui-linkbutton" data-options="iconCls:'icon-search'"
                       onclick=""> 检索 </a>
                </td>
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