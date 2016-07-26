define(function (require, exports, module) {
    var h = require("proJs/head.js");
    require('jform');
    require('suser');
    var b = require('build');
    var arr_dj = ['第一次打卡', '第二次打卡', '第三次打卡', '第四次打卡'];
    exports.init = function () {
        $('#lx').change(function () {
            lx_init();
        });
        lx_init();
        $('#i_start').val(laydate.now());
        if ($.inArray('10', h.permis) != -1) {
            $('#other').show();
            $.openSelect('#other', {
                user: {
                    hideSelect: "#hide_v",
                    showSelect: "#show_v",
                    hideType: "youxiang",
                    showType: "xm",
                    selectedMulti: false
                }, onEnd: function () {
                    $('#target').text(arguments[1]);
                }, email: login_user, systemMark: sysMark, permis: true
            });
        }
        $('#btn_sure').click(function () {
            $('#t_body').empty();
            $.ajax({
                url: '/find',
                data: {r: Math.random(), tar: $('#hide_v').val(), start: $('#i_start').val(), end: $('#i_end').val()},
                success: function (json) {
                    var cc = 0;
                    if (json.length == 0) {
                        var tr = b.new_tr();
                        tr.append(b.new_td("无任何打卡记录").addClass('text-center text-gray').attr('colspan', 5));
                        $('#t_body').append(tr);
                    }
                    for (var i in json) {
                        var tr = b.new_tr();
                        var now = json[i];
                        tr.append(b.new_td(++cc))
                            .append(b.new_td(now.XM))
                            .append(b.new_td(arr_dj[now.type]))
                            .append(b.new_td(now.time_dj))
                            .append(b.new_td(now.rr));
                        $('#t_body').append(tr);
                    }
                }
            });
        });
    };
    function lx_init() {
        var i1 = $('#lx').val();
        if (parseInt(i1) == 0) {
            var arr_head = ['序号', '姓名', '登记类型', '登记时间', '打卡状态'];
            var tr = b.new_tr();
            for (var i in arr_head) {
                tr.append(b.new_td(arr_head[i]));
            }
            $('#thead').append(tr)
        }
    }
});