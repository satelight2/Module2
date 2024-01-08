package ThuVienX;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyThuVien {
    private static ArrayList<Sach> bookList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập danh sách sách
        inputBookList(scanner);

        // Xuất thông tin và tính tổng thành tiền cho từng loại sách
        displayAndCalculateTotalPrice();

        // Tính trung bình cộng đơn giá của sách tham khảo
        calculateAverageUnitPriceForReferenceBooks();

        // Xuất sách giáo khoa của nhà xuất bản X
        displayTextbooksByPublisher(scanner, "X");
    }

    private static void inputBookList(Scanner scanner) {
        System.out.println("Enter the number of books: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Clear the buffer

        for (int i = 0; i < n; i++) {
            System.out.println("Enter book type (1 for Textbook, 2 for ReferenceBook): ");
            int bookType = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer

            System.out.println("Enter book code: ");
            String bookCode = scanner.nextLine();

            System.out.println("Enter import date (dd/mm/yyyy): ");
            String importDate = scanner.nextLine();

            System.out.println("Enter unit price: ");
            int unitPrice = scanner.nextInt();

            System.out.println("Enter quantity: ");
            int quantity = scanner.nextInt();

            scanner.nextLine(); // Clear the buffer

            System.out.println("Enter publisher: ");
            String publisher = scanner.nextLine();

            if (bookType == 1) {
                System.out.println("Enter condition (new/old): ");
                String condition = scanner.nextLine();
                bookList.add(new SachGiaoKhoa(bookCode, importDate, unitPrice, quantity, publisher, condition));
            } else if (bookType == 2) {
                System.out.println("Enter tax: ");
                double tax = scanner.nextDouble();
                bookList.add(new SachThamKhao(bookCode, importDate, unitPrice, quantity, publisher, tax));
            }
        }
    }

    private static void displayAndCalculateTotalPrice() {
        for (Sach book : bookList) {
            book.xuat();
            double totalPrice = book.calculateTotalPrice();
            System.out.println("Total Price: " + totalPrice);
            System.out.println("--------------------------");
        }
    }

    private static void calculateAverageUnitPriceForReferenceBooks() {
        double totalUnitPrice = 0;
        int referenceBookCount = 0;

        for (Sach book : bookList) {
            if (book instanceof SachThamKhao) {
                totalUnitPrice += ((SachThamKhao) book).unitPrice;
                referenceBookCount++;
            }
        }

        if (referenceBookCount > 0) {
            double averageUnitPrice = totalUnitPrice / referenceBookCount;
            System.out.println("Average Unit Price for Reference Books: " + averageUnitPrice);
        } else {
            System.out.println("No Reference Books found.");
        }
    }

    private static void displayTextbooksByPublisher(Scanner scanner, String publisherToSearch) {
        System.out.println("Textbooks from publisher " + publisherToSearch + ":");
        System.out.println("--------------------------");

        boolean foundTextbook = false;

        for (Sach book : bookList) {
            if (book instanceof SachGiaoKhoa && publisherToSearch.equals(book.nhaXuatBan)) {
                book.xuat();
                foundTextbook = true;
                System.out.println("--------------------------");
            }
        }

        if (!foundTextbook) {
            System.out.println("No Textbooks found from publisher " + publisherToSearch + ".");
        }
    }
}
