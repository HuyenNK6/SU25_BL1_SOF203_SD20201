package buoi11.repository;

import buoi11.entity.GiangVien;
import buoi11.util.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GiangVienRepository {
    public List<GiangVien> getAll(){
        List<GiangVien> listGVs= new ArrayList<>();
        String sql= "SELECT [id]\n" +
                "      ,[ma]\n" +
                "      ,[ten]\n" +
                "      ,[tuoi]\n" +
                "      ,[gioi_tinh]\n" +
                "      ,[que_quan]\n" +
                "  FROM [DB_GiangVien].[dbo].[giang_vien]";
        try(Connection con = DBConnect.getConnection();
            PreparedStatement ps= con.prepareStatement(sql)
        ) {
            //executeQuery: Select => trả về nhiều bản ghi => dưới dạng bảng => Result set
            //executeUpdate: Insert, update, delete => trả về số lượng bản ghi được thực hiện
            ResultSet rs= ps.executeQuery();
            while (rs.next()){//có còn dòng ko
                //tạo 1 đối tượng GV mới
                GiangVien gv = new GiangVien();
                gv.setId(rs.getInt("id"));
                gv.setMa(rs.getString("ma"));
                gv.setTen(rs.getString("ten"));
                gv.setTuoi(rs.getInt("tuoi"));
                gv.setGioiTinh(rs.getBoolean("gioi_tinh"));
                gv.setQueQuan(rs.getString("que_quan"));
                //thêm đối tượng vào danh sách
                listGVs.add(gv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listGVs;
    }

    public static void main(String[] args) {
        GiangVienRepository repo = new GiangVienRepository();
        List<GiangVien> listGVs = repo.getAll();
        for (GiangVien gv : listGVs) {
            System.out.println(gv.toString());
        }
    }
}
