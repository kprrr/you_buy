$(function () {
    $("#car_no").val(getCookie(keyCookie.trainTitlte));
    initMenus();
})

//初始化一点菜单
function initMenus() {
    $("body").data(menus);
    sumPrice();
    var menusParamDom = $("#menus");
    for (var key in menus) {
        menusParamDom.append(menuItemDom(menus[key]));
    }
}

function menuItemDom(menu) {
    var dom = '<li>' +
        '<div class="kl">{0}</div>' +
        '<div class="kr">' +
        '<span class="price">￥{1}</span>' +
        '<a class="jian" href="javascript:;">' +
        '<img src="/img/wap/-.jpg">' +
        '</a><span class="myOrderCount">{2}</span><a class="add" href="javascript:;">' +
        '<img src="/img/wap/j.jpg">' +
        '</a>' +
        '</div>' +
        '</li>';
    dom = $($.format(dom, menu.title, menu.price, menu.my_order_count));
    dom.data("data", menu);//注入数据

    //添加加减事件
    $(".jian", dom).click(function () {
        clickAddOrJianMenus(0, dom);
    });
    $(".add", dom).click(function () {
        clickAddOrJianMenus(1, dom);
    });

    return dom;
}

//加减菜单 0 减 1加 dom 点击菜单dom对象
function clickAddOrJianMenus(type, dom) {
    var menus = dom.data("data");
    //获取数字对象
    var myOrderCountDom = $(".myOrderCount", dom);
    //处理点击个数
    var count = parseFloat(myOrderCountDom.html());
    if (type == 1 || (type == 0 && count > 0)) {
        myOrderCountDom.html(count + (type == 0 ? -1 : 1));
        count = parseFloat(myOrderCountDom.html());
    }
    //设置点击个数
    menus.my_order_count = count;
    if (count == 0) {
        $("body").removeData(menus.id);
        //dom.remove();
    } else {
        $("body").data(menus.id, menus);
    }

    //计算总价
    sumPrice();
}

var sump = 0;
//计算总价
function sumPrice() {
    sump = 0;
    var dom = $("body");
    for (var key in dom.data()) {//遍历data
        var data = dom.data(key);
        sump += parseFloat(data.price) * data.my_order_count;
    }
    $("#sumPrice").html("总价￥" + sump);
}

//提交订单
function submitOrder() {
    if (sump) {
        //提交订单
        var carNo = $("#car_no").val();
//       var scTime = $("#sc_time").val();
        // var remark = $("#remark").val();
        var tel = $("#tel").val();

        if (carNo == "") {
            alert("请输入车次!");
        } else if (tel == "") {
            alert("请输入手机号码!");
        } else if (tel.length != 11) {
            alert("请输入正确的手机号码!");
        }
        /*else if(scTime==""){
         alert("请选择送餐时间");
         }*/
        else {
            //提交请求
            var data = {};
            data.car_no = carNo;
            data.seat_number = $("#che").val() + "车" + $("#pai").val() + "排" + $("#zuo").val() + "坐";
            //data.sc_time = scTime;
            //data.remark = remark;
            data.tel = tel;
            data.fa_piao = $('#fa_piao').is(':checked') ? "1" : "0";
            data.sum_price = sump;
            data.train_id = getCookie(keyCookie.trainId);
            data.menus = JSON.stringify($("body").data());
            sendUrl(url.WapCreateOrder, createOrderResult, data);
        }


    } else {
        alert("您好像一个都没点哦!");
    }
}

function createOrderResult(json) {
    alert("下单成功!");
    history.go(-1);//返回
}