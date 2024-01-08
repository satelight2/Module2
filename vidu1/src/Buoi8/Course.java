package Buoi8;

import java.util.Scanner;

public class Course implements IStudent{
    private String id;
    private String name;
    private String mentor;
    private int maxMember;
    private boolean isCourse = true;

    public boolean isCourse() {
        return isCourse;
    }

    public void setCourse(boolean course) {
        isCourse = course;
    }

    public Course() {
    }

    public Course(String id, String name, String mentor, int maxMember) {
        this.id = id;
        this.name = name;
        this.mentor = mentor;
        this.maxMember = maxMember;
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

    public String getMentor() {
        return mentor;
    }

    public void setMentor(String mentor) {
        this.mentor = mentor;
    }

    public int getMaxMember() {
        return maxMember;
    }

    public void setMaxMember(int maxMember) {
        this.maxMember = maxMember;
    }

    @Override
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào ID: ");
        id = sc.nextLine();
        System.out.println("Nhập vào tên lớp: ");
        name = sc.nextLine();
        System.out.println("Nhập vào giáo viên phụ trách: ");
        mentor = sc.nextLine();
        System.out.println("Nhập vào số thành viên tối đa cho phép: ");
        maxMember = Integer.parseInt(sc.nextLine());
    }

    @Override
    public void output() {
        System.out.printf("%5s | %15s | %15s | %10s |\n",getId(),getName(),getMentor(),getMaxMember());
    }
}