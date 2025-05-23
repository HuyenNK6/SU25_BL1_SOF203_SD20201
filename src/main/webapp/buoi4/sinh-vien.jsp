<%--
  Created by IntelliJ IDEA.
  User: Huyen
  Date: 5/21/2025
  Time: 3:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<button><a href="/sinh-vien/view-add">Thêm mới SV</a></button>
    <table>
        <tr>
            <th>STT</th>
            <th>MSSV</th>
            <th>Tên</th>
            <th>Tuổi</th>
            <th>Giới tính</th>
            <th>Địa chỉ</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${lstSVs}" var="sv" varStatus="i">
            <tr>
                <td> ${i.index} </td>
                <td> ${sv.mssv} </td>
                <td> ${sv.ten} </td>
                <td> ${sv.tuoi} </td>
                <td> ${sv.gioiTinh} </td> <%--load lên Nam nữ => tự làm nhé ahihi:D--%>
                <td> ${sv.diaChi} </td>
                <td>
                    <a href="/sinh-vien/detail?mssv=${sv.mssv}">Detail</a>
                    <a href="/sinh-vien/view-update">Update</a>
                    <a href="/sinh-vien/remove">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
