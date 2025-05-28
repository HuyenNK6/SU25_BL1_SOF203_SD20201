package buoi6.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class TraSua {
    private String ma;
    private String vi;
    private int gia;
    private char size;
    private String thuongHieu;
}
