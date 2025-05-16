package buoi2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "loginServlet", value = {"/login","/ket-qua"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        req.setAttribute("message","FPT Polytechnic");
        req.getRequestDispatcher("/buoi2/form-login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        //1. lấy kết quả trong form-login.jsp về servlet
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //2. đưa dữ liệu vừa lấy đc sang trang ket-qua.jsp
        if(username.equalsIgnoreCase("huyen") && password.equalsIgnoreCase("123")){
            req.setAttribute("username", username);
            req.setAttribute("password", password);
            req.getRequestDispatcher("/buoi2/ket-qua.jsp").forward(req,resp);

            //chuyển về home  =>  resp.sendRedirect(); => về nhà làm hoàn thiện bài 2
        }
        else{
            req.setAttribute("error", "tài khoản hoặc mật khẩu không chính xác");
            req.getRequestDispatcher("/buoi2/form-login.jsp").forward(req,resp);
        }
    }
}
