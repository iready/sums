<%@ page import="org.lby.kq.common.CLZ" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/common/head.jsp"/>
    <link href="/js/layer/skin/layer.css" rel="stylesheet"/>
    <script src="/js/layer/layer.js" type="text/javascript"></script>
    <script type="text/javascript">
        seajs.use('proJs/app/db', function (v) {
            v.init(${a}, <%=CLZ.getJson(CLZ.apply_type)%>);
        });
    </script>
</head>
<body>
<jsp:include page="/WEB-INF/common/top.jsp"/>
<div class="container">
    <%--<div class="line">--%>
    <%--<a href="/apply/add" class="fadein-top button bg-blue">申请</a>--%>
    <%--</div>--%>
    <hr class="bg-gray"/>
    <table class="table ">
        <tr>
            <th>申请人</th>
            <th>状态</th>
            <th>操作</th>
        </tr>
        <tbody id="tbody"></tbody>
    </table>
</div>
<div id="mydialog" style="display: none">
    <div class="line padding">
        <div class="panel">
            <label>
                <input type="radio" name="sp" value="0" checked>审批通过
            </label>
            <label>
                <input type="radio" name="sp" value="1">审批不通过
            </label>
            <div class="form-group  padding">
                <strong>理由</strong>
                <textarea type="text" class="input input-auto" name="a.reason" id="reason"></textarea>
            </div>
        </div>
        <button class="button" id="btn_sure">确定</button>
    </div>
</div>
</body>
</html>