<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 15-2-26
  Time: 下午3:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/inc/head.jsp"></jsp:include>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=gb2312"/>
    <meta name="viewport"
          content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>

    <link href="/css/loading.css" rel="stylesheet" type="text/css"/>


    <script>
        $(function () {

            var loadingDom = ' <div class="loadBg">' +
                    '<div class="loadParam">' +
                    '<img src="/img/loading.gif">' +
                    '<div class="title">请稍候</div>' +
                    '</div>';
            $("body").append(loadingDom);
        })
    </script>
</head>
<body id="loading">

</body>
</html>
