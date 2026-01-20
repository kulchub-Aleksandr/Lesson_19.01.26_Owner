package tests;

import config.WebDriverProvider;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebDriverTest {

    private WebDriver driver;

    @BeforeEach
    public void startDriver() {
        driver = new WebDriverProvider().get();
    }


    @Test
    @Tag("simple")
    public void testGithub() {
        String title = driver.getTitle();
        assertEquals("GitHub · Change is constant. GitHub keeps you ahead. · GitHub", title);
    }

    @AfterEach
    public void stopDriver() {
        driver.quit();
    }


}
