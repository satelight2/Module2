package ThuVienX;

import java.util.Scanner;

public class Sach {
    public String maSach;
    public String ngayNhap;
    public int donGia;
    public int soLuong;
    public String nhaXuatBan;
    public double unitPrice;

    public Sach() {

    }

    public Sach(String maSach, String ngayNhap, int donGia, int soLuong, String nhaXuatBan) {
        this.maSach = maSach;
        this.ngayNhap = ngayNhap;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.nhaXuatBan = nhaXuatBan;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }

    public void setNhaXuatBan(String nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }
    public double calculateTotalPrice() {
        return 0; // To be overridden by subclasses
    }

    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap ma sach: ");
        this.maSach = scanner.nextLine();
        System.out.println("Nhap ngay nhap: ");
        this.ngayNhap = scanner.nextLine();
        System.out.println("Nhap don gia: ");
        this.donGia = scanner.nextInt();
        System.out.println("Nhap so luong: ");
        this.soLuong = scanner.nextInt();
        System.out.println("Nhap nha xuat ban: ");
        this.nhaXuatBan = scanner.nextLine();
    }

    public void xuat() {
        System.out.println("Ma sach: " + this.maSach);
        System.out.println("Ngay nhap: " + this.ngayNhap);
        System.out.println("Don gia: " + this.donGia);
        System.out.println("So luong: " + this.soLuong);
        System.out.println("Nha xuat ban: " + this.nhaXuatBan);

    }

    public void tinhTien() {

    }

    public void tinhTien(int soLuong) {

    }

    public void tinhTien(int soLuong, int donGia) {

    }
}
