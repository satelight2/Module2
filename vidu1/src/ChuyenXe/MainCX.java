package ChuyenXe;


import Buoi8.Student;

import java.util.Scanner;

public class MainCX {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NgoaiThanh ngoaiThanh = new NgoaiThanh();
       QuanlyChuyenXe management = new QuanlyChuyenXe();
        do {
            System.out.println("+++++++Quản lý+++++++");
            System.out.println("1. Thêm Chuyến xe ngoại thành");
            System.out.println("2. Thêm Chuyến xe nội thành");
            System.out.println("3. Hiển thị Chuyến xe ngoại thành");
            System.out.println("4. Hiển thị Chuyến xe nội thành");
            System.out.println("5. Thêm khóa học");
            System.out.println("6. Xóa khóa học");
            System.out.println("7. Hiển thị khóa học khóa học");
            System.out.println("8. Thoát");
            System.out.println("Lựa chọn của bạn là: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    management.addNgoaiThanh();

                    break;
                case 2:
                    management.addNoiThanh();
                    break;
                case 3:
                    management.hienThiNgoaiThanh();
                    break;
                case 4:
                    management.hienThiNoiThanh();

                    break;
                case 5:
                    System.out.println("Nhập vào mã chuyến xe ngoại thành muốn sửa: ");
                    String id = sc.nextLine();

                    management.suaNgoaiThanh(id);
                    break;
                case 6:
                    System.out.println("Nhập vào mã chuyến xe ngoại thành muốn sửa: ");
                    String id1 = sc.nextLine();
                    management.suaNoiThanh(id1);
                    break;
                case 7:
                    System.out.printf("%5s | %15s | %15s | %10s |\n","ID","Ten khóa học","Giáo viên","Sinh viên tối đa");

                    break;
                case 8:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn của bạn không phù hợp");
            }
        }while (true);
    }


    }

