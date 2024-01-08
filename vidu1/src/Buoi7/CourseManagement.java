package Buoi7;

// CourseManagement.java
import java.util.Scanner;

public class CourseManagement implements EntityOperations {
    private Course[] courses;
    private Student[] students;
    private int courseCount;
    private int studentCount;

    public CourseManagement(int maxCourses, int maxStudents) {
        this.courses = new Course[maxCourses];
        this.students = new Student[maxStudents];
        this.courseCount = 0;
        this.studentCount = 0;
    }
    /* add */
    @Override
    public void add(Object entity) {
        if (entity instanceof Course) {
            if (courseCount < courses.length) {
                courses[courseCount++] = (Course) entity;
                System.out.println("Course added: " + ((Course) entity).getCourseName());
            } else {
                System.out.println("Cannot add more courses. Maximum capacity reached.");
            }
        } else if (entity instanceof Student) {
            if (studentCount < students.length) {
                students[studentCount++] = (Student) entity;
                System.out.println("Student added: " + ((Student) entity).getStudentName());
            } else {
                System.out.println("Cannot add more students. Maximum capacity reached.");
            }
        }
    }
    public void addCourse() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter course name: ");
        String courseName = scanner.next();

        System.out.print("Enter instructor name: ");
        String instructor = scanner.next();

        System.out.print("Enter maximum number of students: ");
        int maxStudents = scanner.nextInt();

        Course course = new Course(courseName, instructor, maxStudents);
        add(course);
    }
    public void addStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String studentName = scanner.next();

        System.out.print("Enter student ID: ");
        int studentId = scanner.nextInt();

        Student student = new Student(studentName, studentId);
        add(student);
    }

    @Override
    public void search() {

    }

/* delete */
    @Override
    public void delete(Object entity) {
        if (entity instanceof Student) {
            Student studentToDelete = (Student) entity; // downcasting from Object to Student to access getStudentId()
            int index = findStudentIndex(studentToDelete);
            if (index != -1) {
                shiftArrayElements(students, index, studentCount);
                studentCount--;
            }
        } else if (entity instanceof Course) {
            Course courseToDelete = (Course) entity;
            int index = findCourseIndex(courseToDelete);
            if (index != -1) {
                shiftArrayElements(courses, index, courseCount);
                courseCount--;
            }
        }
    }



    private int findStudentIndex(Student student) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getStudentId() == student.getStudentId()) {
                return i;
            }
        }
        return -1;
    }
    private int findCourseIndex(Course course) {
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].getCourseName().equalsIgnoreCase(course.getCourseName())) {
                return i;
            }
        }
        return -1;
    }
    private void shiftArrayElements(Object[] array, int startIndex, int endIndex) {
        for (int i = startIndex; i < endIndex - 1; i++) {
            array[i] = array[i + 1];
        }
        array[endIndex - 1] = null;
    }

/* View */
    @Override
    public void display() {
        System.out.println("Courses:");
        for (int i = 0; i < courseCount; i++) {
            courses[i].displayCourseInfo();
        }
        System.out.println("\nStudents:");
        for (int i = 0; i < studentCount; i++) {
            students[i].displayStudentInfo();
        }
    }


/* UPDATE*/

public void updateEntity() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("1. Update Student");
    System.out.println("2. Update Course");
    System.out.print("Enter your choice: ");
    int choice = scanner.nextInt();

    switch (choice) {
        case 1:
            updateStudent();
            break;
        case 2:
            updateCourse();
            break;
        default:
            System.out.println("Invalid choice. No entity updated.");
            break;
    }
}

    public void updateStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student ID to update: ");
        int studentId = scanner.nextInt();

        Student student = findStudent(studentId);
        if (student != null) {
            System.out.print("Enter new student name: ");
            String newStudentName = scanner.next();

            student.setStudentName(newStudentName);
            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }
    public void updateCourse() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter course name to update: ");
        String courseName = scanner.next();

        Course course = findCourse(courseName);
        if (course != null) {
            System.out.print("Enter new instructor name: ");
            String newInstructor = scanner.next();

            course.setInstructor(newInstructor);
            System.out.println("Course updated successfully.");
        } else {
            System.out.println("Course not found.");
        }
    }







    public void enrollStudentInCourse() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String studentName = scanner.next();

        System.out.print("Enter student ID: ");
        int studentId = scanner.nextInt();

        Student student = new Student(studentName, studentId);
        add(student);

        System.out.print("Enter course name to enroll student: ");
        String courseName = scanner.next();

        Course course = findCourse(courseName);
        if (course != null) {
            enrollStudentInCourse(student, course);
        } else {
            System.out.println("Course not found.");
        }
    }

    private void enrollStudentInCourse(Student student, Course course) {
        if (student != null && course != null) {
            if (isStudentEnrolled(student) || isCourseFull(course)) {
                System.out.println("Student already enrolled or Course is full. Cannot enroll.");
            } else {
                course.enrollStudent();
            }
        } else {
            System.out.println("Invalid student or course.");
        }
    }

    private boolean isStudentEnrolled(Student student) {
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].getEnrolledStudents() > 0) {
                // Assuming a student can only enroll in one course at a time
                return true;
            }
        }
        return false;
    }

    private boolean isCourseFull(Course course) {
        return course.getEnrolledStudents() >= course.getMaxStudents();
    }



    private Course findCourse(String courseName) {
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].getCourseName().equalsIgnoreCase(courseName)) {
                return courses[i];
            }
        }
        return null;
    }
    private Student findStudent(int studentId) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getStudentId() == studentId) {
                return students[i];
            }
        }
        return null;
    }

}
