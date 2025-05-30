package SourceCode;

// EmployeeService.java
// Xử lý nghiệp vụ cho nhân viên: thêm, xem, sửa, xóa, tìm kiếm
import java.util.ArrayList;
public class EmployeeService {
    private ArrayList<Employee> list = new ArrayList<>();

    public void add(Employee e) {
        list.add(e);
    }
    public ArrayList<Employee> getAll() {
        return list;
    }
    public Employee findById(String id) {
        for (Employee e : list) {
            if (e.getId().equals(id)) {
                return e;
            }
        }
        return null;
    }
    public boolean delete(String id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                list.remove(i);
                return true;
            }
        }
        return false;
    }
    // Tìm nhân viên theo tên chứa keyword
    public ArrayList<Employee> searchByName(String keyword) {
        ArrayList<Employee> result = new ArrayList<>();
        for (Employee e : list) {
            if (e.getName().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(e);
            }
        }
        return result;
    }
    // Tìm nhân viên theo ID phòng ban
    public ArrayList<Employee> searchByDept(String deptId) {
        ArrayList<Employee> result = new ArrayList<>();
        for (Employee e : list) {
            if (e.getDept().getId().equals(deptId)) {
                result.add(e);
            }
        }
        return result;
    }
}
