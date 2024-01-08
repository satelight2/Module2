package PhuongTien;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QuanLyPhuongTienGT ql = new QuanLyPhuongTienGT();
        int chon;
        do {
            System.out.println("1. Nhap thong tin phuong tien giao thong");
            System.out.println("2. Xuat thong tin phuong tien giao thong");
            System.out.println("3. Tim kiem phuong tien giao thong");
            System.out.println("4. Sắp xếp phương tiện giao thông");
            System.out.println("5. Thoat");
            System.out.print("Chon: ");
            chon = sc.nextInt();
            switch (chon) {
                case 1:
                    int chon1;
                    do {
                        displaySubmenu();
                        chon1 = sc.nextInt();
                        switch (chon1) {
                            case 1:
                                Oto oto = new Oto();
                                oto.nhap();
                                ql.addOto(oto);
                                break;
                            case 2:
                                XeMay xeMay = new XeMay();
                                xeMay.nhap();
                                ql.addXeMay(xeMay);
                                break;
                            case 3:
                                XeTai xeTai = new XeTai();
                                xeTai.nhap();
                                ql.addXeTai(xeTai);
                                break;
                            case 4:
                                System.out.println("Ket thuc chuong trinh");
                                break;
                            default:
                                System.out.println("Nhap sai, nhap lai");
                                break;
                        }
                    } while (chon1 != 4);
                    break;
                case 2:
                    int chon2;
                    do {
                        displayInfor();
                        chon2 = sc.nextInt();
                        switch (chon2) {
                            case 1:
                                ql.xuat();
                                break;
                            case 2:
                                ql.xuat();
                                break;
                            case 3:
                                ql.xuat();
                                break;
                            case 4:
                                System.out.println("Ket thuc chuong trinh");
                                break;
                            default:
                                System.out.println("Nhap sai, nhap lai");
                                break;
                        }
                    } while (chon2 != 4);
                    break;
                case 3:
                    int chon3;
                    do {
                        searchMenu();
                        chon3 = sc.nextInt();
                        switch (chon3) {
                            case 1:
                                System.out.print("Nhap hang san xuat: ");
                                String hangSX = sc.nextLine();
                                ql.timKiemTheoHang(hangSX);
                                break;
                            case 2:
                                System.out.print("Nhap mau xe: ");
                                String mauXe = sc.nextLine();
                                ql.timKiemTheoMau(mauXe);
                                break;
                            case 3:
                                System.out.println("Ket thuc chuong trinh");
                                break;
                            default:
                                System.out.println("Nhap sai, nhap lai");
                                break;
                        }
                    } while (chon3 != 3);
                    break;
                case 4:
                      int chon4;
                      do{
                          sortMenu();
                            chon4 = sc.nextInt();
                            switch (chon4){
                                case 1:
                                    int chon5;
                                    do{
                                        sortMenu1();
                                        chon5 = sc.nextInt();
                                        switch (chon5){
                                            case 1:
                                                int chon6;
                                                sortMenuAsc();
                                                chon6 = sc.nextInt();
                                                switch (chon6){
                                                    case 1:
                                                        ql.sapXepTheoGiaOto();
                                                        break;
                                                    case 2:
                                                        ql.sapXepTheoGiaXeMay();
                                                        break;
                                                    case 3:
                                                        ql.sapXepTheoGiaXeTai();
                                                        break;
                                                    case 4:
                                                        System.out.println("Ket thuc chuong trinh");
                                                        break;
                                                }
                                                break;

                                            case 2:
                                                int chon7;
                                                sortMenuDesc();
                                                chon7 = sc.nextInt();
                                                switch (chon7){
                                                    case 1:
                                                        ql.sapXepTheoGiaOto();
                                                        break;
                                                    case 2:
                                                        ql.sapXepTheoGiaXeMay();
                                                        break;
                                                    case 3:
                                                        ql.sapXepTheoGiaXeTai();
                                                        break;
                                                    case 4:
                                                        System.out.println("Ket thuc chuong trinh");
                                                        break;
                                                }
                                                break;
                                            case 3:
                                                System.out.println("Ket thuc chuong trinh");
                                                break;
                                        }
                                    }while (chon5 != 3);

                                    break;
                                case 2:
                                    break;
                                case 3:
                                    System.out.println("Ket thuc chuong trinh");
                                    break;
                            }

                      }while (chon4 != 3);

                    break;
                case 5:
                    System.out.println("Ket thuc chuong trinh");
                    break;
                default:
                    System.out.println("Nhap sai, nhap lai");
                    break;
            }
        } while (chon != 4);
    }
    public static void displaySubmenu(){
        System.out.println("1. Them xe oto");
        System.out.println("2. Them xe may");
        System.out.println("3. Them xe tai");
        System.out.println("4. Thoat");
        System.out.print("Chon: ");
    };

    public static void displayInfor(){
        System.out.println("1. Xuat thong tin xe oto");
        System.out.println("2. Xuat thong tin xe may");
        System.out.println("3. Xuat thong tin xe tai");
        System.out.println("4. Thoat");
        System.out.print("Chon: ");}

    public static void searchMenu(){
        System.out.println("1. Tim kiem theo hang san xuat");
        System.out.println("2. Tim kiem theo mau xe");
        System.out.println("3. Thoat");
        System.out.print("Chon: ");}

    public static void sortMenu(){
        System.out.println("1. Sap xep theo giá bán");
        System.out.println("2. Sap xep theo hãng sản xuất");
        System.out.println("3. Thoat");
        System.out.print("Chon: ");}

    public static void sortMenu1(){
        System.out.println("1. Sap xep theo giá bán tăng dần");
        System.out.println("2. Sap xep theo giá bán giảm dần");
        System.out.println("3. Thoat");
        System.out.print("Chon: ");
    };



    public static void sortMenuAsc(){
        System.out.println("1. Xe ô tô");
        System.out.println("2. Xe máy");
        System.out.println("3. Xe tải");
        System.out.println("4. Thoat");
        System.out.print("Chon: ");
    };

    public static void sortMenuDesc(){
        System.out.println("1. Xe ô tô");
        System.out.println("2. Xe máy");
        System.out.println("3. Xe tải");
        System.out.println("4. Thoat");
        System.out.print("Chon: ");
    };
};