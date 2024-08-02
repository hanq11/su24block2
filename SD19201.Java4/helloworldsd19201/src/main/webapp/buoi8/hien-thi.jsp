<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: syn
  Date: 19/07/2024
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<h2>Search</h2>
<form action="/bac-si/search" method="get">
    Ten: <input type="text" name="ten"> <br>
    <button type="submit">Submit</button>
</form>

<button><a href="/bac-si/view-add">Them</a></button>
<body>
    <h2>Table</h2>
    <table>
        <thead>
            <tr>
                <th>ID</th>
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
                        <a href="/bac-si/detail?id=${bs.id}">Detail</a>
                        <a href="/bac-si/view-update?id=${bs.id}">Update</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
