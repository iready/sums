define(function (require, exports, model) {
    require('suser');
    exports.init = function () {
        $('#pz_fy').click(function () {
            if ($('tr.bg-gray').length == 0) {
                alert("请先选择一个配置，单击你所需要的配置名称即可");
                return;
            }
        });
    };
});