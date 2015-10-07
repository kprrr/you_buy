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
<title>消息</title>
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
                url: "message-queryMsgWithTime",
                //data: '{"strUserName": "' + curPage + '", "strComments": "' + msgText + '"}',
                //contentType: "application/json; charset=utf-8",
                dataType: "json",
                processdata: true,
                success: function (data) {
                    var strHTML = "";
                    $.each(data.data, function (i, item) {
                        strHTML += '<li>';
                        strHTML += '<a class="clearfix" href="message-index?sender_id='+item.sender_id+'">';
                        strHTML += '<div class="pic l"><img src="/you_buy/upload/'+item.sender_photo+'" alt="#" /></div>';
                        strHTML += '<div class="info l">';
                        if(item.sex == 0) {
                        	 strHTML += '<p class="name"><i class="sex-f"></i>'+item.sender_nickname+'</p>';
                        }else {
                        	 strHTML += '<p class="name"><i class="sex-m"></i>'+item.sender_nickname+'</p>';
                        }
                       
                        strHTML += '<p class="message">'+item.content+'</p>';
                        strHTML += '</div>';
                        strHTML += '<div class="state r">';
                        strHTML += '<p class="time">'+item.timeFlag+'</p>';
                        strHTML += '</div>';
                        strHTML += '</a>';
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
    <div class=" msg">
        <!--消息聊天列表[[-->
        <div class="list">
            <ul id="ul_content">
                <!--<li>
            <a class="clearfix" href="_myDialog.html">
                <div class="pic l"><img src="images/use-photo.png" alt="#" /></div>
                <div class="info l">
                    <p class="name"><i class="sex-m"></i>Jaaaaamie</p>
                    <p class="message">不好玩呢~</p>
                </div>
                <div class="state r">
                    <p class="time">1秒前</p>
                </div>
            </a>
        </li>
        <li>
            <a class="clearfix" href="_myDialog.html">
                <div class="pic l"><img src="images/use-photo.png" alt="#" /></div>
                <div class="info l">
                    <p class="name"><i class="sex-m"></i>Jaaaaamie</p>
                    <p class="message">秦淮区中山南路12234455667788990000000987655555555555555555</p>
                </div>
                <div class="state r">
                    <p class="time">10分钟前</p>
                </div>
            </a>
        </li>
        <li>
            <a class="clearfix" href="_myDialog.html">
                <div class="pic l"><img src="images/use-photo.png" alt="#" /></div>
                <div class="info l">
                    <p class="name"><i class="sex-f"></i>Jaaaaamie</p>
                    <p class="message">跟你学球,学到了很多,么么哒!</p>
                </div>
                <div class="state r">
                    <p class="time">1小时前</p>
                </div>
            </a>
        </li>
        <li>
            <a class="clearfix" href="_myDialog.html">
                <div class="pic l"><img src="images/use-photo.png" alt="#" /></div>
                <div class="info l">
                    <p class="name"><i class="sex-m"></i>Jaaaaamie</p>
                    <p class="message">哈尼,可以晚点见面吗?临时有事~</p>
                </div>
                <div class="state r">
                    <p class="time">昨天</p>
                </div>
            </a>
        </li>
        <li>
            <a class="clearfix" href="_myDialog.html">
                <div class="pic l"><img src="images/use-photo.png" alt="#" /></div>
                <div class="info l">
                    <p class="name"><i class="sex-m"></i>Jaaaaamie</p>
                    <p class="message">不好玩呢~</p>
                </div>
                <div class="state r">
                    <p class="time">1秒前</p>
                </div>
            </a>
        </li>
        <li>
            <a class="clearfix" href="_myDialog.html">
                <div class="pic l"><img src="images/use-photo.png" alt="#" /></div>
                <div class="info l">
                    <p class="name"><i class="sex-m"></i>Jaaaaamie</p>
                    <p class="message">秦淮区中山南路12234455667788990000000987655555555555555555</p>
                </div>
                <div class="state r">
                    <p class="time">10分钟前</p>
                </div>
            </a>
        </li>
        <li>
            <a class="clearfix" href="_myDialog.html">
                <div class="pic l"><img src="images/use-photo.png" alt="#" /></div>
                <div class="info l">
                    <p class="name"><i class="sex-f"></i>Jaaaaamie</p>
                    <p class="message">跟你学球,学到了很多,么么哒!</p>
                </div>
                <div class="state r">
                    <p class="time">1小时前</p>
                </div>
            </a>
        </li>
        <li>
            <a class="clearfix" href="_myDialog.html">
                <div class="pic l"><img src="images/use-photo.png" alt="#" /></div>
                <div class="info l">
                    <p class="name"><i class="sex-m"></i>Jaaaaamie</p>
                    <p class="message">哈尼,可以晚点见面吗?临时有事~</p>
                </div>
                <div class="state r">
                    <p class="time">昨天</p>
                </div>
            </a>
        </li>-->
            </ul>
        </div>
        <!--消息聊天列表]]-->
    </div>
    <!--底部导航[[-->
    <div class="nav">
        <ul class="clearfix">
            <li class="home"><a href="index_home.html"><i></i><p>首页</p></a></li>
            <li class="msg curr"><a class="curr" href="index_msg.html"><i></i><p>消息</p></a></li>
            <li class="api"><a href="index_api.html"><i></i><p>场馆</p></a></li>
            <li class="my"><a href="index_my.html"><i></i><p>我</p></a></li>
        </ul>
    </div>
    <!--底部导航]]-->
</body>
</html>