define(function (require, exports, module) {
    exports.new_tr = function () {
        return $('<tr></tr>');
    }
    exports.new_td = function (str) {
        var td = $('<td></td>');
        if (typeof str != "undefined" || str != '')td.text(str);
        // else if (typeof str == "object") td.append(str);
        return td;
    }
    exports.new_th = function (str) {
        var th = $('<th></th>');
        if (str)th.text(str);
        return th;
    }
    exports.new_hi = function (str) {
        var input = $('<input  type="hidden"  />');
        if (typeof str != "undefined" || str != '')input.val(str);
        return input;
    };
});