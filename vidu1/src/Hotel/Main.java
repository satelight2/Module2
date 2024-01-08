package Hotel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ManagerHotel managerHotel = new ManagerHotel();


        do {
            System.out.println("1. Them khach hang");
            System.out.println("2. Them phong");
            System.out.println("3. Hien thi khach hang theo id");
            System.out.println("4. Hien thi danh sach phong");
            System.out.println("5. Xoa khach hang theo id");
            System.out.println("6. Tinh tien phong");
            System.out.println("7. Thoat");
            System.out.print("Nhap lua chon: ");
            int choice = Integer.parseInt(sc.nextLine());


            switch (choice) {
                case 1:

                    managerHotel.addCustomer();
                    break;
                case 2:
                    System.out.print("Nhap loai phong: ");
                    String roomType = sc.nextLine();
                    Room room = new Room(roomType);
                    managerHotel.addRoom(room);
                    break;
                case 3:
                    System.out.print("Nhap cmnd: ");
                    String id = sc.nextLine();
                    managerHotel.showCustomers(id);
                    break;
                case 4:
                    managerHotel.showRooms();
                    break;
                case 5:
                    System.out.print("Nhap cmnd: ");
                    String id1 = sc.nextLine();
                    managerHotel.deleteCustomer(id1);
                    break;
                case 6:
                    System.out.print("Nhap cmnd: ");
                    String id2 = sc.nextLine();
                    managerHotel.calculatePrice(id2);
                    break;
                case 7:
                    sc.close();
                    System.exit(0);

                default:
                    break;
            }

        }  while (true) ;
    }}
