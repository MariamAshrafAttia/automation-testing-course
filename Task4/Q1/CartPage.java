package Q1;

public class CartPage extends BasePage{
    @Override
    public boolean isLoaded()
    {
        System.out.println("Checking Cart Page");
        return true;
    }
}
