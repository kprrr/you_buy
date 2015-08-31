var title = "列车";

$(function() {
	initData();
	// 绑定事件
	$("#reload").click(reload);
    $("#add").click(addForm);
    $("#edit").click(updateForm);
    $("#remove").click(remove);
})
// 刷新
function reload() {
	$("#list").datagrid('reload');
}

// 添加界面
function addForm() {
	opentForm("win", "新建" + title, "war_execute.jsp", 280, 170);
}

// 修改界面
function updateForm() {
	var row = getSelectRow('list');
	if (row != null) {
		opentForm("win", "修改" + title, "war_execute.jsp?id=" + row.id, 280, 170);
	}
}

// 删除数据
function remove() {
	var row = getSelectRow('list');
	if (row != null) {
		deleteData(row.title, url.WebTrainDelete, {
			id : row.id
		});
	}
}
function initData() {
	$("#list").datagrid( {
		method : "post",
		url: "gangWar-get?war_info_id="+id,
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
			field : 'gang_name',
			title : '帮会名',
			align : 'center',
			width : fixWidthTable()
		},
		

		{
			field : 'score',
			title : '总得分',
			align : 'center',
			width : fixWidthTable()
		},
		{
			field : 'mem_num',
			title : '参与人数',
			align : 'center',
			width : fixWidthTable()
		}

		] ],

		onLoadError : function() {
			ShowMessage('提示', '数据加载失败！', 'error');
		}
	});
}

