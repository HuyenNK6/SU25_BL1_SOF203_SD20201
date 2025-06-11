package dethithu.repository;

import dethithu.entity.NhaXuatBan;
import dethithu.entity.Sach;
import dethithu.util.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NxbRepository implements BaseCRUDRepository<NhaXuatBan, Integer>{
    @Override
    public Boolean create(NhaXuatBan entity) {
        return null;
    }

    @Override
    public Boolean update(NhaXuatBan entity) {
        return null;
    }

    @Override
    public Boolean delete(Integer integer) {
        return null;
    }

    @Override
    public List<NhaXuatBan> findAll() {
        String sql= "SELECT id, ma, ten " +
                "FROM     dbo.nxb " ;
        List<NhaXuatBan> lstNXBs= new ArrayList<>();
        try (Connection con = DBConnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)
        ){
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                NhaXuatBan nxb = new NhaXuatBan();
                nxb.setId(rs.getInt("id"));
                nxb.setMa(rs.getString("ma"));
                nxb.setTen(rs.getString("ten"));
                lstNXBs.add(nxb);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstNXBs;
    }

    @Override
    public NhaXuatBan findByID(Integer integer) {
        return null;
    }

    public static void main(String[] args) {
        NxbRepository repo= new NxbRepository();
        List<NhaXuatBan> lst= repo.findAll();
        for (NhaXuatBan nhaXuatBan : lst) {
            System.out.println(nhaXuatBan.toString());
        }
    }
}
