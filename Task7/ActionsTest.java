package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ActionsTest extends BaseTest {

    @Test
    public void hoverTest() {

        driver.get("https://the-internet.herokuapp.com/hovers");

        Actions actions = new Actions(driver);

        // Get all profile cards
        List<WebElement> profiles =  driver.findElements(By.className("figure"));

        List<String> names = new ArrayList<>();

        // Hover over each profile
        for (WebElement profile : profiles)
        {

            actions.moveToElement(profile).perform();

            // Get revealed name
            WebElement nameElement =profile.findElement(By.tagName("h5"));

            String name = nameElement.getText();

            names.add(name);

            System.out.println("Profile Name: " + name);

        }

        // Verify list size
        Assert.assertEquals(names.size(), 3);

        // Verify names
        for (String name : names)
        {

            Assert.assertNotNull(name);

            Assert.assertFalse(
                    name.trim().isEmpty(),
                    "Profile name is empty"
            );

        }
    }


    @Test
    public void dragAndDropTest() {

        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        // Locate A and B
        WebElement columnA =driver.findElement(By.id("column-a"));

        WebElement columnB =driver.findElement(By.id("column-b"));

        // Create Actions
        Actions actions = new Actions(driver);

        // Drag A to B
        actions.dragAndDrop(columnA, columnB).perform();

        // Get updated values
        String columnAText =driver.findElement(By.id("column-a")).getText();

        String columnBText =driver.findElement(By.id("column-b")).getText();

        // Verify swap
        Assert.assertEquals(columnAText, "B");

        Assert.assertEquals(columnBText, "A");

    }
}