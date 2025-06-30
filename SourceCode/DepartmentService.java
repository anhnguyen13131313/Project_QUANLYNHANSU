package SourceCode;

// class xử lý các chức năng cho phòng ban là thêm, xem, sửa, xóa
import java.util.ArrayList;
public class DepartmentService {
    private ArrayList<Department> list = new ArrayList<>();

    // Thêm phòng ban mới
    public void add(Department d) {
        list.add(d);
    }

    // Lấy tất cả phòng ban 
    public ArrayList<Department> getAll() {
        return list;
    }

    // Tìm phòng ban theo ID, trả về null nếu không tìm thấy
    public Department findById(String id) {
        for (Department d : list) {
            if (d.getId().equals(id)) {
                return d;
            }
        }
        return null;
    }

    // Xóa phòng ban theo ID, trả về true nếu xóa thành công
    public boolean delete(String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                list.remove(i);
                return true;
            }
        }
        return false;
    }
}