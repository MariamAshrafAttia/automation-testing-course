package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaScriptExecutorTest extends BaseTest {

    @Test
    public void javaScriptExecutorTest() {

        driver.get("https://www.saucedemo.com/");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // 1. Set username using JavaScript
        WebElement username = driver.findElement(By.id("user-name"));

        js.executeScript(
                "Object.getOwnPropertyDescriptor(" +
                        "HTMLInputElement.prototype, 'value')" +
                        ".set.call(arguments[0], 'standard_user');" +
                        "arguments[0].dispatchEvent(" +
                        "new Event('input', {bubbles:true}));",
                username
        );

        // Enter password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        // Login
        driver.findElement(By.id("login-button")).click();

        // Wait for inventory page
        wait.until(ExpectedConditions.urlContains("inventory.html"));

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));

        // 2. Scroll to bottom
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        // Scroll back to top
        js.executeScript("window.scrollTo(0, 0);");

        // 3. Read document.title
        String jsTitle = (String) js.executeScript("return document.title;");

        String seleniumTitle = driver.getTitle();

        System.out.println("JS Title: " + jsTitle);

        System.out.println("Selenium Title: " + seleniumTitle);

        Assert.assertEquals(jsTitle, seleniumTitle);

        // 4. Highlight cart icon
        WebElement cartIcon =driver.findElement(By.className("shopping_cart_link"));

        js.executeScript("arguments[0].style.border = '3px solid red';",cartIcon);

        // Verify border
        String border = (String) js.executeScript(
                "return arguments[0].style.border;"
                , cartIcon);

        Assert.assertTrue(border.contains("red"));

    }
}