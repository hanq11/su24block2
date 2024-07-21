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
<body>
    <h2>Table</h2>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Ten</th>
                <th>Tuoi</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${danhSach}" var="bs">
                <tr>
                    <td>${bs.id}</td>
                    <td>${bs.ten}</td>
                    <td>${bs.tuoi}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>