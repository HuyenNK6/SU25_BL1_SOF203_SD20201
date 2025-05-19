<%--
  Created by IntelliJ IDEA.
  User: Huyen
  Date: 5/16/2025
  Time: 2:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form Đăng nhập</title>
</head>
<%--    Form Control
        @action: địa chỉ URL nhận dữ liệu form khi nhấp nút submit
        @method: hình thức gửi dữ liệu form, có 2 giá trị
             -   GET: Tạo chuỗi truy vấn và đính kèm URL của @action
             -   POST: Mở kênh truyền thông ngầm gửi dữ liệu lên server
    --%>
<body>
    <h1> ${message}</h1>
    <form action="/ket-qua" method="post">
        <div class="container">
            <p name="error" style="color: red">${error}</p>
            <label>Username</label><br>
            <input type="text" name="username" placeholder="Enter username" required><br>
            <label>Password</label><br>
            <input type="text" name="password" placeholder="Enter password" required><br>
            <input type="submit" value="Login">
        </div>
    </form>
</body>
</html>
