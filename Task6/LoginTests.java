package saucedemo.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

    @Test
    public void validLoginTest() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Enter username
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))).sendKeys("standard_user");
        // Enter password
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("secret_sauce");
        // Click Login
        wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button"))).click();
        // Verify URL
        wait.until(ExpectedConditions.urlContains("inventory"));

        Assert.assertTrue(
                driver.getCurrentUrl().contains("inventory"),
                "Inventory page was not opened"
        );
    }

    @Test
    public void invalidPasswordTest() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))).sendKeys("standard_user");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("wrong_password");

        wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button"))).click();

        String expectedError ="Epic sadface: Username and password do not match any user in this service";

        String actualError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='error']"))).getText();

        Assert.assertEquals(actualError, expectedError);
    }

    @Test
    public void emptyUsernameTest() {

        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));

        // Username is intentionally empty
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("secret_sauce");

        wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button"))).click();

        String expectedError ="Epic sadface: Username is required";

        String actualError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='error']"))).getText();
        Assert.assertEquals(actualError, expectedError);
    }
}
