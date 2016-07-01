define(function (require, exports, module) {
    var b = require('build');
    var arr_dk = ['first', 'second', 'third', 'fourth'];
    var arr_class = ['input input-auto text-center'];
    var json_form = {
        first: ['first_1', 'first_2'],
        second: ['second_1', 'second_2'],
        third: ['third_1', 'third_2'],
        fourth: ['fourth_1', 'fourth_2'],
        sb: ['after_sb', 'before_sb'],
        xb: ['after_xb', 'before_xb'],
        hc: ['hc_sb', 'hc_xb']
    };
    exports.init = function () {
        // 吊炸天脚本渲染
        for (var i in json_form) {
            for (var ii in json_form[i]) {
                $('#' + json_form[i][ii]).addClass(arr_class[0]);
            }
        }
        $('#configform').submit(function () {
            // 先假设全部验证通过

            // 取值操作
            var div_con = $('#con').empty();
            for (var i in arr_dk) {
                var t1 = json_form[arr_dk[i]][0];
                var t2 = json_form[arr_dk[i]][1];
                div_con.append(b.new_hi($('#' + t1).val() + ':' + $('#' + t2).val() + ':59').attr('name', 'c.' + arr_dk[i]));
            }
            return true;
        });
    }
});