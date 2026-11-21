
package saucedemo.tests;

import saucedemo.pages.LoginPage;
import saucedemo.pages.InventoryPage;
import saucedemo.pages.CartPage;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class InventoryTests extends BaseTest {

    @Test
    public void inventoryAndCartTest() {

        // Login
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        // Inventory
        InventoryPage inventoryPage =
                new InventoryPage(driver);

        // Get product names
        List<String> names =
                inventoryPage.getProductNames();

        System.out.println("Product Names: " + names);

        // Get product prices
        List<String> prices =
                inventoryPage.getProductPrices();

        System.out.println("Product Prices: " + prices);

        Assert.assertEquals(names.size(), 6);

        Assert.assertEquals(prices.size(), 6);

        // Sort by price
        inventoryPage.sortBy("lohi");

        // Add product
        inventoryPage.addItemToCart("Sauce Labs Backpack");

        Assert.assertEquals(
                inventoryPage.getCartBadgeCount(), 1
        );

        // Go to cart
        inventoryPage.goToCart();

        // Cart
        CartPage cartPage = new CartPage(driver);

        Assert.assertEquals(cartPage.getItemCount(), 1);

        // Remove first item
        cartPage.removeFirstItem();

        Assert.assertEquals(cartPage.getItemCount(), 0);
    }
}
