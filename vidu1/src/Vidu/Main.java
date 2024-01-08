package Vidu;

import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String gender;

    public Student(int id, String firstName, String lastName, String gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName;
    }
}

class StudentManager {
    private ArrayList<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayStudentsByLastName() {
        System.out.println("\nDanh sach sinh vien theo nhom ho:");
        String currentLastName = "";
        for (Student student : students) {
            String lastName = student.getLastName();
            if (!lastName.equals(currentLastName)) {
                System.out.println(lastName);
                currentLastName = lastName;
            }
            System.out.println("  " + student);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager studentManager = new StudentManager();

        for (int i = 0; i < 5; i++) {
            System.out.println("Nhap thong tin cho sinh vien thu " + (i + 1));
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("First Name: ");
            String firstName = scanner.nextLine();
            System.out.print("Last Name: ");
            String lastName = scanner.nextLine();
            System.out.print("Gender: ");
            String gender = scanner.nextLine();

            Student student = new Student(id, firstName, lastName, gender);
            studentManager.addStudent(student);
        }

        // Hiển thị danh sách theo nhóm họ
        studentManager.displayStudentsByLastName();
    }
}
