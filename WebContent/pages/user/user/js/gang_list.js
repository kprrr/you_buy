var title = "帮会";

$(function() {
	initData();
	// 绑定事件
	$("#search").click(search);// 数据检索
	$("#add").click(addForm);
	$("#edit").click(updateForm);
	$("#remove").click(remove);
	$("#reload").click(reload);
	
	$("#btn_arti").click(openArti);//打开建筑
	$("#btn_game").click(openGame);//打开游戏
	$("#btn_user").click(openUser);//打开成员
})

function openUser(){
	var row = getSelectRow('list');
	if (row != null) {
		opentIframeForm("fwin", "帮会成员", "user_list.jsp?gangId=" + row.id, 700, 500);
	}
}

function openArti(){
	var row = getSelectRow('list');
	if (row != null) {
		opentIframeForm("fwin", "帮会建筑", "arti_list.jsp?gangId=" + row.id, 700, 500);
	}
}
function openGame(){
	var row = getSelectRow('list');
	if (row != null) {
		opentIframeForm("fwin", "帮会游戏", "game_list.jsp?gangId=" + row.id, 700, 500);
	}
}

// 检索数据
function search() {
	$('#list').datagrid('load', {
		g_name : $("#s_title").val()
	});
}
// 刷新
function reload() {
	$("#list").datagrid('reload');
}

// 添加界面
function addForm() {
	opentForm("win", "新建" + title, "execute.jsp", 280, 350);
}

// 修改界面
function updateForm() {
	var row = getSelectRow('list');
	if (row != null) {
		opentForm("win", "修改" + title, "execute.jsp?id=" + row.id, 280, 350);
	}
}

// 删除数据
function remove() {
	var row = getSelectRow('list');
	if (row != null) {
		deleteData(row.name, "gang-remove", {
			id : row.id
		});
	}
}
function initData() {
	$("#list").datagrid( {
		method : "post",
		url : "gangship-get?userid=" + id,
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
			field : 'g_icon',
			title : '帮会logo',
			align : 'center',
			width : fixWidthTable()/2,
			formatter: function (value, row, index) {
                return '<img style="padding: 2px;border-radius:10px;" height="35px" width="35px" src="' + row.icon + '" />';
            }
		},
		
		{
			field : 'g_name',
			title : '帮会名称',
			align : 'center',
			width : fixWidthTable()
		},
		{
			field : 'g_scores',
			title : '帮会积分',
			align : 'center',
			width : fixWidthTable()
		}
		] ],

		onLoadError : function() {
			ShowMessage('提示', '数据加载失败！', 'error');
		}
	});
}
