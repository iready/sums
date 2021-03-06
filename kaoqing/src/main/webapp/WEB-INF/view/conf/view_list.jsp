<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <jsp:include page="/WEB-INF/common/head.jsp"/>
    <%@include file="/WEB-INF/common/layer.jsp" %>
    <script type="text/javascript">
        function delete_(s) {
            if (window.confirm("确定删除吗")) {
                $.get('/config/del/' + s, function (da) {
                    window.location.reload();
                })
            }
        }
        function edit() {
            if (arguments.length) {
                location.href = '/config/edit/' + arguments[0];
//            window.open('/config/edit/' + arguments[0]);
            } else {
                alert("发生错误");
            }
        }
        seajs.use('proJs/conf/view_list', function (v) {
            v.init();
        })
    </script>
</head>
<body>
<jsp:include page="/WEB-INF/common/top.jsp"/>
<div class="container">
    <div class="line">
        <a href="/config" class="fadein-top button bg-blue">添加</a>
    </div>
    <hr class="bg-gray"/>
    <table class="table ">
        <tr>
            <th>提供者</th>
            <th>配置名称</th>
            <th>所使用的法院</th>
            <th>所使用的部门</th>
            <th>操作</th>
        </tr>
        <c:forEach var="va" items="${c}">
            <tr class="table_click">
                <td>${va.provider}</td>
                <td>${va.confName}</td>
                <td>${va.unitType==0?va.unitName:"无"}</td>
                <td>${va.unitType==0?"无":va.unitName}</td>
                <td>
                    <button class="button button-small bg-green" onclick="edit('${va.id}')">编辑</button>
                    <button class="button button-small bg-black" onclick="delete_('${va.id}')">删除</button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>