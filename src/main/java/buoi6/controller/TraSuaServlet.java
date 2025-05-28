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

@WebServlet(name = "traSuaServlet", value = {
        "/tra-sua/hien-thi",
        "/tra-sua/chi-tiet",
        "/tra-sua/tim-kiem",
        "/tra-sua/xoa"
})
public class TraSuaServlet extends HttpServlet {
    ArrayList<TraSua> listTS = new ArrayList<>();
    TraSuaService service = new TraSuaService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if (uri.contains("hien-thi")) {
            this.getAll(req, resp);
        } else if (uri.contains("chi-tiet")) {
            this.detail(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //mục đích: kiểm tra xem đây là chức năng gì khi chọn button add hay update
        String action = req.getParameter("action");
        if (action.equals("add")) {
            this.addTS(req, resp);
        } else if (action.equals("update")) {
            this.updateTS(req, resp);
        }
    }

    protected void getAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        listTS = service.getAll();
        req.setAttribute("listTS", listTS);
        req.getRequestDispatcher("/buoi6/hien-thi.jsp").forward(req, resp);
    }

    protected void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //lấy mã của Trà sữa cần xem chi tiết
        String ma = req.getParameter("ma");
        //tìm kiếm đối tượng TS theo mã
        TraSua ts = service.searchByMa(ma);
        //gửi đối tượng sang jsp
        req.setAttribute("ts", ts);
        //gửi  cả danh sách TS sang nữa
        listTS = service.getAll();
        req.setAttribute("listTS", listTS);
        req.getRequestDispatcher("/buoi6/hien-thi.jsp").forward(req, resp);
    }

    protected void addTS(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1: lấy dữ liệu từ trên form trong jsp
        String ma= req.getParameter("ma");
        String vi= req.getParameter("vi");
        String gia= req.getParameter("gia");
        String size= req.getParameter("size");
        String thuongHieu= req.getParameter("thuongHieu");
        //2. tạo đối tượng
        //sử dụng constructor
         /*
        TraSua.builder():
            Phương thức này được Lombok tự động tạo ra nhờ annotation @Builder.
            Nó trả về một đối tượng của lớp TraSua.TraSuaBuilder, đây là lớp nội bộ được Lombok tạo ra để hỗ trợ việc xây dựng đối tượng TraSua.
            Lombok sẽ tự động tạo ra các phương thức setter cho từng thuộc tính, nhưng không đặt tên theo quy ước setAttribute(), mà dùng chính tên thuộc tính.
            Ví dụ, thay vì gọi setMa(), bạn gọi trực tiếp ma().
        .ma("giá trị"): Đây là phương thức setter do Lombok tạo ra để gán giá trị cho thuộc tính mã
        .build():
            Phương thức build() được tự động tạo ra bởi Lombok và có nhiệm vụ tạo ra đối tượng TraSua hoàn chỉnh với tất cả các thuộc tính đã được cấu hình trước đó (trong các bước gọi setter).
            Sau khi build() được gọi, một đối tượng TraSua sẽ được trả về.
         */

        TraSua ts= TraSua.builder()
                .vi(vi)
                .ma(ma)
                .thuongHieu(thuongHieu)
                .gia(Integer.valueOf(gia))
                .size(size.charAt(0))
                .build();

        //3. thêm vào danh sách
        service.addTS(ts);

        //4. cập nhật lại danh sách
        listTS = service.getAll();
        req.setAttribute("listTS", listTS);
        req.getRequestDispatcher("/buoi6/hien-thi.jsp").forward(req, resp);
    }

    protected void updateTS(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        listTS = service.getAll();
        req.setAttribute("listTS", listTS);
        req.getRequestDispatcher("/buoi6/hien-thi.jsp").forward(req, resp);
    }
}
