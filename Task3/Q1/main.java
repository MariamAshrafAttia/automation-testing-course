package Q1;

public class main {
    public static void main(String[] args)
    {
        double result1 = Calculator.add(5, 3);
        System.out.println("Result1 : "+result1);
        double result2 = Calculator.add(5, 3.52);
        System.out.println("Result2 : "+result2);
        double result3 = Calculator.add(5.75, 3);
        System.out.println("Result3 : "+result3);
        double result4 = Calculator.add(5.1, 3.3);
        System.out.println("Result4 : "+result4);

        System.out.println("Result4 after format string : "+ Calculator.formatResult(result4,2));


    }
}
