package SourceCode;

// Tạo báo cáo bảng lương in ra console gồm ID, tên, Dept, Days, và tổng lương(Salary)
import java.util.ArrayList;
public class PayrollService {
    private EmployeeService empService;
    private AttendanceService attService;

    public PayrollService(EmployeeService empService, AttendanceService attService) {
        this.empService = empService;
        this.attService = attService;
    }

    public void generateReport() {
        System.out.println("ID    | Ten            | Dept | Days | Salary");
        System.out.println("-----------------------------------------------");
        ArrayList<Employee> all = empService.getAll();
        for (Employee e : all) {
            int days = attService.getDaysAttended(e.getId());
            double salary = e.calculateSalary(days);
            // Định dạng in ra cột
            System.out.println(String.format("%-5s | %-14s | %-4s | %-4d | %.2f",
                e.getId(), e.getName(), e.getDept().getId(), days, salary));
        }
        System.out.println("-----------------------------------------------");
    }
}

