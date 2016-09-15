package com.encoway.ecasta_example.utils;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Augmenter;

/**
 * Holder for the web driver.
 */
public class WebDriverHolder {

    private static ChromeDriver driver;

    /**
     * returns a chrome web driver.
     * 
     * @return an instance of {@link ChromeDriver}
     */
    public static WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }

    @After(order = 1)
    public static void resetDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    @After
    public void takeScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot takesScreenshot;
            if (driver instanceof TakesScreenshot) {
                takesScreenshot = (TakesScreenshot) driver;
            } else {
                takesScreenshot = (TakesScreenshot) new Augmenter().augment(driver);
            }
            scenario.embed(takesScreenshot.getScreenshotAs(OutputType.BYTES), "image/png");
            ((WebDriver) takesScreenshot).close();
        }
    }
}
