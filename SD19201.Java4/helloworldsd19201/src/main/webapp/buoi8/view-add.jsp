<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: syn
  Date: 22/07/2024
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Add</h2>
    <form action="/bac-si/add" method="post">
        Ten: <input type="text" name="ten"> <br>
        Tuoi: <input type="number" name="tuoi"> <br>
        Phong kham:
        <select name="phongKham">
            <c:forEach items="${danhSachPhongKham}" var="pk">
                <option value="${pk.id}" label="${pk.ten}"></option>
            </c:forEach>
        </select> <br>
        <button>Save</button>
    </form>
</body>
</html>
