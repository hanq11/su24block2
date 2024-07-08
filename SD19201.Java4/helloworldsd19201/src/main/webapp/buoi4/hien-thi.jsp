<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: syn
  Date: 08/07/2024
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <button><a href="/sinh-vien/view-add">Them sinh vien</a></button>
    <h2>Table</h2>
    <table>
        <thead>
            <tr>
                <th>STT</th>
                <th>Ma sinh vien</th>
                <th>Ten</th>
                <th>Tuoi</th>
                <th>Gioi tinh</th>
                <th colspan="3">Hanh dong</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${danhSach}" var="sv" varStatus="i">
                <tr>
                    <td>${i.index + 1}</td>
                    <td>${sv.maSinhVien}</td>
                    <td>${sv.ten}</td>
                    <td>${sv.tuoi}</td>
                    <td>${sv.gioiTinh ? "Nam" : "Nu"}</td>
                    <td>
                        <a href="/sinh-vien/detail?id=${sv.maSinhVien}">Detail</a>
                        <a href="/sinh-vien/view-update?id=${sv.maSinhVien}">Update</a>
                        <a href="/sinh-vien/delete?id=${sv.maSinhVien}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
