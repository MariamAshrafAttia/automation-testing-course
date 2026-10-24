package Q4;

public class main {
    public static void main(String[] args) {

        Product p1 = new ProductBuilder()
                .withName("Laptop")
                .withPrice(25000)
                .withQuantity(2)
                .withCategory("Electronics")
                .build();

        Product p2 = new ProductBuilder()
                .withName("Book")
                .withPrice(200)
                .withQuantity(5)
                .withCategory("Education")
                .build();

        Product p3 = new ProductBuilder()
                .withName("Chair")
                .withPrice(1500)
                .withQuantity(3)
                .withCategory("Furniture")
                .build();

        System.out.println("Product name : "+p1.name+ ", Product price : "+p1.price);
        System.out.println("Product name : "+p2.name+ ", Product price : "+p2.price);
        System.out.println("Product name : "+p3.name+ ", Product price : "+p3.price);
    }
}
