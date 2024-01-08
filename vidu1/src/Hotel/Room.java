package Hotel;

public class Room {
    private String roomType;
    private int price;
    private Customer customer;

    public Room(String roomType) {
        this.roomType = roomType;
        setPrice();
        this.customer = null;
    }

    private void setPrice() {
        switch (roomType) {
            case "A":
                this.price = 500;
                break;
            case "B":
                this.price = 300;
                break;
            case "C":
                this.price = 100;
                break;
            default:
                this.price = 0;
        }
    }

    public String getRoomType() {
        return roomType;
    }

    public int getPrice() {
        return price;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

