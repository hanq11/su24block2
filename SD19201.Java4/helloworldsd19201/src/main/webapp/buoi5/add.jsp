<%--
  Created by IntelliJ IDEA.
  User: syn
  Date: 12/07/2024
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Them giang vien</h2>
    <form action="/giang-vien/add" method="post">
        Ma giang vien: <input type="text" name="maGiangVien"> <br>
        Dia chi: <input type="text" name="diaChi"> <br>
        Luong: <input type="text" name="luong"> <br>
        Ngay sinh: <input type="date" name="ngaySinh"> <br>
        Gioi tinh: <input type="radio" name="gioiTinh" value="true" checked> Nam
        <input type="radio" name="gioiTinh" value="false" > Nu
        <button type="submit">Save</button>
    </form>
</body>
</html>
