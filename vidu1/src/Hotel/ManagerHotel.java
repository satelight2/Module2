package Hotel;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagerHotel {
    private ArrayList<Customer> customers;
    private ArrayList<Room> rooms;

    public ManagerHotel() {
        customers = new ArrayList<>();
        rooms = new ArrayList<>();
    }

    public void addCustomer() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        System.out.print("Enter customer age: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter customer ID number: ");
        String idNumber = scanner.nextLine();


        System.out.println("Room types:");
        System.out.println("A - $500");
        System.out.println("B - $300");
        System.out.println("C - $100");
        System.out.print("Enter room type (A/B/C): ");
        String roomType = scanner.nextLine();


        Room room = new Room(roomType);
        addRoom(room);


        Customer customer = new Customer(name, age, idNumber);
        room.setCustomer(customer);
        customer.setRoom(room);
        addCustomer(customer, room);

        System.out.println("Customer added successfully.");
    }

    public void addCustomer(Customer customer, Room room) {
        customers.add(customer);
        room.setCustomer(customer);
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void showCustomers(String id) {
        for (Customer customer : customers) {
            if (customer.getCmnd().equals(id)) {
                Room room = customer.getRoom();
                if (room != null) {
                    System.out.println("-------------------------------------------------------------------------");
                    System.out.printf("| %-30s | %-10s | %-15s | %-15s |\n", "Họ tên", "Tuổi", "Số CMND", "Phòng");
                    System.out.println("-------------------------------------------------------------------------");
                    System.out.printf("| %-30s | %-10d | %-15s | %-15s |\n", customer.getHoTen(), customer.getTuoi(), customer.getCmnd(), room.getRoomType());
                    System.out.println("-------------------------------------------------------------------------");
                } else {
                    System.out.println("Không có thông tin phòng cho khách hàng này.");
                }
            }
        }
    }


    public void showRooms() {
        System.out.println("-------------------------------------------------------------------------");
        System.out.printf("| %-10s | %-10s | %-10s | %-10s |\n", "Loại phòng", "Giá", "Trạng thái", "Khách hàng");
        System.out.println("-------------------------------------------------------------------------");

        for (Room room : rooms) {
            String roomType = room.getRoomType();
            int price = room.getPrice();
            String status = room.getCustomer() == null ? "Trống" : "Đã thuê";
            String customerName = room.getCustomer() == null ? "Chưa có" : room.getCustomer().getHoTen();

            System.out.printf("| %-10s | %-10d | %-10s | %-10s |\n", roomType, price, status, customerName);
        }

        System.out.println("-------------------------------------------------------------------------");
    }

    public void deleteCustomer(String id) {
        for(Customer customer : customers) {
            if(customer.getCmnd().equals(id)) {
                customers.remove(customer);
                break;
            }
        }
    }

    public void calculatePrice(String id) {
        for(Customer customer : customers) {
            if(customer.getCmnd().equals(id)) {
                Room room = customer.getRoom();
                if(room != null) {
                    String price = room.getRoomType().toUpperCase();
                    switch(price) {
                        case "A":
                            price = "500";
                            break;
                        case "B":
                            price = "300";
                            break;
                        case "C":
                            price = "100";
                            break;
                        default:
                            price = "0";
                    }
                    System.out.println("Tổng tiền phải trả: " + price);
                } else {
                    System.out.println("Không có thông tin phòng cho khách hàng này.");
                }
            }
        }
    }
}
