<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<link rel="stylesheet" type="text/css" href="/css/sys/allExecute.css"/>
<script>
    var id = "${param.id}"
</script>
<script src="/js/sys/userExecute.js"></script>

<form id="form" class="panl" method="post">
    <fieldset>
        <legend>信息填写</legend>
        <table cellpadding="1">
            <tr>
                <td>用户名:</td>
                <td>
                    <input class="easyui-validatebox textbox" type="user_name" id="user_name" name="user_name"
                           data-options="required:true"></input>
                </td>
                <td>密码:</td>
                <td>
                    <input class="easyui-validatebox textbox" type="password" id="pass_word" name="pass_word"
                           data-options="required:true"></input>
                </td>
            </tr>
            <tr>
                <td>状态:</td>
                <td><input type="checkbox" id="isdelete" title="启用" value="1"/>启用</td>
            </tr>
            <tr>
                <td>角色:</td>
                <td colspan="3">
                    <select class="easyui-combobox" data-options="panelHeight: 'auto',editable:false " id="role"
                            style="width:154px;">
                        <option value="1">管理员</option>
                        <option value="0" selected="selected">普通用户</option>
                    </select>
                    <span class="span">管理员不需要选择权限</span>
                </td>
            </tr>

        </table>

    </fieldset>

    <fieldset class="menus">
        <legend>权限选择</legend>
        <div>
            <ul id="tree_menu"></ul>
        </div>
    </fieldset>

    <div class="save-div">
        <a href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="subMit()">保存</a>
    </div>

</form>