
package saucedemo.pages;

import saucedemo.actions.PageActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.List;

public class InventoryPage {

    private WebDriver driver;

    // Private locators
    private By productNames = By.cssSelector("[data-test='inventory-item-name']");

    private By productPrices = By.cssSelector("[data-test='inventory-item-price']");

    private By cartBadge = By.cssSelector("[data-test='shopping-cart-badge']");

    private By cartIcon = By.className("shopping_cart_link");

    private By sortDropdown = By.className("product_sort_container");

    // Composition
    private PageActions actions;

    public InventoryPage(WebDriver driver)
    {
        this.driver = driver;
        actions = new PageActions(driver);
    }

    // Get all product names
    public List<String> getProductNames()
    {
        return actions.getTexts(productNames);
    }

    // Get all product prices
    public List<String> getProductPrices()
    {
        return actions.getTexts(productPrices);
    }

    // Dynamic private locator for product button
    private By addButtonForProduct(String productName)
    {

        return By.xpath(
                "//div[@class='inventory_item']" +
                        "[.//div[@data-test='inventory-item-name' " +
                        "and normalize-space()='" + productName + "']]" +
                        "//button"
        );
    }

    // Add specific product to cart
    public void addItemToCart(String productName)
    {
        actions.click(addButtonForProduct(productName));
    }

    // Get cart badge count
    public int getCartBadgeCount()
    {
        if (driver.findElements(cartBadge).isEmpty())
        {
            return 0;
        }

        return Integer.parseInt(actions.getText(cartBadge));
    }

    // Navigate to cart
    public void goToCart()
    {
        actions.click(cartIcon);
    }

    // Sort products
    public void sortBy(String option)
    {
        actions.selectByValue(sortDropdown, option);
    }
}
