<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/common/head.jsp"/>
    <script type="text/javascript" src="/js/jquery-validate.min.js"></script>
    <%--<script type="text/javascript" src="/js/laydate/laydate.js"></script>--%>
    <script type="text/javascript">
        seajs.use('proJs/conf/index', function (v) {
            v.init();
        })
    </script>
</head>
<body>
<jsp:include page="/WEB-INF/common/top.jsp"/>
<div class="container">
    <div class="line">
        <div class="x12">
            <div class="panel" style="margin-right: 5px;">
                <form action="/config/save" class="form" id="configform" method="post">
                    <div class="panel-head">
                        <strong>配置参数</strong>
                        <div style="float:right;margin:-8px 3px 0px 0px">
                            <button class="button bg-green">快速应用设置</button>
                            <button class="button bg-sub">保存</button>
                        </div>
                    </div>
                    <div class="panel-body">
                        <div class="collapse-toggle">
                            <div class="panel active">
                                <div class="panel-head">
                                    <h4>上下班时间设定</h4>
                                </div>
                                <div class="panel-body">
                                    <div class="form-group">
                                        <strong>第一次打卡时间</strong>
                                        <input type="text" id="first_1" size="5"/>
                                        <strong>:</strong>
                                        <input type="text" id="first_2" size="5"/>
                                    </div>
                                    <div class="form-group">
                                        <strong>第二次打卡时间</strong>
                                        <input type="text" id="second_1" size="5"/>
                                        <strong>:</strong>
                                        <input type="text" id="second_2" size="5"/>
                                    </div>
                                    <div class="form-group">
                                        <strong>第三次打卡时间</strong>
                                        <input type="text" id="third_1" size="5"/>
                                        <strong>:</strong>
                                        <input type="text" id="third_2" size="5"/>
                                    </div>
                                    <div class="form-group">
                                        <strong>第四次打卡时间</strong>
                                        <input type="text" id="fourth_1" size="5"/>
                                        <strong>:</strong>
                                        <input type="text" id="fourth_2" size="5"/>
                                    </div>
                                </div>
                            </div>
                            <div class="panel">
                                <div class="panel-head">
                                    <h4>打卡时间设定</h4>
                                </div>
                                <div class="panel-body form-x">
                                    <div class="form-group ">
                                        <strong>上班前</strong>
                                        <input type="text" id="before_sb" name="c.beforeSb" size="5"/>
                                        <strong>分钟可打卡</strong>
                                    </div>
                                    <div class="form-group ">
                                        <strong>上班后</strong>
                                        <input type="text" id="after_sb" name="c.afterSb" size="5"/>
                                        <strong>分钟可打卡</strong>
                                    </div>
                                    <div class="form-group ">
                                        <strong>下班前</strong>
                                        <input type="text" id="before_xb" name="c.beforeXb" size="5"/>
                                        <strong>分钟可打卡</strong>
                                    </div>
                                    <div class="form-group ">
                                        <strong>下班后</strong>
                                        <input type="text" id="after_xb" name="c.afterXb" size="5"/>
                                        <strong>分钟可打卡</strong>
                                    </div>
                                </div>
                            </div>
                            <div class="panel">
                                <div class="panel-head">
                                    <h4>迟到缓冲区间</h4>
                                </div>
                                <div class="panel-body">
                                    <div class="form-group ">
                                        <strong>上班后</strong>
                                        <input type="text" name="c.hcSb" id="hc_sb" size="5"/>
                                        <strong>分钟打卡不算迟到</strong>
                                    </div>
                                    <div class="form-group ">
                                        <strong>下班前</strong>
                                        <input type="text" name="c.hcXb" id="hc_xb" size="5"/>
                                        <strong>分钟打卡不算早退</strong>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <strong>规则所属法院</strong>
                            <input name="ssfy" value="KOO"/>
                        </div>
                    </div>
                    <div style="display:none" id="con"></div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
