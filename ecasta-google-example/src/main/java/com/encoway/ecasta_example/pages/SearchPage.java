package com.encoway.ecasta_example.pages;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

import com.encoway.ecasta_example.utils.WebDriverHolder;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.LoadableComponent;

public class SearchPage extends LoadableComponent<SearchPage> {

    private WebDriver driver = WebDriverHolder.getDriver();

    /**
     * loads the URL by reading the system properties.
     */
    @Override
    protected void load() {
        String url = System.getProperty("application.local.protocol", "http") + "://"
                + System.getProperty("application.local.host", "google.fr") + ":"
                + System.getProperty("application.local.port", "80") + "/"
                + System.getProperty("application.local.context", "");
        driver.get(url);
    }

    /**
     * looks for if page is loaded.
     * 
     * @throws Error if not loaded
     */
    @Override
    protected void isLoaded() throws Error {
        String host = System.getProperty("application.local.host", "google.fr");
        assertThat(driver.getCurrentUrl(), containsString(host));
    }

    /**
     * submit a search query to google.
     * 
     * @param key is the word to search for
     */
    public void submitSearch(String key) {
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys(key);
        element.submit();

    }

    public String getTitle() {
        String title = "";
        long time = System.currentTimeMillis() + 5000;
        while (time > System.currentTimeMillis()) {
            title = driver.getTitle();
        }
        return title;
    }

}
