package SourceCode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
// Chương trình chính với menu1 7 chức năng
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
            System.out.println("6. Xuat danh sach email nhan vien");
            System.out.println("7. Luu du lieu ra file");
            System.out.println("8. Nap du lieu tu file");
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
                    System.out.println("Danh sach email:");
                    for (Employee e : empService.getAll()) {
                        System.out.println(e.getEmail());
                    }
                    break;
                    case "7":
                    saveData(deptService, empService, attService);
                    break;
                case "8":
                    loadData(deptService, empService, attService);
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

    private static void saveData(DepartmentService ds, EmployeeService es, AttendanceService as) {
        // Lưu phòng ban
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("departments.txt"))) {
            for (Department d : ds.getAll()) {
                bw.write(d.getId() + "," + d.getName() + "," + d.getDescription());
                bw.newLine();
            }
            System.out.println("Da luu phong ban vao departments.txt");
        } catch (IOException e) {
            System.err.println("Loi khi luu phong ban: " + e.getMessage());
        }
        // Lưu nhân viên
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("employees.txt"))) {
            for (Employee e : es.getAll()) {
                bw.write(e.getId() + "," + e.getName().replace(",", " ") + "," + e.getEmail() + "," + e.getDept().getId() + "," + e.baseSalary + "," + e.getClass().getSimpleName());
                bw.newLine();
            }
            System.out.println("Da luu nhan vien vao employees.txt");
        } catch (IOException e) {
            System.err.println("Loi khi luu nhan vien: " + e.getMessage());
        }
        // Lưu chấm công
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("attendance.txt"))) {
            for (AttendanceRecord r : as.getAllRecords()) {
                bw.write(r.empId + "," + r.date);
                bw.newLine();
            }
            System.out.println("Da luu cham cong vao attendance.txt");
        } catch (IOException e) {
            System.err.println("Loi khi luu cham cong: " + e.getMessage());
        }
    }

    private static void loadData(DepartmentService ds, EmployeeService es, AttendanceService as) {
        // Nap phong ban
        ds.getAll().clear();
        try (BufferedReader br = new BufferedReader(new FileReader("departments.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split(",", 3);
                ds.add(new Department(p[0], p[1], p[2]));
            }
            System.out.println("Da nap phong ban tu departments.txt");
        } catch (IOException e) {
            System.err.println("Loi khi nap phong ban: " + e.getMessage());
        }
        // Nap nhan vien
        es.getAll().clear();
        try (BufferedReader br = new BufferedReader(new FileReader("employees.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split(",", 6);
                Department d = ds.findById(p[3]);
                double sal = Double.parseDouble(p[4]);
                Employee emp;
                switch (p[5]) {
                    case "FullTime": emp = new FullTime(p[0], p[1], p[2], d, sal); break;
                    case "PartTime": emp = new PartTime(p[0], p[1], p[2], d, sal); break;
                    default:          emp = new Intern(p[0], p[1], p[2], d, sal); break;
                }
                es.add(emp);
            }
            System.out.println("Da nap nhan vien tu employees.txt");
        } catch (IOException e) {
            System.err.println("Loi khi nap nhan vien: " + e.getMessage());
        }
        // Nap cham cong
        as.getAllRecords().clear();
        try (BufferedReader br = new BufferedReader(new FileReader("attendance.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split(",", 2);
                as.checkIn(p[0], p[1]);
            }
            System.out.println("Da nap cham cong tu attendance.txt");
        } catch (IOException e) {
            System.err.println("Loi khi nap cham cong: " + e.getMessage());
        }
    }
}
