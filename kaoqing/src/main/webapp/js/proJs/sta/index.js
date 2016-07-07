define(function (require, exports, module) {
    exports.init = function () {
        $('#sd').click(function () {
            $.ajax({
                url: '/statistics/sure_time',
                data: {year: $('#year').val(), month: $('#month').val()},
                success: function (dat) {
                    var maxday = dat.day_max, day_cont = $('#days');
                    day_cont.empty();
                    
                }
                , dataType: "json"
            });
        });
    }
});