<%@ page import="org.lby.kq.common.CLZ" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <jsp:include page="/WEB-INF/common/head.jsp"/>
    <script type="text/javascript">
        seajs.use('proJs/app/db', function (v) {
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
            <th>序号</th>
            <th>申请类型</th>
            <th>申请人</th>
            <th>申请时间</th>
            <th>申请时间区间</th>
            <th>申请原因</th>
            <th>操作</th>
        </tr>
        <tbody id="tbody"></tbody>
    </table>
</div>
<div id="mydialog" style="display: none">
    <form action="/apply/ajax_sp" type="post" id="form1">
        <div class="line padding">
            <input type="hidden" name="id" id="my_id"/>
            <div class="panel">
                <label>
                    <input type="radio" name="state" value="1" checked>审批通过
                </label>
                <label>
                    <input type="radio" name="state" value="2">审批不通过
                </label>
                <div class="form-group  padding">
                    <strong><strong class="text-red">* </strong>理由：</strong>
                    <textarea type="text" name="sp_reason" class="input input-auto" id="liy"></textarea>
                </div>
            </div>
            <div class="text-center"><input type="button" class="button btn-block bg-main" id="btn_sure" value="提交"/>
            </div>
        </div>
    </form>
</div>
</body>
</html>