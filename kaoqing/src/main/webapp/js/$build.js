define(function (require, exports, module) {
    exports.new_tr = function () {
        return $('<tr></tr>');
    };
    exports.new_td = function (str) {
        var td = $('<td></td>');
        if (typeof str != "undefined" || str != '')td.text(str);
        // else if (typeof str == "object") td.append(str);
        return td;
    };
    exports.new_th = function (str) {
        var th = $('<th></th>');
        if (str)th.text(str);
        return th;
    };
    exports.new_hi = function (str) {
        var input = $('<input  type="hidden"  />');
        if (typeof str != "undefined" || str != '')input.val(str);
        return input;
    };
    exports.new_li = function () {
        return $('<li></li>');
    };
    exports.new_a = function () {
        return $('<a></a>');
    };
    exports.new_span = function (str) {
        var td = $('<span></span>');
        if (typeof str != "undefined" || str != '')td.text(str);
        return td;
    };
    exports.sub_cont = function (cont, length, append) {
        if (typeof cont == "string") {
            return cont.substr(0, length) + (cont.length > length && typeof append != "undefined" ? append : "");
        }
        return "";
    };
    exports.time_format = function (time) {
        time = time.replace(/-/g, "/");
        time = new Date(time);
        return time.getFullYear() + '-' + (time.getMonth() + 1) + '-' + time.getDate();
    };
});