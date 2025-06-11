package dethithu.controller;

import dethithu.entity.NhaXuatBan;
import dethithu.entity.Sach;
import dethithu.repository.NxbRepository;
import dethithu.repository.SachRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "sachServlet", value = {
        "/book-management/group",
        "/book-management/update",
        "/book-management/detail",
        "/book-management/remove"
})
public class SachServlet extends HttpServlet {
    List <Sach> lstSachs= new ArrayList<>();
    SachRepository sachRepo= new SachRepository();
    List <NhaXuatBan> lstNXBs= new ArrayList<>();
    NxbRepository nxbRepo= new NxbRepository();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("group")){
            this.getAll(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    protected void getAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        lstNXBs = nxbRepo.findAll();
        lstSachs = sachRepo.findAll();
        req.setAttribute("lstNXBs",lstNXBs);
        req.setAttribute("lstSachs",lstSachs);
        req.getRequestDispatcher("/dethithu/sach-view.jsp").forward(req,resp);
    }
}
