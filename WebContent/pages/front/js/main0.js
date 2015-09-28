var game = game || {};

//适应屏
game.sframe = function(){
			var detectBrowser = function(name) {
			if(navigator.userAgent.toLowerCase().indexOf(name) > -1) {
				return true;
			} else {
				return false;
			}
		};
		var width = parseInt(window.screen.width);
		var scale = width/640;
		var userScalable = 'no';
		if(detectBrowser("qq/")) userScalable = 'yes';
		document.getElementById('viewport').setAttribute('content', 'target-densitydpi=device-dpi,width=640,user-scalable='+userScalable+',initial-scale=' + scale);
};
//活动创建页地址下拉框
game.selectedhide= function () {
	var oLi=$("#position-ul li");
	var aDiv=$("#position-ul li div");
	
    oLi.on("click", "h2", function (event) {//显示下拉框
        event.stopPropagation();
        $(this).parent("li").siblings().find("div").slideUp("fast");
        $(this).siblings("div").slideDown("fast"); 
    });
    aDiv.on("click", " a",function (event) {//取值
        var txt = $(this).attr('title');
        $(this).parents("div").siblings("h2").text(txt);
        $(this).addClass('on').siblings().removeClass('on');
        $(this).closest("div").slideUp("fast");
    });
	
    $("html").on('click', function (event) { //滑动文档隐藏touchmove  
        aDiv.slideUp("fast");
    });
};
//场馆信息下拉框
game.selectapi= function () {
	var oLi=$("#api-ul li");
	var aDiv=$("#api-ul li .select-list");
	
    oLi.on("click", "h2", function (event) {//显示下拉框
        event.stopPropagation();
        $(this).parent("li").siblings().find(".select-list").slideUp("fast");
        $(this).siblings(".select-list").slideDown("fast"); 
    });
    aDiv.on("click", " a",function (event) {//取值
        var txt = $(this).attr('title');
        $(this).parents(".select-list").siblings("h2").text(txt);
        $(this).addClass('on').siblings().removeClass('on');
        $(this).closest(".select-list").slideUp('');
    });
	
    $("html").on('click', function (event) { //滑动文档隐藏touchmove  
        aDiv.slideUp("fast");
    });
}
//首页抬头下拉框
game.selecthome= function () {
	var oLi=$("#tit-select .select-box");
	var aDiv=$("#tit-select .select-box .select-list");
	
    oLi.on("click", "h2", function (event) {//显示下拉框
        event.stopPropagation();
        $(this).parent("li").siblings().find(".select-list").slideUp("fast");
        $(this).siblings(".select-list").slideDown("fast"); 
    });
    aDiv.on("click", " a",function (event) {//取值
        var txt = $(this).attr('title');
        $(this).parents(".select-list").siblings("h2").text(txt);
        $(this).addClass('on').siblings().removeClass('on');
        $(this).closest(".select-list").slideUp('');
    });

    $("html").on('click', function (event) { //滑动文档隐藏touchmove  
        aDiv.slideUp("fast");
    });
}

