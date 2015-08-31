var title = "帮战";

$(function () {
    initData();
    initCs();
    // 绑定事件
    $("#search").click(search);// 数据检索
    $("#add").click(addForm);
    $("#edit").click(updateForm);
    $("#remove").click(remove);
    $("#reload").click(reload);
    $("#btn_gang").click(openGang);
})

function openGang(){
    var row = getSelectRow('list');
    if (row != null) {
        opentIframeForm("fwin", "帮战", "war_list.jsp?id=" + row.id, 500, 300);
    }
}

// 检索数据
function search() {
    $('#list').datagrid('load', {
        name: $("#s_title").val()
    });
}
// 刷新
function reload() {
    $("#list").datagrid('reload');
}

// 添加界面
function addForm() {
    opentForm("win", "新建" + title, "execute.jsp", 280, 400);
}

// 修改界面
function updateForm() {
    var row = getSelectRow('list');
    if (row != null) {
        opentForm("win", "修改" + title, "execute.jsp?id=" + row.id, 280, 400);
    }
}

// 删除数据
function remove() {
    var row = getSelectRow('list');
    if (row != null) {
        deleteData(row.name, "gangWarInfo-remove", {
            id: row.id
        });
    }
}
function initData() {
    $("#list").datagrid({
        method: "post",
        url: "gangWarInfo-get",
        fit: true,
        fitColumns: true,
        pagination: true,
        rownumbers: true,
        striped: true,
        singleSelect: true,

        columns: [
            [
                {
                    field: 'id',
                    hidden: true
                },

                {
                    field: 'icon',
                    title: '帮战logo',
                    align: 'center',
                    formatter: function (value, row, index) {
                        return '<img style="padding: 2px;border-radius:10px;" height="35px" width="35px" src="' + row.icon + '" />';
                    }
                },

                {
                    field: 'name',
                    title: '帮战名称',
                    align: 'center',
                    width: fixWidthTable()
                },
                {
                    field: 'start_time',
                    title: '开始时间',
                    align: 'center',
                    width: fixWidthTable()
                },
                {
                    field: 'end_time',
                    title: '结束时间',
                    align: 'center',
                    width: fixWidthTable()
                },
                {
                    field: 'interval',
                    title: '周期',
                    align: 'center',
                    width: fixWidthTable()
                }
                ,
                {
                    field: 'isOn',
                    title: '是否开启',
                    align: 'center',
                    width: fixWidthTable(),
                    formatter: function (value, row, index) {
                        return row.isOn == 1 ? "开启" : "未开启";
                    }
                }

            ]
        ],

        onLoadError: function () {
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
