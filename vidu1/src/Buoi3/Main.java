package Buoi3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Store myStore = new Store(5);

        int choice;
        do {
            System.out.println("Chọn thao tác:");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Tìm kiếm sản phẩm");
            System.out.println("3. Sắp xếp và hiển thị danh sách sản phẩm");
            System.out.println("4. Hiển thị danh sách sản phẩm");
            System.out.println("0. Thoát");

            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Nhập thông tin sản phẩm:");
                    System.out.print("ID: ");
                    String id = scanner.next();
                    System.out.print("Tên: ");
                    String name = scanner.next();
                    System.out.print("Giá: ");
                    double price = scanner.nextDouble();
                    System.out.print("Giảm giá (%): ");
                    double discount = scanner.nextDouble();

                    myStore.add(new Product(id, name, price, discount));
                    break;

                case 2:
                    System.out.print("Nhập ID sản phẩm cần tìm: ");
                    String searchId = scanner.next();
                    Product foundProduct = myStore.findId(searchId);
                    if (foundProduct != null) {
                        System.out.println("Sản phẩm được tìm thấy: " + foundProduct.getName());
                    } else {
                        System.out.println("Không tìm thấy sản phẩm có ID = " + searchId);
                    }
                    break;

                case 3:
                    myStore.sort();
                    myStore.show();
                    break;

                case 4:
                    myStore.show();
                    break;

                case 0:
                    System.out.println("Chương trình kết thúc.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }

        } while (choice != 0);

        scanner.close();
    }
}

