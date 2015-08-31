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
					type="text" id="name" name="name" data-options="required:true" />
			</th>
		</tr>
		<tr>
			<td>
				类型:
			</td>
			<th>
				<input class="easyui-validatebox textbox" placeholder="请输入类型"
					type="text" id="type" name="type"
					data-options="required:true" />
			</th>
		</tr>
		<tr>
			<td>
				图片:
			</td>
			<th>
				<input type="file" name="img" data-options="prompt:'Choose a file...'" >

			</th>
		</tr>
		<tr>
			<td>
				价格:
			</td>
			<th>
				<input class="easyui-validatebox textbox" placeholder="请输入价格"
					type="text" id="price" name="price" data-options="required:true" />元/小时

			</th>
		</tr>
		<tr>
			<td>
				地址:
			</td>
			<th>
				<input class="easyui-validatebox textbox" placeholder="请输入场馆地址，限100个字符"
					type="text" id="place" name="place" data-options="required:true" />

			</th>
		</tr>
		<tr>
			<td>
				所属区域:
			</td>
			<th>
				<select class="easyui-combobox" 
				id="region_id" name="region_id" data-options="required:true" >
				<option value="请选择" >请选择</option>
				</select>

			</th>
		</tr>
		<tr>
			<td>
				电话:
			</td>
			<th>
				<input class="easyui-validatebox textbox" placeholder="请输输入场馆联系电话"
					type="text" id="tel" name="tel" data-options="required:true" />

			</th>
		</tr>
		<tr>
			<td>
				经度:
			</td>
			<th>
				<input class="easyui-validatebox textbox" placeholder="请输入场馆经度"
					type="text" id="Longitude" name="Longitude" data-options="required:true" />

			</th>
		</tr>
		<tr>
			<td>
				纬度:
			</td>
			<th>
				<input class="easyui-validatebox textbox" placeholder="请输入场馆纬度"
					type="text" id="Latitude" name="Latitude" data-options="required:true" />

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