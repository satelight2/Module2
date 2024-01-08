package Buoi6;
import java.util.Scanner;

public class QLSinhVien {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Welcome to the Data Management System!");

            System.out.print("Enter the capacity for Student and Course databases: ");
            int capacity = scanner.nextInt();

            DataManager<BaseEntity> dataManager = new DataManager<>(capacity);

            int choice;
            do {
                System.out.println("\nMenu:");
                System.out.println("1. Add Student");
                System.out.println("2. Add Course");
                System.out.println("3. View Data");
                System.out.println("4. Update Data");
                System.out.println("5. Delete Data");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        dataManager.add(createStudent());
                        break;
                    case 2:
                        dataManager.add(createCourse());
                        break;
                    case 3:
                        dataManager.display();
                        break;
                    case 4:
                        updateData(dataManager, scanner);
                        break;
                    case 5:
                        deleteData(dataManager, scanner);
                        break;
                }
            } while (choice != 0);

            System.out.println("Thank you for using the Data Management System!");
        }

        private static Student createStudent() {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter Student ID: ");
            int studentId = scanner.nextInt();
            System.out.print("Enter Student Name: ");
            String studentName = scanner.next();

            return new Student(studentId, studentName);
        }

        private static Course createCourse() {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter Course ID: ");
            int courseId = scanner.nextInt();
            System.out.print("Enter Course Name: ");
            String courseName = scanner.next();

            return new Course(courseId, courseName);
        }

        private static void updateData(DataManager<BaseEntity> dataManager, Scanner scanner) {
            System.out.println("Select the type of data to update:");
            System.out.println("1. Student");
            System.out.println("2. Course");
            System.out.print("Enter your choice: ");
            int typeChoice = scanner.nextInt();

            System.out.print("Enter the index of the item to update: ");
            int index = scanner.nextInt();

            if (typeChoice == 1) {
                dataManager.update(index, createStudent());
            } else if (typeChoice == 2) {
                dataManager.update(index, createCourse());
            } else {
                System.out.println("Invalid choice.");
            }
        }

        private static void deleteData(DataManager<BaseEntity> dataManager, Scanner scanner) {
            System.out.println("Select the type of data to delete:");
            System.out.println("1. Student");
            System.out.println("2. Course");
            System.out.print("Enter your choice: ");
            int typeChoice = scanner.nextInt();

            System.out.print("Enter the index of the item to delete: ");
            int index = scanner.nextInt();

            if (typeChoice == 1) {
                dataManager.delete(index);
            } else if (typeChoice == 2) {
                dataManager.delete(index);
            } else {
                System.out.println("Invalid choice.");
            }
        }


}
