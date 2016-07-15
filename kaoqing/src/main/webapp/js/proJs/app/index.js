define(function (require, exports, module) {
    var b = require('build');
    var p = require('page');
    exports.init = function (obj, type) {
        var arr_state = {0: "未审批", 1: "审批通过", 2: '审批未通过'};
        var option = {
            firstPage: obj.firstPage,
            lastPage: obj.lastPage,
            pageNumber: obj.pageNumber,
            pageSize: obj.pageSize,
            totalPage: obj.totalPage,
            totalRow: obj.totalRow,
            targetContent: '#jpage',
            activeClass: "bg-red",
            call: function (page, pageSize) {
                location.href = window.location.pathname + "?page=" + page + "&pageSize=" + pageSize + "&r=" + Math.random();
            }
        };
        p.init(option);
        console.log(obj);
        for (var i = 0; i < obj.list.length; i++) {
            var obj1 = obj.list[i];
            var tr = b.new_tr();
            tr.append(b.new_td(obj1.spr)).append(b.new_td(type[obj1.type])).append(b.new_td(obj1.time_sq)).append(b.new_td(obj1.reason)).append(b.new_td().text(function () {
                return arr_state[obj1.state];
            }()))/*.append(b.new_td().text(function () {
             return "暂无";
             }()))*/;
            $('#tbody').append(tr);
        }
        $('#sq').click(function () {
            layer.open({
                title: "申请", type: 2, content: ['/apply/add'], area: ['100%', '100%'], end: function () {
                    location.reload();
                }
            });
        });
    };
});