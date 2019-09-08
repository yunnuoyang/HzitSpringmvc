<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/8/11
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sp" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<h2>${name}</h2>--%>
登陆界面
<script src="xxx/jquery-1.9.1.min.js">
</script>
<script>
        $(function(){
            alert("rtty");
        })
</script>
<sp:form action="addUser" modelAttribute="user" >

    用户名:<sp:input path="username" ></sp:input> <sp:errors path="username"/>
    <br>
    密码:<sp:password path="password"></sp:password><sp:errors path="password"/>
    性别：<sp:radiobuttons path="sex"  items="${sex}"></sp:radiobuttons>
    爱好：<sp:checkboxes path="hobby" items="${hobby}"></sp:checkboxes>
        <sp:button value="提交"></sp:button>
</sp:form>
/*// <form action="login" method="post">
//     用户名<input name="username">
//     密码<input name="password">
// </form>*/
</body>
</html>
