package Q2;

import java.util.Scanner;

public class main {
    public static void main(String[] args)
    {
        System.out.println("Enter 3 nmbers : ");
        Scanner input=new Scanner(System.in);
        int num1=input.nextInt(),num2=input.nextInt(),num3=input.nextInt();
        input.close();
        System.out.println("The average : "+((num1+num2+num3)/3));
    }
}