//附近娱乐项目下拉框
game.dropdown= function () {
	var oLi=$("#siDrop");
	var aDiv=$("#siDrop .si-list");
	
    oLi.on("click", "input", function (event) {//显示下拉框
        event.stopPropagation();
        $(this).siblings(".si-list").slideDown("fast"); 
    });
    aDiv.on("click", " a",function (event) {//取值
        var txt = $(this).attr('title');
		if($(this).hasClass("c")){
			$(this).parents(".si-list").siblings("input").removeAttr("readonly");
		};
        $(this).parents(".si-list").siblings("input").val(txt);
        $(this).addClass('on').siblings().removeClass('on');
        $(this).closest(".si-list").slideUp('');
		
    });
	
    $("html").on('click', function (event) { //滑动文档隐藏touchmove  
        aDiv.slideUp("fast");
    });
}
//弹框
game.apitel = function () {
    //电话弹层
	var tel=$(".api-ul li");
	var cols=$(".cols");
	tel.click(function(){
		$(".overlay,.dialog").show();	
	});
	cols.click(function(){
		$(".overlay,.dialog").hide();	
	});
    //分享引导弹层
	$(".fillin-main .share").click(function () {
	    $(".overlay,.homeshare").show();
	});
	$(".overlay,.homeshare").click(function () {
	    $(".overlay,.homeshare").hide();
	});
};
//发起约战验证表单
game.launch=function(){
	
	$(".dial-info input").each(function(){
     var thisVal=$(this).val();
     //判断文本框的值是否为空，有值的情况就隐藏提示语，没有值就显示
     if(thisVal!=""){
       $(this).siblings("span").hide();
      };
     //聚焦型输入框验证 
     $(this).focus(function(){
       $(this).siblings("span").hide();
      }).blur(function(){
        var val=$(this).val();
        if(val!=""){
         $(this).siblings("span").hide();
        };
      });
    });
	//input焦点事件赋给span
	$(".dial-info span").click(function(){
		$(this).siblings("input").focus();
	});
	
	//点击发起约战按钮
	$(".bnt-info").click(function(){
		$(".dial-info input").each(function(){
		    var thisVal = $(this).val();
		    var date = $(".dial-info .number").val();

		    if (thisVal == "") {
		        $(this).parent().addClass("tip-err");
		        $(".bnt-info a").attr("href", "javascript:;");
		    } else if (isNaN(date)) {
		        $(".tip-box").fadeIn().text("你输入不是数字！").fadeOut(2500);
		    } else if (date < '1') {
		        $(".tip-box").fadeIn().text("不能为0").fadeOut(2500);
		    } else {
		        $(this).parent().removeClass("tip-err");
		        $(".bnt-info a").attr("href", "_homeInfo.html");
		    };
		});
	});
};
//调用日历
game.calendar=function(){
		$("#beginTime").focus(function(){
        ECode.calendar({inputBox:"#beginTime",isSelect:true,flag:false,isTime:true,isWeek:false});
    	});
		$("#endTime").focus(function(){
        ECode.calendar({inputBox:"#endTime",isSelect:true,flag:false,isTime:true,isWeek:false});
    	});
	
};
//聊天窗口发送消息
game.msgdialog=function(){
    var oDiv = $(".msg-cont");
	$(".msg-bnt").click(function(){
	    var msgText = $("#msg-text").val();
	    var msgCont = "<div class='r msg-fr'><div class='r'><img src='images/play_banner.png'/></div><div class='text r'><span class='r'>" + msgText + "</span><b class='r'>2015-09-10 21:20</b></div></div>";
	    if (msgText != '') {
	        oDiv.append(msgCont);
	        $("#msg-text").val("");
	    } else {
	        $(".tip-box").fadeIn().text("消息不能为空！").fadeOut(2500);
	    };
	});	
};
//评论页提交评论
game.msgcom = function () {
    //提交评论追加评论内容
    var oDiv = $(".com-content");
    $(".com-bnt").click(function () {
        var msgText = $(".com-text textarea").val();
        var aLi="<li><div class='reply-main clearfix'><div class='name l'><img src='images/play_banner.png'><p>我是明明</p></div><div class='cont l'><p class='user-msg clearfix'><span>" + msgText + "</span><a class='hf'  href='javascript:void(0);'>回复</a></p></div></div><div class='reply-input clearfix'><input type='text' /><a class='fs'  href='javascript:void(0);'>发送</a></div></li>";
        if (msgText != '') {
            oDiv.append(aLi);
            $(".com-text textarea").val("");
        } else {
            $(".tip-box").fadeIn().text("请输入内容！").fadeOut(2500);
        };
    });
    //点击回复显示切换
    $(".com-content").delegate(".hf", "click", function () {
        $(this).parents(".reply-main").siblings().slideToggle("fast");
    });

    //回复内容追加
    $(".com-content").delegate(".fs", "click", function () {
        var msgText = $(this).siblings("input").val();
        var msgCont = "<div class='reply-cont clearfix'><i><em>我是你主人</em>回复<b>我是明明</b>:</i><span>" + msgText + "</span></div>";
        if (msgText != "") {
            $(this).parents("li").find(".cont").append(msgCont);
            $(this).siblings("input").val("");
            $(this).parent(".reply-input").slideUp("fast");
        } else {
            $(".tip-box").fadeIn().text("请输入内容！").fadeOut(2500);
        }   
    });

};
//同意谁输谁买单
game.aenrgree=function(){
	$(".enr-box p span").click(function(){
		if($(this).hasClass("act")){
			$(this).removeClass("act");
		}else{
			$(this).addClass("act");
		}
	});
	
	$(".enr-box .enr").click(function(){
		$(".enr-dialog,.overlay").show();
	});
	
};
//个人资料编辑页
game.editforms = function () {

        $(".mybnt").click(function () {
            $(".forms input").each(function () {
                var thisVal = $(this).val();
                if (thisVal == "") {
                    $(this).addClass("tip-err");
                } else {
                    $(this).removeClass("tip-err");
                };
        });

    });
};



//事件执行
$(function(){
	game.sframe();//适应屏
	game.apitel();//场馆电话弹框
	game.launch();//发起约战验证表单
	game.calendar();//调用日历
	game.msgdialog();//聊天窗口发送消息
	game.aenrgree();//同意谁输谁买单
	game.msgcom();//评论页提交评论
	game.editforms();//个人资料编辑页
	game.selectedhide();//活动创建页地址下拉框
	game.selectapi();//场馆信息下拉框
	game.selecthome();//首页抬头下拉框
	game.dropdown();//附近娱乐项目下拉框


});