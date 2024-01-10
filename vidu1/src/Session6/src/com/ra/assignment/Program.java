package Exception.ra.assignment;

public class Program {
    public static void main(String[] args) {
        Manager students = new Manager();
        Manager employees = new Manager();

        Student st = new Student();
        st.setId("SV01");
        st.setName("Nam");
        st.setClassName("RA/FUKUOKA-JV230929");

        Student st1 = new Student();
        st1.setId("SV02");
        st1.setName("Thành");
        st1.setClassName("RA/FUKUOKA-JV230929");
        students.add(st);
        students.add(st1);

        students.findId("SV01").show();
        // Anonymous clas
//        Predicate predicate = new Predicate() {
//            @Override
//            public boolean test(Object obj) {
//                return false;
//            }
//        };
        // Anonymous method
        Predicate predicateA = (obj) -> {
            return obj.equals("A");
        };
        // Lambda expression
        Predicate predicateB = obj -> obj.equals("B");


        System.out.println(predicateA.test("C"));
        System.out.println(predicateB.test("B"));
    }
}
