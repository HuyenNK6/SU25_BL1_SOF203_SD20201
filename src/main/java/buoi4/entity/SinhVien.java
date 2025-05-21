package buoi4.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor //tạo ctor full tham số
@NoArgsConstructor //tạo ctor ko tham số
@Builder //=> nói gọn: tạo constructor tùy ý
@ToString
public class SinhVien {
    //String mssv; String ten; int tuoi; boolean gioiTinh; String diaChi;
    //Có constructor, getter, setter
    private String mssv;
    private String ten;
    private int tuoi;
    private boolean gioiTinh;
    private String diaChi;
}
