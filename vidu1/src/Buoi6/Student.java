package Buoi6;

// Student.java
public class Student extends BaseEntity {
    private int studentId;

    public Student(int studentId, String name) {
        super(name);
        this.studentId = studentId;
    }

    public int getStudentId() {
        return studentId;
    }

    @Override
    public String toString() {
        return "Student ID: " + studentId + ", Name: " + name;
    }
}
