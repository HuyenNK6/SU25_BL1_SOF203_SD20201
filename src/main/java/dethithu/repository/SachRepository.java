package dethithu.repository;

import dethithu.entity.NhaXuatBan;
import dethithu.entity.Sach;
import dethithu.util.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SachRepository implements BaseCRUDRepository<Sach, Integer> {
    @Override
    public Boolean create(Sach entity) {
        return null;
    }

    @Override
    public Boolean update(Sach entity) {
        return null;
    }

    @Override
    public Boolean delete(Integer integer) {
        return null;
    }

    @Override
    public List<Sach> findAll() {
        String sql= "SELECT dbo.sach.id, dbo.sach.ma, dbo.sach.ten, dbo.sach.so_trang, " +
                "dbo.sach.don_gia, dbo.sach.id_nxb, dbo.nxb.ma AS ma_nxb, dbo.nxb.ten AS ten_nxb, dbo.sach.trang_thai\n" +
                "FROM     dbo.nxb INNER JOIN\n" +
                "dbo.sach ON dbo.nxb.id = dbo.sach.id_nxb\n";
        List<Sach> lstSachs= new ArrayList<>();
        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)
        ){
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                Sach sach = new Sach();
                sach.setId(rs.getInt("id"));
                sach.setMa(rs.getString("ma"));
                sach.setTen(rs.getString("ten"));
                sach.setSoTrang(rs.getInt("so_trang"));
                sach.setDonGia(rs.getDouble("don_gia"));
                //nxb
                NhaXuatBan nxb = new NhaXuatBan();
                nxb.setId(rs.getInt("id_nxb"));
                nxb.setMa(rs.getString("ma_nxb"));
                nxb.setTen(rs.getString("ten_nxb"));
                sach.setNxb(nxb);//set đối tượng nxb -> sach
                sach.setTrangThai(rs.getInt("trang_thai"));
                //thêm vào list
                lstSachs.add(sach);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstSachs;
    }

    @Override
    public Sach findByID(Integer integer) {
        return null;
    }

    public static void main(String[] args) {
        SachRepository repo = new SachRepository();
        List<Sach> lstSachs= repo.findAll();
        for (Sach sach : lstSachs) {
            System.out.println(sach.toString());
        }
    }
}
