<%--
  Created by IntelliJ IDEA.
  User: zhang
  Date: 2019/8/14
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.3.1.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            $("#get").click(function () {
                    alert(1);
                    //请求参数
                    var list = {id:28,"title":"xxxx","content":"NNNNNNN"};

                    $.ajax({
                        //请求方式
                        type : "get",
                        //请求的媒体类型
                        contentType: "application/json;charset=UTF-8",
                        //请求地址
                        url : "getresources",
                        //数据，json字符串
                        //data : JSON.stringify(list),//将json转为string   parse 正好相反
                        data : list,
                        //请求成功
                        success : function(result) {
                            alert("==="+result);

                            $("#result").html(result);
                        },
                        //请求失败，包含具体的错误信息
                        error : function(e){
                            $("#result").html(e.status);
                            $("#result").html(e.responseText);
                        }
                    });

            });
            $("#post").click(function () {
                alert(2);
                //请求参数
                var list = {id:28,name:"天气很热",sex:"男"};
                alert(JSON.stringify(list));
                $.ajax({
                    //请求方式
                    type : "post",
                    //请求的媒体类型
                    contentType: "application/json;charset=UTF-8",
                    //请求地址
                    url : "addresources",
                    //数据，json字符串
                    data : JSON.stringify(list),//将json转为string   parse 正好相反
                    //data : list,
                    //请求成功
                    success : function(result) {
                        alert("==="+result);
                        $("#result").html(result);
                    },
                    //请求失败，包含具体的错误信息
                    error : function(e){
                        $("#result").html(e.status);
                        $("#result").html(e.responseText);
                    }
                });
            });
            $("#put").click(function () {
                alert(3);
                //请求参数
                var list = {id:28,name:"天气很热",sex:"男"};

                $.ajax({
                    //请求方式
                    type : "put",
                    //请求的媒体类型
                    contentType: "application/json;charset=UTF-8",
                    //请求地址
                    url : "updateresources",
                    //数据，json字符串
                    data : JSON.stringify(list),//将json转为string   parse 正好相反
                    //data : list,
                    //请求成功
                    success : function(result) {
                        alert("==="+result);
                        $("#result").html(result);
                    },
                    //请求失败，包含具体的错误信息
                    error : function(e){
                        $("#result").html(e.status);
                        $("#result").html(e.responseText);
                    }
                });
            });
            $("#delete").click(function () {
                alert(4);
                $.ajax({
                    //请求方式
                    type : "delete",
                    //请求的媒体类型
                    contentType: "application/json;charset=UTF-8",
                    //请求地址
                    url : "deleteresources/3",
                    //请求成功
                    success : function(result) {
                        alert("==="+result);

                        $("#result").html(result);
                    },
                    //请求失败，包含具体的错误信息
                    error : function(e){
                        $("#result").html(e.status);
                        $("#result").html(e.responseText);
                    }
                });
            });
        });
    </script>
</head>

<body>
    <div>
        <input id="get" type="button" value="GET（查询）"> |
        <input id="post" type="button" value="POST（添加）"> |
        <input id="put" type="button" value="PUT（修改）"> |
        <input id="delete" type="button" value="DELETE（删除）">
    </div>
    <div id="result"></div>
</body>
</html>
