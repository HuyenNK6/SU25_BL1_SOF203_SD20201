package buoi4.service;

import buoi4.entity.SinhVien;

import java.util.ArrayList;

public class SinhVienService {
    ArrayList<SinhVien> lstSVs= new ArrayList<>();
    public SinhVienService() {
        fakeData();
    }
    private void fakeData(){
        lstSVs.add(new SinhVien("PH111","Hoa",18,true, "HN"));
        lstSVs.add(new SinhVien("PH222","Hong",20,true, "HN"));
        lstSVs.add(new SinhVien("PH333","Nam",18,false, "HN"));
        lstSVs.add(new SinhVien("PH444","Trang",19,true, "HN"));
        lstSVs.add(new SinhVien("PH555","Nhung",20,true, "HN"));
        lstSVs.add(new SinhVien("PH666","Anh",18,false, "HN"));
    }
    public ArrayList<SinhVien> getAll(){
        return lstSVs;
    }
    public void addSV(SinhVien sv){
        lstSVs.add(sv);
    }
    public SinhVien searchSVByMSSV(String mssv){
        for (SinhVien sv: lstSVs) {
            if(sv.getMssv().equalsIgnoreCase(mssv)){
                return sv;
            }
        }
        return  null;
    }
}
