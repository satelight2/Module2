package Buoi3;
import java.util.Arrays;
class Store {
    private Product[] products;
    private int numOfProducts;

    public Store(int capacity) {
        products = new Product[capacity];
        numOfProducts = 0;
    }


    public boolean add(Product p) {
        if (numOfProducts == products.length) {
            products = Arrays.copyOf(products, products.length * 2);
        }

        // Kiểm tra xem có sản phẩm nào có cùng ID không
        for (Product product : products) {
            if (product != null && product.getId().equals(p.getId())) {
                System.out.println("Không thể thêm sản phẩm. Sản phẩm đã tồn tại với ID: " + p.getId());
                return false;
            }
        }

        products[numOfProducts] = p;
        numOfProducts++;
        System.out.println("Đã thêm sản phẩm vào cửa hàng.");
        return true;
    }

    public Product findId(String id) {
        for (Product product : products) {
            if (product != null && product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }


    public boolean sort() {
        if (numOfProducts > 0) {
            for (int i = 0; i < numOfProducts - 1; i++) {
                for (int j = 0; j < numOfProducts - i - 1; j++) {
                    if (products[j].getName().compareTo(products[j + 1].getName()) > 0) {
                        // Swap
                        Product temp = products[j];
                        products[j] = products[j + 1];
                        products[j + 1] = temp;
                    }
                }
            }
            System.out.println("Đã sắp xếp sản phẩm theo tên từ A-Z.");
            return true;
        } else {
            System.out.println("Không có sản phẩm để sắp xếp.");
            return false;
        }
    }
    public boolean removeProduct(String id) {
        for (int i = 0; i < numOfProducts; i++) {
            if (products[i] != null && products[i].getId().equals(id)) {
                // Di chuyển tất cả các phần tử bên phải của phần tử bị xóa về trái
                for (int j = i; j < numOfProducts - 1; j++) {
                    products[j] = products[j + 1];
                }

                // Đặt phần tử cuối cùng của mảng thành null và giảm số lượng sản phẩm
                products[numOfProducts - 1] = null;
                numOfProducts--;

                System.out.println("Đã xóa sản phẩm có ID = " + id);
                return true;
            }
        }

        System.out.println("Không tìm thấy sản phẩm có ID = " + id);
        return false;
    }


    public void show() {
        if (numOfProducts > 0) {
            System.out.println("Danh sách sản phẩm trong cửa hàng:");
            for (Product product : products) {
                if (product != null) {
                    System.out.println("ID: " + product.getId() + ", Tên: " + product.getName() + ", Giá bán: " + product.getSalePrice());
                }
            }
        } else {
            System.out.println("Không có sản phẩm nào trong cửa hàng.");
        }
    }
}



