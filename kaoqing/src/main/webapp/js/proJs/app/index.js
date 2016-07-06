define(function (require, exports, module) {
    var b = require('build');
    exports.init = function (obj) {
        var arr_state = {0: "未审批", 1: "审批通过", 2: '审批未通过'};
        for (var i = 0; i < obj.length; i++) {
            var obj1 = obj[i];
            console.log(obj1);
            var tr = b.new_tr();
            tr.append(b.new_td(obj1.sqr)).append(b.new_td(obj1.spr)).append(b.new_td().text(function () {
                return arr_state[obj1.state];
            }())).append(b.new_td().text(function () {
                return "暂无";
            }()));
            $('#tbody').append(tr);
        }
    };
});