<%@ page import="org.lby.kq.common.SysVar" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<title>考勤系统</title>
<meta name="renderer" content="webkit"/>
<meta http-equiv=X-UA-Compatible content="IE=edge,chrome=1"/>
<meta http-equiv="X-UA-Compatible" content="IE=8">
<meta content=always name=referrer/>
<script type="text/javascript" src="<%=SysVar.sys_In%>/jquery/jquery.min.js"></script>
<%--<script type="text/javascript" src="/js/jquery/jquery.183.js"></script>--%>
<%@include file="/WEB-INF/common/layer.jsp" %>
<%--<link rel="stylesheet" href="/js/pintuer.css"/>--%>
<%--<link rel="stylesheet" href="http://147.1.7.11:81/js/pintuer_model/pintuer.css"/>--%>
<link rel="stylesheet" href="<%=SysVar.sys_In%>/js/pintuer_model/pintuer.css"/>
<%--<link rel="stylesheet" href="<%=SysVar.sys_pq%>/js/pintuer_model/pintuer.css" type="text/css"/>--%>

<%--<script type="text/javascript" src="<%=SysVar.sys_pq%>/js/pintuer_model/pintuer.js"></script>--%>
<script type="text/javascript" src="/js/sea.js"></script>
<%--<script type="text/javascript" src="/js/respond.js"></script>--%>
<script type="text/javascript">
    var sys_pq = '<%=SysVar.sys_pq%>';//排期地址
    var sys_In = '<%=SysVar.sys_In%>';//接口地址
    seajs.config({
        alias: {
            "pin": sys_In + "/js/pintuer_model/pintuer",
            "json2": "/js/pintuer_model/json2",
            "suser": sys_In + "/js/select/selectuser.js",
//            "suser": "http://147.1.7.11:81/js/select/selectuser.js",
            "layer": "/js/common/layer/layer-2.1",
            "laydate": "/js/common/laydate/laydate",
            "jform": "/js/proJs/jquery.form.min",
            "base64": "/js/common/base/jquery.base64",
            "build": "/js/$build",
            "qutils": "/js/project_model/zyq/utils",
            "echat": "/js/common/echarts.min",
            "page": "/js/jpages.js"
        },
        preload: ["pin"]
    });
</script>