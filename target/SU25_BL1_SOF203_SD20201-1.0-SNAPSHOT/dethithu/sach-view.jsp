<%--
  Created by IntelliJ IDEA.
  User: Huyen
  Date: 6/11/2025
  Time: 1:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/book-management/group" method="post">
    <label>ID: </label><input type="text" name="id" value="${sach.id}" required><br>
    <label>Mã: </label><input type="text" name="ma" value="${sach.ma}" required><br>
    <label>Tên: </label><input type="text" name="ten" value="${sach.ten}" required><br>
    <label>Số trang: </label><input type="text" name="soTrang" value="${sach.soTrang}" required><br>
    <label>Đơn giá: </label><input type="text" name="donGia" value="${sach.donGia}" required><br>

    <label>Nhà xuất bản: </label>
    <select name="nxb">
        <c:forEach items="${lstNXBs}" var="nxb">
            <option value="${nxb.id}">${nxb.ten}</option>
        </c:forEach>
    </select>
    <label>Trạng thái: </label><input type="text" name="trangThai" value="${sach.trangThai}" required><br>

    <button type="submit" name="action" value="add">Add</button>
    <button type="submit" name="action" value="update">Update</button>
</form>
<table>
    <thead>
    <th>ID</th>
    <th>Mã</th>
    <th>Tên</th>
    <th>Số trang</th>
    <th>Đơn giá</th>
    <th>Mã NXB</th>
    <th>Tên NXB</th>
    <th>Trạng thái</th>
    <th>Action</th>
    </thead>
    <tbody>
    <c:forEach var="sach" items="${lstSachs}">
        <tr>
            <td>${sach.id}</td>
            <td>${sach.ma}</td>
            <td>${sach.ten}</td>
            <td>${sach.soTrang}</td>
            <td>${sach.donGia}</td>
            <td>${sach.nxb.ma}</td>
            <td>${sach.nxb.ten}</td>
            <td>${sach.trangThai}</td>
            <td>
                <a href="/book-management/detail?id=${sach.id}">Detail</a>
                <a href="/book-management/remove?id=${sach.id}">Remove</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
