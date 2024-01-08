package Buoi6;

// CRUDOperations.java
public interface CRUDOperations<T> {
    void add(T item);
    void display();
    void update(int index, T newItem);
    void delete(int index);
}
