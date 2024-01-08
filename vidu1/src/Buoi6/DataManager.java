package Buoi6;

// DataManager.java
public   class DataManager<T extends BaseEntity> implements CRUDOperations<T> {
    private T[] items;
    private int size;

    public DataManager(int capacity) {
        items = (T[]) new BaseEntity[capacity];
        size = 0;
    }

    @Override
    public void add(T item) {
        if (size < items.length) {
            items[size++] = item;
            System.out.println(item.getClass().getSimpleName() + " added: " + item);
        } else {
            System.out.println(item.getClass().getSimpleName() + " database is full. Cannot add more items.");
        }
    }

    @Override
    public void display() {
        System.out.println(itemClassSimpleName() + "s:");
        for (T item : items) {
            if (item != null) {
                System.out.println(item);
            }
        }
    }

    @Override
    public void update(int index, T newItem) {
        if (index >= 0 && index < size) {
            items[index] = newItem;
            System.out.println(itemClassSimpleName() + " updated at index " + index + ": " + newItem);
        } else {
            System.out.println("Invalid index for updating " + itemClassSimpleName());
        }
    }

    @Override
    public void delete(int index) {
        if (index >= 0 && index < size) {
            System.out.println(itemClassSimpleName() + " deleted: " + items[index]);
            for (int i = index; i < size - 1; i++) {
                items[i] = items[i + 1];
            }
            items[size - 1] = null;
            size--;
        } else {
            System.out.println("Invalid index for deleting " + itemClassSimpleName());
        }
    }

    private String itemClassSimpleName() {
        return items.getClass().getComponentType().getSimpleName();
    }
}
