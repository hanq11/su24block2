<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: syn
  Date: 18/07/2024
  Time: 15:16
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
        <button type="submit">Submit</button>
    </form>
    <h2>Table</h2>
    <table>
        <thead>
            <tr>
                <th>Id</th>
                <th>Ten</th>
                <th>Tuoi</th>
                <th>Ten phong kham</th>
                <th colspan="3">Hanh dong</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${danhSach}" var="bs">
                <tr>
                    <td>${bs.id}</td>
                    <td>${bs.ten}</td>
                    <td>${bs.tuoi}</td>
                    <td>${bs.phongKham.ten}</td>
                    <td>
                        <a href="/bac-si/delete?id=${bs.id}">Delete</a>
                        <a href="/bac-si/view-detail?id=${bs.id}">Detail</a>
                        <a href="/bac-si/view-update?id=${bs.id}">Update</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
