<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/8/12
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="st" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Title</title>

    <sf:form action="" method="get" modelAttribute="user">
        <st:message code="login.email"></st:message>
        <st:message code="login.username"></st:message>
        <sf:input path="username"></sf:input></br>
        <st:message code="login.password"></st:message>
        <sf:password path="password"></sf:password>
    </sf:form>
</head>
<body>

</body>
</html>
