
package saucedemo.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PageActions {

    private WebDriver driver;

    public PageActions(WebDriver driver)
    {
        this.driver = driver;
    }

    // Click
    public void click(By locator)
    {
        driver.findElement(locator).click();
    }

    // Type
    public void type(By locator, String text)
    {
        driver.findElement(locator).sendKeys(text);
    }

    // Get text
    public String getText(By locator)
    {
        return driver.findElement(locator).getText();
    }

    // Get text from multiple elements
    public List<String> getTexts(By locator)
    {
        return driver.findElements(locator)
                .stream()
                .map(WebElement::getText)
                .toList();
    }

    // Get number of elements
    public int getElementCount(By locator)
    {
        return driver.findElements(locator).size();
    }

    // Select dropdown option by value
    public void selectByValue(By locator, String value)
    {
        Select select = new Select(driver.findElement(locator));

        select.selectByValue(value);
    }

    // Clear field
    public void clear(By locator)
    {
        driver.findElement(locator).clear();
    }
}
