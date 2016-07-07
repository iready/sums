<%@ page import="org.lby.kq.common.CLZ" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/common/head.jsp"/>
    <script type="text/javascript">
        seajs.use('proJs/app/index', function (v) {
            v.init(${a}, <%=CLZ.getJson(CLZ.apply_type)%>);
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
            <th>审批人</th>
            <th>申请类型</th>
            <th>状态</th>
            <th>操作</th>
        </tr>
        <tbody id="tbody"></tbody>
    </table>
</div>
</body>
</html>