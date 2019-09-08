<%@page language="java" pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<%
    System.out.println("+++5555+++");
%>
<script src="js/jquery-3.3.1.js"></script>
<h2>Hello World!</h2>
<h2>首页</h2>
<c:if test="${empty sessionScope.user}">
    先进行登陆
</c:if>
<c:if test="${not empty sessionScope.user}">
    欢迎回来${sessionScope.user.username}
</c:if>
<a id="a" href="init">Let is go</a><br>
<a id="a" href="logout">exit</a><br>
<a id="a" href="show">showpage</a>
<a id="a" href="convert">查看日期转换器</a>

</body>
</html>
