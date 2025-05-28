package buoi6.controller;

import buoi6.entity.TraSua;
import buoi6.service.TraSuaService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name="traSuaServlet", value = {
        "/tra-sua/hien-thi",
        "/tra-sua/chi-tiet",
        "/tra-sua/tim-kiem",
        "/tra-sua/xoa"
})
public class TraSuaServlet extends HttpServlet {
    ArrayList<TraSua> listTS= new ArrayList<>();
    TraSuaService service  = new TraSuaService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("hien-thi")){
            this.getAll(req, resp);
        }else if(uri.contains("chi-tiet")){
            this.detail(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    protected void getAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        listTS = service.getAll();
        req.setAttribute("listTS", listTS);
        req.getRequestDispatcher("/buoi6/hien-thi.jsp").forward(req,resp);
    }
    protected void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //lấy mã của Trà sữa cần xem chi tiết
        String ma= req.getParameter("ma");
        //tìm kiếm đối tượng TS theo mã
        TraSua ts= service.searchByMa(ma);
        //gửi đối tượng sang jsp
        req.setAttribute("ts", ts);
        //gửi  cả danh sách TS sang nữa 
        listTS = service.getAll();
        req.setAttribute("listTS", listTS);
        req.getRequestDispatcher("/buoi6/hien-thi.jsp").forward(req,resp);
    }
}
