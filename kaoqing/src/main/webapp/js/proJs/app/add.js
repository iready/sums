define(function (require, exports, module) {
    require('suser');
    exports.init = function (obj) {
        $.openSelect('#choose', {
            user: {
                hideSelect: "#hide_v",
                showSelect: "#show_v",
                hideType: "id",
                showType: "name",
                selectedMulti: true,
            }, onEnd: function () {
                // panel_b.text(arguments[1]);
                // panel_show_div.fadeIn();
            }
        });
    }
});