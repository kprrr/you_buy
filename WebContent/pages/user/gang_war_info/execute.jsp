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
            <td>
                帮战名称:
            </td>
            <th width="150px">
                <input class="easyui-validatebox textbox" placeholder="请输入帮战名称"
                       type="text" id="name" name="name" data-options="required:true"/>
            </th>
        </tr>
        <tr>
            <td>
                开始时间:
            </td>
            <th>
                <input id="start_time" name="start_time"
                       type="text" class="easyui-datetimebox"
                       data-options="required:true,editable:false">
            </th>
        </tr>
        <tr>
            <td>
                结束时间:
            </td>
            <th>
                <input id="end_time" name="end_time"
                       validType="timeCheck['start_time']" invalidMessage="结束时间必须大于开始时间"
                       type="text" class="easyui-datetimebox"
                       data-options="required:true,editable:false">
            </th>
        </tr>

        <tr>
            <td>
                周期:
            </td>
            <th>
                <input id="interval" name="interval" class="easyui-numberspinner"
                       style="width: 100%" required="required"
                       data-options="min:0,max:200,precision:0" value="0">
            </th>

        </tr>
        <tr>
            <td>
                是否开启:
            </td>
            <th>
                <select class="easyui-combobox"
                        data-options="panelHeight: 'auto',editable:false " name="isOn"
                        id="isOn" style="width: 50px;">
                    <option value="1" selected="selected">开启</option>
                    <option value="0">未开启</option>
                </select>

            </th>

        </tr>

        <tr>
            <td>
                图标:
            </td>
            <th>
                <a href="javascript:;" id="select_file" style="width: 150px"
                   class="easyui-linkbutton" data-options="iconCls:'icon-search'">点击上传图片</a>
                <br/>
                <input name="file" id="imageBut" type="file" style="display: none;"
                       ltype="text"/>

                <input name="icon" id="icon" type="hidden"/>
                <img class="image" tag="icon" width="100px" height="100px" style="margin-top: 5px"/>
            </th>
        </tr>


    </table>
    <div class="save-div">
        <a href="javascript:;" class="easyui-linkbutton"
           data-options="iconCls:'icon-save'" onclick="subMit()">保存</a>
    </div>

</form>