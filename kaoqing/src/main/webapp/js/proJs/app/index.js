define(function (require, exports, module) {
    var b = require('build');
    var p = require('page');
    exports.init = function (obj, type) {
        var arr_state = {0: "未审批", 1: "审批通过", 2: '审批未通过'};
        var arr_state_color = ['text-gray', 'text-green', 'text-red'];
        console.log(obj);
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
        for (var i = 0; i < obj.list.length; i++) {
            var obj1 = obj.list[i];
            var tr = b.new_tr();
            tr.append(b.new_td(p.getCount())).append(b.new_td(type[obj1.type]))
                .append(b.new_td(b.time_format(obj1.time_sq)).attr('title', obj1.time_sq)).append(b.new_td().html(function () {
                return obj1.time_start + " 至<br/>" + obj1.time_end;
            }()))
                .append(b.new_td(b.sub_cont(obj1.reason, 10, "...")))
                .append(b.new_td(obj1.sprxm))
                .append(b.new_td().html(function () {
                    return b.new_span(arr_state[obj1.state]).addClass(arr_state_color[obj1.state]);
                }()))
                .append(b.new_td().html(function () {
                    return b.new_span(obj1.state == 0 ? arr_state[0] : b.time_format(obj1.time_sp)).addClass(arr_state_color[obj1.state]).attr('title', obj1.time_sp);
                }())).append(b.new_td().html(function () {
                return b.new_span(obj1.state == 0 ? arr_state[0] : b.sub_cont(obj1.sp_reason, 10, "...")).attr('title', obj1.sp_reason).addClass(arr_state_color[obj1.state]);
            }()));
            $('#tbody').append(tr);
        }
        $('#sq').click(function () {
            location.href = '/apply/add?r=' + Math.random();
        });
    };
});