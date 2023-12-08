package Buoi3;


class Product {
    private String id;
    private String name;
    private double price;
    private double discount;
    private double salePrice;

    // Constructors
    public Product() {
        // Default constructor
    }

    public Product(String id, String name, double price, double discount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.discount = discount;
        calculateSalePrice();
    }

    // Getters and Setters
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
        calculateSalePrice();
    }

    public double getSalePrice() {
        return salePrice;
    }

    // Calculate salePrice
    public void calculateSalePrice() {
        this.salePrice = price - (price / 100 * discount);
    }
}

