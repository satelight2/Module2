package ThuVienX;

public class SachThamKhao extends Sach{
    private double thue;

    public SachThamKhao() {
    }

    public SachThamKhao(String maSach, String ngayNhap, int donGia, int soLuong, String nhaXuatBan, double thue) {
        super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
        this.thue = thue;
    }

    public double getThue() {
        return thue;
    }

    public void setThue(double thue) {
        this.thue = thue;
    }

    public double calculateTotalPrice() {
        return soLuong * donGia + thue;
    }
}
