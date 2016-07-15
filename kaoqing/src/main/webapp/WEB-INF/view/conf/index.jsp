<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <jsp:include page="/WEB-INF/common/head.jsp"/>
    <%@include file="/WEB-INF/common/validate.jsp" %>
    <script type="text/javascript">
        seajs.use('proJs/conf/index', function (v) {
            v.init();
            try {
                if (${isEdit})v.edit_init(${c}, ${u});
            } catch (e) {

            }
        });
        $.validator.addMethod("hour", function (value, element, param) {
            value = parseInt(value);
            if (!isNaN(value)) {
                $(element).val(value);
                return value >= param[0] && value <= param[1];
            }
            return false;
        }, $.validator.format("请输入{0}-{1}之间的数字"));
    </script>
</head>
<body>
<jsp:include page="/WEB-INF/common/top.jsp"/>
<div class="container">
    <div class="line">
        <div class="x12">
            <div class="panel" style="margin-right: 5px;">
                <form action="/config/save" class="form" id="configform" method="post">
                    <input name="c.id" type="hidden">
                    <div class="panel-head">
                        <strong>配置参数</strong>
                        <div style="float:right;margin:-8px 3px 0px 0px">
                            <input type="button" value="快速应用设置" class="button">
                            <input class="button bg-sub fadein-right" type="submit" value="保存"/>
                        </div>
                    </div>
                    <div class="panel-body">
                        <div class="collapse-toggle">
                            <div class="panel active">
                                <div class="panel-head">
                                    <h4>配置属性</h4>
                                </div>
                                <div class="panel-body">
                                    <div class="form-group">
                                        <strong class="text-red">* </strong><strong>当前配置名字：</strong>
                                        <input type="text" name="c.confName" autocomplete="off"
                                               id="confName"
                                               size="20"/>
                                    </div>
                                    <div class="form-group">
                                        <strong class="text-red">* </strong><strong>适用于：</strong>
                                        <label id="radio_fy">
                                            <input name="u.unitType" value="0" type="radio">法院
                                        </label>
                                        <label id="radio_dept">
                                            <input name="u.unitType" value="1" type="radio">部门
                                        </label>
                                        <div class="panel" id="show_div" style="margin-top: 10px">
                                            <div class="panel-head"><strong>已选择的</strong><strong id="tc_lx"></strong>
                                                <div style="position: relative; float:right;margin:-8px 3px 0px 0px">
                                                    <input style="display: none" value="请选择" type="button" id="choose_"
                                                           class="button bg-main"/>
                                                    <input id="hide_v" name="u.unit" type="hidden"/>
                                                    <input id="show_v" name="u.unitName" type="hidden"/>
                                                </div>
                                            </div>
                                            <div class="panel-body"></div>
                                        </div>
                                        <h1>上下班时间设定</h1>
                                        <div class="form-group">
                                            <strong>第一次打卡时间</strong>
                                            <input type="text" id="first_1" size="5"/>
                                            <strong>:</strong>
                                            <input type="text" id="first_2" size="5"/>
                                        </div>
                                        <div class="form-group">
                                            <strong>第二次打卡时间</strong>
                                            <input name="hour" type="text" id="second_1" size="5"/>
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
                                        <h4>打卡时间设定</h4>
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
                                        <h4>迟到缓冲区间</h4>
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
                        </div>
                        <div style="display:none" id="con"></div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>