<%--
  Created by IntelliJ IDEA.
  User: Huyen
  Date: 5/23/2025
  Time: 3:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<button> <a href="/sinh-vien/get-all">Trang chủ</a></button>
<label>MSSV: </label> ${sv.mssv}<br>
    <label>Tên: </label> ${sv.ten}<br>
    <label>Tuổi: </label> ${sv.tuoi}<br>
    <label>Giới tính: </label> ${sv.gioiTinh ? "Nữ":"Nam"}<br>
    <label>Địa chỉ: </label> ${sv.diaChi}
</body>
</html>
