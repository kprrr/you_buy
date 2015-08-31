var title = "兑换记录";

var sumScoreDom;
$(function() {
	sumScoreDom = $("#sumScore");
	initData();
	initDay();
	initCs();
	// 绑定事件
	$("#search").click(search);// 数据检索
	$("#add").click(addForm);
	$("#edit").click(updateForm);
	$("#remove").click(remove);
	$("#reload").click(reload)

	$("#month_search").click(monthSearch);
})
// 计算当前月份 以及年限

var year;
function initDay() {
	var mydate = new Date();
	year = mydate.getFullYear();
	var month = mydate.getMonth() + 1;
	if (month.toString().length == 1) {
		month = "0" + month;
	}
	$('#s_month').combobox('select', month);
	monthSearch();
}

// 当月汇总
function monthSearch() {
	var msDom = $("#month_score");
	msDom.html("请稍后");
	var startTime = year + "-" + $("#s_month").combobox('getValue')
			+ "-01 00:00:00";
	var endTime = year + "-" + $("#s_month").combobox('getValue')
			+ "-33 00:00:00";
	var data = {
		uid : id,
		strarTime : startTime,
		endTime : endTime
	};
	getData("scoreRecord-getSumScore", data, function(json) {
		msDom.html("总计:" + json.mess);
	});
}

// 检索数据
function search() {
	$('#list').datagrid('load', {
		type2 : $("#s_type").combobox('getValue'),
		strarTime : $("#start_time").datebox('getValue'),
		endTime : $("#end_time").datebox('getValue')
	});
	getSumScore();
}
// 刷新
function reload() {
	$("#list").datagrid('reload');
}

// 总积分
function getSumScore() {
	sumScoreDom.html("加载中");
	var data = {
		type2 : $("#s_type").combobox('getValue'),
		uid : id,
		strarTime : $("#start_time").datebox('getValue'),
		endTime : $("#end_time").datebox('getValue')
	}

	getData("scoreRecord-getSumScore", data, function(json) {
		sumScoreDom.html(json.mess + "分");
	});
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
	getSumScore();
	$("#list").datagrid( {
		method : "post",
		url : "scoreRecord-get?uid=" + id,
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

		/*
		 * { field : 'icon', title : '头像', align : 'center', width :
		 * fixWidthTable()/2, formatter: function (value, row, index) { return '<img
		 * style="padding: 2px;border-radius:10px;" height="35px" width="35px"
		 * src="' + row.icon + '" />'; } }, { field : 'attach_name', title :
		 * '用户名', align : 'center', width : fixWidthTable() },
		 */
		{
			field : 'score',
			title : '积分',
			align : 'center',
			width : fixWidthTable()
		}, {
			field : 'info',
			title : '简介',
			align : 'center',
			width : fixWidthTable()
		}, {
			field : 'timestamp',
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
