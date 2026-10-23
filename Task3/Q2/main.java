package Q2;

public class main {
    public static void main(String[] args)
    {
        // TC1 :Valid Product
        Product p = new Product(
                "Laptop", 25000, 2, "Electronics");

        System.out.println(p);
        System.out.println("Name: " + p.getName());
        System.out.println("Price: " + p.getPrice());
        System.out.println("Quantity: " + p.getQuantity());
        System.out.println("Category: " + p.getCategory());
        System.out.println("Total: " + p.getTotal());

        // TC2: Update valid values
        p.setPrice(30000);
        p.setQuantity(3);

        System.out.println("Updated Total: " + p.getTotal());

        // Invalid price test
        try {
            p.setPrice(-100);
        } catch (IllegalArgumentException e) {
            System.out.println("Price Error: " + e.getMessage());
        }

        // Invalid quantity test
        try {
            p.setQuantity(-1);
        } catch (IllegalArgumentException e) {
            System.out.println("Quantity Error: " + e.getMessage());
        }

    }
}
