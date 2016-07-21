<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <script type="text/javascript" src="/js/laydate/laydate.js"></script>
    <jsp:include page="/WEB-INF/common/head.jsp"/>
    <script type="text/javascript">
        seajs.use('proJs/index/select', function (v) {
            v.init();
        });
    </script>
</head>
<body>
<jsp:include page="/WEB-INF/common/top.jsp"/>
<div class="container ">
    <div class="panel">
        <div class="panel-head"><strong>查询打卡记录</strong></div>
        <div class="panel-body">
            <div class="line">
                <input type="hidden" id="hide_v"/>
                <input type="hidden" id="show_v"/>
                <input type="button" style="display: none" id="other" class="button " value="选择其他人"/>
                <input type="text" id="time" class="input input-auto"/>
                <%--时间范围：<input id="i_start" class="input input-auto " readonly/>---%>
                <%--<input class="input input-auto" type="text" readonly id="i_end"/>--%>
                <input type="button" class="button " value="确定"/></div>
        </div>
    </div>
</div>
</body>
</html>