// ShopManager.java
// Trung tam quan ly toan bo du lieu cua shop: san pham, khach hang, don hang

import java.util.ArrayList;
import java.util.Scanner;

public class ShopManager {
    private ArrayList<SanPham> dsSanPham;
    private ArrayList<KhachHang> dsKhachHang;
    private ArrayList<DonHang> dsDonHang;
    private Scanner sc;

    public ShopManager() {
        dsSanPham = new ArrayList<>();
        dsKhachHang = new ArrayList<>();
        dsDonHang = new ArrayList<>();
        sc = new Scanner(System.in);
    }

    //----------------------------------------
    // 1. Quan ly san pham
    //----------------------------------------

    // Them san pham moi (kiem tra ma khong trung)
    public void themSanPham() {
        System.out.print("Nhap ma san pham: ");
        String ma = sc.nextLine();
        // Kiem tra ma trung
        if (findSanPhamById(ma) != null) {
            System.out.println("Ma san pham da ton tai!");
            return;
        }
        System.out.print("Nhap ten san pham: ");
        String ten = sc.nextLine();
        System.out.print("Nhap don gia: ");
        double gia = Double.parseDouble(sc.nextLine());
        System.out.print("Nhap so luong: ");
        int sl = Integer.parseInt(sc.nextLine());

        SanPham sp = new SanPham(ma, ten, gia, sl);
        dsSanPham.add(sp);
        System.out.println("Da them san pham thanh cong.\n");
    }

    // Xoa san pham theo ma
    public void xoaSanPham(String ma) {
        SanPham sp = findSanPhamById(ma);
        if (sp != null) {
            dsSanPham.remove(sp);
            System.out.println("Da xoa san pham co ma: " + ma);
        } else {
            System.out.println("Khong tim thay san pham can xoa.");
        }
    }

    // Hien thi danh sach tat ca san pham
    public void hienThiTatCaSanPham() {
        if (dsSanPham.isEmpty()) {
            System.out.println("Chua co san pham nao.\n");
            return;
        }
        System.out.println("Danh sach san pham hien co:");
        for (SanPham sp : dsSanPham) {
            sp.hienThiThongTin();
        }
        System.out.println();
    }

    // Tim san pham theo ma
    public SanPham findSanPhamById(String ma) {
        for (SanPham sp : dsSanPham) {
            if (sp.getMaSanPham().equalsIgnoreCase(ma)) {
                return sp;
            }
        }
        return null;
    }

    // Tim va hien thi san pham theo ma
    public void timSanPhamTheoMa() {
        System.out.print("Nhap ma san pham can tim: ");
        String ma = sc.nextLine();
        SanPham sp = findSanPhamById(ma);
        if (sp != null) {
            sp.hienThiThongTin();
        } else {
            System.out.println("Khong tim thay san pham.\n");
        }
    }

    //----------------------------------------
    // 2. Quan ly khach hang
    //----------------------------------------

    // Them khach hang moi (kiem tra ma khong trung)
    public void themKhachHang() {
        System.out.print("Nhap ma khach hang: ");
        String ma = sc.nextLine();
        if (findKhachHangById(ma) != null) {
            System.out.println("Ma khach hang da ton tai!");
            return;
        }
        System.out.print("Nhap ten khach hang: ");
        String ten = sc.nextLine();
        System.out.print("Nhap so dien thoai: ");
        String sdt = sc.nextLine();
        System.out.print("Khach hang than thiet? (yes/no): ");
        String ans = sc.nextLine().trim().toLowerCase();
        boolean thanThiet = ans.equals("yes");

        KhachHang kh = new KhachHang(ma, ten, sdt, thanThiet);
        dsKhachHang.add(kh);
        System.out.println("Da them khach hang thanh cong.\n");
    }

    // Hien thi danh sach khach hang
    public void hienThiTatCaKhachHang() {
        if (dsKhachHang.isEmpty()) {
            System.out.println("Chua co khach hang nao.\n");
            return;
        }
        System.out.println("Danh sach khach hang:");
        for (KhachHang kh : dsKhachHang) {
            kh.hienThiThongTin();
        }
        System.out.println();
    }

    // Tim khach hang theo ID
    public KhachHang findKhachHangById(String ma) {
        for (KhachHang kh : dsKhachHang) {
            if (kh.getMaKhachHang().equalsIgnoreCase(ma)) {
                return kh;
            }
        }
        return null;
    }

