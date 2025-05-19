<%--
  Created by IntelliJ IDEA.
  User: Huyen
  Date: 5/19/2025
  Time: 2:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng ký</title>
</head>
<body>
    <h1 style="size: 24px; font-weight: bold">Form đăng ký</h1>
    <form method="post" action="/ket-qua-sign-in">
       <div>
           <label for="username">Họ và tên:</label>
           <input type="text" id="username" name="hoTen" placeholder="Nhập họ và tên" required/>
       </div>
        <div>
            <label for="date">Ngày sinh:</label>
            <input type="date" id="date" name="ngaySinh"/>
        </div>
        <div>
            <label for="phonenumber">Số điện thoại:</label>
            <input type="text" id="phonenumber" name="sdt" placeholder="Nhập số điện thoại" required/>
        </div>
        <div>
                    <input type="radio" id="nam" name="gioiTinh" value="Nam" required/>
                    <label for="nam">Nam</label>
                    <input type="radio" id="nu" name="gioiTinh" value="Nữ" required/>
                    <label for="nu">Nữ</label>
        </div>
        <div>
            <label for="address">Địa chỉ</label>
            <textarea id="address" name="diaChi" rows="5" cols="40"></textarea>
        </div>
        <%--COMBOBOX--%>
        <div>
            <label for="country">Chọn quốc gia:</label>
            <select id="country" name="quocGia">
                <option value="vietnam">Việt Nam</option>
                <option value="anh">Anh</option>
                <option value="my">Mỹ</option>
            </select>
        </div>
        <%--LIST BOX--%>
        <div>
            <label for="subject">Chọn môn học:</label>
            <select id="subject" name="monHoc" size="3" multiple>
                <option value="toan">Toán</option>
                <option value="van">Văn</option>
                <option value="anh">Anh</option>
            </select>
        </div>
        <%--CHECK BOX--%>
        <div>
            <label>Chọn sở thích:</label>

            <br/>
            <input type="checkbox" id="book" name="soThich" value="Đọc sách"/>
            <label for="book">Đọc sách</label>
            <br/>

            <input type="checkbox" id="travel" name="soThich" value="Du lịch"/>
            <label for="travel">Du lịch</label>
            <br/>
            <input type="checkbox" id="music" name="soThich" value="Nghe nhạc"/>
            <label for="music">Nghe nhạc</label>
        </div>

        <div>
            <label for="avatar">Ảnh đại diện:</label>
            <input type="file" id="avatar"/>
        </div>
        <button type="submit">
            Đăng ký
        </button>
    </form>
</body>
</html>
