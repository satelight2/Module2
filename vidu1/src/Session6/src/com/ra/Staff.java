package com.ra;

public abstract class Staff {
    private String id;
    private String name;
    private String email;

    public Staff() {
    }

    public Staff(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void report() {
        System.out.println("Report");
    }

    public abstract void work();
}
