package Buoi3;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Product> productList = new ArrayList<>();

        int choice;
        do {
            System.out.println("1. Nhập sản phẩm");
            System.out.println("2. Tính giá bán cho từng sản phẩm");
            System.out.println("3. Hiển thị danh sách sản phẩm theo giá bán tăng dần");
            System.out.println("4. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Nhập n sản phẩm
                    System.out.print("Nhập số lượng sản phẩm: ");
                    int n = scanner.nextInt();
                    for (int i = 0; i < n; i++) {
                        System.out.println("Nhập thông tin sản phẩm thứ " + (i + 1) + ":");
                        System.out.print("ID: ");
                        String id = scanner.next();
                        System.out.print("Tên: ");
                        String name = scanner.next();
                        System.out.print("Giá: ");
                        double price = scanner.nextDouble();
                        System.out.print("Giảm giá (%): ");
                        double discount = scanner.nextDouble();

                        Product product = new Product(id, name, price, discount);
                        productList.add(product);
                    }
                    break;

                case 2:
                    // Tính giá bán cho từng sản phẩm
                    for (Product product : productList) {
                        product.calculateSalePrice();
                    }
                    System.out.println("Đã tính giá bán cho từng sản phẩm.");
                    break;

                case 3:
                    // Hiển thị danh sách sản phẩm theo giá bán tăng dần
                    Collections.sort(productList, Comparator.comparingDouble(Product::getSalePrice));
                    System.out.println("Danh sách sản phẩm theo giá bán tăng dần:");
                    for (Product product : productList) {
                        System.out.println("ID: " + product.getId() + ", Tên: " + product.getName() + ", Giá bán: " + product.getSalePrice());
                    }
                    break;

                case 4:
                    System.out.println("Đã thoát chương trình.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 4);
    }
}

