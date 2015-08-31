var title = "秘籍";

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
	opentForm("win", "新建" + title, "execute.jsp", 280, 150);
}

// 修改界面
function updateForm() {
	var row = getSelectRow('list');
	if (row != null) {
		opentForm("win", "修改" + title, "execute.jsp?id=" + row.id, 280, 150);
	}
}

// 删除数据
function remove() {
	var row = getSelectRow('list');
	if (row != null) {
		deleteData(row.u_name,"fans-remove", {
			id : row.id
		});
	}
}
function initData() {
	$("#list").datagrid( {
		method : "post",
		url : "fans-get",
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
			field : 'u_icon',
			title : '头像',
			align : 'center',
			width : fixWidthTable()/2,
			formatter: function (value, row, index) {
                return '<img style="padding: 2px;border-radius:10px;" height="35px" width="35px" src="' + row.u_icon + '" />';
            }
		}, {
			field : 'u_name',
			title : '用户名',
			align : 'center',
			width : fixWidthTable()
		}, {
			field : 'fan_name',
			title : '粉丝名称',
			align : 'center',
			width : fixWidthTable()
		}, {
			field : 'fan_icon',
			title : '粉丝头像',
			align : 'center',
			width : fixWidthTable()/2,
			formatter: function (value, row, index) {
                return '<img style="padding: 2px;border-radius:10px;" height="35px" width="35px" src="' + row.fan_icon + '" />';
            }
		}, {
			field : 'fan_male',
			title : '粉丝性别',
			align : 'center',
			width : fixWidthTable()
		}, {
			field : 'fan_age',
			title : '粉丝年龄',
			align : 'center',
			width : fixWidthTable()
		}, {
			field : 'fan_mobile',
			title : '粉丝手机号码',
			align : 'center',
			width : fixWidthTable()
		}, {
			field : 'fan_score',
			title : '粉丝积分',
			align : 'center',
			width : fixWidthTable()
		}

		] ],

		onLoadError : function() {
			ShowMessage('提示', '数据加载失败！', 'error');
		}
	});
}

