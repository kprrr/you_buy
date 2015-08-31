var title = "用户";

$(function () {
    initData();
    initCs();
    // 绑定事件
    $("#search").click(search);// 数据检索
    $("#add").click(addForm);
    $("#edit").click(updateForm);
    $("#remove").click(remove);
    $("#reload").click(reload);

    $("#btn_score_record").click(scoreRecord);
    $("#btn_fan").click(fan);

    $("#btn_gang").click(gang);//所属帮户
})

function gang() {
    var row = getSelectRow('list');
    if (row != null) {
        opentIframeForm("fwin", "帮会", "gang_list.jsp?id=" + row.id, 700, 400);
    }
}

function fan() {
    var row = getSelectRow('list');
    if (row != null) {
        opentIframeForm("fwin", "用户粉丝", "fan_list.jsp?id=" + row.id, 700, 400);
    }
}

function scoreRecord() {
    var row = getSelectRow('list');
    if (row != null) {
        opentIframeForm("fwin", "积分 兑换记录", "score_record_list.jsp?id=" + row.id, 700, 400);
    }
}

// 检索数据
function search() {
    $('#list').datagrid('load', {
    	prize_code: $("#s_title").val()
    });
//	car_segment_id : $("#s_car_segment_id").combobox('getValue'),

}
// 刷新
function reload() {
    $("#list").datagrid('reload');
}

// 添加界面
function addForm() {
    opentForm("win", "新建" + title, "execute.jsp", 530, 460);
}

// 修改界面
function updateForm() {
    var row = getSelectRow('list');
    if (row != null) {
        opentForm("win", "修改" + title, "execute.jsp?id=" + row.id, 530, 460);
    }
}

// 删除数据
function remove() {
    var row = getSelectRow('list');
    if (row != null) {
        deleteData(row.name, "banner-remove", {
            id: row.id
        });
    }
}
function initData() {
    $("#list").datagrid({
        method: "post",
        url: "userPrizeA-get",
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
                    field: 'prize_code',
                    title: '奖券兑换号',
                    align: 'center',
                    width: fixWidthTable()
                },

                {
                    field: 'prize',
                    title: '奖品信息',
                    align: 'center',
                    width: fixWidthTable()
                },
                {
                    field: 'info',
                    title: '奖品信息',
                    align: 'center',
                    width: fixWidthTable()
                }
                
//                ,
//                {
//                    field: 'got',
//                    title: '是否领取',
//                    align: 'center',
//                    width: fixWidthTable(),
//                    formatter: function (value, row, index) {
//                        return row.got==1?"领取":"未领取";
//                    }
//                }
                
                ,
                {
                    field: 'timestamp',
                    title: '获取时间',
                    align: 'center',
                    width: fixWidthTable()
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
