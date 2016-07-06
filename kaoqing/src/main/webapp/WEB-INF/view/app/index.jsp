<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="/js/laydate/laydate.js"></script>
    <jsp:include page="/WEB-INF/common/head.jsp"/>
    <script type="text/javascript">
        seajs.use('proJs/app/index', function (v) {
            v.init();
        });
    </script>
</head>
<body>
<jsp:include page="/WEB-INF/common/top.jsp"/>
<div class="container">
    <div class="line">
        <a href="/apply/add" class="fadein-top button bg-blue">申请</a>
    </div>
    <hr class="bg-gray"/>
    <table class="table ">
        <tr>
            <th>申请人</th>
            <th>审批人</th>
            <th>状态</th>
            <th>操作</th>
        </tr>
    </table>
</div>
</body>
</html>