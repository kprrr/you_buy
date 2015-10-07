<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta content="width=device-width, initial-scale=1, maximum-scale=1" name="viewport">
<meta http-equiv="X-UA-Compatible" content="IE=7">
<meta id="viewport" content="target-densitydpi=device-dpi,width=640,user-scalable=no,initial-scale=0.646875" name="viewport">
<link type="text/css" href="css/main.css" rel="stylesheet" />
<script src="js/jquery-1.11.0.min.js"></script>
<script src="js/main.js"></script>
</head>
<body>
<div class="homeInfo">
	<!--顶部娱乐选项[[-->
    <div class="tit-select clearfix">
        <div class="return l"><a href="_homeEnroll.html"><i>&lt;</i>返回</a></div>
        <div class="sel play r">
            <span class="l"><b class="r">8</b></span>
            <div class="l " id="nvDrop">
                <!--dir-top-->
                <h2 class="nv-selected">全部</h2>
                <div class="nv-list" style="display:none">
                    <a title="台球" href="javascript:;">台球</a>
                    <a title="篮球" href="javascript:;">篮球</a>
                    <a title="足球" href="javascript:;">足球</a>
                </div>
            </div>
        </div>
    </div>
    <!--顶部娱乐选项]]-->
	<div class="banner"><img src="images/play_banner.png" alt="图片" /></div>
    <!--活动报名[[-->
    <div class="main fillin-main">
		<div class="user-info">
			<div class="name clearfix">
				<div class="l"><img src="images/use-photo.png" /></div>
				<h3 class="l"><p><i class="sex-m"></i>${activity.nickname }</p><span>${activity.activity_name }</span></h3>
			</div>
			<div class="mobile clearfix"><b class="l">电话:</b><p class="l">${activity.tel }</p></div>
			<div class="mobile loaction clearfix">
				<b class="l">地址:</b>
				<input type = "hidden" id="distance" value="${activity.distance }" />
				<p class="l"><span>${activity.site_name }</span><em>${activity.site_address }</em><a href="_loactNav.html"></a><p>
			</div>
		</div>
		<div class="com-info">
			<h3>评论</h3>
			<ul class="com-content">
				<li>
					<div class="reply-main clearfix">
						<div class="name l"><img src="images/play_banner.png"><p>我是明明</p></div>
						<div class="cont l">
							<p class="user-msg clearfix"><span>这个地方真不错,真不错,真不错真不错真不错真不错真不错真不错真不错真不错真不错</span><a class="hf"  href="javascript:void(0);">回复</a></p>
							<div class="reply-cont clearfix"><i><em>我是你主人</em>回复<b>我是明明</b>:</i><span>深有同感哟深有同感哟深有同感哟深有同感哟深有同感哟深有同感哟深有同感哟深有同感哟深有同感哟深有同感哟!</span></div>
						</div>
					</div>
					<div class="reply-input clearfix"><input type="text" value="" /><a class="fs"  href="javascript:void(0);">发送</a></div>
				</li>
			</ul>
		</div>
		
		<div  class="com-text"><textarea  id="content" placeholder='请文明发言'></textarea></div>
		<div class="com-bnt"><a  href="javascript:void(0);">提交评论</a></div>
    </div>
    <!--活动报名]]-->
</div>
<!--消息提示[[-->
<div class="tip-box"></div>
<!--消息提示]]-->
</body>
<script type="text/javascript">
$(function(){

// 	$(".com-bnt").click(function(){
// 		$.post('comment-addComment',{"content":$("#content").val()},function(json){
// 			if(json.code == 1){
// 				alert("1111");
// 			}
			
// 		},'json');
// 		alert($("#content").val());
		
// 	});
	
	
});


</script>
</html>