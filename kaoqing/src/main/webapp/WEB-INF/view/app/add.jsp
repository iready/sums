<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="/js/laydate/laydate.js"></script>
    <jsp:include page="/WEB-INF/common/head.jsp"/>
    <link rel="stylesheet" href="/js/layer/skin/layer.css"/>
    <script type="text/javascript" src="/js/layer/layer.js"></script>
    <script type="text/javascript">
        seajs.use('proJs/app/add', function (v) {
            v.init();
        });
    </script>
</head>
<body>
<jsp:include page="/WEB-INF/common/top.jsp"/>
<div class="container">
    <div class="line">
        <div class="x12">
            <input type="hidden" id="show_v"/>
            <input type="hidden" id="hide_v"/>
            <form action="/apply/save" class="form" method="post">
                <div class="panel">
                    <div class="form-group  padding">
                        <strong>事由</strong>
                        <input type="text" class="input input-auto" name="a.reason" id="reason" size="20"/>
                    </div>
                    <div class="form-group  padding">
                        <strong>类型：</strong>
                        <select name="a.type" class="input input-auto">
                            <option value="0">外出</option>
                            <option value="1">请假</option>
                            <option value="2">出差</option>
                        </select>
                    </div>
                    <div class="form-group  padding">
                        <strong>时间：</strong>
                        <input type="text" name="a.time_start"
                               onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})" id="i_start"
                               class="input input-auto" readonly size="20"/>--
                        <input id="i_end" type="text" class="input input-auto" name="a.time_end"
                               onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})" readonly size="20"/>
                    </div>
                    <div class="form-group  padding">
                        <strong>审批人：</strong>
                        <a class="button" id="choose" href="javascript:;">选择</a>
                        <input type="hidden" class="input input-auto" size="10" name="a.spr"/>
                    </div>
                    <input type="submit" class="button btn-block" value="保存"/>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>