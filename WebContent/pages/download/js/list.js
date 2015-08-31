var title = "任务";

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
		name : $("#s_title").val(),
        type : $("#s_type").combobox('getValue')
	});
//	,

}
// 刷新
function reload() {
	$("#list").datagrid('reload');
}

// 添加界面
function addForm() {
	opentForm("win", "新建" + title, "execute.jsp", 280, 450);
}

// 修改界面
function updateForm() {
	var row = getSelectRow('list');
	if (row != null) {
		opentForm("win", "修改" + title, "execute.jsp?id=" + row.id, 280, 450);
	}
}

// 删除数据
function remove() {
	var row = getSelectRow('list');
	if (row != null) {
		deleteData(row.name, "gangTask-remove", {
			id : row.id
		});
	}
}
function initData() {
	$("#list").datagrid( {
		method : "post",
		url : "gangTask-get",
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
			field : 'icon',
			title : '图标',
			align : 'center',
			width : fixWidthTable()/2,
			formatter: function (value, row, index) {
                return '<img style="padding: 2px;border-radius:10px;" height="35px" width="35px" src="' + row.icon + '" />';
            }
		}, {
			field : 'name',
			title : '任务名称',
			align : 'center',
			width : fixWidthTable()
		}, {
			field : 'content',
			title : '说明',
			align : 'center',
			width : fixWidthTable()
		}, {
			field : 'score',
			title : '完成任务积分',
			align : 'center',
			width : fixWidthTable()
		}, {
			field : 'url',
			title : '链接',
			align : 'center',
			width : fixWidthTable()
		}, {
			field : 'type',
			title : '任务类型',
			align : 'center',
			width : fixWidthTable()
		} ] ],

		onLoadError : function() {
			ShowMessage('提示', '数据加载失败！', 'error');
		}
	});
}
