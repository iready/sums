define(function (require, exports, module) {
    var b = require('build');
    exports.init = function (obj, type) {
        var arr_state = {0: "未审批", 1: "审批通过", 2: '审批未通过'};
        for (var i = 0; i < obj.length; i++) {
            var now = obj[i], tr = b.new_tr();
            tr.append(b.new_td(now.sqr)).append(b.new_td(type[now.type])).append(b.new_td(now.time_sq))
                .append(b.new_td(now.time_sp)).append(b.new_td(now.sp_reason)).append(b.new_td(arr_state[now.state]));
            $('#tbody').append(tr);
        }
    }
});