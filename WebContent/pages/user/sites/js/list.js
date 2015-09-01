var title = "场馆";

$(function() {
	initData();
	// 绑定事件
	$("#search").click(search);// 数据检索
	$("#add").click(addForm);
	$("#edit").click(updateForm);
	$("#remove").click(remove);
	$("#reload").click(reload);
})
// 检索数据
function search() {
	$('#list').datagrid('load', {
		title : $("#s_title").val()
	});
}
// 刷新
function reload() {
	$("#list").datagrid('reload');
}

// 添加界面
function addForm() {
	opentForm("win", "新建" + title, "execute.jsp", 380, 300);
}

// 修改界面
function updateForm() {
	var row = getSelectRow('list');
	if (row != null) {
		opentForm("win", "修改" + title, "execute.jsp?id=" + row.id, 280, 200);
	}
}

// 删除数据
function remove() {
	var row = getSelectRow('list');
	if (row != null) {
		deleteData(row.title, "post-remove", {
			id : row.id
		});
	}
}
function initData() {
	$.post('site-get',function(json){
		var data = json.data;
		listInitial(data);
	},'json');
	
}
function listInitial(data){
	$("#list").datagrid( {
		method : "post",
//		url : "site-get",
		data:data,
		fit : true,
		fitColumns : true,
		pagination : true,
		rownumbers : true,
		striped : true,
		singleSelect : true,

		columns : [ [ {
			field : 'id',
			hidden : true
		},

		{
			field : 'name',
			title : '场馆名称',
			align : 'center',
			width : fixWidthTable()
		}, {
			field : 'type',
			title : '类型',
			align : 'center',
			width : fixWidthTable()
		}, {
			field : 'img',
			title : '图片路径',
			align : 'center',
			width : fixWidthTable()
		}, {
			field : 'price',
			title : '价格',
			align : 'center',
			width : fixWidthTable()
		},{
			field : 'place',
			title : '地址',
			align : 'center',
			width : fixWidthTable()
		},{
			field : 'region_id',
			title : '所属区域',
			align : 'center',
			width : fixWidthTable()
		},{
			field : 'tel',
			title : '电话',
			align : 'center',
			width : fixWidthTable()
		},{
			field : 'longitude',
			title : '经度',
			align : 'center',
			width : fixWidthTable()
		},{
			field : 'latitude',
			title : '纬度',
			align : 'center',
			width : fixWidthTable()
		},{
			field : 'createtime',
			title : '创建时间',
			align : 'center',
			width : fixWidthTable()
		} ] ],

		onLoadError : function() {
			ShowMessage('提示', '数据加载失败！', 'error');
		}
	});
}

