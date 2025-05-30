package SourceCode;

// PartTime.java
// Nhân viên làm việc bán thời gian, lương = đơn giá/ngày * số ngày
public class PartTime extends Employee {
    public PartTime(String id, String name, String email, Department dept, double dailyRate) {
        super(id, name, email, dept, dailyRate);
    }

    @Override
    public double calculateSalary(int daysAttended) {
        return baseSalary * daysAttended;
    }
}
