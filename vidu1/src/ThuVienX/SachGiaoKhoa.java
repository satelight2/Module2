package ThuVienX;

public class SachGiaoKhoa extends Sach{
    private String tinhTrang;


    public SachGiaoKhoa() {
    }

    public SachGiaoKhoa(String maSach, String ngayNhap, int donGia, int soLuong, String nhaXuatBan, String tinhTrang) {
        super(maSach, ngayNhap, donGia, soLuong, nhaXuatBan);
        this.tinhTrang = tinhTrang;

    }

    public String getTinhTrang() {
        return tinhTrang;
    }



    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }
    public double calculateTotalPrice() {
        if (tinhTrang.equals("moi"))
            return soLuong * donGia;
        else if (tinhTrang.equals("cu"))
            return soLuong * donGia * 0.5;
        else
            return 0;

    }


    @Override
    public String toString() {
        return "SachGiaoKhoa{" +
                "tinhTrang='" + tinhTrang + '\'' +
                ", maSach='" + maSach + '\'' +
                ", ngayNhap='" + ngayNhap + '\'' +
                ", donGia=" + donGia +
                ", soLuong=" + soLuong +
                ", nhaXuatBan='" + nhaXuatBan + '\'' +
                '}';
    }
}
