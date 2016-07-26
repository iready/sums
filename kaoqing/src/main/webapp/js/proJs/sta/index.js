define(function (require, exports, module) {
    var color_class = 'bg-red';
    var b = require('build');
    var arr_unit = ['法院', '部门'];
    require('jform');
    require('suser');
    var json_cont = undefined;
    exports.init = function (json) {
        json_cont = json;
        var j = json.yx_year.split(',');
        for (var i in j) {
            $('#year').append('<option value="' + j[i] + '">' + j[i] + '</option>');
        }
        for (var i = 1; i < 13; i++) {
            $('#month').append('<option value="' + i + '">' + i + '</option>');
        }
        $('#month').change(function () {
            $('#sd').trigger('click');
        });
        $(':input[name="unitType"]').click(init_btn_unit);
        init_btn_unit();
        $('#btn_selunit').trigger('click');
        $('#year').val(json.now_year);
        $('#month').val(json.now_month);
        day_init(json.now_year, json.now_month, json.max_day, json.first_week);
        $('#tr_d th').click(function () {
            var t = $(this).index();
            $('#dbody tr').each(function () {
                $(this).find(' td:eq(' + t + ')').trigger('click');
            });
        });
        $('#tr_d th:lt(5)').trigger('click');
        $('#btn_sure').click(function () {
            $('#form1').ajaxSubmit({
                url: "/statistics/sure_tj",
                beforeSubmit: function (arr) {
                    try {
                        layer.msg("请稍等，正在为您计算统计");
                    } catch (e) {
                    }
                    for (var i in arr) {
                        if (arr[i].name == 'i_days') {
                            arr[i].value = $('#dbody .bg-red').map(function () {
                                return $(this).text();
                            }).get().join(',');
                        }
                    }
                    $('#t_body').empty();
                },
                success: function (data) {
                    var null20 = function (dat) {
                        if (dat == null) return 0;
                        else return dat;
                    };
                    for (var i in data.result) {
                        var now = data.result[i], tr = b.new_tr();
                        tr.append(b.new_td(now.dept_name)).append(b.new_td(now.XM)).append(b.new_td(now.cd1 + now.cd3)).append(b.new_td(now.zt2 + now.zt4)).append(b.new_td(now.kg))
                            .append(b.new_td(null20(now.wc))).append(b.new_td(null20(now.qj))).append(b.new_td(null20(now.cc)));
                        $('#t_body').append(tr);
                    }
                }
            })
        });
        $('#excel_submit').click(function () {
            $('#i_days').val($('#dbody .bg-red').map(function () {
                return $(this).text();
            }).get().join(','));
            $('#form1').submit();
        });
        /**
         * 锁定时间
         */
        $('#sd').click(function () {
            $.ajax({
                url: '/statistics/sure_time',
                data: {year: $('#year').val(), month: $('#month').val()},
                success: function (dat) {
                    day_init($('#year').val(), $('#month').val(), dat.day_max, dat.first_week);
                    if (json_cont.now_year == $('#year').val() && json_cont.now_month == $('#month').val()) {

                    }
                    $('#tr_d th:lt(5)').trigger('click');
                }
                , dataType: "json"
            });
        });
    };


    function getUnitType() {
        return $(':input[name="unitType"]:checked').val();
    }

    function set_unit(data, hide) {
        $('#unit').val(hide);
        $('#div_choose').text(data);
    }

    function day_init(y, m, md, fd) {
        $('#dbody').empty();
        var rows = parseInt((md + fd) / 7), tc = -fd + 1, ys = (md + fd - 1) % 7;
        if (ys != 0) {
            rows++;
        }
        var cl = function () {
            var $this = $(this);
            $this.toggleClass(color_class);
        };
        for (var i = 0; i < rows; i++) {
            var tr = b.new_tr();
            for (var j = 0; j < 7; j++) {
                var obj = b.new_td();
                tc++;
                if (tc > 0 && tc <= md) {
                    obj.text(tc);
                    obj.click(cl);
                }
                tr.append(obj);
            }
            if (i == rows - 1 && tr.find('td:eq(0)').text() == "") {
                break;
            }
            $('#dbody').append(tr);
        }
        if (json_cont.now_year == $('#year').val() && json_cont.now_month == $('#month').val()) {

        }
    }

    function init_btn_unit() {
        set_unit('', '');
        $('.cunit').each(function () {
            var $this = $(this);
            if (getUnitType() == 0) {
                if ($this.is(":input")) {
                    $this.val($this.val().replace(arr_unit[1], arr_unit[0]));
                } else {
                    $this.text($this.text().replace(arr_unit[1], arr_unit[0]));
                }
            } else {
                if ($this.is(":input")) {
                    $this.val($this.val().replace(arr_unit[0], arr_unit[1]));
                } else {
                    $this.text($this.text().replace(arr_unit[0], arr_unit[1]));
                }
            }
        });
        $('#btn_selunit').unbind('click').click(function () {
            if (getUnitType() == 0) {
                set_unit(json_cont.fyname, json_cont.fy);
            } else {
                set_unit(json_cont.dept_name, json_cont.deptId);
            }
            try {
                layer.msg("已选择本" + arr_unit[getUnitType()]);
            } catch (e) {
            }
        }).trigger('click');
        $('#other_fy').unbind('click');
        if (getUnitType() == 0) {
            $.openSelect('#other_fy', {
                fy: {
                    hideSelect: "#hide_v",
                    showSelect: "#show_v",
                    hideType: "fy",
                    showType: "name",
                    selectedMulti: false
                }, onEnd: function () {
                    set_unit(arguments[1], arguments[0])
                }, email: login_user, systemMark: sysMark, permis: true
            });
        } else {
            $.openSelect('#other_fy', {
                dept: {
                    hideSelect: "#hide_v",
                    showSelect: "#show_v",
                    hideType: "id",
                    showType: "name",
                    selectedMulti: false
                }, onEnd: function () {
                    set_unit(arguments[1], arguments[0])
                }, email: login_user, systemMark: sysMark, permis: true
            });
        }
    }
});