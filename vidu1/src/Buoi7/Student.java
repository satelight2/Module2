package Buoi7;

// Student.java
public class Student {
    private String studentName;
    private int studentId;

    public Student(String studentName, int studentId) {
        this.studentName = studentName;
        this.studentId = studentId;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getStudentId() {
        return studentId;
    }

    public void displayStudentInfo() {
        System.out.println("Student: " + studentName + " (ID: " + studentId + ")");
    }
}
