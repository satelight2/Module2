package PhuongTien;

public class XeTai extends PhuongTien{
    private int TrongTai;

    public XeTai() {
    }

    public XeTai(int iD, String HangSX, int NamSX, double GiaBan, String MauXe, int TrongTai) {
        super(iD, HangSX, NamSX, GiaBan, MauXe);
        this.TrongTai = TrongTai;
    }

    public int getTrongTai() {
        return TrongTai;
    }

    public void setTrongTai(int trongTai) {
        TrongTai = trongTai;
    }

    public void nhap(){
        super.nhap();
        System.out.print("Nhap trong tai: ");
        TrongTai = sc.nextInt();
    }
}
