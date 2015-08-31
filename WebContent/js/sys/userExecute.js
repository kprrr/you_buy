var url = "/sysUser-add";

$(function () {
    $('#tree_menu').tree({
        checkbox: true,
        url: '/sysMenu-get',
        parentField: "pid",
        textFiled: "text",
        idFiled: "id",
        onBeforeExpand: function (node, param) {
            $('#tree_menu').tree('options').url = "/sysMenu-get?super_id=null";
        },
        onLoadSuccess: initView//加载完毕后触发
    });
})

function initView() {
    $("#tree_menu").tree('collapseAll');
    $('#tree_menu').tree('options').animate = true;

    if (id != "") {
        url = "/sysUser-update?id=" + id;
        //加载数据
        getData("/sysUser-get", {id: id}, function (json) {
            var user = json.rows[0];
            $('#form').form('load', {
                user_name: user.user_name,
                pass_word: user.pass_word
            });
            //用户名只读
            $("#user_name").attr('disabled', 'disabled');
            $('#role').combobox('setValue', user.role);
            if (user.isdelete == 1) {//启用
                $("#isdelete").attr("checked", "checked")
            }
        }, "win");

        //用户权限自动选择
        getDataNotCode("/sysMenu-get", {uid: id}, function (json) {
            for (var i in json) {
                var node = $('#tree_menu').tree('find', json[i].id);
                $('#tree_menu').tree('check', node.target);
            }
        }, "win");
    }
}

function subMit() {
    var role = $("#role").combobox('getValue');
    var ids = "";
    //获取选择节点
    if (role == "0") {//普通用户
        var nodes = $('#tree_menu').tree('getChecked');
        for (var i = 0; i < nodes.length; i++) {
            ids += nodes[i].id + ",";
        }
        ids = ids.substring(0, ids.length - 1);
    }
    $('#form').form('submit', {
        url: url,
        onSubmit: function (param) {
            param.role = role;
            param.menus = ids;
            param.isdelete = $("#isdelete").attr("checked") ? 1 : 0;
            var temp = $("#form").form('validate');
            if (temp) {
                ajaxLoading("win");
            }
            return temp;
        },
        success: function (data) {
            ajaxLoadEnd();
            var json = JSON.parse(data);
            if (json.code == "1") {
                //刷新父窗体数据
                $("#list").datagrid('reload');
                //关闭窗体
                $('#win').window('close');
            } else {
                $.messager.show({
                    title: '提示',
                    msg: json.mess,
                    showType: 'slide'
                });
            }
        }
    });
}
