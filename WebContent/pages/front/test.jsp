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
<script src="js/main.js"></script>
<title>个人信息编辑</title>
<script>
//相片上传	
$(function () {
	alert(1)
	var c_url = 'http://139.196.4.82/you_buy/activity-queryAll';
	
// 	c_url = 'http://s8.hk:8088/s8/s?format=text&longUrl=';  
    c_url +=document.location.href;  
    //注意下面只需一个问号，不用具体的函数名  
    c_url += '&jsonp=?'  
    		alert(c_url)
// 	$.ajax(  
// 		    {  
// 		        type:'post',  
// 		        url : 'http://139.196.4.82/you_buy/activity-queryAll&jsonp=?',  
// 		        dataType : 'jsonp',  
// 		        jsonp:"jsoncallback",  
// 		        success  : function() {  
// 		            alert(111);  
// 		        },  
// 		        error : function() {  
// 		            alert('fail');  
// 		        }  
// 		    }  
// 		); 
	  $.getJSON(c_url, function(data){  
          alert(data.json);  
      });  
});
</script>
</head>
<body>
<div class="myPrivate myedit">
	<div class="user">
        <p class="pic" id="camera">
            <input type="file">
            <img id="infoimg" src="/upload/${wxuser.photo } style=" width:100%;" alt="上传头像" />
        </p>
	</div>
	<div class="main">
	<form class="forms">
		<p class="clearfix"><label>昵称:</label><input type="text" value="${wxuser.nickname }" /></p>
		<p class="clearfix"><label>性别:</label><input type="text" value="${wxuser.sex }" /></p>
		<p class="clearfix"><label>年龄:</label><input type="text" value="${wxuser.age }" /></p>
        <p class="clearfix register"><label>手机号:</label><input type="text" value="${wxuser.tel }" /></p>
		<p class="clearfix register"><label>注册时间:</label><span>${wxuser.registtime }</span></p>
		<div class="loact">
			<span>地址:</span>
			<input type="text" value="${wxuser.wxuser_address }" />
		</div>
		<div class="qm">
			<span>签名:</span>
			<textarea>${wxuser.signature }</textarea>
		</div>
	</form>
	</div>
	<div class="mybnt pri"><a href="javascript:void(0);">确定提交</a></div>
</div>

</body>
</html>