define(function (require, exports, module) {
    var h = require("proJs/head.js");
    exports.init = function () {
        if ($.inArray('10', h.permis) != -1) {
            $('#other').click(function () {

            }).show();
        }
        
        // $.ajax({
        //     url: '/ajax_time', data: {times: $('#time').val()}, success: function () {
        //
        //     }
        // });
    };
});