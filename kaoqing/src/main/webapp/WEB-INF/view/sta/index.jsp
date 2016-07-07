<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/common/head.jsp"/>
    <script type="text/javascript">
        seajs.use('proJs/sta/index', function (v) {
            v.init();
        });
    </script>
</head>
<body>
<jsp:include page="/WEB-INF/common/top.jsp"/>
<div class="container">
    <div class="line">
        <div class="x12">
            <div class="panel" style="margin-right: 5px;">
                <div class="panel-head">
                    <strong>统计</strong>
                </div>
                <div class="panel-body">
                    <div class="form-group">
                        <strong>统计类型</strong>
                        <div class="button-group radio">
                            <label class="button" id="radio_fy">
                                <input name="u.unitType" value="0" checked="checked" type="radio">法院
                            </label>
                            <label class="button" id="radio_dept">
                                <input name="u.unitType" value="1" type="radio">部门
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <strong>统计时间</strong>
                    </div>
                    <div>
                        <input type="text" id="year" class="input-auto input" size="5" value="2016"/>年
                        <input type="text" id="month" class="input-auto input" size="5" value="7"/>月
                        <input type="button" class="button" value="锁定日期" id="sd"/>
                        <div id="days">

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>