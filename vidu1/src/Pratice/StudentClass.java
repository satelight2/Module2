package Pratice;

import java.util.Scanner;

public class StudentClass implements IStudentManagement{
    private String classId;
    private String className;
    private String descriptions;
    private int classStatus;

    public StudentClass() {

    }

    public StudentClass(String classId, String className, String descriptions, int classStatus) {
        this.classId = classId;
        this.className = className;
        this.descriptions = descriptions;
        this.classStatus = classStatus;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public int getClassStatus() {
        return classStatus;
    }

    public void setClassStatus(int classStatus) {
        this.classStatus = classStatus;
    }

    @Override
    public void inputData() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Class ID (5 characters, starting with 'J'): ");
        do
        {

            if (this.classId.length() != 5 || !this.classId.startsWith("J"))
            {
                System.out.println("Class ID must be 5 characters, starting with 'J'");
            }else{
                this.classId = scanner.nextLine();
                break;
            }
        } while (true);


        System.out.println("Enter Class Name (up to 10 characters): ");
        do
        {

            if (this.className.length() > 10)
            {
                System.out.println("Class Name must be up to 10 characters");
            }else{
                this.className = scanner.nextLine();
                break;
            }
        } while (true);

        System.out.println("Enter Class Descriptions: ");
        this.descriptions = scanner.nextLine();

        System.out.println("Enter Class Status (1 for Active, 0 for Inactive): ");
        this.classStatus = scanner.nextInt();


    }

    @Override
    public void displayData() {
        System.out.println("Class ID: " + classId);
        System.out.println("Class Name: " + className);
        System.out.println("Class Descriptions: " + descriptions);
        System.out.println("Class Status: " + (classStatus == 1 ? "Active" : "Inactive"));
    }
}
