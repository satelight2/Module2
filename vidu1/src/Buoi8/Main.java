package Buoi8;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CourseManagement management = new CourseManagement();
        do {
            System.out.println("+++++++Quản lý+++++++");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Thêm khóa học cho sinh viên");
            System.out.println("3. Xóa sinh viên");
            System.out.println("4. Hiển thị danh sách sinh viên");
            System.out.println("5. Thêm khóa học");
            System.out.println("6. Xóa khóa học");
            System.out.println("7. Hiển thị khóa học khóa học");
            System.out.println("8. Thoát");
            System.out.println("Lựa chọn của bạn là: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    String select;
                    do {
                        management.setCourse(false);
                        management.setStudent(true);
                        management.add();
                        System.out.println("Bạn có muốn tiếp tục nhập không (Y/N): ");
                        select = sc.nextLine();
                    } while(select.equalsIgnoreCase("y"));
                    break;
                case 2:
                    do {
                        System.out.println("Nhập vào ID sinh viên muốn thêm course: ");
                        String id = sc.nextLine();
                        Student st = management.searchByIdSt(id);
                        if (st == null){
                            System.out.println("Sinh viên không tồn tại");
                        } else {
                            management.searchByIdSt(id).output();
                            System.out.println("Mời bạn nhập id của khóa học muốn thêm");
                            String idCourse = sc.nextLine();
                            if (st.getCourse() != null){
                                System.out.println("Sinh viên đã có khóa học, bạn có muốn sửa (Y/N)");
                                String s = sc.nextLine();
                                if (s.equalsIgnoreCase("y")){
                                    management.addCourse(st,idCourse);
                                }
                            } else {
                                management.addCourse(st, idCourse);
                            }
                        }


                        System.out.println("Bạn có muốn tiếp tục nhập không (Y/N): ");
                        select = sc.nextLine();
                    } while(select.equalsIgnoreCase("y"));
                    break;
                case 3:
                    management.delete();
                    break;
                case 4:
                    System.out.printf("%5s | %15s | %10s | %10s | %15s | %15s |\n","ID","Tên sinh viên","Tuổi","Giới tính","Số điện thoại","Khóa học");
                    management.display("Student");
                    break;
                case 5:
                    do {
                        management.setStudent(false);
                        management.setCourse(true);
                        management.add();
                        System.out.println("Bạn có muốn tiếp tục nhập không (Y/N): ");
                        select = sc.nextLine();
                    } while(select.equalsIgnoreCase("y"));
                    break;
                case 6:
                    management.delete();
                    break;
                case 7:
                    System.out.printf("%5s | %15s | %15s | %10s |\n","ID","Ten khóa học","Giáo viên","Sinh viên tối đa");
                    management.display("Course");
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