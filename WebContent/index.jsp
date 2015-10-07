<%@ page contentType="text/html; charset=utf-8" language="java"
	errorPage=""%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<jsp:include page="inc/head.jsp"></jsp:include>
	<script src="js/sys/index.js"></script>

	<link rel="stylesheet" type="text/css" href="css/sys/index.css" />

	<head id="Head1">
		<title>xx管理系统</title>
	</head>

	<body class="easyui-layout" style="overflow-y: hidden" scroll="no">

		<div data-options="region:'north'"
			style="height: 80px; background-color: #70A0FB">
			<!--logo-->
			<img src="" height="77px" style="display: block; float: left;" />

			<div class="top-span">
				<span> <img style="vertical-align: middle;"
						src="/you_buy/images/male.png" /> <span style="vertical-align: middle;">${1==1?"管理员":"普通用户"}(账号:管理员)</span>
				</span>
				<span onclick=""> <img style="vertical-align: middle;"
						src="/you_buy/images/action_delete.png" /> <span
					style="vertical-align: middle;" id="logOut">退出登录</span> </span>
			</div>
		</div>

		<div data-options="region:'west',split:true,minWidth:'150'"
			title="功能列表" style="width: 200px; min-width: 150px;">
			<%--<div class="easyui-accordion" fit="true" border="false">--%>
			<%-- <div title="功能菜单">
         <div class='datagrid-mask-msg'>加载中...</div>
         <ul id="menus"></ul>
     </div>--%>
			<div>
			<div class="nav-item menuItem"
					onclick="addMenuTab('场馆管理','/you_buy/pages/user/sites/list.jsp')">
					<img src="/you_buy/images/miji.png"></img>
					<span>场馆管理</span>
				</div>
<!-- 				<div class="nav-item menuItem" -->
<!-- 					onclick="addMenuTab('秘籍管理','/pages/user/cheats/list.jsp')"> -->
<!-- 					<img src="/images/miji.png"></img> -->
<!-- 					<span>秘籍管理</span> -->
<!-- 				</div> -->
<!-- <div class="nav-item menuItem" -->
<!-- 					onclick="addMenuTab('帮会管理','/pages/user/gang/list.jsp')"> -->
<!-- 					<img src="/images/banghu.png"></img> -->
<!-- 					<span>帮会管理</span> -->
<!-- 				</div> -->

<!--                 <div class="nav-item menuItem" -->
<!--                      onclick="addMenuTab('任务管理','/pages/user/task/list.jsp')"> -->
<!--                     <img src="/images/renwu.png"></img> -->
<!--                     <span>任务管理</span> -->
<!--                 </div> -->

<!-- 				<div class="nav-item menuItem" -->
<!-- 					onclick="addMenuTab('帮会建筑功能设定','/pages/user/gang_arti/list.jsp')"> -->
<!-- 					<img src="/images/jianzhu.png"></img> -->
<!-- 					<span>帮会建筑功能设定</span> -->
<!-- 				</div> -->

<!-- 				<div class="nav-item menuItem" -->
<!-- 					onclick="addMenuTab('帮战管理','/pages/user/gang_war_info/list.jsp')"> -->
<!-- 					<img src="/images/paiming.png"></img> -->
<!-- 					<span>帮战管理</span> -->
<!-- 				</div> -->
<!-- 				<div class="nav-item menuItem" -->
<!-- 					onclick="addMenuTab('帮会游戏','/pages/user/gang_game/list.jsp')"> -->
<!-- 					<img src="/images/game.png"></img> -->
<!-- 					<span>帮会游戏</span> -->
<!-- 				</div> -->

<!--                 <div class="nav-item menuItem" onclick="addMenuTab('论坛管理', '/pages/user/forum/list.jsp')"> -->
<!--                     <img src="images/luntan.png"></img> -->
<!--                     <span>论坛管理</span> -->
<!--                 </div> -->

<!--                 <div class="nav-item menuItem" onclick="addMenuTab('下载量管理', '/pages/user/download/list.jsp')"> -->
<!--                     <img src="images/xiazailiang.jpg"></img> -->
<!--                     <span>下载量管理</span> -->
<!--                 </div> -->
                
<!--                 <div class="nav-item menuItem" onclick="addMenuTab('广告管理', '/pages/user/banner/list.jsp')"> -->
<!--                     <img src="images/xiazailiang.jpg"></img> -->
<!--                     <span>广告管理</span> -->
<!--                 </div> -->
<!--                  <div class="nav-item menuItem" onclick="addMenuTab('兑换记录', '/pages/user/user_prize_a/list.jsp')"> -->
<!--                     <img src="images/xiazailiang.jpg"></img> -->
<!--                     <span>兑换记录</span> -->
<!--                 </div> -->
<!-- 				<div class="nav-item menuItem" -->
<!-- 					onclick="addMenuTab('用户数据','/pages/user/user/list.jsp')"> -->
<!-- 					<img src="/images/users.png"></img> -->
<!-- 					<span>用户数据</span> -->
<!-- 				</div> -->


			</div>

		</div>

		<div data-options="region:'center'">
			<div id="tabs" class="easyui-tabs" fit="true" border="false">
				<div title="欢迎使用" style="padding: 20px; overflow: hidden;" id="home">

					欢迎使用
				</div>
			</div>
		</div>

	</body>
</html>