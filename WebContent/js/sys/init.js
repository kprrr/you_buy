//时间比较
$.extend($.fn.datetimebox.defaults.rules, {
    timeCheck: {
        validator: function (value, param) {
            var s = $("input[name=" + param[0] + "]").val();
            //因为日期是统一格式的所以可以直接比较字符串 否则需要Date.parse(_date)转换
            return value >= s;
        },
        message: '非法数据'
    },
    timeCheckForNow: {
        validator: function (value, param) {
            //2014-08-13 14:48:22
            var d = new Date();
            var vYear = d.getFullYear();
            var vMon = d.getMonth() + 1;
            var vDay = d.getDate();
            var h = d.getHours();
            var m = d.getMinutes();
            var se = d.getSeconds();
            var s = vYear + "-" + vMon + "-" + vDay + " " + h + ":" + m + ":" + se;
            //因为日期是统一格式的所以可以直接比较字符串 否则需要Date.parse(_date)转换
            return value >= s;
        },
        message: '非法数据'
    }
});

//发送请求
function getData(url, data, sucessfn, loadingId) {
    $.ajax({
        type: "post",
        //使用get方法访问后台
        dataType: "json",
        //返回json格式的数据
        url: url,
        //要访问的后台地址
        data: data,
        //开始发送
        beforeSend: function () {
            //onloading();
            if (loadingId) {
                ajaxLoading(loadingId);
            }
        },
        //访问结束
        complete: function () {
            //removeload();
            if (loadingId) {
                ajaxLoadEnd();
            }
        },
        success: function (json) {
            //removeload();
            if (json.code == 1) {
                sucessfn(json);
            } else {
                $.messager.show({
                    title: '提示',
                    msg: json.mess,
                    showType: 'slide'
                });
            }
        },
        error: function (XMLHttpRequest, textStatus, thrownError) {

        }
    });
}

//发送请求
function getDataNotCode(url, data, sucessfn, loadingId) {
    $.ajax({
        type: "post",
        //使用get方法访问后台
        dataType: "json",
        //返回json格式的数据
        url: url,
        //要访问的后台地址
        data: data,
        //开始发送
        beforeSend: function () {
            //onloading();
            if (loadingId) {
                ajaxLoading(loadingId);
            }
        },
        //访问结束
        complete: function () {
            if (loadingId) {
                ajaxLoadEnd();
            }
        },
        success: function (json) {
            sucessfn(json);
        },
        error: function (XMLHttpRequest, textStatus, thrownError) {

        }
    });
}

function ajaxLoading(id) {
    var w = $("#" + id).width();
    var h = $("#" + id).height();
    $("<div class='datagrid-mask'></div>").css({display: "block", width: w, height: h, left: 6, top: 28, zIndex: 999999}).appendTo("#" + id);
    $("<div class='datagrid-mask-msg'></div>").html("请稍后...").appendTo("#" + id).css({display: "block", left: ((w - 153) / 2), top: ((h + 45) / 2), zIndex: 999999});
}
function ajaxLoadEnd() {
    $(".datagrid-mask").remove();
    $(".datagrid-mask-msg").remove();
}


