package Buoi4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Classes myClass = new Classes(10); // Assuming a maximum of 10 students in the class
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Remove Student");
            System.out.println("4. Find Student by ID");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Add Student");
                    System.out.println("-----------");
                    System.out.println("Enter student information:");
                    System.out.println("Enter firstName :");
                    String firstName = scanner.next();
                    System.out.println("Enter lastName :");
                    String lastName = scanner.next();
                    System.out.println("Enter markCss :");
                    double markCss = scanner.nextDouble();
                    System.out.println("Enter markHtml :");
                    double markHtml = scanner.nextDouble();
                    System.out.println("Enter markJs :");
                    double markJs = scanner.nextDouble();
                    //diem trung binh
                    double markAvg = (markCss + markHtml + markJs) / 3;
                    Student newStudent = new Student(firstName, lastName, markCss, markHtml, markJs);

                    // Set student information (you may use input method in Student class)
                    myClass.add(newStudent);
                    break;

                case 2:
                    // Edit Student
                    System.out.print("Enter the ID of the student to edit: ");
                    String editStudentId = scanner.next();
                    Student editStudent = myClass.findId(editStudentId);
                    if (editStudent != null) {
                        //show student information
                        editStudent.output();
                        System.out.println("Enter new information:");
                        System.out.println("Enter new firstName :");
                        String newFirstName = scanner.next();
                        System.out.println("Enter new lastName :");
                        String newLastName = scanner.next();
                        System.out.println("Enter new markCss :");
                        double newMarkCss = scanner.nextDouble();
                        System.out.println("Enter new markHtml :");
                        double newMarkHtml = scanner.nextDouble();
                        System.out.println("Enter new markJs :");
                        double newMarkJs = scanner.nextDouble();
                        //put new information in editStudent
//                        editStudent = new Student(newFirstName, newLastName, newMarkCss, newMarkHtml, newMarkJs);
                        editStudent.setFirstName(newFirstName);
                        editStudent.setLastName(newLastName);
                        editStudent.setMarkCss(newMarkCss);
                        editStudent.setMarkHtml(newMarkHtml);
                        editStudent.setMarkJs(newMarkJs);

                        // Display student information
                        editStudent.output();

                        myClass.edit(editStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 3:
                    // Remove Student
                    System.out.print("Enter the ID of the student to remove: ");
                    String removeStudentId = scanner.next();
                    Student removeStudent = myClass.findId(removeStudentId);
                    if (removeStudent != null) {
                        myClass.remove(removeStudent);
                        System.out.println("Student removed successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    // Find Student by ID
                    System.out.print("Enter the ID of the student to find: ");
                    String findStudentId = scanner.next();
                    Student foundStudent = myClass.findId(findStudentId);
                    if (foundStudent != null) {
                        foundStudent.output(); // Display student information
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please choose again.");
            }

        } while (choice != 5);

        scanner.close();
    }
}
