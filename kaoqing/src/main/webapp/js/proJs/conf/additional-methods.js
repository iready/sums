jQuery.validator.addMethod("byteRangeLength", function (value, element, param) {
    var length = value.length;
    for (var i = 0; i < value.length; i++) {
        if (value.charCodeAt(i) > 127) {
            length++;
        }
    }
    return this.optional(element) || ( length >= param[0] && length <= param[1] );
}, $.validator.format("请确保输入的值在{0}-{1}个字节之间(一个中文字算2个字节)"));

$.validator.addMethod("hour", function (value, element, param) {
    value = parseInt(value);
    if (!isNaN(value)) {
        $(element).val(value);
        return value > param[0] && value < param[1];
    }
    return false;
}, $.validator.format("请输入{0}-{1}之间的数字"));

$.validator.addMethod("af", function (value, element, params) {
    if (value.length > 1) {
        return false;
    }
    if (value >= params[0] && value <= params[1]) {
        return true;
    } else {
        return false;
    }
}, "必须是一个字母,且a-f");