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
    <h2>Them khoa hoc</h2>
    <form action="/khoa-hoc/add" method="post">
        Id: <input type="number" name="id"> <br>
        Hoc phi: <input type="text" name="hocPhi"> <br>
        Ten: <input type="text" name="ten"> <br>
        Do kho: <input type="radio" name="kho" value="true"> Kho
        <input type="radio" name="kho" value="false"> De <br>
        Bo mon:
        <select name="boMon">
            <option value="ptpm" label="Phat trien phan mem"></option>
            <option value="udpm" label="Ung dung phan mem"></option>
        </select>
        <br>
        Ngay nhap hoc: <input type="date" name="ngayNhapHoc"> <br>
        <button type="submit">Save</button>
    </form>
</body>
</html>
