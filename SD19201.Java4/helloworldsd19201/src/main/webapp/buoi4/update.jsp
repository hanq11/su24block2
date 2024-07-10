<%--
  Created by IntelliJ IDEA.
  User: syn
  Date: 10/07/2024
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Form</h2>
    <form action="/sinh-vien/update" method="post">
        Ma sinh vien: <input type="text" name="maSinhVien" value="${sinhVien.maSinhVien}"> <br>
        Ten: <input type="text" name="ten" value="${sinhVien.ten}"> <br>
        Tuoi: <input type="text" name="tuoi" value="${sinhVien.tuoi}"> <br>
        Gioi tinh:
        <input type="radio" name="gioiTinh" value="true" ${sinhVien.gioiTinh ? "checked" : ""}> Nam
        <input type="radio" name="gioiTinh" value="false" ${sinhVien.gioiTinh ? "" : "checked"}> Nu <br>
        <button type="submit">Update</button>
    </form>
</body>
</html>
