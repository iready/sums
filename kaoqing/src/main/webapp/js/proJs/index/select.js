define(function (require, exports, module) {
    var h = require("proJs/head.js");
    require('jform');
    require('suser');
    var b = require('build');
    var arr_dj = ['第一次打卡', '第二次打卡', '第三次打卡', '第四次打卡'];
    var arr_state_color = ['text-gray', 'text-green', 'text-red'];
    exports.init = function (cont) {
        $('#lx').change(function () {
            lx_init();
        });
        lx_init();
        $('#i_start').val(laydate.now());
        if ($.inArray('10', h.permis) != -1) {
            $('#other').show();
            $('#hide_v').val(login_user);
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
                data: {
                    r: Math.random(),
                    tar: $('#hide_v').val(),
                    start: $('#i_start').val(),
                    end: $('#i_end').val(),
                    type: $('#lx').val()
                },
                success: function (json) {
                    if (parseInt($('#lx').val()) == 0) {
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
                    } else {
                        var arr_state = {0: "未审批", 1: "审批通过", 2: '审批未通过'};
                        var cc = 0;
                        if (json.length == 0) {
                            var tr = b.new_tr();
                            tr.append(b.new_td("无任何申请记录").addClass('text-center text-gray').attr('colspan', 9));
                            $('#t_body').append(tr);
                        }
                        for (var i in json) {
                            var tr = b.new_tr();
                            var now = json[i];
                            tr.append(b.new_td(++cc))
                                .append(b.new_td(cont.type[now.type]))
                                .append(b.new_td(b.time_format(now.time_sq)).attr('title', now.time_sq))
                                .append(b.new_td().html(function () {
                                    return now.time_start + " 至<br/>" + now.time_end;
                                }()))
                                .append(b.new_td(b.sub_cont(now.reason, 10, "...")))
                                .append(b.new_td(now.XM))
                                .append(b.new_td().html(function () {
                                    return b.new_span(now.state == 0 ? arr_state[0] : b.time_format(now.time_sp)).addClass(arr_state_color[now.state]).attr('title', now.time_sp);
                                }())).append(b.new_td().html(function () {
                                return b.new_span(now.state == 0 ? arr_state[0] : b.sub_cont(now.sp_reason, 10, "...")).attr('title', now.sp_reason).addClass(arr_state_color[now.state]);
                            }())).append(b.new_td().html(function () {
                                return b.new_span(arr_state[now.state]).addClass(arr_state_color[now.state]);
                            }()));
                            $('#t_body').append(tr);
                        }
                    }
                }
            });
        });
    };
    function lx_init() {
        $('#thead').empty();
        var i1 = $('#lx').val();
        if (parseInt(i1) == 0) {
            var arr_head = ['序号', '姓名', '登记类型', '登记时间', '打卡状态'];
            var tr = b.new_tr();
            for (var i in arr_head) {
                tr.append(b.new_td(arr_head[i]));
            }
            $('#thead').append(tr)
        } else {
            var arr_head = ['序号', '申请类型', '申请时间', '申请时间区间', '申请原因', '审批人', '审批状态', '审批时间', '审批理由'];
            var tr = b.new_tr();
            for (var i in arr_head) {
                tr.append(b.new_td(arr_head[i]));
            }
            $('#thead').append(tr)
        }
    }
});