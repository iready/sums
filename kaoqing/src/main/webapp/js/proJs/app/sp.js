define(function (require, exports, module) {
    var b = require('build');
    var p = require('page');
    exports.init = function (obj, type) {
        var arr_state = {0: "未审批", 1: "审批通过", 2: '审批未通过'};
        var arr_state_color = ['text-gray', 'text-green', 'text-red'];
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
        for (var i = 0; i < obj['list'].length; i++) {
            var now = obj['list'][i], tr = b.new_tr();
            tr.append(b.new_td(p.getCount()))
                .append(b.new_td(type[now.type]))
                .append(b.new_td(now.sprxm))
                .append(b.new_td(b.time_format(now.time_sq)).attr('title', now.time_sq))
                .append(b.new_td().html(function () {
                    return now.time_start + " 至<br/>" + now.time_end;
                }()))
                .append(b.new_td(b.sub_cont(now.reason, 10, "...")))
                .append(b.new_td().html(function () {
                    return b.new_span(now.state == 0 ? arr_state[0] : b.time_format(now.time_sp)).addClass(arr_state_color[now.state]).attr('title', now.time_sp);
                }())).append(b.new_td().html(function () {
                return b.new_span(now.state == 0 ? arr_state[0] : b.sub_cont(now.sp_reason, 10, "...")).attr('title', now.sp_reason).addClass(arr_state_color[now.state]);
            }())).append(b.new_td().html(function () {
                return b.new_span(arr_state[now.state]).addClass(arr_state_color[now.state]);
            }()));
            $('#tbody').append(tr);
        }
    }
});