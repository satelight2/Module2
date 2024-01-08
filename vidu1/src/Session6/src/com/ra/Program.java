package com.ra;

public class Program {
    public static void main(String[] args) {
        Staff staff = new Employee();
        staff.work();

        Service service = new Service() {
            @Override
            public void add(String item) {

            }

            @Override
            public void remove(int index) {

            }
        };
    }
}
