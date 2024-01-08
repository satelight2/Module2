package com.ra;

public interface Service {
    // Hằng số
    String SERVICE_NAME = "GENERAL SERVICE";

    // Phương thức trừu tượng
    void add(String item);
    void remove(int index);
}
