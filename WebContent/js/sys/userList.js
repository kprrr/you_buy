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
		user_name : $("#s_user_name").val(),
		role : $("#s_role").combobox('getValue'),
		isdelete : $("#s_isdelete").combobox('getValue')
	});
}
// 刷新
function reload() {
	$("#list").datagrid('reload');
}

// 添加界面
function addForm() {
	opentForm("win", "新建用户信息", "/pages/sys/user_execute.jsp", 490, 300);
}

// 修改界面
function updateForm() {
	var row = getSelectRow('list');
	if (row != null) {
		opentForm("win", "修改用户信息", "/pages/sys/user_execute.jsp?id=" + row.id,
				490, 300);
	}
}

// 删除数据
function remove() {
	var row = getSelectRow('list');
	if (row != null) {
		$.messager.confirm('确认', '您确认想要删除[' + row.user_name + ']吗?',
				function(r) {
					if (r) {
						// 发送删除请求
				getDataNotCode("/sysUser-remove", {
					id : row.id
				}, function(json) {
					$.messager.show( {
						title : '提示',
						msg : '删除数据成功!',
						showType : 'slide'
					});
					// 刷新数据
						$("#list").datagrid('reload');
					}, "mainWin");
			}
		});
	}
}

function initData() {
	$("#list").datagrid( {
		method : "post",
		url : "sysUser-get",
		fit : true,
		fitColumns : true,
		pagination : true,
		rownumbers : true,
		striped : true,
		singleSelect : true,

		columns : [ [ {
			field : 'id',
			hidden : true
		}, {
			field : 'user_name',
			title : '登陆账户',
			align : 'center',
			width : fixWidthTable()
		}, {
			field : 'pass_word',
			title : '登陆密码',
			align : 'center',
			width : fixWidthTable()
		}, {
			field : 'role',
			title : '身份',
			align : 'center',
			width : fixWidthTable(),
			formatter : function(value, row, index) {
				return row.role == 1 ? "管理员" : "普通用户"
			}
		}, {
			field : 'createtime',
			title : '创建时间',
			align : 'center',
			width : fixWidthTable()
		}, {
			field : 'isdelete',
			title : '状态',
			align : 'center',
			width : fixWidthTable(),
			formatter : function(value, row, index) {
				return row.isdelete == 0 ? "启用" : "失效"
			}
		} ] ],

		onLoadError : function() {
			ShowMessage('提示', '数据加载失败！', 'error');
		}
	});
}
