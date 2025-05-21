package buoi4.controller;

import buoi4.entity.SinhVien;
import buoi4.service.SinhVienService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "sinhVienServlet", value = {"/sinh-vien/get-all",//GET
                                                "/sinh-vien/search",//GET
                                                "/sinh-vien/remove",//GET
                                                "/sinh-vien/detail",//GET
                                                "/sinh-vien/view-update",//GET
                                                "/sinh-vien/view-add",//GET
                                                "/sinh-vien/update",//POST
                                                "/sinh-vien/add"//POST
                                                })
public class SinhVienServlet extends HttpServlet {
    SinhVienService service = new SinhVienService();
    ArrayList<SinhVien> lstSVs= new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        lstSVs = service.getAll();
        req.setAttribute("lstSVs",lstSVs);
        req.getRequestDispatcher("/buoi4/sinh-vien.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
    }
}
