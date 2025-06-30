package SourceCode;

import java.util.Scanner;
public class EmployeeMenu {
    public static void show(Scanner sc, EmployeeService empService, DepartmentService deptService) {
        System.out.println("-- Quan ly nhan vien --");
        System.out.println("a. Them");
        System.out.println("b. Xem");
        System.out.println("c. Sua");
        System.out.println("d. Xoa");
        System.out.print("Lua chon: ");
        String c = sc.nextLine();
        switch(c) {
            case "a":
                System.out.print("Nhap ID: "); String id = sc.nextLine();
                System.out.print("Nhap ten: "); String name = sc.nextLine();
                System.out.print("Nhap email: "); String email = sc.nextLine();
                System.out.println("Chon loai: 1-FullTime,2-PartTime,3-Intern");
                int type = Integer.parseInt(sc.nextLine());
                System.out.print("Nhap muc luong/ don gia: "); double sal = Double.parseDouble(sc.nextLine());
                System.out.print("Nhap Dept ID: "); String did = sc.nextLine();
                Department dept = deptService.findById(did);
                if (dept == null) {
                    System.out.println("Phong ban khong ton tai."); break;
                }
                Employee emp;
                if (type == 1) emp = new FullTime(id,name,email,dept,sal);
                else if (type == 2) emp = new PartTime(id,name,email,dept,sal);
                else emp = new Intern(id,name,email,dept,sal);
                empService.add(emp);
                System.out.println("Da them nhan vien.");
                break;
            case "b":
                for (Employee e : empService.getAll()) {
                    System.out.println(e.getId()+" - "+e.getName()+" - "+e.getDept().getId()+" - "+e.getClass().getSimpleName());
                }
                break;
            case "c":
                System.out.print("Nhap ID can sua: "); id = sc.nextLine();
                Employee eFound = empService.findById(id);
                if (eFound != null) {
                    System.out.print("Ten moi: "); name = sc.nextLine();
                    eFound.name = name; // thay doi truc tiep de don gian
                    System.out.println("Da cap nhat.");
                } else {
                    System.out.println("Khong tim thay.");
                }
                break;
            case "d":
                System.out.print("Nhap ID can xoa: "); id = sc.nextLine();
                if (empService.delete(id)) System.out.println("Da xoa.");
                else System.out.println("Khong tim thay.");
                break;
            default:
                System.out.println("Quay lai.");
        }
    }
}
