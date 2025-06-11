<%@ page import="buoi6.entity.TraSua" %><%--
  Created by IntelliJ IDEA.
  User: Huyen
  Date: 5/28/2025
  Time: 2:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    TraSua ts = (TraSua) request.getAttribute("ts");
//    String thuongHieuSelected = ts.getThuongHieu(); => xảy ra lỗi do ts null trong TH mới chạy
    String thuongHieuSelected = "Tocotoco";
    if(ts!=null){
        thuongHieuSelected =ts.getThuongHieu();
    }
%>
    <form action="/tra-sua/hien-thi" method="post">
        <label>Mã: </label><input name="ma" value="${ts.ma}" required><br>
        <label>Vị: </label><input name="vi" value="${ts.vi}" required><br>
        <label>Giá: </label><input name="gia" value="${ts.gia}" required><br>
        <label>Size: </label><input name="size" value="${ts.size}" required><br>
        <label>Thương hiệu: </label>
        <%--<input name="thuongHieu" value="${ts.thuongHieu}" required><br>--%>
        <%--        Thẻ <%= %> trong JSP được gọi là Expression Tag (Thẻ biểu thức).
Thẻ này cho phép bạn chèn và hiển thị trực tiếp giá trị của một biểu thức Java vào trong nội dung HTML của trang JSP.
Các biểu thức này sẽ được đánh giá và kết quả của chúng sẽ được chèn vào vị trí của thẻ trong HTML.--%>
        <select name="thuongHieu">
            <option value="Tocotoco" <%=thuongHieuSelected.equalsIgnoreCase("Tocotoco") ? "selected": ""%>>Tocotoco</option>
            <option value="DingTea" <%=thuongHieuSelected.equalsIgnoreCase("DingTea") ? "selected": ""%>>DingTea</option>
            <option value="Highland" <%=thuongHieuSelected.equalsIgnoreCase("Highland") ? "selected": ""%>>Highland</option>
            <option value="The Coffee House" <%=thuongHieuSelected.equalsIgnoreCase("The Coffee House") ? "selected": ""%>>The Coffee House</option>
            <option value="Mixue" <%=thuongHieuSelected.equalsIgnoreCase("Mixue") ? "selected": ""%>>Mixue</option>
        </select><br>
        <button type="submit" name="action" value="add">Add</button>
        <button type="submit" name="action" value="update">Update</button>
    </form>
    <table>
        <tr>
            <th>STT</th>
            <th>Mã</th>
            <th>Vị</th>
            <th>Giá</th>
            <th>Size</th>
            <th>Thương hiệu</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${listTS}" var="ts" varStatus="i">
            <tr>
                <td>${i.index}</td>
                <td>${ts.ma}</td>
                <td>${ts.vi}</td>
                <td>${ts.gia}</td>
                <td>${ts.size}</td>
                <td>${ts.thuongHieu}</td>
                <td>
                    <a href="/tra-sua/chi-tiet?ma=${ts.ma}">Detail</a>
                    <a href="/tra-sua/xoa?ma=${ts.ma}">Remove</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
