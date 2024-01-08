package Buoi7;

// Course.java
public class Course {
    private String courseName;
    private String instructor;
    private int maxStudents;
    private int enrolledStudents;

    public Course(String courseName, String instructor, int maxStudents) {
        this.courseName = courseName;
        this.instructor = instructor;
        this.maxStudents = maxStudents;
        this.enrolledStudents = 0;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getInstructor() {
        return instructor;
    }

    public int getMaxStudents() {
        return maxStudents;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public int getEnrolledStudents() {
        return enrolledStudents;
    }

    public void enrollStudent() {
        if (enrolledStudents < maxStudents) {
            enrolledStudents++;
            System.out.println("Student enrolled in " + courseName + ": " + enrolledStudents + "/" + maxStudents);
        } else {
            System.out.println("Course is full. Cannot enroll more students.");
        }
    }

    public void displayCourseInfo() {
        System.out.println("Course: " + courseName);
        System.out.println("Instructor: " + instructor);
        System.out.println("Enrolled Students: " + enrolledStudents + "/" + maxStudents);
    }
}
