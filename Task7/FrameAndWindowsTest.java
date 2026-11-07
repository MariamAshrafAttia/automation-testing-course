package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.Keys;

import java.util.Set;

public class FrameAndWindowsTest extends BaseTest {

    @Test
    public void iframeTest() {

        driver.get("https://the-internet.herokuapp.com/iframe");

        // Switch to iframe
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                By.id("mce_0_ifr")
        ));

        // Locate editor and wait until clickable
        WebElement editor = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("tinymce"))
        );

        // Clear existing text
        editor.click();
        editor.sendKeys(Keys.CONTROL, "a");
        editor.sendKeys(Keys.BACK_SPACE);

        // Enter name
        editor.sendKeys("Mariam Ashraf");

        // Verify text
        String actualText = editor.getText();
        System.out.println("Actual text: " + actualText);

        Assert.assertEquals(actualText.trim(), "Mariam Ashraf");

        // Switch back to main page
        driver.switchTo().defaultContent();

        Assert.assertTrue(driver.getCurrentUrl().contains("/iframe"));

    }


    @Test
    public void windowsTest() {

        driver.get("https://the-internet.herokuapp.com/windows");

        // Store original window
        String originalWindow =driver.getWindowHandle();

        String originalTitle = driver.getTitle();

        // Click Here
        driver.findElement(By.linkText("Click Here")).click();

        // Wait for new window
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        // Get all windows
        Set<String> allWindows =driver.getWindowHandles();

        // Switch to new window
        for (String window : allWindows) {

            if (!window.equals(originalWindow))
            {

                driver.switchTo().window(window);

                break;
            }
        }

        // Verify new window title
        wait.until(ExpectedConditions.titleIs("New Window"));

        Assert.assertEquals(driver.getTitle(),"New Window");

        // Close new window
        driver.close();

        // Return to original window
        driver.switchTo().window(originalWindow);

        // Verify original page
        Assert.assertEquals(driver.getTitle(),originalTitle);

        Assert.assertTrue(driver.getCurrentUrl().contains("/windows"));

    }
}
