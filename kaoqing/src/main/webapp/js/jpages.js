//基于jquery
define(function (require, exports, module) {
    var options = {
        targetContent: "",
        firstPage: false,
        lastPage: false,
        pageNumber: 1,
        pageSize: 10,
        totalPage: 1,
        totalRow: 1,
        isFirstShow: true,
        call: "",
        pages: [10, 15, 20, 25, 50, 100],
        select_pageSize: 'sel_ps',
        activeClass: "active"
    };
    var count = 0;
    exports.getCount = function () {
        if (options.totalPage != 0) {
            return (options.pageNumber - 1) * options.pageSize + (++count);
        }
    };
    exports.init = function (o) {
        $.extend(options, o);
        if (o.totalPage != 0) {
            if (options.targetContent == "") {
                alert("找不到容器");
            }
            if (options.isFirstShow) {
                options.targetContent = $(options.targetContent);
                var btn_first = $('<input type="button" class="button" value="第一页"/>');
                var btn_last = $('<input type="button" class="button" value="末页"/>');
                var in_ys = $('<input class="input input-auto" size="5" type="text" />');
                options.targetContent.append(btn_first);
                if (options.firstPage) {
                    btn_first.attr('disabled', 'disabled');
                } else {
                    btn_first.click(function () {
                        goto(1);
                    });
                }
                for (var i = 1; i <= options.totalPage; i++) {
                    var now = $('<input type="button" class="button" value="' + i + '"/>');
                    if (i == options.pageNumber) {
                        now.addClass(options.activeClass);
                    }
                    options.targetContent.append(now.click(function () {
                        goto($(this).val());
                    }));
                }
                options.targetContent.append(btn_last);
                if (options.lastPage) {
                    btn_last.attr('disabled', 'disabled');
                } else {
                    btn_last.click(function () {
                        goto(options.totalPage);
                    });
                }
                options.targetContent.append('<span>总计' + options.totalRow + '条记录</span>');
                var span_tz = "<span> 跳至</span>";
                var span_ys = "<span>页</span>";
                options.targetContent.append(span_tz).append(in_ys).append(span_ys);
                // 确定事件
                in_ys.keyup(function () {
                    var vl = parseInt($(this).val());
                    if (!isNaN(vl) && vl > 0 && vl <= options.totalPage) {
                        goto(vl);
                    } else {
                        alert("无效数值");
                    }
                });
                var sel_size = $('<select id="' + options.select_pageSize + '"></select>');
                for (var i in options.pages) {
                    sel_size.append('<option value="' + options.pages[i] + '">' + options.pages[i] + '</option>');
                }
                sel_size.val(options.pageSize);
                sel_size.change(function () {
                    if ($(this).val() * options.pageNumber > options.totalRow) {
                        goto(1);
                    } else {
                        goto(options.pageNumber);
                    }
                });
                options.targetContent.append(sel_size);
            }
        }
    };
    function goto(page) {
        if (options.call == "") {
            alert("请实现点击事件");
            return;
        }
        options.call(page, $('#' + options.select_pageSize).val());
    }
});