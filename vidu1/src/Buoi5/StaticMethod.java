package Buoi5;

public class StaticMethod {
    // Thuộc tính static
    public static double PI = 3.14;

    // Phương thức tính diện tích hình tròn
    public static double calCircleArea(double radius) {
        return PI * radius * radius;
    }

    // Phương thức tính diện tích hình chữ nhật
    public static double calRectangleArea(double width, double height) {
        return width * height;
    }

    // Phương thức tính diện tích tam giác dựa trên công thức Heron
    public static double calTriangleArea(double a, double b, double c) {
        // Nửa chu vi
        double s = (a + b + c) / 2;
        // Diện tích tam giác theo công thức Heron
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}
