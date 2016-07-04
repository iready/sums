<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="org.zyq.core.lang.T" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/common/head.jsp"/>
    <script type="text/javascript">
        seajs.use('proJs/index/index', function (v) {
            v.init();
        })
    </script>
</head>
<body>
<jsp:include page="/WEB-INF/common/top.jsp"/>
<div class="container">
    <table class="table">
        <tr  >
            <th colspan="4">日期：<%=new SimpleDateFormat("yyyy年MM月dd日").format(new Date()) + " " + T.getWeekOfDate(new Date())%>
            </th>
        </tr>
        <tr>
            <td>登记类型</td>
            <td>上班时间</td>
            <td>登记时间</td>
            <td>操作</td>
        </tr>
    </table>
</div>
</body>
</html>
