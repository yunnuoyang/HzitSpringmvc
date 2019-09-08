<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/8/15
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
</head>
<body>
<sf:form action="doconvert" modelAttribute="file">
    显示日期<sf:input  path="upDate"></sf:input>
    <sf:button value="提交"> </sf:button>
</sf:form>
</body>
</html>
