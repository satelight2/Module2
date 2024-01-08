package ChuyenXe;

public class NgoaiThanh extends ChuyenXe{
    private String noiDen;
    private int soNgay;

    public NgoaiThanh(String ma, String name, String sx, double dt, String noiDen, int soNgay) {
        super(ma, name, sx, dt);
        this.noiDen = noiDen;
        this.soNgay = soNgay;
    }

    public NgoaiThanh() {
        super();
        this.noiDen = "";
        this.soNgay = 0;
    }

    public String getNoiDen() {
        return noiDen;
    }

    public void setNoiDen(String noiDen) {
        this.noiDen = noiDen;
    }

    public int getSoNgay() {
        return soNgay;
    }

    public void setSoNgay(int soNgay) {
        this.soNgay = soNgay;
    }

    public void nhap()
    {
        super.nhap();
        System.out.println("Nhap noi den: ");
        in.nextLine();
        noiDen=in.nextLine();
        System.out.println("Nhap so ngay: ");
        soNgay=in.nextInt();
    }

    public String toString()
    {
        return super.toString()+"\t"+this.noiDen+"\t"+this.soNgay;
    }
}
