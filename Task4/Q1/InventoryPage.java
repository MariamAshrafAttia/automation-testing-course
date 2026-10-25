package Q1;

public class InventoryPage extends BasePage{
    @Override
    public boolean isLoaded() {
        System.out.println("Checking Inventory Page");
        return true;
    }
}
