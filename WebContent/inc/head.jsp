<%@ page import="java.util.Date" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>


<c:set var="ctx" value="http://${header['host']}${pageContext.request.contextPath}/"/>

<link rel="stylesheet" type="text/css" href="${ctx }easyui/themes/default/easyui.css?<%=new Date().getTime()%>"/>
<link rel="stylesheet" type="text/css" href="${ctx }easyui/themes/icon.css"/>
<link rel="stylesheet" type="text/css" href="${ctx }css/sys/allList.css"/>

<script type="text/javascript" src="${ctx }easyui/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${ctx }easyui/json2.js"></script>
<script type="text/javascript" src="${ctx }easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${ctx }js/sys/common.js"></script>
<script type="text/javascript" src="${ctx }js/sys/tool.js"></script>
<script type="text/javascript" src="${ctx }easyui/locale/easyui-lang-zh_CN.js"></script>
<script src="${ctx }js/sys/init.js"></script>
<script src="${ctx }js/sys/ajaxfileupload.js"></script>
<script src="${ctx }js/sys/upload.js"></script>
<script src="/js/url.js"></script>



<c:if test="${session.systemUserInfo==null}">
    <script>
        top.window.location.href = "/login.jsp";
    </script>
</c:if>