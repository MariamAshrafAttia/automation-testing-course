package Q2;

public class Product {
    private String name;
    private double price;
    private int quantity;
    private String category;

public Product(String name,double price,int quantity,String category)
{
    if (name == null || name.trim().isEmpty()) {
        throw new IllegalArgumentException("Name cannot be empty");
    }

    if (category == null || category.trim().isEmpty()) {
        throw new IllegalArgumentException("Category cannot be empty");
    }
    this.name=name;
    this.category=category;
    setPrice(price);
    setQuantity(quantity);
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
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be positive");
        }
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        this.quantity = quantity;
    }

    // Calculate Total
    public double getTotal() {
        return price * quantity;
    }

    // Display Product Information
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", category='" + category + '\'' +
                '}';
    }
}
