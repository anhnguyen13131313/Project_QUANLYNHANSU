package SourceCode;

// DepartmentMenu.java
import java.util.Scanner;
public class DepartmentMenu {
    public static void show(Scanner sc, DepartmentService service) {
        System.out.println("-- Quan ly phong ban --");
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
                System.out.print("Nhap mo ta: "); String desc = sc.nextLine();
                service.add(new Department(id, name, desc));
                System.out.println("Da them."); break;
            case "b":
                for (Department d : service.getAll()) {
                    System.out.println(d.getId()+" - "+d.getName()+" ("+d.getDescription()+")");
                }
                break;
            case "c":
                System.out.print("Nhap ID can sua: "); id = sc.nextLine();
                Department dpt = service.findById(id);
                if (dpt != null) {
                    System.out.print("Ten moi: "); name = sc.nextLine();
                    System.out.print("Mo ta moi: "); desc = sc.nextLine();
                    dpt.setName(name); dpt.setDescription(desc);
                    System.out.println("Da cap nhat.");
                } else {
                    System.out.println("Khong tim thay.");
                }
                break;
            case "d":
                System.out.print("Nhap ID can xoa: "); id = sc.nextLine();
                if (service.delete(id)) System.out.println("Da xoa.");
                else System.out.println("Khong tim thay hoac co nhan vien thuoc phong ban.");
                break;
            default:
                System.out.println("Quay lai.");
        }
    }
}
