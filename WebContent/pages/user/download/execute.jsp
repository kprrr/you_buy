<%@ page contentType="text/html; charset=utf-8" language="java"
	errorPage=""%>
<link rel="stylesheet" type="text/css" href="/css/sys/allExecute.css" />
<script>
	var id = "${param.id}"
</script>
<script src="js/execute.js"></script>

<form id="form" class="panl" method="post">
	<table border="0" width="100%" cellpadding="5" cellspacing="1"
		class="menus table_bg">
		<tr>
			<td>
				安卓下载量:
			</td>
			<th>
				<input id="apk" name="apk" class="easyui-numberspinner"
					style="width: 100%" required="required"
					data-options="min:0,max:99999999999,precision:0" value="0">
			</th>
		</tr>
        <tr>
            <td>
                IOS下载量:
            </td>
            <th>
                <input id="ipa" name="ipa" class="easyui-numberspinner"
                       style="width: 100%" required="required"
                       data-options="min:0,max:99999999999,precision:0" value="0">
            </th>
        </tr>
	</table>
	<div class="save-div">
		<a href="javascript:;" class="easyui-linkbutton"
			data-options="iconCls:'icon-save'" onclick="subMit()">保存</a>
	</div>

</form>