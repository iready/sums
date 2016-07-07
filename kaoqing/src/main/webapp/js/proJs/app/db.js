define(function (require, exports, module) {
    var b = require('build');
    exports.init = function (obj, type) {
        var dq = undefined;
        for (var i = 0; i < obj.length; i++) {
            var now = obj[i], tr = b.new_tr();
            tr.append(b.new_td(now.sqr)).append(b.new_td(now.time_sq)).append(b.new_td(type[now.type])).append(b.new_td().append(function () {
                return $("<a href='javascript:;' class='button'>审批</a>").data('_id', now.id).click(function () {
                    dq = $(this).data('_id');
                    layer.open({
                        type: 1,
                        title: "审批",
                        content: $('#mydialog'),
                        area: ['500px', '300px']
                    });
                });
            }()));
            $('#tbody').append(tr);
        }
        $('#btn_sure').click(function () {
            $.ajax({
                url: '/apply/ajax_sp',
                data: {id: dq, state: $(':input[name="sp"]:checked').val(), sp_reason: $('#liy').val()},
                success: function () {
                    layer.msg(arguments[0]);
                    location.reload();
                }
            });
        })
    };
});