import java.util.Arrays;
import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {

        String [] products={"Black heels","Bronze sandals","Brown shades"
                ,"Grey jacket","Striped top","White sandals"};

        //Print the sorted array using for-each
        Arrays.sort(products);
        for(String product : products)
        {
            System.out.println(product);
        }

        //Search for a specific product
        System.out.println("Enter the name of product which you want to search");
        String searchingProdcutName;
        Scanner productName= new Scanner(System.in);
        searchingProdcutName =productName.nextLine();
        int index = Arrays.binarySearch(products, searchingProdcutName);
        System.out.println("Product index: " + index);
        productName.close();
        //Reverse the sorted array using a classic for loop
        for (int i = 0; i < products.length / 2; i++) {
            String temp = products[i];
            products[i] = products[products.length - 1 - i];
            products[products.length - 1 - i] = temp;
        }

        //Print the reversed array
        System.out.println("Reversed array:");
        for (String product : products) {
            System.out.println(product);
        }
    }
}
