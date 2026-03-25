import java.util.*;
import java.util.stream.*;

public class ProductService {
    private List<Product> products = new ArrayList<>();

    // CREATE
    public void addProduct(Product p) {
        boolean exists = products.stream()
                .anyMatch(prod -> prod.getId() == p.getId());

        if (exists) {
            throw new InvalidProductException("ID đã tồn tại!");
        }

        products.add(p);
    }

    // READ
    public void displayProducts() {
        System.out.printf("%-5s %-15s %-10s %-10s %-15s\n",
                "ID", "Name", "Price", "Qty", "Category");

        products.forEach(p ->
                System.out.printf("%-5d %-15s %-10.2f %-10d %-15s\n",
                        p.getId(), p.getName(), p.getPrice(),
                        p.getQuantity(), p.getCategory()));
    }

    // UPDATE (dùng Optional)
    public void updateQuantity(int id, int newQuantity) {
        Optional<Product> optional = products.stream()
                .filter(p -> p.getId() == id)
                .findFirst();

        Product product = optional.orElseThrow(() ->
                new InvalidProductException("Không tìm thấy sản phẩm!")
        );

        product.setQuantity(newQuantity);
    }

    // DELETE (Java 8)
    public void deleteOutOfStock() {
        products.removeIf(p -> p.getQuantity() == 0);
    }
}