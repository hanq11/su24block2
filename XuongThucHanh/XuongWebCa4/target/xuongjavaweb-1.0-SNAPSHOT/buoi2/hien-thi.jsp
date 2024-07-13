<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: syn
  Date: 13/07/2024
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <button><a href="/khoa-hoc/view-add">Them khoa hoc</a></button>
    <br>
    <h2>Tim kiem</h2>
    <form action="/khoa-hoc/search" method="get">
        Ten khoa hoc: <input type="text" name="ten"> <br>
        <button type="submit">Search</button>
    </form>
    <br>
    <h2>Table</h2>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Hoc phi</th>
                <th>Ten</th>
                <th>Do kho</th>
                <th>Bo mon</th>
                <th>Ngay nhap hoc</th>
                <th colspan="3">Hanh dong</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${danhSach}" var="kh">
                <tr>
                    <td>${kh.id}</td>
                    <td>${kh.hocPhi}</td>
                    <td>${kh.ten}</td>
                    <td>${kh.kho}</td>
                    <td>${kh.boMon}</td>
                    <td>${kh.ngayNhapHoc}</td>
                    <td>
                        <a href="/khoa-hoc/detail?id=${kh.id}">Detail</a>
                        <a href="/khoa-hoc/delete?id=${kh.id}">Delete</a>
                        <a href="/khoa-hoc/view-update?id=${kh.id}">Update</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
