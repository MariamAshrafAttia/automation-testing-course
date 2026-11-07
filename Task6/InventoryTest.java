package saucedemo.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class InventoryTest extends BaseTest {

    @Test
    public void productAndCartTest() {

        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));

        // Step 1: Login
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))).sendKeys("standard_user");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("secret_sauce");

        wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button"))).click();

        wait.until(ExpectedConditions.urlContains("inventory"));

        // Step 2: Get all product names
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_item_name")));

        List<WebElement> nameElements =driver.findElements(By.className("inventory_item_name"));

        List<String> productNames = nameElements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        System.out.println("Product Names: " + productNames);

        // Step 3: Get all product prices
        List<WebElement> priceElements =driver.findElements(By.className("inventory_item_price"));

        List<String> productPrices = priceElements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        System.out.println("Product Prices: " + productPrices);

        Assert.assertFalse(productNames.isEmpty());

        Assert.assertEquals(
                productNames.size(),
                productPrices.size()
        );

        // Step 4: Click Add to Cart on second product
        List<WebElement> addButtons =driver.findElements(By.cssSelector("[data-test^='add-to-cart']"));

        Assert.assertTrue(addButtons.size() >= 2);

        addButtons.get(1).click();

        // Step 5: Verify cart badge = 1
        WebElement cartBadge = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("shopping_cart_badge")));

        Assert.assertEquals(cartBadge.getText(), "1");

        // Step 6: Click cart icon
        wait.until(ExpectedConditions.elementToBeClickable(By.className("shopping_cart_link"))).click();

        wait.until(ExpectedConditions.urlContains("cart"));

        // Step 7: Verify cart contains one item
        List<WebElement> cartItems =driver.findElements(By.className("cart_item"));

        Assert.assertEquals(cartItems.size(),1,"Cart should contain exactly one product"
        );

        System.out.println("Cart item count: " + cartItems.size());
    }
}
