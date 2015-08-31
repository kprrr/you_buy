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
				用户:
			</td>
			<th>
				<input id="uid" name="uid" data-options="required:true">
			</th>
		</tr>
		<tr>
			<td>
				粉丝:
			</td>
			<th>
				<input id="fan" name="fan" data-options="required:true">
			</th>
		</tr>
	</table>
	<div class="save-div">
		<a href="javascript:;" class="easyui-linkbutton"
			data-options="iconCls:'icon-save'" onclick=
	subMit();
>保存</a>
	</div>

</form>