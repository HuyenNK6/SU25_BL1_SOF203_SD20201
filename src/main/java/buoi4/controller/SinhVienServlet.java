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
        String uri= req.getRequestURI();
        if(uri.contains("get-all")){
            this.getAll(req, resp);
        }else if(uri.contains("search")){
            //gọi chức năng search
        }else if(uri.contains("remove")){
            //gọi chức năng remove
        }else if(uri.contains("detail")){
            //gọi chức năng detail
            this.viewDetail(req,resp);
        }else if(uri.contains("view-update")){
            //gọi chức năng view-update

        }else if(uri.contains("view-add")){
            //gọi chức năng view-add
            this.viewAdd(req,resp);
        }
    }
   private void getAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        lstSVs = service.getAll();
        req.setAttribute("lstSVs",lstSVs);
        req.getRequestDispatcher("/buoi4/sinh-vien.jsp").forward(req,resp);
    }
    private void viewDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mssv= req.getParameter("mssv");
        System.out.println("MSV= "+mssv);
        //tìm kiếm đối tượng sv theo mã
        SinhVien sv = service.searchSVByMSSV(mssv);

        req.setAttribute("sv", sv);
        req.getRequestDispatcher("/buoi4/view-detail.jsp").forward(req,resp);
    }
    private void viewAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/buoi4/view-add.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri= req.getRequestURI();
        if(uri.contains("add")){
            //gọi chức năng add
            this.addSV(req,resp);
        }else if(uri.contains("update")){
            //gọi chức năng update
        }
    }
    private void addSV(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. lấy toàn bộ thông từ tràn view-add.jsp
        String mssv = req.getParameter("mssv");
        String ten = req.getParameter("ten");
        String tuoi = req.getParameter("tuoi");
        String diaChi = req.getParameter("diaChi");
        String gioiTinh = req.getParameter("gioiTinh");

        //2. tạo đối tượng SV mới từ thông tin vừa lấy đc
        //tìm hiểu Builder
        SinhVien sv = new SinhVien(
                mssv,
                ten,
                Integer.valueOf(tuoi),
                Boolean.valueOf(gioiTinh),
                diaChi
               );
        //3. thêm đối tượng vào danh sách
        service.addSV(sv);
        //4. get all
        this.getAll(req, resp);

    }
}
