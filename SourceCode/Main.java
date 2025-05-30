package SourceCode;

// Main.java
// Chương trình chính với menu console 7 chức năng
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DepartmentService deptService = new DepartmentService();
        EmployeeService empService = new EmployeeService();
        AttendanceService attService = new AttendanceService();
        PayrollService payrollService = new PayrollService(empService, attService);

        while (true) {
            // Hiển thị menu chính
            System.out.println("\\n=== HR MANAGEMENT ===");
            System.out.println("1. Quan ly phong ban");
            System.out.println("2. Quan ly nhan vien");
            System.out.println("3. Cham cong (check-in)");
            System.out.println("4. Tinh bang luong");
            System.out.println("5. Tim kiem/loc nhan vien");
            System.out.println("6. Xuat bao cao (bang luong)");
            System.out.println("7. Xuat danh sach email nhan vien");
            System.out.println("0. Thoat");
            System.out.print("Lua chon: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    // Chuyen den menu phong ban
                    DepartmentMenu.show(sc, deptService);
                    break;
                case "2":
                    EmployeeMenu.show(sc, empService, deptService);
                    break;
                case "3":
                    // Chuc nang cham cong
                    System.out.print("Nhap ID nhan vien: ");
                    String eid = sc.nextLine();
                    System.out.print("Nhap ngay (yyyy-MM-dd): ");
                    String date = sc.nextLine();
                    attService.checkIn(eid, date);
                    System.out.println("Da cham cong.");
                    break;
                case "4":
                    payrollService.generateReport();
                    break;
                case "5":
                    System.out.print("Tim theo (1-ID,2-Ten,3-Dept): ");
                    String f = sc.nextLine();
                    if (f.equals("1")) {
                        System.out.print("Nhap ID: ");
                        Employee e = empService.findById(sc.nextLine());
                        System.out.println(e != null ? e.getId()+" - "+e.getName() : "Khong tim thay");
                    } else if (f.equals("2")) {
                        System.out.print("Nhap ten chu: ");
                        for (Employee e : empService.searchByName(sc.nextLine())) {
                            System.out.println(e.getId()+" - "+e.getName());
                        }
                    } else {
                        System.out.print("Nhap Dept ID: ");
                        for (Employee e : empService.searchByDept(sc.nextLine())) {
                            System.out.println(e.getId()+" - "+e.getName());
                        }
                    }
                    break;
                case "6":
                    payrollService.generateReport();
                    break;
                case "7":
                    System.out.println("Danh sach email:");
                    for (Employee e : empService.getAll()) {
                        System.out.println(e.getEmail());
                    }
                    break;
                case "0":
                    System.out.println("Tam biet!");
                    sc.close();
                    return;
                default:
                    System.out.println("Lua chon khong hop le");
            }
        }
    }
}
