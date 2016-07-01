/*统一工具库*/
define(function (require, exports, module) {
    /**
     * 字符串转数组
     * @param str '["1","2"]'
     * @param spl
     * @returns {Array}
     */
    exports.str2Arr = function (str, spl) {
        return str.replace(/[\[\]]/g, '').split(spl ? spl : ',');
    };
    /**
     * 相等判断
     * @param s1
     * @param s2
     * @returns {boolean}
     */
    exports.equals = function (s1, s2) {
        return s1.replace(/^\s*|\s*$/g, "") == s2.replace(/^\s*|\s*$/g, "");
    };
    /**
     * 去空格
     * @param s
     * @returns {XML|void|string|*}
     */
    exports.trim = function (s) {
        return s.replace(/^\s*|\s*$/g, "");
    };
    /**
     * 文字字符串组成的数组去空
     * @param arr
     * @returns {Array}
     */
    exports.strArr_trim = function (arr) {
        var _arr = [];
        for (var obj in arr) {
            _arr[obj] = exports.trim(arr[obj]);
        }
        return _arr;
    };
    /**
     * js原生数组扩展
     * @param dx
     * @returns {boolean}
     */
    Array.prototype.remove = function (dx) {
        if (isNaN(dx) || dx > this.length) {
            return false;
        }
        for (var i = 0, n = 0; i < this.length; i++) {
            if (this[i] != this[dx]) {
                this[n++] = this[i];
            }
        }
        this.length -= 1;
    };
    /**
     * 不产生新的数组，将数组中可能为数字的地方改成数字类型
     */
    exports.parseArr = function () {
        for (var param in arguments) {
            for (var p in arguments[param]) if ($.isNumeric(arguments[param][p])) arguments[param][p] = parseInt(arguments[param][p]);
        }
    };
    /**
     * 是不是Undefinded
     * @returns {boolean}
     */
    exports.isUndefined = function () {
        if (arguments.length == 0)return true;
        else if (arguments.length == 1) {
            return typeof arguments[0] == "undefined";
        }
        for (var param in arguments) if (typeof arguments[param] == "undefined") return true;
        return false;
    };
    exports.isFunction = function () {
        if (typeof arguments[0] == 'function') {
            return true;
        }
        return false;
    };
});