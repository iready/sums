define(function (require, exports, module) {
    var b = require('build');
    var p = require('page');
    require('jform');
    exports.init = function (obj, type) {
        var dq = undefined;
        for (var i = 0; i < obj.length; i++) {
            var obj1 = obj[i], tr = b.new_tr();
            tr.append(b.new_td(p.getCount()))
                .append(b.new_td(type[obj1.type]))
                .append(b.new_td(obj1.sqrxm))
                .append(b.new_td(b.time_format(obj1.time_sq)).attr('title', obj1.time_sq))
                .append(b.new_td().html(function () {
                    return obj1.time_start + " 至<br/>" + obj1.time_end;
                }()))
                .append(b.new_td(b.sub_cont(obj1.reason, 10, "...")))
                .append(b.new_td().append(function () {
                return $("<a href='javascript:;' class='button button-small'>审批</a>").data('_id', obj1.id).click(function () {
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
            if ($('#liy').val() == "") {
                alert("请输入理由");
                return;
            }
            $('#my_id').val(dq);
            $('#form1').ajaxSubmit({
                success: function () {
                    location.reload();
                }
            });
        })
    };
});