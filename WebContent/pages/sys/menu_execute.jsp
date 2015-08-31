<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<link rel="stylesheet" type="text/css" href="/css/sys/allExecute.css"/>
<script>
    var id = "${param.id}"
    var superId = '${param.superId}';
</script>
<script src="/js/sys/menuExecute.js"></script>

<form id="form" class="panl" method="post">
    <fieldset class="menus">
        <legend>信息填写</legend>
        <table cellpadding="1">
            <c:if test="${param.id==null}">
                <tr>
                    <td>上级节点:</td>
                    <td>
                        <input class="easyui-validatebox textbox" type="text" name="super_name"
                               value="${param.superName}" disabled="disabled"></input>
                    </td>
                </tr>
            </c:if>

            <tr>
                <td>节点名称:</td>
                <td><input class="easyui-validatebox textbox" type="text" name="title" data-options="required:true"/>
                </td>
            </tr>
            <tr>
                <td>请求地址:</td>
                <td><input class="easyui-validatebox textbox" type="text" name="url"/></td>
            </tr>


        </table>
    </fieldset>

    <div class="save-div">
        <a href="javascript:;" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="subMit()">保存</a>
    </div>
</form>