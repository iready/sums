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
            <form id="form1" method="post">
                <div class="panel" style="margin-right: 5px;">
                    <div class="panel-head">
                        <strong>统计</strong>
                    </div>
                    <div class="panel-body">
                        <div class="form-group">
                            <strong>统计类型</strong>
                            <label >
                                <input name="unitType" value="0" checked="checked" type="radio">法院
                            </label>
                            <label >
                                <input name="unitType" value="1" type="radio">部门
                            </label>
                            <input value="K00" ID="unit" name="unit"/>
                        </div>
                        <div class="form-group">
                            <strong>统计时间</strong>
                        </div>
                        <div>
                            <input type="text" id="year" name="year" class="input-auto input" size="5" value="2016"/>年
                            <input type="text" id="month" name="month" class="input-auto input" size="5" value="7"/>月
                            <input type="button" class="button" value="锁定日期" id="sd"/>
                            <input type="hidden" name="i_days" id="i_days"/>
                            <div id="days">

                            </div>
                        </div>
                        <div class="form-group">
                            <input class="button btn-main" type="submit" value="确定"/>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>