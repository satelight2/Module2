package com.ra.assignment;

public class Employee implements BaseEntity {
    private int id;
    private String name;
    private double salary;

    @Override
    public boolean checkId(Object id) {
        return id.equals(id);
    }

    @Override
    public void input() {

    }

    @Override
    public void show() {

    }
}
