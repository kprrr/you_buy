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
						src="/images/male.png" /> <span style="vertical-align: middle;">${1==1?"管理员":"普通用户"}(账号:管理员)</span>
				</span>
				<span onclick=""> <img style="vertical-align: middle;"
						src="/images/action_delete.png" /> <span
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
					onclick="addMenuTab('场馆管理','/pages/user/sites/list.jsp')">
					<img src="/images/miji.png"></img>
					<span>场馆管理</span>
				</div>
<!-- 				<div class="nav-item menuItem" -->
<!-- 					onclick="addMenuTab('秘籍管理','/pages/user/cheats/list.jsp')"> -->
<!-- 					<img src="/images/miji.png"></img> -->
<!-- 					<span>秘籍管理</span> -->
<!-- 				</div> -->

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