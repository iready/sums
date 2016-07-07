define(function (require, exports, module) {
    require('suser');
    exports.init = function (obj) {
        $.openSelect('#choose', {
            user: {
                hideSelect: "#hide_v",
                showSelect: "#show_v",
                hideType: "youxiang",
                showType: "xm",
                selectedMulti: false,
            }, onEnd: function () {
                $('#spr').val(arguments[0])
                $('#div_s').text(arguments[1]);
            }
        });
    }
});