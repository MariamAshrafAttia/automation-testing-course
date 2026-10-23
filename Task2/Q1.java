import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Q1 {
    public static void main(String[] args) {
        String productName="";
        double price;
        int quantityOrdered;
        boolean inStock= true;

        System.out.println("Please Enter Product Name");
        Scanner product = new Scanner(System.in);
        productName =product.nextLine();
        Scanner pricing = new Scanner(System.in);
        System.out.println("Please Enter Pricing");
        price =pricing.nextDouble();
        Scanner QPricing = new Scanner(System.in);
        System.out.println("Please Enter Quantity");
        quantityOrdered = QPricing.nextInt();
        if(inStock== true)
        {
            System.out.println("Total price : " + (price*quantityOrdered));
        }
    }
}