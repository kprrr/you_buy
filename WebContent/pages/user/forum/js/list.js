var title = "论坛";

$(function() {
	initData();
	// 绑定事件
	$("#search").click(search);// 数据检索
	$("#add").click(addForm);
	$("#edit").click(updateForm);
	$("#remove").click(remove);
	$("#reload").click(reload);
	$("#btn_result").click(reslut);
	$("#btn_tops").click(settingTop);
})

function settingTop() {
	var row = getSelectRow('list');
	if (row != null) {
		getData("post-update",{id:row.id,is_top:1},function(json){
			 //刷新数据
            $("#list").datagrid('reload');
		});
	}
}

function reslut() {
	var row = getSelectRow('list');
	if (row != null) {
		opentIframeForm("fwin", "回帖", "result_list.jsp?id=" + row.id, 700, 400);
	}
}

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
	opentForm("win", "新建" + title, "execute.jsp", 280, 200);
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
	$("#list").datagrid( {
		method : "post",
		url : "post-get?category=2",
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
			field : 'title',
			title : '帖子名称',
			align : 'center',
			width : fixWidthTable()
		}, {
			field : 'content',
			title : '简介',
			align : 'center',
			width : fixWidthTable()
		}, {
			field : 'attach_name',
			title : '创建人',
			align : 'center',
			width : fixWidthTable()
		}, {
			field : 'time',
			title : '创建时间',
			align : 'center',
			width : fixWidthTable()
		} ] ],

		onLoadError : function() {
			ShowMessage('提示', '数据加载失败！', 'error');
		}
	});
}
