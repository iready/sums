define(function (require, exports, module) {
    var color_class = 'bg-red';
    require('jform');
    exports.init = function () {
        $('#form1').ajaxForm({
            url: "/statistics/sure_tj",//默认是form action
            beforeSubmit: function () {
                $('#i_days').val($('#days .bg-red').map(function () {
                    return $(this).text();
                }).get().join(','));
            },
            success: function (data) {

            }
        });
        $('#sd').click(function () {
            $.ajax({
                url: '/statistics/sure_time',
                data: {year: $('#year').val(), month: $('#month').val()},
                success: function (dat) {
                    var maxday = dat.day_max, day_cont = $('#days');
                    day_cont.empty();
                    for (var i = 1; i <= maxday; i++) {
                        var button = $('<button class="button">' + i + '</button>').click(function () {
                            $(this).toggleClass(color_class);
                        });
                        day_cont.append(button);
                    }
                }
                , dataType: "json"
            });
        });
    }
});