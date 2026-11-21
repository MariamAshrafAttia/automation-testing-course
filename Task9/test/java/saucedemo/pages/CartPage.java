
package saucedemo.pages;

import saucedemo.actions.PageActions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    // Private locators
    private By cartItems = By.cssSelector(".cart_item");

    private By firstRemoveButton =
            By.xpath(
                    "(//div[@class='cart_item'])[1]" +
                            "//button[starts-with(@data-test,'remove')]"
            );

    private By checkoutButton = By.id("checkout");

    // Composition
    private PageActions actions;

    // Constructor
    public CartPage(WebDriver driver)
    {
        actions = new PageActions(driver);
    }

    // Get number of items
    public int getItemCount()
    {
        return actions.getElementCount(cartItems);
    }

    // Remove first item
    public void removeFirstItem()
    {
        if (getItemCount() > 0) {

            actions.click(firstRemoveButton);

        } else {

            System.out.println("Cart is empty");
        }
    }

    // Proceed to checkout
    public void proceedToCheckout()
    {
        actions.click(checkoutButton);
    }
}
