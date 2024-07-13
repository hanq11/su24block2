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
    <h2>Sua khoa hoc</h2>
    <form action="/khoa-hoc/update" method="post">
        Id: <input type="number" name="id" value="${khoaHoc.id}" readonly> <br>
        Hoc phi: <input type="text" name="hocPhi" value="${khoaHoc.hocPhi}"> <br>
        Ten: <input type="text" name="ten" value="${khoaHoc.ten}"> <br>
        Do kho: <input type="radio" name="kho" value="true" ${khoaHoc.kho ? "checked" : ""}> Kho
        <input type="radio" name="kho" value="false" ${!khoaHoc.kho ? "checked" : ""}> De <br>
        Bo mon:
        <select name="boMon">
            <option value="ptpm" label="Phat trien phan mem" ${khoaHoc.boMon.equals("ptpm") ? "selected" : ""}></option>
            <option value="udpm" label="Ung dung phan mem" ${khoaHoc.boMon.equals("udpm") ? "selected" : ""}></option>
        </select>
        <br>
        Ngay nhap hoc: <input type="date" name="ngayNhapHoc" value="${khoaHoc.ngayNhapHoc}"> <br>
        <button type="submit">Save</button>
    </form>
</body>
</html>
