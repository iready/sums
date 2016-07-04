<%@ page import="org.lby.kq.common.SysVar" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <%
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < SysVar.menu_name.length; i++) {
                sb.append("<li class='");
                if ((Integer) request.getAttribute(SysVar.route_name) == i) {
                    sb.append("active");
                }
                sb.append("'><a href='").append(SysVar.menu_url[i]).append("'>").append(SysVar.menu_name[i]).append("</a></li>");
            }
            out.print(sb);
        %>
    </ul>
</div>