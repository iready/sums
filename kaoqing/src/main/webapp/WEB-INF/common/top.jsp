<%@ page import="org.lby.kq.common.SysVar" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="layout bg-black" style="padding: 10px 0;color: #999;">
    <div class="container">
        <div class="line">
            <div class="x8">
                <%=session.getAttribute(SysVar.DEPT_NAME) + "  " + session.getAttribute(SysVar.USER_NAME)%>
                欢迎使用考勤系统
            </div>
        </div>
    </div>
</div>
<div class="container" style="padding: 10px 0">
        <ul class="nav nav-menu nav-inline nav-main nav-justified nav-navicon border-red"   id="nav-pills6">

        </ul>
</div>
<script type="text/javascript">
    seajs.use('proJs/head', function (v) {
        v.init(<%=session.getAttribute(SysVar.json_js_config)%>, '<%=request.getAttribute(SysVar.route_name)%>');
    });
</script>