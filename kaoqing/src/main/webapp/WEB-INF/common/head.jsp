<%@ page import="org.lby.kq.common.SysVar" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<title>考勤系统</title>
<link rel="stylesheet" href="/js/pinture.css"/>
<%--<link rel="stylesheet" href="<%=SysVar.sys_pq%>/js/pintuer_model/pintuer.css" type="text/css"/>--%>
<script type="text/javascript" src="<%=SysVar.sys_In%>/jquery/jquery.min.js"></script>
<%--<script type="text/javascript" src="<%=SysVar.sys_pq%>/js/pintuer_model/pintuer.js"></script>--%>
<script type="text/javascript" src="/js/pintuer.js"></script>
<script type="text/javascript" src="/js/sea.js"></script>
<script type="text/javascript">
    var sys_pq = '<%=SysVar.sys_pq%>';//排期地址
    var sys_In = '<%=SysVar.sys_In%>';//接口地址
    seajs.config({
        alias: {
            "pin": sys_In + "/js/pintuer_model/pintuer",
            "json2": "/js/pintuer_model/json2",
            "suser": "http://147.1.4.52:8187/js/select/selectuser.js",
            "layer": "/js/common/layer/layer-2.1",
            "laydate": "/js/common/laydate/laydate",
            "jform": "/js/proJs/jquery.form.min",
            "base64": "/js/common/base/jquery.base64",
            "build": "/js/$build",
            "qutils": "/js/project_model/zyq/utils",
            "echat": "/js/common/echarts.min",
        },
        preload: ["pin"]
    });
</script>