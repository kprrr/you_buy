$(function () {
    //initMenu();
    $("#logOut").click(function () {
        $.messager.confirm('确认', '确定退出登陆吗?', function (r) {
            if (r) {
                window.location.href = "/sysUser-logOut";
            }
        });

    });
});

//初始化功能列表
function initMenu() {
    $('#menus').tree({
        url: '/sysMenu-get',
        parentField: "pid",
        textFiled: "text",
        idFiled: "id",
        onBeforeExpand: function (node, param) {
            $('#menus').tree('options').url = "/sysMenu-get?super_id=null";
        },
        onClick: function (node) {
            if (node.attributes.url) {
                //打开新窗口
                addMenuTab(node.text, node.attributes.url);
            }

        },
        onLoadSuccess: function () {//加载完毕后触发
            //展开全部菜单
            $("#menus").tree('expandAll');
            $('#menus').tree('options').animate = true;
        }
    });
}

function addMenuTab(title, url) {
    if (!$('#tabs').tabs('exists', title)) {
        var from = '<iframe name="mainFrame" scrolling="auto" frameborder="0"  src="' + url + '" style="width:100%;height:100%;"></iframe>';
        $('#tabs').tabs('add', {
            title: title,
            content: from,
            closable: true
        });
    } else {
        $('#tabs').tabs('select', title);
    }
}