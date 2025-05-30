package SourceCode;

// Intern.java
// Thực tập sinh, tính lương giống bán thời gian
public class Intern extends Employee {
    public Intern(String id, String name, String email, Department dept, double stipendPerDay) {
        super(id, name, email, dept, stipendPerDay);
    }

    @Override
    public double calculateSalary(int daysAttended) {
        return baseSalary * daysAttended;
    }
}
