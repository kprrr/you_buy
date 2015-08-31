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
				场馆名称:
			</td>
			<th>
				<input class="easyui-validatebox textbox" placeholder="请输入场馆名称"
					type="text" id="title" name="title" data-options="required:true" />
			</th>
		</tr>
		<tr>
			<td>
				类型:
			</td>
			<th>
				<input class="easyui-validatebox textbox" placeholder="请输入简介"
					type="text" id="content" name="content"
					data-options="required:true" />
			</th>
		</tr>
		<tr>
			<td>
				图片:
			</td>
			<th>
				<input id="author" name="author" data-options="required:true">

			</th>
		</tr>
		<tr>
			<td>
				价格:
			</td>
			<th>
				<input id="author" name="author" data-options="required:true">

			</th>
		</tr>
		<tr>
			<td>
				地址:
			</td>
			<th>
				<input id="author" name="author" data-options="required:true">

			</th>
		</tr>
		<tr>
			<td>
				所属区域:
			</td>
			<th>
				<input id="author" name="author" data-options="required:true">

			</th>
		</tr>
		<tr>
			<td>
				电话:
			</td>
			<th>
				<input id="author" name="author" data-options="required:true">

			</th>
		</tr>
		<tr>
			<td>
				经度:
			</td>
			<th>
				<input id="author" name="author" data-options="required:true">

			</th>
		</tr>
		<tr>
			<td>
				纬度:
			</td>
			<th>
				<input id="author" name="author" data-options="required:true">

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