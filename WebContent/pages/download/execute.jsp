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
				任务名称:
			</td>
			<th>
				<input class="easyui-validatebox textbox" placeholder="请输入用户名"
					type="text" id="name" name="name" data-options="required:true" />
			</th>
		</tr>
		<tr>
			<td>
                任务说明:
			</td>
			<th>
				<input class="easyui-validatebox textbox" placeholder="请输入任务说明"
					type="text" id="content" name="content"
					data-options="required:true" />
			</th>
		</tr>
		<tr>
			<td>
				任务类型:
			</td>
			<th>
				<select class="easyui-combobox"
					data-options="panelHeight: 'auto',editable:false " name="type"
					id="type" style="width: 100px;">
					<option value="默认" selected="selected">默认任务</option>
					<option value="帮会">帮会任务</option>
				</select>
				
			</th>

		</tr>
		<tr>
			<td>
				完成任务积分:
			</td>
			<th>
				<input id="score" name="score" class="easyui-numberspinner"
					style="width: 100%" required="required"
					data-options="min:0,max:99999999,precision:0" value="0">
			</th>
		</tr>
		<tr>
			<td>
				链接:
			</td>
			<th>
				<input class="easyui-validatebox textbox" placeholder="请输入链接"
					type="text" id="url" name="url" data-options="required:true" />
			</th>
		</tr>

		<tr>
			<td>
				图标:
			</td>
			<th>
				<a href="javascript:;" id="select_file" style="width: 150px"
					class="easyui-linkbutton" data-options="iconCls:'icon-search'">点击上传图片</a>
				<input name="file" id="imageBut" type="file" style="display: none;"
					ltype="text" />

				<input name="icon" id="icon" type="hidden" />
				<img class="image"  tag="icon" width="100px" height="100px" style="margin-top: 5px" />
			</th>
		</tr>
	</table>
	<div class="save-div">
		<a href="javascript:;" class="easyui-linkbutton"
			data-options="iconCls:'icon-save'" onclick="subMit()">保存</a>
	</div>

</form>