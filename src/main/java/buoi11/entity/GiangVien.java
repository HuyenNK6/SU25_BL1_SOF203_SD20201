package buoi11.entity;

import lombok.*;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class GiangVien {
    private int id;
    private String ma;
    private String ten;
    private int tuoi;
    private boolean gioiTinh;
    private String queQuan;
}
