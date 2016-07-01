<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="layout bg-black" style="padding: 10px 0;color: #999;">
    <div class="container">
        <div class="line">
            <div class="x8">
                欢迎使用考勤系统
            </div>
        </div>
    </div>
</div>
<div class="container" style="padding: 10px 0">
    <button class="button icon-navicon" data-target="#nav-pills6">
    </button>
    <ul class="nav nav-menu nav-inline nav-pills nav-justified nav-big nav-navicon  border-yellow" id="nav-pills6">
        <li ><a href="/config/view_list">我要打卡</a></li>
        <li class="active"><a href="/config/view_list">参数配置</a></li>
        <li><a>我的审批</a></li>
        <li><a>我的申请</a></li>
        <li><a>我的代办</a></li>
        <li><a>统计</a></li>
        <%--<li>参数配置</li>--%>
    </ul>
</div>