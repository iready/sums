define(function (require, exports, module) {
    require('suser');
    require('jform');
    exports.init = function (obj) {
        $('#i_start').val(obj);
        var rules = {
            "a.reason": {
                required: true
            },
            "a.time_start": {
                required: true
            },
            "a.time_end": {
                required: true
            }
        }, messages = {"a.reason": "必须填写原因"};
        $.validator.setDefaults({
            submitHandler: function (form) {
                var end = new Date($('#i_end').val().replace(/-/g, "/"));
                var start = new Date($('#i_start').val().replace(/-/g, "/"));
                if (end < start) {
                    alert("结束时间不能小于开始时间");
                    return;
                }
                if ($('#hide_v').val() == "") {
                    alert("请选择审批人");
                    return;
                }
                $('#form1').ajaxSubmit({
                    success: function () {
                        location.href = '/apply?r=' + Math.random();
                    }
                });
            }
        });
        $().ready(function () {
            $("#form1").validate({rules: rules, messages: messages});
        });
        $.openSelect('#choose', {
            user: {
                hideSelect: "#hide_v",
                showSelect: "#show_v",
                hideType: "youxiang",
                showType: "xm",
                selectedMulti: false
            }, onEnd: function () {
                $('#spr').val(arguments[0])
                $('#div_s').text(arguments[1]);
            }
        });
    }
});