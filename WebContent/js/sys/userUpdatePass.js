$(function () {

})

function subMit() {
    $('#form').form('submit', {
        url: '/sysUser-updatePass',
        onSubmit: function (param) {
            var temp = $("#form").form('validate');

            if ($("#new_pass").val() != $("#_new_pass").val()) {
                $.messager.show({
                    title: '提示',
                    msg: '两次密码不一致!',
                    showType: 'slide'
                });
                temp = false;
            }
            if (temp) {
                ajaxLoading("mainWin");
            }
            return temp;
        },
        success: function (data) {
            ajaxLoadEnd();
            var json = JSON.parse(data);
            if (json.code == "1") {
                $.messager.show({
                    title: '提示',
                    msg: '密码更新成功,下次请用新密码登陆!',
                    showType: 'slide'
                });
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