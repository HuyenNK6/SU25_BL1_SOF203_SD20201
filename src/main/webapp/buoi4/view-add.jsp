<%--
  Created by IntelliJ IDEA.
  User: Huyen
  Date: 5/23/2025
  Time: 3:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <button> <a href="/sinh-vien/get-all">Trang chủ</a></button>
    <form action="/sinh-vien/add" method="post">
        <label>MSSV:</label>
        <input name="mssv" placeholder="Nhập MSSV" required> <br>
        <label>Tên:</label>
        <input name="ten" placeholder="Nhập Tên" required> <br>
        <label>Tuổi:</label>
        <input name="tuoi" placeholder="Nhập Tuổi" required> <br>
        <label>Địa chỉ:</label>
        <input name="diaChi" placeholder="Nhập Địa chỉ" required> <br>
        <label>Giới tính:</label>
        <input type="radio" name="gioiTinh" value="Nam" checked>Nam
        <input type="radio" name="gioiTinh" value="Nữ">Nữ <br>
        <button type="submit">Add</button>
    </form>
</body>
</html>
