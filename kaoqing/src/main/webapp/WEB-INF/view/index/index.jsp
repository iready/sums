<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.zyq.core.lang.T" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <jsp:include page="/WEB-INF/common/head.jsp"/>
    <script type="text/javascript">
        seajs.use('proJs/index/index', function (v) {
            v.init(${c},<%=System.currentTimeMillis()%>,${salarys},${btn_show});
        })
    </script>
</head>
<body>
<jsp:include page="/WEB-INF/common/top.jsp"/>
<div class="container ">
    <c:if test="${empty confId}">
        <div class="alert alert-yellow">
            <span class="close rotate-hover"></span><strong>注意：</strong>您所在的法院或者部门没有配置相应的打卡参数，请联系管理员
        </div>
    </c:if>
    <c:if test="${not empty confId}">
        <br>
        <table class="table">
            <tr class="fadein-top">
                <th colspan="4" >
                    日期：<%=new SimpleDateFormat("yyyy年MM月dd日").format(new Date()) + " " + T.getWeekOfDate(new Date())%>
                </th>
            </tr>
            <tr class="fadein-bottom">
                <td>登记类型</td>
                <td>标准打卡时间</td>
                <td>登记时间</td>
                <td>操作</td>
            </tr>
            <tbody id="tb_1"></tbody>
        </table>
    </c:if>
</div>
</body>
</html>