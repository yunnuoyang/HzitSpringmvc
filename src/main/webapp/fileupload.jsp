<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/8/13
  Time: 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="xxx/jquery-1.9.1.min.js" type="text/javascript"></script>

</head>
<script type="text/javascript">
    $(document).ready(function () {
        $("[value=增加文件]").click(function(){
            var li = $("<li>");
            li.append("选择文件：<input type='file' name='file2'>");
            //li.append(li);

            $("#upcontent").append(li);
        });
    });
</script>
<body>

        <form  enctype="multipart/form-data" method="post" action="uploadfile">
                NIO选择文件<input type="file" name="file">
            <input type="submit" >
            <input type="button" value="增加文件">
        </form>
        <form id="upcontent" enctype="multipart/form-data" method="post" action="tranditionalLoad">
                传统选择文件<input type="file" name="file2">
            <input type="button" value="增加文件">
            <input type="submit" >
        </form>
</body>
</html>
