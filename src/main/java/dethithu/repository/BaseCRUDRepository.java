package dethithu.repository;

import java.util.List;

/*
Cặp ký hiệu <T, ID> trong Java là một phần của Generic types, giúp viết code tổng quát, linh hoạt và tái sử dụng
- T: đại diện cho kiểu dữ liệu của đối tượng (entity) mà repository sẽ thao tác.
- ID: đại diện cho kiểu dữ liệu của khóa chính (ID) của đối tượng đó.
* Lưu ý:
- Java Generics chỉ hoạt động với kiểu đối tượng (reference types),
còn các kiểu như int, double, boolean... là kiểu nguyên thủy - (primitive types)
- Thay vì dùng kiểu nguyên thủy, hãy dùng lớp bao (wrapper class)
VD: id tương ứng là Integer.
 */
public interface BaseCRUDRepository <T,ID>{
    Boolean create (T entity);

    Boolean update (T entity);

    Boolean delete (ID id);

    List<T> findAll ();

    T findByID(ID id);
}
