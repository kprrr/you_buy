var title = "下载量";

$(function () {
    initData();
    // 绑定事件
    $("#edit").click(updateForm);
    $("#reload").click(reload);
})

// 刷新
function reload() {
    $("#list").datagrid('reload');
}

// 修改界面
function updateForm() {
    var row = getSelectRow('list');
    if (row != null) {
        opentForm("win", "修改" + title, "execute.jsp?id=" + row.id, 280, 200);
    }
}
function initData() {
    $("#list").datagrid({
        method: "post",
        url: "downloads-get",
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
                    field: 'apk',
                    title: '安卓下载量',
                    align: 'center',
                    width: fixWidthTable()
                },

                {
                    field: 'ipa',
                    title: 'IOS下载量',
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
