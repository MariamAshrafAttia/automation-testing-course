package saucedemo.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
        import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        // Using Explicit Wait only
        driver.manage().timeouts().implicitlyWait(Duration.ZERO);

        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {

        if (driver != null) {

            String testName =result.getMethod().getMethodName();

            String status =result.getStatus() == ITestResult.SUCCESS ? "PASS" : "FAIL";

            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss_SSS"));

            String fileName = testName + "_" + status + "_" + timestamp + ".png";

            try {

                File folder = new File("screenshots");

                if (!folder.exists())
                {
                    folder.mkdirs();
                }

                File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

                File destination = new File(folder, fileName);

                FileUtils.copyFile(source, destination);

                System.out.println("Screenshot saved: "+ destination.getAbsolutePath());

            } catch (IOException | WebDriverException e) {

                System.out.println("Screenshot failed: " + e.getMessage());

            } finally {

                driver.quit();
            }
        }
    }
}
