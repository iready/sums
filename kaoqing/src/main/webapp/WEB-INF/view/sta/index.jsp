<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <jsp:include page="/WEB-INF/common/head.jsp"/>
    <%@include file="/WEB-INF/common/validate.jsp" %>
    <script type="text/javascript">
        seajs.use('proJs/sta/index', function (v) {
            v.init(${r});
        });
    </script>
    <style rel="stylesheet">
        .ph_btn {
            float: right;
            margin-top: -7px;
        }
    </style>
</head>
<body>
<jsp:include page="/WEB-INF/common/top.jsp"/>
<div class="container">
    <input id="show_v" type="hidden"/>
    <input id="hide_v" type="hidden"/>
    <div class="line">
        <div class="x12">
            <form id="form1" action="/statistics/execl_dc" method="post">
                <div class="panel" style="margin-right: 5px;">
                    <div class="panel-head">
                        <strong>统计</strong>
                        <div class="ph_btn">
                            <input class="button bg-main" type="button" id="excel_submit" value="导出EXCEL数据"/>
                            <input class="button bg-blue" type="button" id="btn_sure" value="确定"/>
                        </div>
                    </div>
                    <div class="panel-body">
                        <div class="form-group">
                            <strong>统计类型：</strong>
                            <label>
                                <input name="unitType" value="0" checked="checked" type="radio">法院
                            </label>
                            <label>
                                <input name="unitType" value="1" type="radio">部门
                            </label>
                            <div class="panel" style="margin: 10px">
                                <div class="panel-head"><strong>已选择的</strong><strong class="cunit">法院</strong>
                                    <div class="ph_btn ">
                                        <input type="button" class="button cunit bg-main" id="btn_selunit" value="本法院"/>
                                        <input type="button" class="button cunit" id="other_fy" value="选择其它法院"/>
                                    </div>
                                </div>
                                <div class="panel-body" id="div_choose"></div>
                            </div>
                            <input id="unit" name="unit" type="hidden"/>
                        </div>
                        <div class="form-group">
                            <strong>统计时间：</strong>
                        </div>
                        <div class="panel" style="margin: 10px;">
                            <div class="panel-head ">
                                <strong>统计日期：</strong>
                                <select id="year" name="year"></select>年
                                <select id="month" name="month"></select>月
                                <div class="ph_btn">
                                    <input type="button" class="button" value="锁定日期" id="sd"/></div>
                            </div>
                            <div class="panel-body">
                                <input type="hidden" name="i_days" id="i_days"/>
                                <table class="table table-bordered">
                                    <tr id="tr_d">
                                        <th>星期一</th>
                                        <th>星期二</th>
                                        <th>星期三</th>
                                        <th>星期四</th>
                                        <th>星期五</th>
                                        <th>星期六</th>
                                        <th>星期日</th>
                                    </tr>
                                    <tbody id="dbody"></tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
            <div>
                <table class="table">
                    <tr>
                        <td>部门</td>
                        <td>姓名</td>
                        <td>迟到（次）</td>
                        <td>早退（次）</td>
                        <td>旷工（天）</td>
                        <td>外出（次）</td>
                        <td>请假（天）</td>
                        <td>出差（天）</td>
                    </tr>
                    <tbody id="t_body"></tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>