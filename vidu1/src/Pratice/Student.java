package Pratice;

import java.util.ArrayList;
import java.util.Scanner;

public class Student extends  StudentClass{
    private String studentId;
    private String studentName;
    private int age;
    private boolean sex;
    private StudentClass classStudent;
    private ArrayList<Float> listMarkJavaScript;
    private ArrayList<Float> listMarkJavaCore;
    private ArrayList<Float> listMarkJavaWeb;
    private float avgMark;
    private String GPA;
    private boolean studentStatus;

    // Constructor
    public Student() {
        listMarkJavaScript = new ArrayList<>();
        listMarkJavaCore = new ArrayList<>();
        listMarkJavaWeb = new ArrayList<>();
    }

    public Student(String classId, String className, String descriptions, int classStatus, String studentId, String studentName, int age, boolean sex, StudentClass classStudent, ArrayList<Float> listMarkJavaScript, ArrayList<Float> listMarkJavaCore, ArrayList<Float> listMarkJavaWeb, float avgMark, String GPA, boolean studentStatus) {
        super(classId, className, descriptions, classStatus);
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.sex = sex;
        this.classStudent = classStudent;
        this.listMarkJavaScript = listMarkJavaScript;
        this.listMarkJavaCore = listMarkJavaCore;
        this.listMarkJavaWeb = listMarkJavaWeb;
        this.avgMark = avgMark;
        this.GPA = GPA;
        this.studentStatus = studentStatus;
    }

    // Getter and Setter


    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public StudentClass getClassStudent() {
        return classStudent;
    }

    public void setClassStudent(StudentClass classStudent) {
        this.classStudent = classStudent;
    }

    public ArrayList<Float> getListMarkJavaScript() {
        return listMarkJavaScript;
    }

    public void setListMarkJavaScript(ArrayList<Float> listMarkJavaScript) {
        this.listMarkJavaScript = listMarkJavaScript;
    }

    public ArrayList<Float> getListMarkJavaCore() {
        return listMarkJavaCore;
    }

    public void setListMarkJavaCore(ArrayList<Float> listMarkJavaCore) {
        this.listMarkJavaCore = listMarkJavaCore;
    }

    public ArrayList<Float> getListMarkJavaWeb() {
        return listMarkJavaWeb;
    }

    public void setListMarkJavaWeb(ArrayList<Float> listMarkJavaWeb) {
        this.listMarkJavaWeb = listMarkJavaWeb;
    }

    public float getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(float avgMark) {
        this.avgMark = avgMark;
    }

    public String getGPA() {
        if (avgMark >= 9.0) {
            GPA = "Excellent";
        } else if (avgMark >= 7.0) {
            GPA = "Good";
        } else if (avgMark >= 5.0) {
            GPA = "Average";
        } else {
            GPA = "Poor";
        }
        return GPA;
    }

    public void setGPA(String GPA) {
        this.GPA = GPA;
    }

    public boolean isStudentStatus() {
        return studentStatus;
    }

    public void setStudentStatus(boolean studentStatus) {
        this.studentStatus = studentStatus;
    }

    @Override
    public void inputData() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Student ID (6 characters, starting with 'S'): ");
        this.studentId = scanner.nextLine();

        System.out.println("Enter Student Name (20-50 characters): ");
        this.studentName = scanner.nextLine();

        System.out.println("Enter Age (must be 18 or older): ");
        this.age = scanner.nextInt();

        System.out.println("Enter Gender (true for Male, false for Female): ");
        this.sex = scanner.nextBoolean();

        // Input class information
        this.classStudent = new StudentClass();
        this.classStudent.inputData();

        // Input marks
        System.out.println("Enter marks for JavaScript exam (separated by space): ");
        inputMarks(listMarkJavaScript);

        System.out.println("Enter marks for Java Core exam (separated by space): ");
        inputMarks(listMarkJavaCore);

        System.out.println("Enter marks for Java Web exam (separated by space): ");
        inputMarks(listMarkJavaWeb);

        // Calculate average mark
        calAvgMark();

        // Calculate GPA
        getGPA();

        // Set student status
        this.studentStatus = this.avgMark >= MARK_PASS;


    }
    @Override
    public void displayData() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Student Name: " + studentName);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + (sex ? "Male" : "Female"));
        System.out.println("Class: " + classStudent.getClassName());
        System.out.println("Average Mark: " + avgMark);
        System.out.println("GPA: " + GPA);
        System.out.println("Student Status: " + (studentStatus ? "Pass" : "Fail"));
    }

    public void calAvgMark() {
        float sumMarks = 0.0f;
        int numExams = listMarkJavaScript.size();

        for (int i = 0; i < numExams; i++) {
            sumMarks += listMarkJavaScript.get(i) + listMarkJavaCore.get(i) + listMarkJavaWeb.get(i);
        }

        avgMark = sumMarks / (numExams * 3);
    }



    private void inputMarks(ArrayList<Float> list) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter marks (separated by space): ");
        String[] marks = scanner.nextLine().split(" ");

        for (String mark : marks) {
            list.add(Float.parseFloat(mark));
        }
    }
}

