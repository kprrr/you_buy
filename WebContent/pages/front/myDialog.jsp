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
<title>我的消息</title>
</head>
<body>
<div class="my myAttend mydialog">
	<!--返回[[-->
	<div class="myAttend-tit clearfix"><a href="index_msg.html"><i>&lt;</i>返回</a><h3>${sender.nickname }</h3></div>
    <!--返回]]-->
    <!--对话框[[-->
    <div class="main">
		<div class="user"><a class=" clearfix" href="#">
			<img class="l" src="/you_buy/upload/${sender.photo }"><input type="hidden" id="id" value="${sender.id }">
			<input type="hidden" id="photo" value="${sender.photo }">
			<div class="l">
				<p class="name clearfix"><em class="sex-f l"></em><strong class="l">${sender.nickname }</strong></p>
				<p class="tel"><em>${sender.age }岁</em>${sender.tel }</p>
				<p class="loact">${sender.wxuser_address }</p>
			</div></a>
		</div>
		<div class="msg-cont clearfix">
		<input type="hidden" id="me_photo" value="${me_photo }">
			<div class="l msg-fl">
				<div class="l"><img class="l" src="images/play_banner.png"/></div>
				<div class="text l">
					<span class="l">哈喽~周未打球哟!哈喽~周未打球哟!哈喽~周未打球哟!哈喽~周未打球哟!哈喽~周未打球哟!哈喽~周未打球哟!哈喽~周未打球哟!</span>
					<b class="l">2015-09-10&nbsp; 21:20</b>
				</div>
			</div>
			<div class="r msg-fr">
				<div class="r"><img src="images/play_banner.png"/></div>
				<div class="text r">
					<span class="r">哈喽~周未打球哟!哈喽~周未打球哟!</span>
					<b class="r">2015-09-01&nbsp;21:00</b>
				</div>
			</div>
            
		</div>

    </div>
    <!--对话框]]-->
	<!--编辑信息[[-->
	<div class="msg-info">
		<p class="clearfix">
        	<input type="text" class="l" id="msg-text">
        	<a class="r msg-bnt" href="javascript:void(0);">发送</a>
        </p>
	</div>
<!--编辑信息]]-->
</div>
<!--消息提示[[-->
<div class="tip-box"></div>
    <!--消息提示]]-->
</body>
</html>