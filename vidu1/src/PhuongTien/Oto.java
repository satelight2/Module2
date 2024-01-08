package PhuongTien;

public class Oto extends PhuongTien {
    private int SoChoNgoi;
    private String KieuDongCo;

    public Oto() {
    }

    public Oto(int iD, String HangSX, int NamSX, double GiaBan, String MauXe, int SoChoNgoi, String KieuDongCo) {
        super(iD, HangSX, NamSX, GiaBan, MauXe);
        this.SoChoNgoi = SoChoNgoi;
        this.KieuDongCo = KieuDongCo;
    }

    public int getSoChoNgoi() {
        return SoChoNgoi;
    }

    public void setSoChoNgoi(int soChoNgoi) {
        SoChoNgoi = soChoNgoi;
    }

    public String getKieuDongCo() {
        return KieuDongCo;
    }

    public void setKieuDongCo(String kieuDongCo) {
        KieuDongCo = kieuDongCo;
    }

    public void nhap(){

        super.nhap();
        System.out.print("Nhap so cho ngoi: ");

        SoChoNgoi = sc.nextInt();
        System.out.print("Nhap kieu dong co: ");
        sc.nextLine();
        KieuDongCo = sc.nextLine();
    }
    public void xuat() {
        System.out.println("-".repeat(150));
        System.out.printf("| %-10s | %-20s | %-15s | %-15s | %-15s | %-15s | %-15s |\n",
                "ID", "Hãng SX", "Năm SX", "Giá bán", "Màu xe", "Số chỗ ngồi", "Kiểu động cơ");
        System.out.println("-".repeat(150));
        System.out.printf("| %-10s | %-20s | %-15d | %-15.2f | %-15s | %-15d | %-15s |\n",
                super.getiD(), super.getHangSX(), super.getNamSX(), super.getGiaBan(), super.getMauXe(), SoChoNgoi, KieuDongCo);
        System.out.println("-".repeat(150));
    }



}

