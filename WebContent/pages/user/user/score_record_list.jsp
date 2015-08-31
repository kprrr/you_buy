<%@ page contentType="text/html; charset=utf-8" language="java"
         errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<jsp:include page="/inc/head.jsp"></jsp:include>

<script>
	var id = ${param.id};
</script>

<script src="js/score_record_list.js"></script>

<link rel="stylesheet" type="text/css" href="/css/sys/allList.css"/>
<head>
    <title></title>
</head>

<body id="mainWin" class="easyui-layout">

<!-- 查询条件 -->
<!-- 查询条件 -->
<div data-options="region:'north',title:'数据检索',iconCls:'icon-search'"
     style="height:140px; min-width: 300px; overflow:hidden">
    <fieldset>
        <legend>数据检索</legend>
        <table border="0" cellpadding="5" cellspacing="1" class="table_bg">
					<tr>

						<td>
							类型:
						</td>
						<th>
							<select class="easyui-combobox"
								data-options="panelHeight: 'auto',editable:false" id="s_type"
								style="width: 100px;">
								<option value="">全部</option>
								<option value="任务">玩赚天地</option>
								<option value="多盟">多盟</option>
								<option value="有米">有米</option>
								<option value="万普">万普</option>
								<option value="分享">分享</option>
								<option value="粉丝">粉丝</option>
								<option value="话费">话费</option>
								<option value="支付宝">支付宝</option>
								<option value="Q币">Q币</option>
								<option value="点卡">点卡</option>
								<option value="礼物">礼物</option>
								<option value="礼物券">礼物券</option>
							</select>
						</th>
						<td>
							开始时间:
						</td>
						<th>
							<input id="start_time" name="start_time" type="text"
								class="easyui-datetimebox">
						</th>
						<td>
							结束时间:
						</td>
						<th>
							<input id="end_time" name="end_time"
								validType="timeCheck['start_time']"
								invalidMessage="结束时间必须大于开始时间" type="text"
								class="easyui-datetimebox">
						</th>
					</tr>
					<tr>
						<td>
							当前汇总:
						</td>
						<th id="sumScore">
							加载中
						</th>
						<th colspan="2">
							<a href="javascript:;" id="search" class="easyui-linkbutton"
								data-options="iconCls:'icon-search'" onclick=""> 检索 </a>
						</th>
						
						<td>
							月汇总:
						</td>
						<th>
							<select class="easyui-combobox"
								data-options="panelHeight: 'auto',editable:false" id="s_month"
								style="width: 50px;">
								<option value="01">1月</option>
								<option value="02">2月</option>
								<option value="03">3月</option>
								<option value="04">4月</option>
								<option value="05">5月</option>
								<option value="06">6月</option>
								<option value="07">7月</option>
								<option value="08">8月</option>
								<option value="09">9月</option>
								<option value="10">10月</option>
								<option value="11">11月</option>
								<option value="12">12月</option>
							</select>
							<span style="position:relative;top: 2px;" id="month_score">加载用</span>
							<a href="javascript:;" id="month_search" class="easyui-linkbutton"
								data-options="iconCls:'icon-search'" onclick="">汇总 </a>
						</th>
					</tr>
				</table>

    </fieldset>
</div>

<!-- 主界面 -->
<div region="center">
    <table id="list" data-options="toolbar: '#menus'" border="false"></table>
    <div id="menus" style="height:auto">
        
        <a href="javascript:;" id="reload" class="easyui-linkbutton"
           data-options="iconCls:'icon-reload',plain:true">刷新</a>
    </div>
</div>

<!-- 弹窗 -->
<div id="win"></div>

</body>

</html>