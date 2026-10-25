package Q1;

import java.util.Scanner;

public class main {
    public static void main(String[] args)
    {   System.out.println("Enter radius of circle : ");
        Scanner input=new Scanner(System.in);
        double radius = input.nextDouble();
        input.close();
        if (radius <=0)
        {
            System.out.println("Radius should be positive value");
        }

        System.out.println("Area of a circle : "+ (3.14*radius*radius));
        System.out.println("Perimeter of a circle : "+ (2*3.14*radius));
    }
}
