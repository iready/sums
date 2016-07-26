<%@ page import="org.lby.kq.common.SysVar" %>
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
        <div class="panel-head">
            <strong>类型：</strong>
            <select id="lx">
                <option value="0">打卡记录</option>
                <option value="1">申请记录</option>
            </select>
            <div class="line">
                <input type="hidden" id="hide_v"/>
                <input type="hidden" id="show_v"/>
                <strong>查询目标：</strong>
                <span class="text-gray" id="target"><%=session.getAttribute(SysVar.USER_NAME)%></span>
                <input type="button" style="display: none" id="other" class="button btn-small" value="选择其他人"/>
            </div>
            <div>
                <strong>时间范围: </strong>
                <input id="i_start" onclick="laydate({format: 'YYYY-MM-DD'});" class="input input-auto" type="text" size="10"
                       readonly/>-
                <input id="i_end" onclick="laydate({format: 'YYYY-MM-DD'});" class="input input-auto" type="text" size="10"
                       readonly/>
            </div>
            <input type="button" class="button bg-black" id="btn_sure" value="确定"/>
        </div>
        <div class="panel-body">
            <table class="table ">
                <thead id="thead">
                </thead>
                <tbody id="t_body">

                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>