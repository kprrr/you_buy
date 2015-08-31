$(function () {
    //判断是否需要选择列车
    if (!getCookie(keyCookie.trainId)) {
        openTrainList();//打开列车选择
    } else {
        getMenusType();//打开菜单
    }

    //车次搜索
    $("#searchTrain").click(searchTrain);

    //车次选择
    $(".select_train").click(function () {
        //清除cookie
        delCookie(keyCookie.trainId);
        delCookie(keyCookie.trainTitlte);
        delCookie(keyCookie.carSegmentId);
        //打开选择器
        openTrainList();
    });
})

//搜索车次
function searchTrain() {
    var key = $("#searchTrainKey").val();
    if (key == "") {
        alert("请输入车次!");
    } else {
        //开始搜索
        sendUrl(url.WapTrainList, trainResult, {title: key});
    }
}

//车次选择
function trainResult(json) {
    //渲染车次
    var tarinParamDom = $(".items_param");
    tarinParamDom.empty();//清空
    if (json.length == 0) {
        tarinParamDom.append($('<div class="not_tarin">未搜索到此车次哦!</div>'));
    } else {
        $(json).each(function (index, item) {
            tarinParamDom.append(trainItemDom(item));
        })
    }
}
//车次itemDom
function trainItemDom(item) {
    var dom = "<a href='javascript:;' onclick=\"selectTrain('{0}','{1}','{2}')\">{3}</a>";
    dom = $($.format(dom,
    item.id,item.title,item.car_segment_id,item.title));
    return dom;
}

function openTrainList() {
    $(".window_bg").show();
}

//选择车次 进行查询菜单
function selectTrain(train_id, train_title, car_segment_id) {
    //注入cookie
    setCookie(keyCookie.trainId, train_id);
    setCookie(keyCookie.trainTitlte, train_title);
    setCookie(keyCookie.carSegmentId,car_segment_id);

    //关闭车次选择
    $(".window_bg").hide();
    getMenusType();//选择
}

//获取分类
function getMenusType() {
    //车次名称
    $("#train_title").html(getCookie(keyCookie.trainTitlte));

    sendUrl(url.WapMenusType, menusTypeResutl);
}
//分类返回结果
function menusTypeResutl(json) {
    var menusTypeParamDom = $("#menusType");
    menusTypeParamDom.empty();//清除
    $(json).each(function (index, item) {
        menusTypeParamDom.append(menusTypeItem(index, item));
    });
}
//分类dom
function menusTypeItem(index, menusType) {
    var dom = '<li>' +
        '{0}' +
        '</li>';
    dom = $($.format(dom, menusType.title));
    if (index == 0) {
        dom.addClass("hover");
        //获取第一个菜单
        getMenus(menusType.id);
    }
    dom.data("data", menusType);//注入数据
    dom.click(function () {
        onclickMenusType(dom);
    });
    return dom;
}

//点击分类
function onclickMenusType(dom) {
    //全部去掉选中class
    dom.siblings().removeClass("hover");
    //当前添加class
    dom.addClass("hover");
    getMenus(dom.data("data").id);
}

//获取菜单
function getMenus(menusTypeId) {
    sendUrl(url.WapMenus, menusResult,
        {
            "menus_type_id": menusTypeId,
            "train_id": getCookie(keyCookie.trainId),
            "car_segment_id" : getCookie(keyCookie.carSegmentId)
        });
}
//获取菜单结果
function menusResult(json) {
    var menusParamDom = $("#menus");
    menusParamDom.empty();
    if (json.length == 0) {
        var notMenusDom = '<li class="notMenus">' +
            '暂无任何菜单哦!' +
            '</li>';
        menusParamDom.append(notMenusDom);
    } else {
        $(json).each(function (index, item) {
            menusParamDom.append(menusItem(index, item));
        });
    }
}
//菜单dom
function menusItem(index, menus) {
    //<img src="{0}">
    var dom = '<li>' +
        '<div class="tp">{0}</div>' +
        '<div class="nr">' +
        '<div class="tn">{1}</div>' +
        '<div class="jg"><span>￥{2}</span></div>' +
        '<div class="sl">' +
        '<a class="jian" href="javascript:;"><img src="/img/wap/-.jpg"></a>' +
        '<span class="myOrderCount">{3}</span>' +
        '<a class="add" href="javascript:;"><img src="/img/wap/j.jpg"></a>' +
        '</div>' +
        '</div>' +
        '<div style="clear:both"></div>' +
        '</li>';
    //从body 中读取个数
    var menusMap = $("body").data(menus.id);
    $("img",dom).hide();
    if (menusMap) {
        menus = menusMap;//读取 已经点的对象
    }

//menus.image
    dom = $($.format(dom, '', menus.title, menus.price, menus.my_order_count));
    dom.data("data", menus);//注入数据
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
    } else {
        $("body").data(menus.id, menus);
    }

    //计算总价
    sumPrice();
}

var sump = 0.0;
//计算总价
function sumPrice() {
    sump = 0.0;
    var dom = $("body");
    for (var key in dom.data()) {//遍历data
        var data = dom.data(key);
        sump += parseFloat(data.price) * data.my_order_count;
    }
    $("#sumPrice").html("共￥" + sump);

//    var submitDom = $(".submit");
//    submitDom.off("click");
//    if (sump > 0) {
//        submitDom.removeClass("ensubmit");
//        submitDom.on("click", submitOrder);
//    } else {
//        submitDom.addClass("ensubmit");
//    }
}

//提交订单
function submitOrder() {
    if (sump > 0) {
        //提交订单
        $("#userOrderMenus").val(JSON.stringify($("body").data()));
        $("form").submit();
    } else {
        alert("您好像一个都没点哦!");
    }
}
