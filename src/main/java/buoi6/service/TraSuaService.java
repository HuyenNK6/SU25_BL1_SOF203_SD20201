package buoi6.service;

import buoi6.entity.TraSua;

import java.util.ArrayList;

public class TraSuaService {
    ArrayList<TraSua> listTS = new ArrayList<>();

    public TraSuaService() {
        fakeData();
    }

    private void fakeData() {
        listTS.add(new TraSua("TS01", "Matcha", 35000, 'M', "Tocotoco"));
        listTS.add(new TraSua("TS02", "Hồng trà", 32000, 'M', "DingTea"));
        listTS.add(new TraSua("TS03", "Nhài", 39000, 'L', "Highland"));
        listTS.add(new TraSua("TS04", "Hoa Cúc", 40000, 'L', "Highland"));
        listTS.add(new TraSua("TS05", "Socola", 32000, 'M', "The Coffee House"));
        listTS.add(new TraSua("TS06", "Vani", 30000, 'M', "Mixue"));
        listTS.add(new TraSua("TS07", "Dâu tằm", 38000, 'L', "Tocotoco"));
        listTS.add(new TraSua("TS08", "Dừa", 30000, 'M', "DingTea"));
        listTS.add(new TraSua("TS09", "Ô long", 35000, 'M', "Highland"));
        listTS.add(new TraSua("TS10", "Bạc hà", 39000, 'L', "The Coffee House"));
    }
    public ArrayList<TraSua> getAll(){
        return listTS;
    }
    public TraSua searchByMa(String ma){
        //iter + tab
        for (TraSua ts : listTS) {
            if(ts.getMa().equalsIgnoreCase(ma)){
                return ts;
            }
        }
        return null;
    }
}
