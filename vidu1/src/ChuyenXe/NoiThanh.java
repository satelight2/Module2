package ChuyenXe;

public class NoiThanh extends  ChuyenXe{
    private double SoKm;
    private String SoTuyen;

    public NoiThanh(String maSoChuyen, String hoTenTaiXe, String soXe, double doanhThu, double SoKm, String SoTuyen) {
        super(maSoChuyen, hoTenTaiXe, soXe, doanhThu);
        this.SoKm = SoKm;
        this.SoTuyen = SoTuyen;
    }

    public NoiThanh() {
        super();
        this.SoKm = 0;
        this.SoTuyen = "";
    }


    public double getSoKm() {
        return SoKm;
    }

    public void setSoKm(double soKm) {
        SoKm = soKm;
    }

    public String getSoTuyen() {
        return SoTuyen;
    }

    public void setSoTuyen(String soTuyen) {
        SoTuyen = soTuyen;
    }
    public void nhap()
    {
        super.nhap();
        System.out.println("Nhap So Tuyen: ");
        in.nextLine();
        this.SoTuyen=in.nextLine();
        System.out.println("So Km: ");
        this.SoKm=in.nextDouble();

    }
    public String toString()
    {
        return "Chuyen Xe Noi Thanh " + super.toString()
                + "\n So Tuyen: " + this.SoTuyen + "\nSo Km: " + this.SoKm
                + "\nDoanh Thu: " + this.DoanhThu;
    }
}


