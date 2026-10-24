package Q4;

public class ProductBuilder {
    String name;
    double price;
    int quantity;
    String category;
    public ProductBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ProductBuilder withPrice(double price) {
        this.price = price;
        return this;
    }

    public ProductBuilder withQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public ProductBuilder withCategory(String category) {
        this.category = category;
        return this;
    }

    public Product build() {

        Product p = new Product();

        p.name = this.name;
        p.price = this.price;
        p.quantity = this.quantity;
        p.category = this.category;

        return p;
    }
}

