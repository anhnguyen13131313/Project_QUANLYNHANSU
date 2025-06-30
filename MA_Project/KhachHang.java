// KhachHang.java
// Quan ly thong tin khach hang cua shop, co them thuoc tinh "khachThanThiet" de danh dau khach hang than thiet.

public class KhachHang implements HienThi {
    private String maKhachHang;     // Ma dinh danh duy nhat, vi du "C001"
    private String tenKhachHang;    // Ten khach hang, vi du "Nguyen Van A"
    private String soDienThoai;     // So dien thoai lien he
    private boolean khachThanThiet; // Danh dau co phai khach hang than thiet hay khong

    // Constructor
    public KhachHang(String maKhachHang, String tenKhachHang, String soDienThoai, boolean khachThanThiet) {
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.soDienThoai = soDienThoai;
        this.khachThanThiet = khachThanThiet;
    }

    // Getter/Setter
    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public boolean isKhachThanThiet() {
        return khachThanThiet;
    }

    public void setKhachThanThiet(boolean khachThanThiet) {
        this.khachThanThiet = khachThanThiet;
    }

    // Hien thi thong tin khach hang
    @Override
    public void hienThiThongTin() {
        String loai = khachThanThiet ? " (Than thiet)" : "";
        System.out.printf("Ma: %s | Ten: %s%s | SDT: %s\n",
                maKhachHang, tenKhachHang, loai, soDienThoai);
    }
}
