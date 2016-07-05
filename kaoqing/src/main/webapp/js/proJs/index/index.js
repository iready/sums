define(function (require, exports, module) {
    var b = require('build');
    exports.init = function (json, time, sal, btn_show) {
        var arr_dk = ['first', 'second', 'third', 'fourth'];
        var arr_dk_value = ['第一次打卡', '第二次打卡', '第三次打卡', '第四次打卡'];
        var time = new Date(time);
        for (var i in arr_dk) {
            var tr = b.new_tr();
            var bzdk = json[arr_dk[i]], flag_dk = false;
            tr.append(b.new_td(arr_dk_value[i]));
            tr.append(b.new_td(bzdk));
            for (var ii in sal) {
                if (sal[ii].type == i) {
                    tr.append(b.new_td(sal[ii].time_dj));
                    tr.append(b.new_td().append('<span class="text-green">已打卡</span>'));
                    flag_dk = true;
                }
            }
            if (!flag_dk) {
                tr.append(b.new_td().append('<span class="text-gray">暂无打卡记录</span>'));
                tr.append(b.new_td().append(function () {
                    var bt = undefined;
                    /*判断是否显示button*/
                    if (btn_show[arr_dk[i]]) {
                        bt = $('<button class="button text-blue">打卡</button>').data("type", i);
                        bt.click(function () {
                            $.ajax({
                                url: '/dk', data: {type: $(this).data('type')}, success: function (dat) {
                                    var tishi = dat.result ? "成功" : "失败\n失败原因：" + dat.info;
                                    alert(tishi)
                                    if (dat.result)window.location.reload();
                                }
                            });
                        });
                    } else {
                        bt = $('<span class="text-red">非打卡时间</span>')
                    }
                    return bt;
                }()));
            }
            $('#tb_1').append(tr);
        }
    };
});