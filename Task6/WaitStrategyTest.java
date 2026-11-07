package saucedemo.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class WaitStrategyTest extends BaseTest {

    @Test
    public void wrongLocatorAndFixedLocatorTest() {

        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));

        // Step 1: Use wrong locator deliberately
        try {

            driver.findElement(By.id("wrong-login-button"));

            Assert.fail("NoSuchElementException was expected");

        } catch (NoSuchElementException e) {

            System.out.println("Expected Exception: "+ e.getClass().getSimpleName());
        }

        // Step 2: Fix the locator
        WebElement loginButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("login-button"))
        );

        Assert.assertTrue(loginButton.isDisplayed());

        System.out.println("Correct locator found!");
    }

    @Test
    public void delayedElementTest() {

        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));

        JavascriptExecutor js =(JavascriptExecutor) driver;

        // Add button after 2 seconds
        js.executeScript(
                "window.setTimeout(function() {" +
                        "var button = document.createElement('button');" +
                        "button.id = 'delayed-button';" +
                        "button.innerText = 'Delayed Button';" +
                        "document.body.appendChild(button);" +
                        "}, 2000);"
        );

        // Wait for delayed element
        WebElement delayedButton = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("delayed-button")
                )
        );

        Assert.assertTrue(delayedButton.isDisplayed());

        Assert.assertEquals(
                delayedButton.getText(),
                "Delayed Button"
        );

        System.out.println("Delayed element appeared!");
    }
}

