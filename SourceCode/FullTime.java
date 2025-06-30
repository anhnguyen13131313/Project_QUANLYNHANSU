package SourceCode;

// Nhân viên làm việc toàn thời gian, tính lương theo ngày công trên tháng
public class FullTime extends Employee {
    public FullTime(String id, String name, String email, Department dept, double monthlySalary) {
        super(id, name, email, dept, monthlySalary);
    }

    @Override
    public double calculateSalary(int daysAttended) {
        // Giả sử 22 ngày công chuẩn trong tháng, vì sẽ được nghỉ thứ 7 và chủ nhật
        return baseSalary * (daysAttended / 22.0);
    }
}
