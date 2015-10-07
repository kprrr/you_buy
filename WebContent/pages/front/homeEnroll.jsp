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
<title>${activity.activity_name }</title>
</head>
<body>
<div class="homeInfo">
	<!--顶部娱乐选项[[-->
    <div class="tit-select clearfix">
        <div class="return l"><a href="index_home.html"><i>&lt;</i>返回</a></div>
        <div class="sel play r">
            <span class="l"><b class="r">8</b></span>
<!--             <div class="l " id="nvDrop"> -->
<!--                 dir-top -->
<!--                 <h2 class="nv-selected">全部</h2> -->
<!--                 <div class="nv-list" style="display:none"> -->
<!--                     <a title="台球" href="javascript:;">台球</a> -->
<!--                     <a title="篮球" href="javascript:;">篮球</a> -->
<!--                     <a title="足球" href="javascript:;">足球</a> -->
<!--                 </div> -->
<!--             </div> -->
        </div>
    </div>
    <!--顶部娱乐选项]]-->
	<div class="banner"><img src="/you_buy/pages/front/images/play_banner.png" alt="图片" /></div>
    <!--活动报名[[-->
    <div class="main fillin-main">
		<div class="user-info">
			<div class="name clearfix">
                <div class="l"><a href="_myDialog.html"><img src="/you_buy/upload/${createUser.photo }" /></a></div>
				<h3 class="l">
					<a href="_myPrivate.html">
						<p><i class="sex-m"></i>${createUser.nickname }</p>
						<span>${activity.activity_name }</span>
					</a>
				</h3>
			</div>
			<div class="mobile clearfix"><b class="l">电话:</b><p class="l">${createUser.tel }</p></div>
			<div class="mobile loaction clearfix">
				<b class="l">地址:</b>
				<p class="l"><span>${activity.site_name }</span><em>${activity.site_address }</em><a href="_loactNav.html"></a><p>
			</div>
		</div>
		<div class="dial-info">
			<div class="begin box clearfix"><i></i><input type="text" value="活动举办时间" readonly><p>${activity.starttime }</p></div>
			<div class="end box clearfix"><i></i><input type="text" value="报名截止时间" readonly><p>${activity.deadline }</p></div>
			<div class="loca box clearfix"><i></i><input type="text" value="报名地点" readonly><p>${activity.site_name }</p></div>
			<div class="duration box clearfix"><i></i><input  type="text" value="活动时长" readonly><p><em>${activity.lasttime }</em>小时</p></div>
			<div class="num box clearfix"><i></i><input type="text" value="人数上限"><p><em>${activity.limit_num }</em>人</p> </div>
		</div>
		<div class="enr-box clearfix"><p class="l"><span class="l act"></span>我同意谁输谁买单</p><a class="enr r" href="javascript:void(0);">我要报名</a></div>
		<div class="enr-bnt clearfix">
			<a class="share l" href="javascript:void(0);">分享<i>(3)</i></a>
			<a class="comment l" href="comment-index">评论</a>
            <a class="collection l" href="_myCollection.html">收藏</a>
		</div>
    </div>
    <!--活动报名]]-->
</div>
<!--谁输谁买单弹框[[-->
<div class="overlay " style="display:none"></div>
<div class="dialog alert enr-dialog" style="display:none">
	<div class="conte attend">
		<p>确定参加此次"谁输谁买单"的活动吗？</p>
		<div class="bnt clearfix"><a class="cancel cols" href="javascript:void(0);">取消</a><a class="dial cols" href="activity-signUp">确定</a></div>
	</div>
</div>
<!--谁输谁买单弹框]]-->
    <!--分享引导页[[-->
    <div class="overlay" style="display:none"></div>
    <div class="homeshare" style="display:none"><img src="/you_buy/pages/front/images/tip-share.png" alt="分享引导" /></div>
    <!--分享引导页]]-->
</body>
</html>