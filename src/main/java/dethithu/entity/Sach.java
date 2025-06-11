package dethithu.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data//getter, setter, toString, equal...
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sach {
    private Integer id;
    private String ma;
    private String ten;
    private Integer soTrang;
    private Double donGia;
    private NhaXuatBan nxb;
    private Integer trangThai;
}
