define(function (require, exports, module) {
    var b = require('build');
    require('suser');
    var arr_dk = ['first', 'second', 'third', 'fourth'];
    var arr_class = ['input input-auto text-center'];
    var json_form = {
        first: ['first_1', 'first_2'],
        second: ['second_1', 'second_2'],
        third: ['third_1', 'third_2'],
        fourth: ['fourth_1', 'fourth_2'],
        sb: ['after_sb', 'before_sb'],
        xb: ['after_xb', 'before_xb'],
        hc: ['hc_sb', 'hc_xb'],
        sx: ['confName']
    };
    var nowId = '';
    exports.init = function () {
        var rules = {"c.confName": "required"}, messages = {"c.confName": "请输入配置名字"};
        // 脚本渲染
        for (var i in json_form) {
            for (var ii in json_form[i]) {
                if ($.inArray(i, arr_dk) != -1) {
                    /*验证脚本*/
                    $('#' + json_form[i][0]).attr("name", json_form[i][0]);
                    $('#' + json_form[i][1]).attr("name", json_form[i][1]);
                    rules[json_form[i][0]] = {
                        required: true,
                        hour: [0, 24]
                    };
                    rules[json_form[i][1]] = {
                        required: true,
                        hour: [0, 60]
                    }
                }
                if (i == "sb" || i == "xb" || i == "hc") {
                    rules['c.' + json_form[i][0]] = {
                        required: true,
                        hour: [0, 200]
                    };
                    rules['c.' + json_form[i][1]] = {
                        required: true,
                        hour: [0, 200]
                    };
                }
                $('#' + json_form[i][ii]).addClass(arr_class[0]);
            }
        }
        /**
         * 校验规则
         */
        $.validator.setDefaults({
            submitHandler: function (form) {
                if ($('#hide_v').val().length == 0) {
                    layer.msg("请选择部门或者法院");
                } else {
                    var div_con = $('#con').empty();
                    for (var i in arr_dk) {
                        var t1 = $('#' + json_form[arr_dk[i]][0]).val();
                        var t2 = $('#' + json_form[arr_dk[i]][1]).val();
                        if (t1.length == 1) {
                            t1 = "0" + t1;
                        }
                        if (t2.length == 1) {
                            t2 = "0" + t2;
                        }
                        div_con.append(b.new_hi(t1 + ':' + t2 + ':00').attr('name', 'c.' + arr_dk[i]));
                    }
                    form.submit();
                }
            }
        });
        $().ready(function () {
            $("#configform").validate({rules: rules, messages: messages});
        });
        function clean_selct() {
            $('#hide_v').val('');
            $('#show_v').val('');
        }
        $('#radio_fy').click(function () {
            var c_ = $('#choose_').unbind('click').show(), h_ = $('#show_v'), panel_b = $('#show_div .panel-body').empty(), panel_show_div = $('#show_div');
            clean_selct();
            bind_rever();
            $.openSelect(c_, {
                fy: {
                    hideSelect: "#hide_v",
                    showSelect: "#show_v",
                    hideType: "fy",
                    showType: "name",
                    selectedMulti: false
                }, onEnd: function () {
                    panel_b.text(arguments[1]);
                    panel_show_div.fadeIn();
                    if (arguments[0]) {
                        ajax_yz(0, arguments[0], arguments[1]);
                    }
                }
            });
        });
        function ajax_yz(unitType, unit, name) {
            $.ajax({
                url: '/config/ajax_cf_yz', data: {unitType: unitType, unit: unit, id: nowId}, success: function (dat) {
                    if (parseInt(dat) == 1) {
                        layer.msg(name + "已有参数配置，请重新选择");
                        $('#show_div .panel-body').empty();
                        clean_selct();
                    }
                }
            });
        }

        $('#radio_dept').click(function () {
            var c_ = $('#choose_').unbind('click').show(), h_ = $('#show_v'), panel_b = $('#show_div .panel-body').empty(), panel_show_div = $('#show_div');
            clean_selct();
            bind_rever();
            $.openSelect(c_, {
                dept: {
                    hideSelect: "#hide_v",
                    showSelect: "#show_v",
                    hideType: "id",
                    showType: "name",
                    selectedMulti: false
                }, onEnd: function () {
                    panel_b.text(arguments[1]);
                    panel_show_div.fadeIn();
                    if (arguments[0]) {
                        ajax_yz(1, arguments[0], arguments[1]);
                    }
                }
            });
        });
        function bind_rever() {
            if ($('#radio_fy :input:checked').length == 1) {
                $('#tc_lx').text("法院");
            } else {
                $('#tc_lx').text("部门");
            }
        }
    };
    exports.edit_init = function (json, choose_unit) {
        nowId = json.id;
        for (var i in json) {
            if ($.inArray(i, arr_dk) == -1) {
                $('input[name="c.' + i + '"]').val(json[i]);
            } else {
                var arr_temp = json[i].split(":");
                $('#' + json_form[i][0]).val(arr_temp[0]);
                $('#' + json_form[i][1]).val(arr_temp[1]);
            }
        }
        if (choose_unit.unitType == 0) {
            $('#radio_fy input').trigger('click');
            $('#tc_lx').text("法院");
        } else {
            $('#radio_dept input').trigger('click');
            $('#tc_lx').text("部门");
        }
        var panel_b = $('#show_div .panel-body').empty(), panel_show_div = $('#show_div').hide();
        $('#hide_v').val(choose_unit.unit);
        $('#show_v').val(choose_unit.unitName);
        panel_b.text(choose_unit.unitName);
        panel_show_div.fadeIn();
    };
});