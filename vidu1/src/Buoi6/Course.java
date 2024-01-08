package Buoi6;

// Course.java
public class Course extends BaseEntity {
    private int courseId;

    public Course(int courseId, String name) {
        super(name);
        this.courseId = courseId;
    }

    public int getCourseId() {
        return courseId;
    }

    @Override
    public String toString() {
        return "Course ID: " + courseId + ", Name: " + name;
    }
}

