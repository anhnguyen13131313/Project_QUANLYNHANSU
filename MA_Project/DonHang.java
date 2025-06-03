// DonHang.java
// Luu tru thong tin 1 don hang: bao gom khach hang va danh sach san pham duoc chon
import java.util.ArrayList;

public class DonHang {
    private KhachHang khachHang;            // Khach hang dat don
    private ArrayList<SanPham> danhSachSP;  // Danh sach san pham trong don (moi san pham co so luong rieng)
    private double giamGia;                 // Giam gia (neu khach than thiet), ti le % (vd: 0.05 = 5%)

    // Constructor: khoi tao don hang voi khach hang da chon
    public DonHang(KhachHang khachHang) {
        this.khachHang = khachHang;
        this.danhSachSP = new ArrayList<>();
        // Neu khach hang than thiet, mac dinh giam 5%
        this.giamGia = khachHang.isKhachThanThiet() ? 0.05 : 0.0;
    }

    // Them san pham vao don hang; neu san pham da co trong don, chi cap nhat so luong
    public void themSanPham(SanPham spMoi) {
        for (SanPham sp : danhSachSP) {
            if (sp.getMaSanPham().equals(spMoi.getMaSanPham())) {
                // Neu ma giong, cong don so luong
                int soLuongCu = sp.getSoLuong();
                sp.setSoLuong(soLuongCu + spMoi.getSoLuong());
                return;
            }
        }
        // Neu chua co, them moi
        danhSachSP.add(spMoi);
    }

    // Tinh tong tien (chua tinh giam gia)
    public double tinhTongTienTruocGiam() {
        double tong = 0.0;
        for (SanPham sp : danhSachSP) {
            tong += sp.tinhThanhTien();
        }
        return tong;
    }

    // Tinh tong tien sau khi giam gia (neu co)
    public double tinhTongTien() {
        double truocGiam = tinhTongTienTruocGiam();
        return truocGiam * (1 - giamGia);
    }

    // Hien thi chi tiet hoa don
    public void hienThiHoaDon() {
        System.out.println("----- HOA DON CHI TIET -----");
        System.out.print("Khach hang: ");
        khachHang.hienThiThongTin();
        System.out.println("Danh sach san pham:");
        System.out.println("Ma    | Ten                          | Don gia    | So luong | Thanh tien");
        System.out.println("--------------------------------------------------------------------------");
        for (SanPham sp : danhSachSP) {
            System.out.printf("%-5s | %-28s | %10.2f | %8d | %10.2f\n",
                    sp.getMaSanPham(), sp.getTenSanPham(), sp.getDonGia(),
                    sp.getSoLuong(), sp.tinhThanhTien());
        }
        System.out.println("--------------------------------------------------------------------------");
        double tongTruoc = tinhTongTienTruocGiam();
        if (giamGia > 0) {
            System.out.printf("Tong truoc giam: %.2f\n", tongTruoc);
            System.out.printf("Giam gia %.0f%%       : -%.2f\n", giamGia * 100, tongTruoc * giamGia);
        }
        System.out.printf("Tong thanh toan   : %.2f\n", tinhTongTien());
        System.out.println("---------------------------\n");
    }

    // Getter danh sach san pham (neu can)
    public ArrayList<SanPham> getDanhSachSP() {
        return danhSachSP;
    }
}
