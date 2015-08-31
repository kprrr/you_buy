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
		name : $("#s_title").val()
	});
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
		deleteData(row.name, "user-remove", {
			id : row.id
		});
	}
}
function initData() {
	$("#list").datagrid( {
		method : "post",
		url : "gangship-get",
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
			title : '头像',
			align : 'center',
			width : fixWidthTable()/2,
			formatter: function (value, row, index) {
                return '<img style="padding: 2px;border-radius:10px;" height="35px" width="35px" src="' + row.icon + '" />';
            }
		}, {
			field : 'name',
			title : '用户名',
			align : 'center',
			width : fixWidthTable()
		}, {
			field : 'password',
			title : '密码',
			align : 'center',
			width : fixWidthTable()
		}, {
			field : 'male',
			title : '性别',
			align : 'center',
			width : fixWidthTable()
		}, {
			field : 'age',
			title : '年龄',
			align : 'center',
			width : fixWidthTable()
		}, {
			field : 'mobile',
			title : '手机号码',
			align : 'center',
			width : fixWidthTable()
		}, {
			field : 'score',
			title : '积分',
			align : 'center',
			width : fixWidthTable()
		}, {
			field : 'addtime',
			title : '创建时间',
			align : 'center',
			width : fixWidthTable()
		} ] ],

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
