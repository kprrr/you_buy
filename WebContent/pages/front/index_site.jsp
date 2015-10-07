<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content="width=device-width, initial-scale=1, maximum-scale=1" name="viewport">
    <meta http-equiv="X-UA-Compatible" content="IE=7">
    <meta id="viewport" content="target-densitydpi=device-dpi,width=640,user-scalable=no,initial-scale=0.646875" name="viewport">
    <link type="text/css" href="/you_buy/pages/front/css/main.css" rel="stylesheet" />
    <script src="/you_buy/pages/front/js/jquery-1.11.0.min.js"></script>
    <script src="/you_buy/pages/front/js/main.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
        //记住计数
        var COUNTER = 1;
        $(function () {
            //首次加载, 加载第一页
            loadDataByAjax(COUNTER);
        })

        //curPage,当前页数
        function loadDataByAjax(curPage) {
            $.ajax({
                type: "POST",
                url: "site-queryAll",
               // data: '{"pageNum": "' + curPage + '"}',
                dataType: "json",
                processdata: true,
                success: function (data) {
                    var strHTML = "";
                    $.each(data.data, function (i, item) {
                        strHTML += '<li>';

                        strHTML += '<a class="clearfix" href="javascript:void(0);">';
                        strHTML += '<div class="pic l"><img src="/you_buy/upload/'+item.img+'" alt="#" /></div>';
                        strHTML += '<div class="info l">';
                        strHTML += '<p class="name">'+item.name+'</p>';
                        strHTML += '<p class="price">约战价格:<b>'+item.price+'/小时</b></p>';
                        strHTML += '<p class="loact"><i></i>'+item.place+'</p>';
                        strHTML += '<p class="tel"><i></i>'+item.tel+'</p>';
                        strHTML += '</div>';
                        strHTML += '<div class="state r">';
                        strHTML += '<p class="space">'+item.distance+'m</p>';
                        strHTML += '</div>';
                        strHTML += '</a>';
                        //strHTML += '';
                        //strHTML += '';

                        strHTML += '</li>';

                    });

                    $("#ul_content").append(strHTML);

                },
                error: function (msg) {
                    alert('服务调用失败: ' + msg.status + '' + msg.statusText);
                }
            });
        }


    </script>

</head>

