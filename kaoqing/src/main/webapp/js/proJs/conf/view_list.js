define(function (require, exports, model) {
    require('suser');
    exports.init = function () {
        $('.table_click').click(function () {
            var $this = $(this);
            var class_check = 'bg-gray';
            if ($this.is('.' + class_check)) {
                $this.removeClass(class_check);
            } else {
                $this.addClass(class_check);
                $this.siblings().removeClass(class_check)
            }
        });
        $('#pz_fy').click(function () {
            if ($('tr.bg-gray').length == 0) {
                alert("请先选择一个配置，单击你所需要的配置名称即可");
                return;
            }
        });

    };
});