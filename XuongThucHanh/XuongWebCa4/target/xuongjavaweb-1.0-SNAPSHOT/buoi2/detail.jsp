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
    <h2>Thong tin</h2>
Id: ${khoaHoc.id} <br>
Hoc phi: ${khoaHoc.hocPhi} <br>
Ten: ${khoaHoc.ten} <br>
Kho: ${khoaHoc.kho ? "Kho" : "De"} <br>
Bo mon: ${khoaHoc.boMon == "udpm" ? "Ung dung phan mem" : "Phat trien phan mem"} <br>
Ngay nhap hoc: ${khoaHoc.ngayNhapHoc}
</body>
</html>
