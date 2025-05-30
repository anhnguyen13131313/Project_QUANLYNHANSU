package SourceCode;

// Employee.java
// Lớp trừu tượng mô tả nhân viên chung
public abstract class Employee {
    protected String id;         // Mã nhân viên, ví dụ "E001"
    protected String name;       // Tên nhân viên
    protected String email;      // Email nhân viên
    protected Department dept;   // Phòng ban (liên kết đến Department)
    protected double baseSalary; // Lương cơ bản hoặc đơn giá/ngày

    public Employee(String id, String name, String email, Department dept, double baseSalary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dept = dept;
        this.baseSalary = baseSalary;
    }

    // Các phương thức lấy thông tin cơ bản
    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public Department getDept() { return dept; }

    // Phương thức tính lương phải do lớp con định nghĩa
    public abstract double calculateSalary(int daysAttended);
}
