define(function (require, exports, module) {
    var b = require('build');
    exports.init = function (json, time) {
        var arr_dk = ['first', 'second', 'third', 'fourth'];
        var arr_dk_value = ['第一次打卡', '第二次打卡', '第三次打卡', '第四次打卡'];
        var time = new Date(time);
        console.log(json);
        for (var i in arr_dk) {
            var tr = b.new_tr();
            var bzdk = json[arr_dk[i]];
            tr.append(b.new_td(arr_dk_value[i]));
            tr.append(b.new_td(bzdk));
            tr.append(b.new_td());
            tr.append(b.new_td().append(function () {
                /*判断是否显示button*/
                var bt = $('<button class="button text-blue">打卡</button>').data("type", i);
                bt.click(function () {
                    $.ajax({
                        url: '/dk', data: {type: $(this).data('type')}, success: function (dat) {

                        }
                    });
                    console.log($(this).data('type'))
                });
                return bt;
            }()));
            $('#tb_1').append(tr);
        }
    };
});