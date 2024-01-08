package Buoi7;

// Main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the maximum number of courses: ");
        int maxCourses = scanner.nextInt();

        System.out.print("Enter the maximum number of students: ");
        int maxStudents = scanner.nextInt();

        CourseManagement courseManagement = new CourseManagement(maxCourses, maxStudents);

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add Course");
            System.out.println("2. Enroll Student in Course");
            System.out.println("3. Display Course List");
            System.out.println("4. Add Student");
            System.out.println("5. Display Student List");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    courseManagement.addCourse();
                    break;
                case 2:
                    courseManagement.enrollStudentInCourse();
                    break;
                case 3:
                    courseManagement.display();
                    break;
                case 4:
                    courseManagement.addStudent();
                    break;
                case 5:
                    courseManagement.display();
                    break;
                case 0:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice != 0);
    }
}
