<%@ page import="org.lby.kq.common.CLZ" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/common/head.jsp"/>
    <script type="text/javascript">
        seajs.use('proJs/app/sp', function (v) {
            v.init(${a}, <%=CLZ.getJson(CLZ.apply_type)%>);
        });
    </script>
</head>
<body>
<jsp:include page="/WEB-INF/common/top.jsp"/>
<div class="container">
    <hr class="bg-gray"/>
    <table class="table ">
        <tr>
            <th>申请人</th>
            <th>申请类型</th>
            <th>申请时间</th>
            <th>审批时间</th>
            <th>审批理由</th>
            <th>状态</th>
        </tr>
        <tbody id="tbody"></tbody>
    </table>
</div>
</body>
</html>