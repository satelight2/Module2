package PhuongTien;

import java.util.Scanner;

public class PhuongTien {
    private int iD;
    private String HangSX;
    private int NamSX;
    private double GiaBan;
    private String MauXe;
    Scanner sc = new Scanner(System.in);
    public PhuongTien() {
    }

    public PhuongTien(int iD, String HangSX, int NamSX, double GiaBan, String MauXe) {
        this.iD = iD;
        this.HangSX = HangSX;
        this.NamSX = NamSX;
        this.GiaBan = GiaBan;
        this.MauXe = MauXe;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getHangSX() {
        return HangSX;
    }

    public void setHangSX(String hangSX) {
        HangSX = hangSX;
    }

    public int getNamSX() {
        return NamSX;
    }

    public void setNamSX(int namSX) {
        NamSX = namSX;
    }

    public double getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(double giaBan) {
        GiaBan = giaBan;
    }

    public String getMauXe() {
        return MauXe;
    }

    public void setMauXe(String mauXe) {
        MauXe = mauXe;
    }

    public void nhap() {

        System.out.println("Nhap thong tin phuong tien");
        System.out.print("Nhap ID: ");
        iD = Integer.parseInt(sc.nextLine());
        System.out.print("Nhap hang san xuat: ");
        HangSX = sc.nextLine();
        System.out.print("Nhap nam san xuat: ");
        NamSX = Integer.parseInt(sc.nextLine());
        System.out.print("Nhap gia ban: ");
        GiaBan = Double.parseDouble(sc.nextLine());
        System.out.print("Nhap mau xe: ");
        MauXe = sc.nextLine();
    }
    public void xuat() {
        System.out.println("------------------------------------------------------------------------");
        System.out.printf("| %-10s | %-20s | %-15s | %-15s | %-15s |\n", "ID", "Hãng SX", "Năm SX", "Giá bán", "Màu xe");
        System.out.println("------------------------------------------------------------------------");
        System.out.printf("| %-10s | %-20s | %-15d | %-15.2f | %-15s |\n", iD, HangSX, NamSX, GiaBan, MauXe);
        System.out.println("------------------------------------------------------------------------");
    }

}
