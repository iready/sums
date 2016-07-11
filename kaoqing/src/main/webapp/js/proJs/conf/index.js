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
    exports.init = function () {
        // 吊炸天脚本渲染
        for (var i in json_form) {
            for (var ii in json_form[i]) {
                $('#' + json_form[i][ii]).addClass(arr_class[0]);
            }
        }
        /**
         * 校验规则
         */
        $.validator.setDefaults({
            submitHandler: function () {
                alert("提交事件!");
            }
        });
        $().ready(function () {
            $("#configform").validate();
        });


        function clean_selct() {
            $('#hide_v').val('');
            $('#show_v').val('');
        }

        $('#radio_fy').click(function () {
            var c_ = $('#choose_').unbind('click').show(), h_ = $('#show_v'), panel_b = $('#show_div .panel-body').empty(), panel_show_div = $('#show_div').hide();
            clean_selct();
            $.openSelect(c_, {
                fy: {
                    hideSelect: "#hide_v",
                    showSelect: "#show_v",
                    hideType: "fy",
                    showType: "name",
                    selectedMulti: true
                }, onEnd: function () {
                    panel_b.text(arguments[1]);
                    panel_show_div.fadeIn();
                }
            });
        });
        $('#radio_dept').click(function () {
            var c_ = $('#choose_').unbind('click').show(), h_ = $('#show_v'), panel_b = $('#show_div .panel-body').empty(), panel_show_div = $('#show_div').hide();
            clean_selct();
            $.openSelect(c_, {
                dept: {
                    hideSelect: "#hide_v",
                    showSelect: "#show_v",
                    hideType: "id",
                    showType: "name",
                    selectedMulti: true
                }, onEnd: function () {
                    panel_b.text(arguments[1]);
                    panel_show_div.fadeIn();
                }
            });
        });
        // $('#configform').submit(function () {
        //     // 先假设全部验证通过
        //
        //
        //     // 取值操作
        //     var div_con = $('#con').empty();
        //     for (var i in arr_dk) {
        //         var t1 = json_form[arr_dk[i]][0];
        //         var t2 = json_form[arr_dk[i]][1];
        //         div_con.append(b.new_hi($('#' + t1).val() + ':' + $('#' + t2).val() + ':59').attr('name', 'c.' + arr_dk[i]));
        //     }
        //     return true;
        // });
    };
    exports.edit_init = function (json, choose_unit) {
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
            $('#radio_fy').trigger('click');
        } else {
            $('#radio_dept').trigger('click');
        }
        var panel_b = $('#show_div .panel-body').empty(), panel_show_div = $('#show_div').hide();
        $('#hide_v').val(choose_unit.unit);
        $('#show_v').val(choose_unit.unitName);
        panel_b.text(choose_unit.unitName);
        panel_show_div.fadeIn();
    };
});