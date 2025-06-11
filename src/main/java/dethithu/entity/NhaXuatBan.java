package dethithu.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data//getter, setter, toString, equal...
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NhaXuatBan {
    private Integer id;
    private String ma;
    private String ten;
}
