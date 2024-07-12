<%--
  Created by IntelliJ IDEA.
  User: syn
  Date: 12/07/2024
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Update giang vien</h2>
    <form action="/giang-vien/update" method="post">
        Ma giang vien: <input type="text" name="maGiangVien" value="${giangVien.maGiangVien}"> <br>
        Dia chi: <input type="text" name="diaChi" value="${giangVien.diaChi}"> <br>
        Luong: <input type="text" name="luong" value="${giangVien.luong}"> <br>
        Ngay sinh: <input type="date" name="ngaySinh" value="${giangVien.ngaySinh}"> <br>
        Gioi tinh: <input type="radio" name="gioiTinh" value="true" ${giangVien.gioiTinh ? "checked" : ""}> Nam
        <input type="radio" name="gioiTinh" value="false" ${!giangVien.gioiTinh ? "checked" : ""}> Nu
        <button type="submit">Save</button>
    </form>
</body>
</html>
