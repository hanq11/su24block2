<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: syn
  Date: 22/07/2024
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>update</h2>
    <form action="/bac-si/update" method="post">
        ID: <input type="text" name="id" value="${bs.id}" readonly> <br>
        Ten: <input type="text" name="ten" value="${bs.ten}"> <br>
        Tuoi: <input type="number" name="tuoi" value="${bs.tuoi}"> <br>
        Phong kham: <select name="phongKham">
            <c:forEach items="${danhSachPhongKham}" var="pk">
                <option value="${pk.id}" label="${pk.ten}" ${bs.phongKham.id == pk.id ? "selected" : ""}></option>
            </c:forEach>
        </select> <br>
        <button>Save</button>
    </form>
</body>
</html>
