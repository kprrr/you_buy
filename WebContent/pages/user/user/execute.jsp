<%@ page contentType="text/html; charset=utf-8" language="java"
         errorPage="" %>
<link rel="stylesheet" type="text/css" href="/css/sys/allExecute.css"/>
<script>
    var id = "${param.id}"
</script>
<script src="js/execute.js"></script>

<form id="form" class="panl" method="post">
    <table border="0" width="100%" cellpadding="5" cellspacing="1"
           class="menus table_bg">
        <tr>
            <td width="70px">
                用户名:
            </td>
            <th width="150px">
                <input class="easyui-validatebox textbox" placeholder="请输入用户名"
                       type="text" id="name" name="name" data-options="required:true"/>
            </th>

            <td>
                密码:
            </td>
            <th>
                <input class="easyui-validatebox textbox" placeholder="请输入密码"
                       type="text" id="password" name="password"
                       data-options="required:true"/>
            </th>
        </tr>
        <tr>
            <td>
                性别:
            </td>
            <th>
                <select class="easyui-combobox"
                        data-options="panelHeight: 'auto',editable:false " name="male"
                        id="male" style="width: 50px;">
                    <option value="男" selected="selected">男</option>
                    <option value="女">女</option>
                </select>

            </th>

            <td>
                年龄:
            </td>
            <th>
                <input id="age" name="age" class="easyui-numberspinner"
                       style="width: 100%" required="required"
                       data-options="min:0,max:200,precision:0" value="0">
            </th>
        </tr>
        <tr>
            <td>
                手机号:
            </td>
            <th>
                <input class="easyui-validatebox textbox" placeholder="请输入手机号"
                       type="text" id="mobile" name="mobile" data-options="required:true"/>
            </th>

            <td>
                积分:
            </td>
            <th>
                <input id="score" name="score" class="easyui-numberspinner"
                       style="width: 100%" required="required"
                       data-options="min:0.00,max:9999999.99,precision:2" value="0">
            </th>
        </tr>
        <tr>
            <td>
                头像:
            </td>
            <th colspan="3">
                <a href="javascript:;" id="select_file" style="width: 150px"
                   class="easyui-linkbutton" data-options="iconCls:'icon-search'">点击上传图片</a>
                <br/>
                <input name="file" id="imageBut" type="file" style="display: none;"
                       ltype="text"/>

                <input name="icon" id="icon" type="hidden"/>
                <img class="image" tag="icon" width="100px" height="100px" style="margin-top: 5px"/>
            </th>
        </tr>
        <tr>

            <td>
                安卓地址:
            </td>
            <th  colspan="3">
                <a href="javascript:;" id="select_apk" style="width: 150px"
                   class="easyui-linkbutton" data-options="iconCls:'icon-search'">选择安卓推广app</a>
                <input name="file" id="btn_apk" type="file" style="display: none;"
                       ltype="text"/>

                <input name="apk" id="apk" type="hidden"/>

                <div style="width: 100px" id="apk_url">等待上传</div>


            </th>
        </tr>
        <td>
            IOS地址:
        </td>
        <th colspan="3">
            <a href="javascript:;" id="select_ipa" style="width: 150px;display:block;margin-top: 5px;"
               class="easyui-linkbutton" data-options="iconCls:'icon-search'">选择IOS推广app</a>
            <input name="file" id="btn_ipa" type="file" style="display: none;"
                   ltype="text"/>

            <input style="width: 100px" name="ipa" id="ipa" type="hidden"/>

            <div id="ipa_url">等待上传</div>

        </th>


    </table>
    <div class="save-div">
        <a href="javascript:;" class="easyui-linkbutton"
           data-options="iconCls:'icon-save'" onclick="subMit()">保存</a>
    </div>

</form>