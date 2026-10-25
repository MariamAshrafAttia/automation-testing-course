import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        int score;
        System.out.println("Enter score : ");
        Scanner input = new Scanner(System.in);
        score = input.nextInt();
        input.close();

        if(score< 0)
        {
            System.out.println("Invalid grade");
        }
        else if (score>= 90)
        {
            System.out.println("Excellent");
        }
        else if(score>= 75)
        {
            System.out.println("Good");
        }
        else if(score>= 60)
        {
            System.out.println("Pass");
        }
        else if(score <60)
        {
            System.out.println("Fail");
        }
    }
}
