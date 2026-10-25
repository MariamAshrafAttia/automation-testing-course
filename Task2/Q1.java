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
        Scanner input = new Scanner(System.in);
        productName = input.nextLine();
        System.out.println("Please Enter Pricing");
        price =input.nextDouble();
        System.out.println("Please Enter Quantity");
        quantityOrdered = input.nextInt();
        input.close();
        if(inStock)
        {
            System.out.println("Total price : " + (price*quantityOrdered));
        }
    }
}