package Q1;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {

        List<BasePage> pages = new ArrayList<>();

        pages.add(new LoginPage());
        pages.add(new InventoryPage());
        pages.add(new CartPage());

        for (BasePage page : pages) {
            System.out.println(page.isLoaded());
        }
    }
}
