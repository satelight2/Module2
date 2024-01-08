package Pratice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;



public class StudentManagement {
    private static ArrayList<StudentClass> classList = new ArrayList<>();
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            displayMainMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    manageClass();
                    break;
                case 2:
                    manageStudents();
                    break;
                case 3:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        } while (choice != 3);

        // Close the scanner
        scanner.close();
    }

    private static void displayMainMenu() {
        System.out.println("**********************QUẢN LÝ HỌC VIỆN*******************");
        System.out.println("1. Quản lý lớp");
        System.out.println("2. Quản lý sinh viên");
        System.out.println("3. Thoát");
    }

    private static void displayClassMenu() {
        System.out.println("**********************QUẢN LÝ LỚP HỌC********************");
        System.out.println("1. Thêm mới lớp học");
        System.out.println("2. Cập nhật thông tin lớp học");
        System.out.println("3. Hiển thị thông tin lớp học");
        System.out.println("4. Thống kê các lớp học đang hoạt động");
        System.out.println("5. Tìm kiếm lớp học theo tên lớp học");
        System.out.println("6. Thoát");
    }

    private static void displayStudentMenu() {
        System.out.println("***********************QUẢN LÝ SINH VIÊN******************");
        System.out.println("1. Thêm mới sinh viên");
        System.out.println("2. Cập nhật thông tin sinh viên");
        System.out.println("3. Hiển thị thông tin sinh viên");
        System.out.println("4. Tính điểm trung bình");
        System.out.println("5. Xếp loại sinh viên");
        System.out.println("6. Sắp xếp sinh viên theo điểm trung bình tăng dần");
        System.out.println("7. Tìm kiếm sinh viên theo tên sinh viên");
        System.out.println("8. Thống kê số sinh viên đạt loại giỏi, khá, trung bình và yếu");
        System.out.println("9. Thống kê các sinh viên Pass qua các môn học");
        System.out.println("10. Thoát");
    }

    private static void manageClass() {
        int choice;
        do {
            displayClassMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addNewClass();
                    break;
                case 2:
                    updateClass();
                    break;
                case 3:
                    displayClassInfo();
                    break;
                case 4:
                    displayActiveClasses();
                    break;
                case 5:
                    searchClassByName();
                    break;
                case 6:
                    System.out.println("Returning to the main menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        } while (choice != 6);
    }

    private static void manageStudents() {
        int choice;
        do {
            displayStudentMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addNewStudent();
                    break;
                case 2:
                    updateStudent();
                    break;
                case 3:
                    displayStudentInfo();
                    break;
                case 4:
                    calculateAvgMark();
                    break;
                case 5:
                    classifyStudent();
                    break;
                case 6:
                    sortStudentsByAvgMark();
                    break;
                case 7:
                    searchStudentByName();
                    break;
                case 8:
                    statStudentByGrade();
                    break;
                case 9:
                    statPassStudents();
                    break;
                case 10:
                    System.out.println("Returning to the main menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        } while (choice != 10);
    }


    private static void addNewClass() {
        StudentClass newClass = new StudentClass();
        newClass.inputData();
        classList.add(newClass);
        System.out.println("Class added successfully!");
    }

    private static void updateClass() {
        if (classList.isEmpty()) {
            System.out.println("No classes available to update.");
            return;
        }

        System.out.println("Enter the Class ID to update: ");
        String classIdToUpdate = scanner.nextLine();

        StudentClass foundClass = findClassById(classIdToUpdate);

        if (foundClass != null) {
            System.out.println("Class found. Enter new information:");

            // Input new data for the class
            foundClass.inputData();

            System.out.println("Class updated successfully!");
        } else {
            System.out.println("Class with ID " + classIdToUpdate + " not found.");
        }
    }

    private static StudentClass findClassById(String classId) {
        for (StudentClass studentClass : classList) {
            if (studentClass.getClassId().equals(classId)) {
                return studentClass;
            }
        }
        return null;
    }

    private static void displayClassInfo() {
        if (classList.isEmpty()) {
            System.out.println("No classes available to display.");
            return;
        }

        System.out.println("List of all classes:");
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.printf("| %-10s | %-20s | %-30s | %-10s |\n", "Class ID", "Class Name", "Descriptions", "Class Status");
        System.out.println("-----------------------------------------------------------------------------------------------");

        for (StudentClass studentClass : classList) {
            System.out.printf("| %-10s | %-20s | %-30s | %-10s |\n",
                    studentClass.getClassId(), studentClass.getClassName(), studentClass.getDescriptions(),
                    (studentClass.getClassStatus() == 1 ? "Active" : "Inactive"));
            System.out.println("-----------------------------------------------------------------------------------------------");
        }
    }

    private static void displayActiveClasses() {
        if (classList.isEmpty()) {
            System.out.println("No classes available to display.");
            return;
        }

        System.out.println("List of active classes:");
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.printf("| %-10s | %-20s | %-30s | %-10s |\n", "Class ID", "Class Name", "Descriptions", "Class Status");
        System.out.println("-----------------------------------------------------------------------------------------------");

        for (StudentClass studentClass : classList) {
            if (studentClass.getClassStatus() == 1) {
                System.out.printf("| %-10s | %-20s | %-30s | %-10s |\n",
                        studentClass.getClassId(), studentClass.getClassName(), studentClass.getDescriptions(),
                        "Active");
                System.out.println("-----------------------------------------------------------------------------------------------");
            }
        }
    }

    private static void searchClassByName() {
        if (classList.isEmpty()) {
            System.out.println("No classes available to search.");
            return;
        }

        System.out.println("Enter the Class Name to search: ");
        String classNameToSearch = scanner.nextLine();

        boolean found = false;

        System.out.println("Search result for classes with name '" + classNameToSearch + "':");
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.printf("| %-10s | %-20s | %-30s | %-10s |\n", "Class ID", "Class Name", "Descriptions", "Class Status");
        System.out.println("-----------------------------------------------------------------------------------------------");

        for (StudentClass studentClass : classList) {
            if (studentClass.getClassName().equalsIgnoreCase(classNameToSearch)) {
                System.out.printf("| %-10s | %-20s | %-30s | %-10s |\n",
                        studentClass.getClassId(), studentClass.getClassName(), studentClass.getDescriptions(),
                        (studentClass.getClassStatus() == 1 ? "Active" : "Inactive"));
                System.out.println("-----------------------------------------------------------------------------------------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No classes found with the name '" + classNameToSearch + "'.");
        }
    }



    // Student menu

    private static void addNewStudent() {
        Student newStudent = new Student();
        newStudent.inputData();
        studentList.add(newStudent);
        System.out.println("Student added successfully!");
    }

    private static void updateStudent() {
        if (studentList.isEmpty()) {
            System.out.println("No students available to update.");
            return;
        }

        System.out.println("Enter the Student ID to update: ");
        String studentIdToUpdate = scanner.nextLine();

        Student foundStudent = findStudentById(studentIdToUpdate);

        if (foundStudent != null) {
            System.out.println("Student found. Enter new information:");

            // Input new data for the student
            foundStudent.inputData();

            System.out.println("Student updated successfully!");
        } else {
            System.out.println("Student with ID " + studentIdToUpdate + " not found.");
        }
    }

    private static Student findStudentById(String studentId) {
        for (Student student : studentList) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }


    private static void displayStudentInfo() {
        if (studentList.isEmpty()) {
            System.out.println("No students available to display.");
            return;
        }

        System.out.println("List of all students:");
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-10s | %-20s | %-4s | %-5s | %-15s | %-15s | %-15s | %-7s | %-4s | %-4s | %-4s |\n",
                "Student ID", "Student Name", "Age", "Sex", "Class ID", "Avg. Mark", "GPA", "Status", "Java Script", "Java Core", "Java Web");
        System.out.println("------------------------------------------------------------------------------------------------------------------------");

        for (Student student : studentList) {
            System.out.printf("| %-10s | %-20s | %-4d | %-5s | %-15s | %-15.2f | %-15s | %-7s | %-4s | %-4s | %-4s |\n",
                    student.getStudentId(), student.getStudentName(), student.getAge(),
                    (student.isSex() ? "Male" : "Female"), student.getClassStudent().getClassId(),
                    student.getAvgMark(), student.getGPA(), (student.isStudentStatus() ? "Active" : "Inactive"),
                    student.getListMarkJavaScript(), student.getListMarkJavaCore(), student.getListMarkJavaWeb());
            System.out.println("------------------------------------------------------------------------------------------------------------------------");
        }
    }


    private static void calculateAvgMark() {
        if (studentList.isEmpty()) {
            System.out.println("No students available to calculate average marks.");
            return;
        }

        System.out.println("Enter the Student ID to calculate average marks: ");
        String studentIdToCalculate = scanner.nextLine();

        Student foundStudent = findStudentById(studentIdToCalculate);

        if (foundStudent != null) {
            // Calculate average mark for the student
            foundStudent.calAvgMark();

            System.out.println("Average mark calculated successfully!");
            System.out.println("Updated information for student with ID " + studentIdToCalculate + ":");
            foundStudent.displayData();
        } else {
            System.out.println("Student with ID " + studentIdToCalculate + " not found.");
        }
    }

    private static void classifyStudent() {
        if (studentList.isEmpty()) {
            System.out.println("No students available to classify.");
            return;
        }

        System.out.println("Enter the Student ID to classify: ");
        String studentIdToClassify = scanner.nextLine();

        Student foundStudent = findStudentById(studentIdToClassify);

        if (foundStudent != null) {
            // Classify the student based on GPA
            String classification = foundStudent.getGPA();
            System.out.println("Classification for student with ID " + studentIdToClassify + ": " + classification);
        } else {
            System.out.println("Student with ID " + studentIdToClassify + " not found.");
        }
    }

    private static void sortStudentsByAvgMark() {
        if (studentList.isEmpty()) {
            System.out.println("No students available to sort.");
            return;
        }

        // Sort students by average mark
        Collections.sort(studentList, Comparator.comparingDouble(Student::getAvgMark));

        System.out.println("Students sorted by average mark (ascending):");
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-10s | %-20s | %-4s | %-5s | %-15s | %-15s | %-15s | %-7s | %-4s | %-4s | %-4s |\n",
                "Student ID", "Student Name", "Age", "Sex", "Class ID", "Avg. Mark", "GPA", "Status", "Java Script", "Java Core", "Java Web");
        System.out.println("------------------------------------------------------------------------------------------------------------------------");

        for (Student student : studentList) {
            System.out.printf("| %-10s | %-20s | %-4d | %-5s | %-15s | %-15.2f | %-15s | %-7s | %-4s | %-4s | %-4s |\n",
                    student.getStudentId(), student.getStudentName(), student.getAge(),
                    (student.isSex() ? "Male" : "Female"), student.getClassStudent().getClassId(),
                    student.getAvgMark(), student.getGPA(), (student.isStudentStatus() ? "Active" : "Inactive"),
                    student.getListMarkJavaScript(), student.getListMarkJavaCore(), student.getListMarkJavaWeb());
            System.out.println("------------------------------------------------------------------------------------------------------------------------");
        }
    }

    private static void searchStudentByName() {
        if (studentList.isEmpty()) {
            System.out.println("No students available to search.");
            return;
        }

        System.out.println("Enter the Student Name to search: ");
        String studentNameToSearch = scanner.nextLine();

        boolean found = false;

        System.out.println("Search result for students with name '" + studentNameToSearch + "':");
        System.out.println("------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-10s | %-20s | %-4s | %-5s | %-15s | %-15s | %-15s | %-7s | %-4s | %-4s | %-4s |\n",
                "Student ID", "Student Name", "Age", "Sex", "Class ID", "Avg. Mark", "GPA", "Status", "Java Script", "Java Core", "Java Web");
        System.out.println("------------------------------------------------------------------------------------------------------------------------");

        for (Student student : studentList) {
            if (student.getStudentName().toLowerCase().contains(studentNameToSearch.toLowerCase())) {
                System.out.printf("| %-10s | %-20s | %-4d | %-5s | %-15s | %-15.2f | %-15s | %-7s | %-4s | %-4s | %-4s |\n",
                        student.getStudentId(), student.getStudentName(), student.getAge(),
                        (student.isSex() ? "Male" : "Female"), student.getClassStudent().getClassId(),
                        student.getAvgMark(), student.getGPA(), (student.isStudentStatus() ? "Active" : "Inactive"),
                        student.getListMarkJavaScript(), student.getListMarkJavaCore(), student.getListMarkJavaWeb());
                System.out.println("------------------------------------------------------------------------------------------------------------------------");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No students found with the name '" + studentNameToSearch + "'.");
        }
    }


    private static void statStudentByGrade() {
        if (studentList.isEmpty()) {
            System.out.println("No students available to display statistics.");
            return;
        }

        int excellentCount = 0;
        int goodCount = 0;
        int averageCount = 0;
        int poorCount = 0;

        for (Student student : studentList) {
            String classification = student.getGPA();

            switch (classification) {
                case "Excellent":
                    excellentCount++;
                    break;
                case "Good":
                    goodCount++;
                    break;
                case "Average":
                    averageCount++;
                    break;
                case "Poor":
                    poorCount++;
                    break;
            }
        }

        System.out.println("Statistics of students by grade:");
        System.out.println("------------------------------------------------");
        System.out.printf("| %-15s | %-10s |\n", "Grade", "Number of Students");
        System.out.println("------------------------------------------------");
        System.out.printf("| %-15s | %-10d |\n", "Excellent", excellentCount);
        System.out.printf("| %-15s | %-10d |\n", "Good", goodCount);
        System.out.printf("| %-15s | %-10d |\n", "Average", averageCount);
        System.out.printf("| %-15s | %-10d |\n", "Poor", poorCount);
        System.out.println("------------------------------------------------");
    }


    private static void statPassStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students available to display statistics.");
            return;
        }

        int passCount = 0;

        for (Student student : studentList) {
            if (isPass(student)) {
                passCount++;
            }
        }

        System.out.println("Statistics of students who passed all subjects:");
        System.out.println("------------------------------------------------");
        System.out.printf("| %-20s | %-10s |\n", "Pass Status", "Number of Students");
        System.out.println("------------------------------------------------");
        System.out.printf("| %-20s | %-10d |\n", "Pass", passCount);
        System.out.println("------------------------------------------------");
    }

    private static boolean isPass(Student student) {
        return student.getListMarkJavaScript().stream().allMatch(mark -> mark >= IStudentManagement.MARK_PASS)
                && student.getListMarkJavaCore().stream().allMatch(mark -> mark >= IStudentManagement.MARK_PASS)
                && student.getListMarkJavaWeb().stream().allMatch(mark -> mark >= IStudentManagement.MARK_PASS);
    }

}
