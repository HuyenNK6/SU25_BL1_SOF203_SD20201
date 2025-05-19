package buoi3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "signinServlet", value = {"/signin", "/ket-qua-sign-in"})
public class SigninServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        req.getRequestDispatcher("/buoi3/signin.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        String hoTen = req.getParameter("hoTen");
        String ngaySinh = req.getParameter("ngaySinh");
        String sdt = req.getParameter("sdt");
        String gioiTinh = req.getParameter("gioiTinh");
        String diaChi = req.getParameter("diaChi");
        String quocGia = req.getParameter("quocGia");
        String[] monHocs= req.getParameterValues("monHoc");
        String[] soThichs= req.getParameterValues("soThich");

        req.setAttribute("hoTen",hoTen);
        req.setAttribute("ngaySinh",ngaySinh);
        req.setAttribute("sdt",sdt);
        req.setAttribute("gioiTinh",gioiTinh);
        req.setAttribute("diaChi",diaChi);
        req.setAttribute("quocGia",quocGia);
        req.setAttribute("monHocs",monHocs);//mảng string
        req.setAttribute("soThichs",soThichs); //mảng string

        req.getRequestDispatcher("/buoi3/ket-qua-sign-in.jsp").forward(req,resp);

    }
}
