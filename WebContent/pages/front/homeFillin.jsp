<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content="width=device-width, initial-scale=1, maximum-scale=1" name="viewport">
<meta http-equiv="X-UA-Compatible" content="IE=7">
<meta id="viewport" content="target-densitydpi=device-dpi,width=640,user-scalable=no,initial-scale=0.646875" name="viewport">
<link type="text/css" href="css/main.css" rel="stylesheet" />
<script src="js/jquery-1.11.0.min.js"></script>
<script src="js/mobiscroll_002.js" type="text/javascript"></script>
<script src="js/mobiscroll_004.js" type="text/javascript"></script>
<link href="css/mobiscroll_002.css" rel="stylesheet" type="text/css">
<link href="css/mobiscroll.css" rel="stylesheet" type="text/css">
<script src="js/mobiscroll.js" type="text/javascript"></script>
<script src="js/mobiscroll_003.js" type="text/javascript"></script>
<script src="js/mobiscroll_005.js" type="text/javascript"></script>
<link href="css/mobiscroll_003.css" rel="stylesheet" type="text/css">
<script src="js/main.js"></script>
<title>发起约战</title>
</head>
<body>
<div class="homeInfo">
	<!--顶部娱乐选项[[-->
		<div class=" clearfix tit-select tit-return" id="tit-select">
			<div class="return l" ><a href="index_home.html"><i>&lt;</i>返回</a></div>
			<div class="sel play r">
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
    </div>
    <!--顶部娱乐与地址选项]]-->
	<div class="banner"><img src="images/play_banner.png" alt="图片" /></div>
    <!--活动详情填写[[-->
    <div class="main">
		<div class="location-info">
            <ul class="position clearfix" id="position-ul">
                <li class="box">
                    <h2>江苏省</h2>
                    <div>
                        <p>
                            <a class="on" title="北京" href="javascript:;">北京</a>
                            <a title="广东省" href="javascript:;">广东省</a>
                            <a title="浙江省" href="javascript:;">浙江省</a>
                            <a title="东北省" href="javascript:;">东北省</a>
                            <a title="山东省" href="javascript:;">山东省</a>
                            <a title="北京" class="on" href="javascript:;">北京</a>
                            <a title="广东省" href="javascript:;">广东省</a>
                            <a title="浙江省" href="javascript:;">浙江省</a>
                            <a title="东北省" href="javascript:;">东北省</a>
                            <a title="山东省" href="javascript:;">山东省</a>
                            <a title="北京" href="javascript:;">北京</a>
                            <a title="广东省" href="javascript:;">广东省</a>
                            <a title="浙江省" href="javascript:;">浙江省</a>
                            <a title="东北省" href="javascript:;">东北省</a>
                            <a title="山东省" href="javascript:;">山东省</a>
                        </p>
                    </div>
                </li>
                <li class="box">
                    <h2>镇江市</h2>
                    <div>
                        <p>
                            <a class="on" title="北京" href="javascript:;">镇江市</a>
                            <a title="广东省" href="javascript:;">广东省</a>
                            <a title="浙江省" href="javascript:;">浙江省</a>
                            <a title="东北省" href="javascript:;">东北省</a>
                            <a title="山东省" href="javascript:;">山东省</a>
                            <a title="北京" href="javascript:;">北京</a>
                            <a title="广东省" href="javascript:;">广东省</a>
                            <a title="浙江省" href="javascript:;">浙江省</a>
                            <a title="东北省" href="javascript:;">东北省</a>
                            <a title="山东省" href="javascript:;">山东省</a>
                            <a title="北京" href="javascript:;">北京</a>
                            <a title="广东省" href="javascript:;">广东省</a>
                            <a title="浙江省" href="javascript:;">浙江省</a>
                            <a title="东北省" href="javascript:;">东北省</a>
                            <a title="山东省" href="javascript:;">山东省</a>
                        </p>
                    </div>
                </li>
                <li class="box">
                    <h2>京口区</h2>
                    <div>
                        <p>
                            <a class="on" title="北京" href="javascript:;">北京</a>
                            <a title="广东省" href="javascript:;">广东省</a>
                            <a title="浙江省" href="javascript:;">浙江省</a>
                            <a title="东北省" href="javascript:;">东北省</a>
                            <a title="山东省" href="javascript:;">山东省</a>
                        </p>
                    </div>
                </li>
            </ul>
			<div class="detailed box clearfix"><input class="l" type="text" value="中山南路289号" readonly />
                <a class="r" href="_homeLoact.html">地图选择</a></div>
			<div class="tit">您所在附近的<span>台球馆</span></div>
			<div class="site box" id="siDrop">
            	<input class="si-selected" value="名仕台球俱乐部名仕台球俱乐部名仕台球俱乐部(中山南路)" readonly >
                <div class="si-list">
				<p>
                	<a class="on" title="名仕台球俱乐部" href="javascript:;">名球俱乐部</a>
                    <a title="1台球俱乐部" href="javascript:;">1台球部</a>
                    <a title="2台球俱乐部" href="javascript:;">2俱乐部</a>
					<a title="3台球俱乐部" href="javascript:;">3台球部</a>
					<a title="4台球俱乐部" href="javascript:;">4台球部</a>
					<a title="5台球俱乐部" href="javascript:;">5台球部</a>
					<a title="6台球俱乐部" href="javascript:;">6台球部</a>
					<a class="c" title="自定义场馆" href="javascript:;">自定义场馆</a>
				</p>
                </div>
            </div>
		</div>
		<div class="dial-info">
			<div class="tit">详情设置</div>
				<div class="begin box clearfix">
                    <i></i>
					<input value="活动举办时间" readonly name="beginDateTime" id="beginDateTime" type="text">
					<b></b>
                </div>
				<div class="end box clearfix">
                	<i></i>
					<input value="报名截止时间" readonly name="endDateTime" id="endDateTime" type="text">
					<b></b>
				</div>
				<div class="duration box clearfix">
                	<i></i><span>活动时长</span><input class="number" type="text" /><strong>小时</strong></div>
				<div class="num box clearfix">
                	<i></i><span>人数上限</span><input class ="number"type="text" /><strong> 人</strong></div>
		</div>
        <div class="enr-box clearfix"><p class="l"><span class="l act"></span>我同意谁输谁买单</p></div>
		<div class="bnt-info"><a href="javascript:;">发起约战</a></div>
    </div>
    <!--活动详情填写]]-->
</div>
    <!--消息提示[[-->
    <div class="tip-box"></div>
    <!--消息提示]]-->
<script type="text/javascript">
	$(function () {
		var currYear = (new Date()).getFullYear();	
		var opt={};
		opt.datetime = {preset : 'datetime'};
		
		opt.default = {
		theme: 'android-ics light', //皮肤样式
		display: 'modal', //显示方式 
		mode: 'scroller', //日期选择模式
		dateFormat: 'yyyy-mm-dd',
		lang: 'zh',
		showNow: true,
		nowText: "今天",
		startYear: currYear - 10, //开始年份
		endYear: currYear + 10 //结束年份
		};
		
		var optDateTime = $.extend(opt['datetime'], opt['default']);
		$("#beginDateTime").mobiscroll(optDateTime).datetime(optDateTime);
		$("#endDateTime").mobiscroll(optDateTime).datetime(optDateTime);
		
	});
</script>
</body>
</html>