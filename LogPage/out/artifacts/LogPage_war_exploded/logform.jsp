<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2022/5/10
  Time: 1:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form name="myform">
        yhm:<input type="text" name="username">
        mima:<input type="password" name="password">
        <input type="button" value="提交" onclick="change()">
    </form>
    <script>
        function change(){
            var key = 1;
            myfrom.password = key;
        }
        myfrom.method = "post";
        myfrom.submit();
    </script>
</body>
</html>
