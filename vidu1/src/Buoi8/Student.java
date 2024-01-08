package Buoi8;

import java.util.Scanner;

public class Student implements IStudent {
    private String id;
    private String name;
    private int age;
    private String gender;
    private String phone;
    private Course course;
    private boolean isStudent = true;

    public boolean isStudent() {
        return isStudent;
    }

    public void setStudent(boolean student) {
        isStudent = student;
    }

    public Student() {
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student(String id, String name, int age, String gender, String phone, Course course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.course = course;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào id: ");
        id = sc.nextLine();
        System.out.println("Nhập vào tên: ");
        name = sc.nextLine();
        System.out.println("Nhập vào tuổi: ");
        age = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập vào giới tính: ");
        gender = sc.nextLine();
        System.out.println("Nhập vào số điện thoại: ");
        phone = sc.nextLine();
    }

    @Override
    public void output() {
        if (course == null) {
            System.out.printf("%5s | %15s | %10s | %10s | %15s | %15s |\n", id, name, age, gender, phone, "Chưa xếp lớp");
        } else {
            System.out.printf("%5s | %15s | %10s | %10s | %15s | %15s |\n", id, name, age, gender, phone, getCourse().getName());
        }
    }
}