    // Tim va hien thi khach hang theo ten (co the nhap mot phan ten)
    public void timKhachHangTheoTen() {
        System.out.print("Nhap ten (hoac mot phan ten) khach hang can tim: ");
        String tenNguoi = sc.nextLine().toLowerCase();
        boolean found = false;
        for (KhachHang kh : dsKhachHang) {
            if (kh.getTenKhachHang().toLowerCase().contains(tenNguoi)) {
                kh.hienThiThongTin();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay khach hang phu hop.\n");
        } else {
            System.out.println();
        }
    }

    //----------------------------------------
    // 3. Tao don hang
    //----------------------------------------

    public void taoDonHang() {
        if (dsKhachHang.isEmpty()) {
            System.out.println("Chua co khach hang nao, vui long them khach hang truoc.\n");
            return;
        }
        if (dsSanPham.isEmpty()) {
            System.out.println("Chua co san pham nao, vui long them san pham truoc.\n");
            return;
        }

        // Chon khach hang
        System.out.println("Danh sach khach hang:");
        for (KhachHang kh : dsKhachHang) {
            kh.hienThiThongTin();
        }
        System.out.print("Nhap ma khach hang dat don: ");
        String maKH = sc.nextLine();
        KhachHang khChon = findKhachHangById(maKH);
        if (khChon == null) {
            System.out.println("Khong tim thay khach hang.\n");
            return;
        }

        // Tao don moi voi khach duoc chon
        DonHang dh = new DonHang(khChon);

        // Chon san pham va them vao don
        while (true) {
            System.out.println("Danh sach san pham:");
            for (SanPham sp : dsSanPham) {
                sp.hienThiThongTin();
            }
            System.out.print("Nhap ma san pham muon them (go \"done\" de ket thuc): ");
            String maSP = sc.nextLine();
            if (maSP.equalsIgnoreCase("done")) {
                break;
            }
            SanPham spChon = findSanPhamById(maSP);
            if (spChon == null) {
                System.out.println("San pham khong ton tai. Vui long thu lai.\n");
                continue;
            }
            System.out.print("Nhap so luong muon mua: ");
            int soLuongMua = Integer.parseInt(sc.nextLine());
            if (soLuongMua > spChon.getSoLuong()) {
                System.out.println("So luong trong kho khong du. Vui long thu lai.\n");
                continue;
            }
            // Giam so luong kho di
            spChon.setSoLuong(spChon.getSoLuong() - soLuongMua);
            // Them san pham vao don voi so luong tuong ung
            SanPham spTrongDon = new SanPham(spChon.getMaSanPham(),
                                              spChon.getTenSanPham(),
                                              spChon.getDonGia(),
                                              soLuongMua);
            dh.themSanPham(spTrongDon);
            System.out.println("Da them vao don.\n");
        }

        // Luu don vao danh sach don hang
        dsDonHang.add(dh);
        System.out.println("Da tao don hang thanh cong.\n");
    }

    // Hien thi tat ca don hang
    public void hienThiTatCaDonHang() {
        if (dsDonHang.isEmpty()) {
            System.out.println("Chua co don hang nao.\n");
            return;
        }
        System.out.println("Danh sach cac don hang da tao:");
        for (DonHang dh : dsDonHang) {
            dh.hienThiHoaDon();
        }
    }

    //----------------------------------------
    // 4. Tim kiem tong hop
    //----------------------------------------

    // Tim khach hang theo ten
    public void timKhachHang() {
        timKhachHangTheoTen();
    }

    // Tim san pham theo ma
    public void timSanPham() {
        timSanPhamTheoMa();
    }

    //----------------------------------------
    // Ham chay menu con cua ShopManager
    //----------------------------------------

    public void showMenu() {
        while (true) {
            System.out.println("===== SHOP THU CUNG =====");
            System.out.println("1. Them san pham");
            System.out.println("2. Xoa san pham");
            System.out.println("3. Hien thi tat ca san pham");
            System.out.println("4. Them khach hang");
            System.out.println("5. Hien thi tat ca khach hang");
            System.out.println("6. Tao don hang");
            System.out.println("7. Hien thi tat ca don hang");
            System.out.println("8. Tim san pham theo ma");
            System.out.println("9. Tim khach hang theo ten");
            System.out.println("0. Thoat");
            System.out.print("Lua chon cua ban: ");

            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    themSanPham();
                    break;
                case "2":
                    System.out.print("Nhap ma san pham can xoa: ");
                    xoaSanPham(sc.nextLine());
                    break;
                case "3":
                    hienThiTatCaSanPham();
                    break;
                case "4":
                    themKhachHang();
                    break;
                case "5":
                    hienThiTatCaKhachHang();
                    break;
                case "6":
                    taoDonHang();
                    break;
                case "7":
                    hienThiTatCaDonHang();
                    break;
                case "8":
                    timSanPham();
                    break;
                case "9":
                    timKhachHang();
                    break;
                case "0":
                    System.out.println("Cam on ban da su dung chuong trinh. Tam biet!");
                    return;
                default:
                    System.out.println("Lua chon khong hop le. Vui long thu lai.\n");
                    break;
            }
        }
    }
}
