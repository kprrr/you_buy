//提交表单
function formSubMit(url, data) {
    $('#form').form('submit', {
        url: url,
        onSubmit: function (param) {
            if (data) {
                param = $.extend(param, data);//2个json 合并
            }
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

//初始化表单
function initForm(url, data, resultJson) {
    //加载数据
    getData(url, data, function (json) {
        var temp = json.data;
        var inputValues = {};
        //对输入框注值
        $("#form .textbox").each(function (index, dom) {
            eval("inputValues." + dom.id + "=temp." + dom.id);
        });
        //对默认select自动选择
        $("#form select").each(function (index, dom) {
            $('#' + dom.id).combobox('select', eval("temp." + dom.id));
        })
        //对时间框注值
        $("#form .easyui-datetimebox").each(function (index, dom) {
            eval("inputValues." + dom.id + "=temp." + dom.id);
        });
        //对日期
        $("#form .easyui-datebox").each(function (index, dom) {
            eval("inputValues." + dom.id + "=temp." + dom.id);
        });

        //数字注入
        $("#form .easyui-numberspinner").each(function (index, dom) {
            eval("inputValues." + dom.id + "=temp." + dom.id);
        });
        //图片
        $("#form .image").each(function (index, dom) {
            $(dom).attr("src", eval("temp.img" ));
        });

        //其他后续注入


        //开始注入
        $('#form').form('load', inputValues);
        //将json反馈出去
        if (resultJson) {
            resultJson(temp);
        }
    }, "win");
}


//删除提示
function deleteData(title, url, data) {
    $.messager.confirm('确认', '您确认想要删除[' + title + ']吗?', function (r) {
        if (r) {
            //发送删除请求
            getDataNotCode(url, data, function (json) {
                $.messager.show({
                    title: '提示',
                    msg: '删除数据成功!',
                    showType: 'slide'
                });
                //刷新数据
                $("#list").datagrid('reload');
            }, "mainWin");
        }
    });
}


function opentIframeForm(id, title, url, w, h) {
    var from = '<iframe name="mainFrame" scrolling="auto" frameborder="0"  src="' + url + '" style="width:100%;height:100%;"></iframe>';
    $('#' + id).empty();//清空元素
    $('#' + id).append(from);
    $('#' + id).window({
        title: title,
        width: w,
        height: h,
        modal: true,
        collapsible: false,
        minimizable: false,
        maximizable: false,
        resizable: true
    });
}

//提示框
function messBox(info, title) {
    $.messager.show({
        title: title ? title : '提示',
        msg: info,
        showType: 'slide'
    });
}

//打开新窗口
function opentForm(id, title, url, w, h) {
    $('#' + id).window({
        title: title,
        width: w,
        height: h,
        collapsible: false,
        minimizable: false,
        maximizable: false,
        resizable: false,
        modal: true,
        href: url,
        onOpen: function () {
            $('#' + id).window('resize');
        }
    });
}

//获取表格选择行
function getSelectRow(id) {
    var row = $('#' + id).datagrid('getSelected');
    if (row == null) {
        $.messager.show({
            title: '提示',
            msg: '请选择一行数据进行操作!',
            showType: 'slide'
        });
        return null;
    } else {
        return row;
    }
}

//获取树选择节点
function getSelectTreeNode(id) {
    var node = $('#' + id).tree('getSelected');
    if (node == null) {
        $.messager.show({
            title: '提示',
            msg: '请选择一行数据进行操作!',
            showType: 'slide'
        });
        return null;
    } else {
        return node;
    }
}


//重写tree 以pid格式化
$.fn.tree.defaults.loadFilter = function (data, parent) {
    var opt = $(this).data().tree.options;
    var idFiled,
        textFiled,
        parentField;
    if (opt.parentField) {
        idFiled = opt.idFiled || 'id';
        textFiled = opt.textFiled || 'text';
        parentField = opt.parentField;

        var i,
            l,
            treeData = [],
            tmpMap = [];

        for (i = 0, l = data.length; i < l; i++) {
            tmpMap[data[i][idFiled]] = data[i];
        }

        for (i = 0, l = data.length; i < l; i++) {
            if (tmpMap[data[i][parentField]] && data[i][idFiled] != data[i][parentField]) {
                if (!tmpMap[data[i][parentField]]['children'])
                    tmpMap[data[i][parentField]]['children'] = [];
                data[i]['text'] = data[i][textFiled];
                tmpMap[data[i][parentField]]['children'].push(data[i]);
            } else {
                data[i]['text'] = data[i][textFiled];
                treeData.push(data[i]);
            }
        }
        return treeData;
    }
    return data;
};


/**
 * 基本操作
 * Created by 张宏 on 14-8-22.
 */

/**
 * 初始化下拉框数据
 * @param id
 * @param url
 */
function initWithCommbox(_id) {
    var id = _id;
    var selectItem = null;//加载完后自动选择
    var selectFirstImte = true;//默认自动选择第一个
    var isEdite = false;//默认不可编辑
    var isAll = false;//默认没有全部
    var url;
    var defaulTitle = "全部";

    var value = "id",//默认对于值
        text = "title";//默认显示标题

    var onSelectFunction = null;//选择事件

    /**
     * 设置请求
     * @param _url
     */
    this.setUrl = function (_url) {
        url = _url;
    }


    /**
     * 选择某个
     * @param selectItem
     */
    this.setSelectItem = function (_selectItem) {
        selectItem = _selectItem;
    };

    /**
     *是否选择第一个 默认选择第一个
     * @param selectFirstImte
     */
    this.setSelectFirstImte = function (_selectFirstImte) {
        selectFirstImte = _selectFirstImte;
    };

    /**
     * 是否可编辑 默认不可以编辑
     * @param isEdite
     */
    this.setIsEdite = function (_isEdite) {
        isEdite = _isEdite;
    };

    /**
     * 设置对于键值
     * @param value 值
     * @param text 显示
     */
    this.setValueAndText = function (_value, _text) {
        text = _text;
        value = _value;
    };

    /**
     * 设置选择事件
     * @param functionName
     */
    this.setOnSelectFunction = function (_functionName) {
        onSelectFunction = _functionName;
    };

    /**
     * 是否有全部选择项
     * @param _isAll
     */
    this.setIsAll = function (_isAll) {
        isAll = _isAll;
    }

    /**
     * 设置第一个选择项
     * @param _defaulTitle
     */
    this.setDefaulTitle = function (_defaulTitle) {
        defaulTitle = _defaulTitle;
    }

    this.loadData = function () {
        if (isAll) {
            $.ajax({
                url: url,
                type: "post",
                success: function (json) {
                    eval("json.unshift({ " + value + ": \"\", " + text + ": \"" + defaulTitle + "\" })");
                    $("#" + id).combobox({
                        data: json,
                        valueField: value,
                        textField: text,
                        editable: isEdite,
                        onLoadSuccess: onLoadSuccess,
                        onShowPanel: onShowPanel, //点击下拉筐时触发,
                        onSelect: onSelect
                    });
                }
            });
        } else {
            $("#" + id).combobox({
                url: url,
                valueField: value,
                textField: text,
                editable: isEdite,
                onLoadSuccess: onLoadSuccess,
                onShowPanel: onShowPanel, //点击下拉筐时触发,
                onSelect: onSelect
            });
        }
    };

    function onSelect(record) {
        if (onSelectFunction) {
            onSelectFunction(record);
        }
    }

    function onLoadSuccess() {
        if (selectItem) {//指定选择
            $(this).combobox('select', selectItem);
        } else if (selectFirstImte) {//选择第一个
            var data = $(this).combobox('getData');
            if (data.length > 0) {
                $(this).combobox('select', eval("data[0]." + value));
            }
        }
        selectItem = null;//清空防止第二次选择
    }

    function onShowPanel() {
        var data = $(this).combobox('getData');
        var dom = $(this).combobox('panel');
        if (data.length > 8) {
            dom.height(150);
        } else {
            dom.height('auto');
        }
    }

}


/**
 * 获取Listiew多选数据集合
 * @param id
 */
function getListViewItems(_id) {

    var id = _id;
    var title;//提示标题
    var itemId = "id";//多选id
    var itemName;//多选标题
    var url;
    var data = {};//提交参数
    var callBackFuntion;
    var sendDataName;//提交参数名称
    this.setSendDataName = function (_sendDataName) {
        sendDataName = _sendDataName;
    }
    this.setCallBackFuntion = function (_callBackFuntion) {
        callBackFuntion = _callBackFuntion;
    }
    this.setUrl = function (_url) {
        url = _url;
    }
    this.setData = function (_data) {
        data = _data;
    }
    this.setTitle = function (_title) {
        title = _title;
    }
    this.setItemId = function (_itemId) {
        itemId = _itemId;
    }
    this.setItemName = function (_itemName) {
        itemName = _itemName;
    }
    this.load = function () {
        var item = $("#" + id).datagrid('getChecked');
        if (item.length > 0) {
            var ids = "";
            var name = "";
            var count = 0;
            for (var i in item) {
                ids += eval('item[i].' + itemId) + ",";
                if (title) {
                    name += eval('item[i].' + itemName) + ",";
                }
                count++;
            }
            ids = ids.substring(0, ids.length - 1);
            if (title) {
                name = name.substring(0, name.length - 1);
            }
            title = (name.length > 0 ? '您勾选了[' + name + ']' : '') + title;
            $.messager.confirm('确认', title, function (r) {
                if (r) {
                    //加载数据
                    eval('data.' + sendDataName + '="' + ids + '"');
                    //  alert(JSON.stringify(data));
                    getData(url, data, callBackFuntion, "win");
                }
            })

        } else {
            $.messager.show({
                title: '提示',
                msg: '您至少需要选择一条数据!',
                showType: 'slide'
            });
        }
    }

}