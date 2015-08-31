var url = "/sysMenu-add";


$(function () {
    initView();
})
function initView() {
    if (id != "") {
        getDataNotCode("/sysMenu-get", {id: id}, function (json) {
            var menu = json[0];
            $('#form').form('load', {
                title: menu.text,
                url: menu.attributes.url
            });
        }, "win");
        url = "/sysMenu-update?id=" + id;
    }
}


function subMit() {
    $('#form').form('submit', {
        url: url,
        onSubmit: function (param) {
            param.super_id = superId;
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
                reload();
                //关闭窗体
                $('#win').window('close');
            } else {
                $.messager.show({
                    title: '提示',
                    msg: json.mess,
                    showType: 'show'
                });
            }
        }
    });
}