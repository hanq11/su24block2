<%--
  Created by IntelliJ IDEA.
  User: syn
  Date: 20/07/2024
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Update</h2>
<form action="/bac-si/update" method="post">
    ID: <input type="text" name="id" value="${bs.id}" disabled> <br>
    Ten: <input type="text" name="ten" value="${bs.ten}"> <br>
    Tuoi: <input type="number" name="tuoi" value="${bs.tuoi}"> <br>
    <button type="submit">Submit</button>
</form>
</body>
</html>
