package SourceCode;

// lớp abstract mô tả nhân viên chung 
public abstract class Employee {
    protected String id;         // mã nhân viên, ví dụ "E001"
    protected String name;       // tên nhân viên
    protected String email;      // email nhân viên
    protected Department dept;   // phòng ban, được liên kết đến lớp Department
    protected double baseSalary; // lương cơ bản nếu là loại fulltime hoặc đơn giá/ngày cho intern và part time

    public Employee(String id, String name, String email, Department dept, double baseSalary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dept = dept;
        this.baseSalary = baseSalary;
    }

    // các phương thức get lấy các thông tin
    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public Department getDept() { return dept; }

    // phương thức tính lương phải do lớp con định nghĩa vì được khai báo là abstract, và mỗi lớp con sẽ có các tính lương khác nhau
    public abstract double calculateSalary(int daysAttended);
}
