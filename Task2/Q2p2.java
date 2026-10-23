import java.util.Scanner;

public class Q2p2 {
    public static void main(String[] args) {
        int score;
        System.out.println("Enter score : ");
        Scanner grade = new Scanner(System.in);
        score = grade.nextInt();

        switch (score / 10) {
            case 10:
            case 9:
                System.out.println("Excellent");
                break;
            case 8:
            case 7:
                if (score >= 75) {
                    System.out.println("Good");
                } else {
                    System.out.println("Pass");
                }
                break;
            case 6:
                System.out.println("Pass");
                break;
            default:
                if (score >= 0 && score < 60) {
                    System.out.println("Fail");
                } else {
                    System.out.println("Invalid grade");
                }
        }
    }
}
