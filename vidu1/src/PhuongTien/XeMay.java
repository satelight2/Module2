package PhuongTien;

public class XeMay extends PhuongTien{
    private int CongSuat;

    public XeMay() {
    }

    public XeMay(int iD, String HangSX, int NamSX, double GiaBan, String MauXe, int CongSuat) {
        super(iD, HangSX, NamSX, GiaBan, MauXe);
        this.CongSuat = CongSuat;
    }

    public int getCongSuat() {
        return CongSuat;
    }

    public void setCongSuat(int congSuat) {
        CongSuat = congSuat;
    }

    public void nhap(){
        super.nhap();
        System.out.print("Nhap cong suat: ");
        CongSuat = sc.nextInt();
    }

    public void xuat(){
        System.out.println("-".repeat(150));
        System.out.printf("| %-10s | %-20s | %-15s | %-15s | %-15s | %-15s  |\n",
                "ID", "Hãng SX", "Năm SX", "Giá bán", "Màu xe", "Công suất");
        System.out.println("-".repeat(150));
        System.out.printf("| %-10s | %-20s | %-15d | %-15.2f | %-15s | %-15d|\n",
                super.getiD(), super.getHangSX(), super.getNamSX(), super.getGiaBan(), super.getMauXe(),CongSuat);
        System.out.println("-".repeat(150));
    }
}
