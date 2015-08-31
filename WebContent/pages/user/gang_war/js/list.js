var title = "列车";

$(function() {
	initData();
	initCs();
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
		car_segment_id : $("#s_car_segment_id").combobox('getValue'),
		title : $("#s_title").val()
	});
}
// 刷新
function reload() {
	$("#list").datagrid('reload');
}

// 添加界面
function addForm() {
	opentForm("win", "新建" + title, "execute.jsp", 280, 170);
}

// 修改界面
function updateForm() {
	var row = getSelectRow('list');
	if (row != null) {
		opentForm("win", "修改" + title, "execute.jsp?id=" + row.id, 280, 170);
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
		// url: url.WebTrainList,
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
			title : '帮战logo',
			align : 'center',
			width : fixWidthTable()
		},
		
		{
			field : 'name',
			title : '帮派名',
			align : 'center',
			width : fixWidthTable()
		},
		{
			field : 'scores',
			title : '帮会积分',
			align : 'center',
			width : fixWidthTable()
		},
		{
			field : 'mem_num',
			title : '参与人数',
			align : 'center',
			width : fixWidthTable()
		}, {
			field : 'c',
			title : '总得分',
			align : 'center',
			width : fixWidthTable()
		}
		, {
			field : 'age',
			title : '年龄',
			align : 'center',
			width : fixWidthTable()
		} 
		, {
			field : 'mobile',
			title : '手机号码',
			align : 'center',
			width : fixWidthTable()
		} 
		, {
			field : 'score',
			title : '积分',
			align : 'center',
			width : fixWidthTable()
		} 
		, {
			field : 'addtime',
			title : '创建时间',
			align : 'center',
			width : fixWidthTable()
		} 
		] ],

		onLoadError : function() {
			ShowMessage('提示', '数据加载失败！', 'error');
		}
	});
}

function initCs() {
	var cs = new initWithCommbox("s_car_segment_id");
	cs.setUrl(url.WebCarSegmentList + "?selectMenu=id,title");
	cs.setIsAll(true);
	cs.loadData();
}
