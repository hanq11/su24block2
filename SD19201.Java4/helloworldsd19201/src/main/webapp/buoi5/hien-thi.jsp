<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: syn
  Date: 12/07/2024
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <button><a href="/giang-vien/view-add">Them giang vien</a></button>

    <h2>Table</h2>
    <table>
        <thead>
            <tr>
                <th>STT</th>
                <th>Ma giang vien</th>
                <th>Dia chi</th>
                <th>Luong</th>
                <th>Ngay sinh</th>
                <th>Gioi tinh</th>
                <th colspan="3">Hanh dong</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${danhSach}" varStatus="i" var="giangVien">
                <tr>
                    <td>${i.index + 1}</td>
                    <td>${giangVien.maGiangVien}</td>
                    <td>${giangVien.diaChi}</td>
                    <td>${giangVien.luong}</td>
                    <td>${giangVien.ngaySinh}</td>
                    <td>${giangVien.gioiTinh ? "Nam" : "Nu"}</td>
                    <td>
                        <a href="/giang-vien/detail?id=${giangVien.maGiangVien}">Detail</a>
                        <a href="/giang-vien/view-update?id=${giangVien.maGiangVien}">Update</a>
                        <a href="/giang-vien/delete?id=${giangVien.maGiangVien}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
