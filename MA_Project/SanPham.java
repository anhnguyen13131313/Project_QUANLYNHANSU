// SanPham.java
// Luu tru thong tin tung san pham trong shop, quan ly gia, so luong va tinh thanh tien.

public class SanPham implements HienThi {
    private String maSanPham;   // Ma duy nhat cua san pham, vi du "P001"
    private String tenSanPham;  // Ten san pham, vi du "Goi Thuc An Cho Cho"
    private double donGia;      // Gia ban 1 don vi san pham
    private int soLuong;        // So luong san pham (trong kho hoac dat trong don hang)

    // Constructor: khoi tao san pham moi voi thong tin co ban
    public SanPham(String maSanPham, String tenSanPham, double donGia, int soLuong) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }

    // Getter/Setter
    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    // Tinh thanh tien: don gia * so luong
    public double tinhThanhTien() {
        return donGia * soLuong;
    }

    // Hien thi thong tin chi tiet san pham
    @Override
    public void hienThiThongTin() {
        System.out.printf("Ma: %s | Ten: %s | Don gia: %.2f | So luong: %d | Thanh tien (neu dat toan bo): %.2f\n",
                maSanPham, tenSanPham, donGia, soLuong, tinhThanhTien());
    }
}
