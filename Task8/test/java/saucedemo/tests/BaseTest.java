package saucedemo.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseTest {

    protected WebDriver driver;

    @BeforeSuite
    public void suiteStart()
    {
        System.out.println("===== Test Suite Started =====");
    }

    @BeforeClass
    public void launchBrowser()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        System.out.println("Browser Launched");
    }

    @AfterClass(alwaysRun = true)
    public void quitBrowser()
    {

        if (driver != null) {
            driver.quit();
        }

        System.out.println("Browser Closed");
    }
}