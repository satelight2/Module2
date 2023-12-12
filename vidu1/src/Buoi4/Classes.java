package Buoi4;



import java.util.Arrays;

public class Classes {
    private Student[] students;
    private int numberOfStudents;

    public Classes(int capacity) {
        students = new Student[capacity];
        numberOfStudents = 0;
    }

    /**
     * Thêm học viên vào lớp. Không thêm học viên trùng mã học viên(id).
     * @param st Đối tượng học viên được thêm vào lớp
     * @return Thêm thành công trả về true, ngược lại trả về false.
     */
//
//    public boolean add(Product p) {
//        if (numOfProducts == products.length) {
//            products = Arrays.copyOf(products, products.length * 2);
//        }
//
//        // Kiểm tra xem có sản phẩm nào có cùng ID không
//        for (Product product : products) {
//            if (product != null && product.getId().equals(p.getId())) {
//                System.out.println("Không thể thêm sản phẩm. Sản phẩm đã tồn tại với ID: " + p.getId());
//                return false;
//            }
//        }
//
//        products[numOfProducts] = p;
//        numOfProducts++;
//        System.out.println("Đã thêm sản phẩm vào cửa hàng.");
//        return true;
//    }

    public boolean add(Student st) {

        if (numberOfStudents == students.length){
            students = Arrays.copyOf(students, students.length * 2);
        }
        for (Student student : students) {
            if (student != null && student.getId().equals(st.getId())) {
                System.out.println("Student with ID " + st.getId() + " already exists in the class.");
                return false;
            }
        }
        students[numberOfStudents] = st;
        numberOfStudents++;
        System.out.println("Student with ID " + st.getId() + " has been added to the class.");
        return true;
    }

    /**
     * Cập nhật thông tin của học viên trong lớp, cập nhật tất cả thông tin ngoại trừ mã học viên(id)
     * @param st Đối tượng chứa thông tin mới của học viên được cập nhật.
     * @return Cập nhật thành công trả về true, ngược lại trả về false.
     */
    public boolean edit(Student st) {
        int index = findIndex(st.getId());
        if (index != -1) {
            // Update student information
            students[index].setFirstName(st.getFirstName());
            students[index].setLastName(st.getLastName());
            students[index].setMarkCss(st.getMarkCss());
            students[index].setMarkHtml(st.getMarkHtml());
            students[index].setMarkJs(st.getMarkJs());
            students[index].calculateAvg(); // Recalculate average after updating marks
            System.out.println("Student with ID " + st.getId() + " has been updated.");
            return true;
        } else {
            System.out.println("Student with ID " + st.getId() + " not found in the class.");
            return false;
        }
    }
    /**
     * Xóa học viên khỏi lớp
     * @param st Đối tượng học viên cần xóa
     * @return Xóa thành công trả về true, ngược lại trả về false.
     */
    public boolean remove(Student st) {
        int index = findIndex(st.getId());// Tìm vị trí học viên trong lớp
        if (index != -1) { // Nếu học viên có trong lớp thì xóa
            // Shift elements to remove the student
            for (int i = index; i < numberOfStudents - 1; i++) {
                students[i] = students[i + 1];
            }
            students[numberOfStudents - 1] = null; // Set the last element to null
            numberOfStudents--; // Reduce the number of students
            System.out.println("Student with ID " + st.getId() + " has been removed from the class.");
            return true;
        } else {
            System.out.println("Student with ID " + st.getId() + " not found in the class.");
            return false;
        }
    }
    /**
     * Trả về vị trí học viên trong lớp
     * @param id Mã học viên cần tìm
     * @return x - là vị trí của học viên trong lớp
     */
    public int findIndex(String id) {
        for (int i = 0; i < numberOfStudents; i++) {
            if (students[i].getId().equals(id)) {
                return i; // Found the student, return the index
            }
        }
        return -1; // Student not found
    }

    /**
     * Trả về đối tượng học viên trong lớp
     * @param id Mã học viên cần tìm
     * @return trả về đối tượng học viên(Student) được tìm thấy theo mã học viên(id) truyền vào.
     */
            public Student findId(String id) {
        int index = findIndex(id);
        return (index != -1) ? students[index] : null; // Return the student if found, otherwise null
    }
}