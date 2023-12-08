package Buoi4;

public class Student {
    private static int nextId = 1;  // Static variable to keep track of the next available ID

    private String id;
    private String firstName;
    private String lastName;
    private double markCss;
    private double markHtml;
    private double markJs;
    private double markAvg;

    public Student() {
        // Automatically generate and set the ID for a new student
        this.id = generateNextId();
    }

    public Student(String firstName, String lastName, double markCss, double markHtml, double markJs) {
        // Automatically generate and set the ID for a new student
        this.id = generateNextId();
        this.firstName = firstName;
        this.lastName = lastName;
        this.markCss = markCss;
        this.markHtml = markHtml;
        this.markJs = markJs;
    }

    private String generateNextId() {
        // Generate the next ID based on the static variable
        String generatedId = "S" + nextId;
        nextId++;
        return generatedId;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getMarkCss() {
        return markCss;
    }

    public void setMarkCss(double markCss) {
        this.markCss = markCss;
    }

    public double getMarkHtml() {
        return markHtml;
    }

    public void setMarkHtml(double markHtml) {
        this.markHtml = markHtml;
    }

    public double getMarkJs() {
        return markJs;
    }

    public void setMarkJs(double markJs) {
        this.markJs = markJs;
    }

    public double getMarkAvg() {
        return markAvg;
    }

    /**
     * Tính điểm trung bình của học viên
     */
    public void calculateAvg() {
        this.markAvg = (this.markCss + this.markHtml + this.markJs) / 3;
    }

    /**
     * Nhập thông tin cho học viên (có thêm tham số cho hàm nếu cần)
     */
    public void input() {

    }

    /**
     * Hiển thị thông tin học viên ra màn hình
     */
    public void output() {
        System.out.println("Mã học viên: " + this.id);
        System.out.println("Họ tên: " + this.firstName + " " + this.lastName);
        System.out.println("Điểm CSS: " + this.markCss);
        System.out.println("Điểm HTML: " + this.markHtml);
        System.out.println("Điểm JS: " + this.markJs);
        System.out.println("Điểm trung bình: " + this.markAvg);

    }
}