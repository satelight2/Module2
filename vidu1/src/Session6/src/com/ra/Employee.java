package com.ra;

public class Employee extends Staff implements Service, ServiceData {
    @Override
    public void work() {
        System.out.println("Working...");
    }

    @Override
    public void add(String item) {

    }

    @Override
    public void remove(int index) {

    }

    @Override
    public void input() {

    }

    @Override
    public void output() {

    }
}