<body>
    <div class="api">
        <!--场馆信息选项[[-->
        <div class="api-select">
            <ul class="clearfix" id="api-ul">
                <li class="select-box">
                    <h2>桌球</h2>
                    <div class="select-list">
                        <i></i>
                        <div class="option">
                            <p>
                                <a title="台球" href="javascript:;">台球</a>
                                <a title="篮球" href="javascript:;">篮球</a>
                                <a title="足球" href="javascript:;">足球</a>
                                <a title="KTV" href="javascript:;">KTV</a>
                                <a title="足球" href="javascript:;">足球</a>
                                <a title="篮球" href="javascript:;">篮球</a>
                                <a title="KTV" href="javascript:;">KTV</a>
                                <a title="足球" href="javascript:;">足球</a>
                            </p>
                        </div>
                    </div>
                </li>
                <li class="select-box">
                    <h2>区域</h2>
                    <div class="select-list">
                        <i></i>
                        <div class="option">
                            <p>
                                <a title="台球" href="javascript:;">台球</a>
                                <a title="篮球" href="javascript:;">篮球</a>
                                <a title="足球" href="javascript:;">足球</a>
                                <a title="KTV" href="javascript:;">KTV</a>
                                <a title="足球" href="javascript:;">足球</a>
                                <a title="篮球" href="javascript:;">篮球</a>
                                <a title="KTV" href="javascript:;">KTV</a>
                                <a title="足球" href="javascript:;">足球</a>
                            </p>
                        </div>
                    </div>
                </li>
                <li class="select-box">
                    <h2>距离</h2>
                    <div class="select-list">
                        <i></i>
                        <div class="option">
                            <p>
                                <a title="台球" href="javascript:;">台球</a>
                                <a title="篮球" href="javascript:;">篮球</a>
                            </p>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
        <!--场馆信息选项]]-->
        <!--场馆列表[[-->
        <div class="list">
            <ul class="api-ul" id="ul_content">
                <!--<li>
            <a class="clearfix" href="javascript:void(0);">
                <div class="pic l"><img src="images/play-photo.png" alt="#" /></div>
                <div class="info l">
                    <p class="name">Jaaaaamie</p>
                    <p class="price">约战价格:<b>25/小时</b></p>
                    <p class="loact"><i></i>秦淮区中山南路289号2楼(张府园)秦淮区中山南路289号2楼(张府园)</p>
                    <p class="tel"><i></i>025-8369918</p>
                </div>
                <div class="state r">
                    <p class="space">1.7K</p>
                </div>
            </a>
        </li>
        <li>
            <a class="clearfix" href="javascript:void(0);">
                <div class="pic l"><img src="images/play-photo.png" alt="#" /></div>
                <div class="info l">
                    <p class="name">Jaaaaamie</p>
                    <p class="price">约战价格:<b>25/小时</b></p>
                    <p class="loact"><i></i>秦淮区中山南路289号2楼(张府园)秦淮区中山南路289号2楼(张府园)</p>
                    <p class="tel"><i></i>025-8369918</p>
                </div>
                <div class="state r">
                    <p class="space">1.7K</p>
                </div>
            </a>
        </li>
        <li>
            <a class="clearfix" href="javascript:void(0);">
                <div class="pic l"><img src="images/play-photo.png" alt="#" /></div>
                <div class="info l">
                    <p class="name">Jaaaaamie</p>
                    <p class="price">约战价格:<b>25/小时</b></p>
                    <p class="loact"><i></i>秦淮区中山南路289号2楼(张府园)秦淮区中山南路289号2楼(张府园)</p>
                    <p class="tel"><i></i>025-8369918</p>
                </div>
                <div class="state r">
                    <p class="space">1.7K</p>
                </div>
            </a>
        </li>
        <li>
            <a class="clearfix" href="javascript:void(0);">
                <div class="pic l"><img src="images/play-photo.png" alt="#" /></div>
                <div class="info l">
                    <p class="name">Jaaaaamie</p>
                    <p class="price">约战价格:<b>25/小时</b></p>
                    <p class="loact"><i></i>秦淮区中山南路289号2楼(张府园)秦淮区中山南路289号2楼(张府园)</p>
                    <p class="tel"><i></i>025-8369918</p>
                </div>
                <div class="state r">
                    <p class="space">1.7K</p>
                </div>
            </a>
        </li>
        <li>
            <a class="clearfix" href="javascript:void(0);">
                <div class="pic l"><img src="images/play-photo.png" alt="#" /></div>
                <div class="info l">
                    <p class="name">Jaaaaamie</p>
                    <p class="price">约战价格:<b>25/小时</b></p>
                    <p class="loact"><i></i>秦淮区中山南路289号2楼(张府园)秦淮区中山南路289号2楼(张府园)</p>
                    <p class="tel"><i></i>025-8369918</p>
                </div>
                <div class="state r">
                    <p class="space">1.7K</p>
                </div>
            </a>
        </li>
        <li>
            <a class="clearfix" href="javascript:void(0);">
                <div class="pic l"><img src="images/play-photo.png" alt="#" /></div>
                <div class="info l">
                    <p class="name">Jaaaaamie</p>
                    <p class="price">约战价格:<b>25/小时</b></p>
                    <p class="loact"><i></i>秦淮区中山南路289号2楼(张府园)秦淮区中山南路289号2楼(张府园)</p>
                    <p class="tel"><i></i>025-8369918</p>
                </div>
                <div class="state r">
                    <p class="space">1.7K</p>
                </div>
            </a>
        </li>-->
            </ul>
        </div>
        <!--场馆列表]]-->
    </div>

    <!--拨打电话弹框[[-->
    <div class="overlay " style="display:none"></div>
    <div class="dialog alert" style="display:none">
        <div class="conte">
            <h2>是否拨打电话</h2>
            <h3>025-52200055</h3>
            <p>联系我时,说是平台上看到的哟,可享受价格优惠哦!</p>
            <div class="bnt clearfix"><a class="cancel cols" href="javascript:void(0);">取消</a><a class="dial" href="javascript:void(0);">确定拨打</a></div>
        </div>
    </div>
    <!--拨打电话弹框]]-->
    <!--底部导航[[-->
    <div class="nav">
        <ul class="clearfix">
            <li class="home"><a href="index_home.html"><i></i><p>首页</p></a></li>
            <li class="msg"><a href="index_msg.html"><i></i><p>消息</p></a></li>
            <li class="api curr"><a class="curr" href="index_api.html"><i></i><p>场馆</p></a></li>
            <li class="my"><a href="index_my.html"><i></i><p>我</p></a></li>
        </ul>
    </div>
    <!--底部导航]]-->
</body>
</html>