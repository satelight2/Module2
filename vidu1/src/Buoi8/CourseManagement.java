package Buoi8;

import java.util.Arrays;
import java.util.Scanner;

public class CourseManagement implements ICourse {
    private Student[] students;
    private Course[] courses;
    private int indexSt = 0;
    private int indexCourse = 0;

    private int defaultEmelent = 4;
    private boolean isStudent = false;
    private boolean isCourse = false;

    public CourseManagement() {
        this.students = new Student[defaultEmelent];
        this.courses = new Course[defaultEmelent];
    }

    public boolean isStudent() {
        return isStudent;
    }

    public void setStudent(boolean student) {
        isStudent = student;
    }

    public boolean isCourse() {
        return isCourse;
    }

    public void setCourse(boolean course) {
        isCourse = course;
    }


    public Student[] getStudents() {
        return students;
    }

    public Course[] getCourses() {
        return courses;
    }

    public int getIndexSt() {
        return indexSt;
    }

    public int getIndexCourse() {
        return indexCourse;
    }

    @Override
    public void add() {
        //student
        if (isStudent) {
            Student st = new Student();
            st.input();
            if (!isStExist(st.getId())) {
                if (indexSt == students.length - 1)
                    students = Arrays.copyOf(students, students.length + defaultEmelent);
                students[indexSt++] = st;
                System.out.println("Thêm học sinh thành công");
            } else {
                System.out.println("Thêm học sinh thất bại");}
        }
        //course
        if (isCourse) {
            Course course = new Course();
            course.input();
            if (!isCourseExist(course.getId())) {
                if (indexCourse == courses.length - 1)
                    courses = Arrays.copyOf(courses, courses.length + defaultEmelent);
                courses[indexCourse++] = course;
                System.out.println("Thêm khóa học thành công");
            } else {
                System.out.println("Thêm khóa học thất bại");}
        }

    }

    private boolean isStExist(String id) {
        for (int i = 0; i < indexSt; i++) {
            if (students[i].getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    private boolean isCourseExist(String id) {
        for (int i = 0; i < indexCourse; i++) {
            if (courses[i].getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void delete() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào id bạn muốn xóa");
        String id = sc.nextLine();
        //Student
        for (int i = 0; i < indexSt; i++) {
            if (students[0] != null) {
                if (students[i].getId().equals(id)) {
                    for (int j = i; j < indexSt - 1; j++) {
                        students[j] = students[j + 1];
                    }
                    students[indexSt] = null;
                    indexSt -= 1;
                    System.out.println("Xóa thành công");
                    break;
                }
                System.out.println("Xóa thất bại");
            }
        }
        //Course
        for (int i = 0; i < indexCourse; i++) {
            if (courses[0] != null) {
                if (courses[i].getId().equals(id)) {
                    for (int j = i; j < indexCourse - 1; j++) {
                        courses[j] = courses[j + 1];
                    }
                    courses[indexCourse] = null;
                    indexCourse -= 1;
                    System.out.println("Xóa thành công");
                    break;
                }
                System.out.println("Xóa thất bại");
            }
        }
    }

    @Override
    public void display(String selection) {
        if (selection.equals("Student")) {
            for (int i = 0; i < indexSt; i++) {
                students[i].output();
            }
        } else if (selection.equals("Course")) {
            for (int i = 0; i < indexCourse; i++) {
                courses[i].output();
            }
        } else {
            System.out.println("Lỗi lựa chọn không tồn tại");
        }

    }

    public Student searchByIdSt(String id) {
        for (int i = 0; i < indexSt; i++) {
            if (students[i].getId().equals(id)) {
                return students[i];
            }
        }
        return null;
    }

    public Course searchByCourseId(String id){
        for (int i = 0; i < indexCourse; i++) {
            if (courses[i].getId().equals(id)) {
                return courses[i];
            }
        }
        return null;
    }

    public void addCourse(Student st,String id){
        st.setCourse(searchByCourseId(id));
    }
}