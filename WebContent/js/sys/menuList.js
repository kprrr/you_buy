$(function () {
    $('#tree_menu').tree({
        url: '/sysMenu-get',
        parentField: "pid",
        textFiled: "text",
        idFiled: "id",
        onBeforeExpand: function (node, param) {
            $('#tree_menu').tree('options').url = "/sysMenu-get?super_id=null";
        },
        onLoadSuccess: function () {//加载完毕后触发
            //展开全部菜单
            //$("#tree_menu").tree('expandAll');
            $(this).tree('collapseAll');
            $(this).tree('options').animate = true;
        }
    });

    $("#add").click(addMenu);
    $("#reload").click(reload);
    $("#edit").click(editMenu);
    $("#remove").click(removeMenu);
})

//刷新
function reload() {
    $('#tree_menu').tree('options').url = "/sysMenu-get";
    $("#tree_menu").tree('reload');
}

function addMenu() {
    var node = $('#tree_menu').tree('getSelected');
    var superId = "0";
    var superName = "根节点";
    if (node != null) {
        superId = node.id;
        superName = node.text;
    }
    opentForm("win", "新建节点", "/pages/sys/menu_execute.jsp?superId=" + superId + "&superName=" + superName, 310, 220);
}

function editMenu() {
    var node = getSelectTreeNode("tree_menu");
    if (node) {
        opentForm("win", "修改节点", "/pages/sys/menu_execute.jsp?id=" + node.id, 310, 190);
    }
}

function removeMenu() {
    var node = getSelectTreeNode("tree_menu");
    if (node) {
        if ($('#tree_menu').tree('isLeaf', node.target)) {
            $.messager.confirm('确认', '您确认想要删除[' + node.text + ']吗?', function (r) {
                if (r) {
                    //发送删除请求
                    getDataNotCode("/sysMenu-remove", {id: node.id}, function (json) {
                        $.messager.show({
                            title: '提示',
                            msg: '删除数据成功!',
                            showType: 'slide'
                        });
                        //刷新数据
                        reload();
                    });
                }
            });
        } else {
            $.messager.show({
                title: '提示',
                msg: '请先删除子节点再进行删除操作!',
                showType: 'slide'
            });
        }
    }
}

