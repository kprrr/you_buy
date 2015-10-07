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
<title>首页</title>
<script type="text/javascript">
        var totalheight = 0;
        var COUNTER = 1;
        
        $(function () {
            //首次加载, 加载第一页
            loadDataByAjax(COUNTER);
        })
        
         function loadData() {
            totalheight = parseFloat($(window).height()) + parseFloat($(window).scrollTop());
            if ($(document).height() <= totalheight) {
                //滚动时, 页数叠加,加载数据
                loadDataByAjax(COUNTER);
            }
        }
        
        function loadDataByAjax(curPage) {
            totalheight = parseFloat($(window).height()) + parseFloat($(window).scrollTop());
			var activity={};
			activity.pageNum=curPage;
// 			alert(activity.pageNum)
            if ($(document).height() <= totalheight) {
                $.ajax({
                    type: "POST",
                    url: "activity-queryAll",
                    data: activity,
                    dataType: "json",
                    processdata: true,
                    success: function (json) {
// 							var currentUser = json.data;
// 							//用户id
// 							currentUser.id
// 							//用户姓名
// 							currentUser.nickname
// 							//用户头像
// 							currentUser.photo
                    	if(json.rows.length>0) {
                    		 COUNTER++;
                    	}
                    	
                        var strHTML = "";

                        $.each(json.rows, function (i, item) {

                            strHTML += '<li>';
                            strHTML += '<a class="clearfix" href="activity-toDetail?id='+item.id+'">';
                            strHTML += '<div class="pic l"><img src="/you_buy/upload/' + item.photo + '" alt="#" /></div>';
                            strHTML += '<div class="info l">';

                            if (item.sex == 1)
                                strHTML += '<p class="name"><i class="sex-m"></i>' + item.nickname + '</p>';
                            else
                                strHTML += '<p class="name"><i class="sex-f"></i>' + item.nickname + '</p>';

                            strHTML += '<p class="club"><i></i>' + item.site_name + '</p>';
                            strHTML += '<p class="loact"><i></i>' + item.site_address + '</p>';
                            strHTML += '<p class="time"><i></i>' + item.starttime + '</p>';
                            strHTML += '</div>';
                            strHTML += '<div class="state r">';
                            strHTML += '<p class="space">' + item.distance + 'm</p>';
                            strHTML += '<p class="num"><b>' + item.signed_num + '</b>人报名</p>';
                            if (item.activity_status == 0)
                                strHTML += '<p class="begin">即将开始</p>';
                            if (item.activity_status == 1)
                                strHTML += '<p class="enroll">可报名</p>';
                            if (item.activity_status == 2)
                                strHTML += '<p class="end">报名结束</p>';

//                             strHTML += '<p class="begin">即将开始</p>';
                            if (item.isotherpay == 1)
                                strHTML += '<p class="please">谁输谁买单</p>';
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


            //if ($(document).height() <= totalheight) {
            //    $.getJSON("json_data/index_home.json", function (data) {
            //        //加载数据
            //        var strHTML = "";

            //        $.each(data.rows, function (i, item) {
                       

            //            strHTML += '<li>';
            //            strHTML += '<a class="clearfix" href="_homeEnroll.html">';
            //            strHTML += '<div class="pic l"><img src=' + item.photo + ' alt="#" /></div>';
            //            strHTML += '<div class="info l">';

            //            if(item.sex == 1)
            //                strHTML += '<p class="name"><i class="sex-m"></i>' + item.nickname + '</p>';
            //            else
            //                strHTML += '<p class="name"><i class="sex-f"></i>' + item.nickname + '</p>';



            //            strHTML += '<p class="club"><i></i>' + item.site_name + '</p>';
            //            strHTML += '<p class="loact"><i></i>' + item.site_address + '</p>';
            //            strHTML += '<p class="time"><i></i>' + item.starttime + '</p>';
            //            strHTML += '</div>';
            //            strHTML += '<div class="state r">';
            //            strHTML += '<p class="space">' + item.distance + 'm</p>';
            //            strHTML += '<p class="num"><b>' + item.signed_num + '</b>人报名</p>';
            //            strHTML += '<p class="begin">即将开始</p>';
            //            if (item.isotherpay == 1)
            //                strHTML += '<p class="please">谁输谁买单</p>';
            //            strHTML += '</div>';
            //            strHTML += '</a>';
            //            strHTML += '</li>';
            //        });

            //        $("#ul_content").append(strHTML);
            //    });
            //}
        }

        $(window).scroll(function () {
            //console.log("滚动条到顶部的垂直高度: "+$(document).scrollTop());
            //console.log("页面的文档高度 ："+$(document).height());
            //console.log('浏览器的高度：'+$(window).height());

            loadData();
        });
        

    </script>
</head>
<body>
    <div class="home">
        <!--顶部娱乐与地址选项[[-->
        <div class="tit-select clearfix" id="tit-select">
            <div class="sel play l">
                <span class="l"><b class="r">8</b></span>
                <div class="l select-box">
                    <h2>全部</h2>
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
                </div>
            </div>
            <div class="sel location r">
                <span class="l"></span>
                <div class="l select-box">
                    <h2>地区</h2>
                    <div class="select-list">
                        <i></i>
                        <div class="option">
                            <p>
                                <a title="镇江" href="javascript:;">镇江</a>
                                <a title="南京" href="javascript:;">南京</a>
                                <a title="杭州" href="javascript:;">杭州</a>
                                <a title="南京" href="javascript:;">南京</a>
                                <a title="杭州" href="javascript:;">杭州</a>
                                <a title="杭州" href="javascript:;">杭州</a>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--顶部娱乐与地址选项]]-->
        <!--首页列表[[-->
        <div class="list">
            <ul id="ul_content">
<!--                 <li> -->
<!--                     <a class="clearfix" href="_homeEnroll.html"> -->
<!--                         <div class="pic l"><img src="images/use-photo.png" alt="#" /></div> -->
<!--                         <div class="info l"> -->
<!--                             <p class="name"><i class="sex-m"></i>Jaaaaamie</p> -->
<!--                             <p class="club"><i></i>Bingo台球俱乐部</p> -->
<!--                             <p class="loact"><i></i>秦淮区中山南路289号2楼(张府园)秦淮区中山南路289号2楼(张府园)</p> -->
<!--                             <p class="time"><i></i>2015.8.25&nbsp; 21:53:07</p> -->
<!--                         </div> -->
<!--                         <div class="state r"> -->
<!--                             <p class="space">500m</p> -->
<!--                             <p class="num"><b>17</b>人参加</p> -->
<!--                             <p class="end">报名结束</p> -->
<!--                         </div> -->
<!--                     </a> -->
<!--                 </li> -->
            </ul>
        </div>
        <!--首页列表]]-->
        <!-- 约战按钮[[-->
        <div class="bnt">
            <a href="activity-toAdd">发起约战</a>
        </div>
        <!--约战按钮]]-->
    </div>
    <!--底部导航[[-->
    <div class="nav">
        <ul class="clearfix">
            <li class="home curr"><a class="curr" href="index_home.html"><i></i><p>首页</p></a></li>
            <li class="msg"><a href="index_msg.html"><i></i><p>消息</p></a></li>
            <li class="api"><a href="index_api.html"><i></i><p>场馆</p></a></li>
            <li class="my"><a href="index_my.html"><i></i><p>我</p></a></li>
        </ul>
    </div>
    <!--底部导航]]-->
</body>
</html>