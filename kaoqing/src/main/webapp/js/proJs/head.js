define(function (require, exports, module) {
    var b = require('build');
    var arr_me = ['权限管理', '参数配置', '统计'];
    exports.init = function (obj, oo) {
        exports.permis = obj.permis;
        var tar = $('#nav-pills6');
        for (var i = 0; i < obj.mname.length; i++) {
            var obj1 = obj.mname[i], li = b.new_li(), a = b.new_a();
            li.addClass('float-left');
            if (i == oo)li.addClass('active');
            a.attr('href', obj.murl[i] + "?r=" + Math.random()).text(obj1);
            if ($.inArray(obj1, arr_me) != -1) {
                if (obj1 == arr_me[0] && $.inArray('9', obj.permis) != -1) tar.append(li.append(a.attr('target', '_blank')));
                else if (obj1 == arr_me[1] && $.inArray('8', obj.permis) != -1) tar.append(li.append(a));
                else if (obj1 == arr_me[2] && $.inArray('6', obj.permis) != -1) tar.append(li.append(a));
            } else tar.append(li.append(a));
            if (i == 4 && obj.weidu != 0) {
                a.html(a.html() + '<span class="text-red">(' + obj.weidu + ')</span>');
            }
        }
    };
});