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
				标题:
			</td>
			<th width="150px">
				<input class="easyui-validatebox textbox" placeholder="请输入标题"
					type="text" id="titile" name="titile" data-options="required:true" />
			</th>
			<td>
				是否有效:
			</td>
			<th>
				<select class="easyui-combobox"
					data-options="panelHeight: 'auto',editable:false " name="valid"
					id="valid" style="width: 50px;">
					<option value="1" selected="selected">有效</option>
					<option value="0">无效</option>
				</select>
			</th>
		</tr>
		<tr>
			<td width="70px">
				广告位置:
			</td>
			<th>
				<input class="easyui-validatebox textbox" placeholder="请输入广告位置"
					type="text" id="pos" name="pos" data-options="required:true" />
			</th>
			<td width="70px">
				类别:
			</td>
			<th>
				<select class="easyui-combobox"
					data-options="panelHeight: 'auto',editable:false " name="type"
					id="type" style="width: 150px;">
					<option value="1" selected="selected">不可点击</option>
					<option value="2">点击出现内容页</option>
					<option value="3">点击跳转网页</option>
				</select>
			</th>
		</tr>
		
		<tr>
			<td>
				简介:
			</td>
			<th colspan="3">
				<textarea class="easyui-validatebox textbox" placeholder="请输入简介"
					type="text" id="content" name="content" style="height: 150px; width: 90%"
					data-options="required:true"></textarea>
			</th>
		</tr>

		<tr>
			<td width="70px">
				链接:
			</td>
			<th colspan="3">
				<input class="easyui-validatebox textbox" placeholder="请输入链接"
					type="text" id="info_url" name="info_url" data-options="required:true" />
			</th>
		</tr>

		<tr>
			<td>
				图片1:
			</td>
			<th colspan="3">
				<a href="javascript:;" id="btn_pic_url" style="width: 150px"
					class="easyui-linkbutton" data-options="iconCls:'icon-search'">点击上传图片</a>
				<br />
				<input name="file" id="file_pic_url" type="file"
					style="display: none;" ltype="text" />
				<input name="pic_url" id="pic_url" type="hidden" />
				<img id="img_pic_url" class="image" tag="pic_url" alt="" height="80px"
					src="">
			</th>
		</tr>
		<tr>
			<td>
				图片2:
			</td>
			<th colspan="3">
				<a href="javascript:;" id="btn_pic_url2" style="width: 150px"
					class="easyui-linkbutton" data-options="iconCls:'icon-search'">点击上传图片</a>
				<br />
				<input name="file" id="file_pic_url2" type="file" style="display: none;"
					ltype="text" />
				<input name="pic_url2" id="pic_url2" type="hidden"/>
				<img alt="" id="img_pic_url2" class="image" tag="pic_url2"  height="80px" src="">
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