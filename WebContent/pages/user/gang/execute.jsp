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
			<td width="70px">
				帮户名称:
			</td>
			<th>
				<input class="easyui-validatebox textbox" placeholder="帮户名称"
					type="text" id="name" name="name" data-options="required:true" />
			</th>
		</tr>
		<tr>
			<td>
				帮户积分:
			</td>
			<th>
				<input id="scores" name="scores" class="easyui-numberspinner"
					style="width: 100%" required="required"
					data-options="min:0.00,max:9999999.99,precision:2" value="0">
			</th>
		</tr>
		<tr>
			<td>
				帮主:
			</td>
			<th>
				<input id="owner" name="owner" data-options="required:true">

			</th>
		</tr>
		<tr>
			<td>
				头像:
			</td>
			<th>
				<a href="javascript:;" id="select_file" style="width: 150px"
					class="easyui-linkbutton" data-options="iconCls:'icon-search'">点击上传图片</a>
				<input name="file" id="imageBut" type="file" style="display: none;"
					ltype="text" />

				<input name="icon" id="icon" type="hidden" />
				<img class="image" id="icon" tag="icon" width="100px" height="100px" style="margin-top: 5px" />
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