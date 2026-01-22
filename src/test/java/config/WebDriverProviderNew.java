package config;

import config.web.WebConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.function.Supplier;

public class WebDriverProviderNew implements Supplier<WebDriver> {

    private final WebConfig config;

    public WebDriverProviderNew() {
        this.config = ConfigFactory.create(WebConfig.class,System.getProperties());
    }

    @Override
    public WebDriver get() {
        WebDriver driver = createDriver();
        driver.get(config.baseUrl());
        return driver;
    }

    public WebDriver createDriver() {
        switch (config.browser()) {
            case CHROME: {
                WebDriverManager.chromedriver().browserVersion(config.browserVersion()).setup();
                return new ChromeDriver();
            }
            case FIREFOX: {
                WebDriverManager.firefoxdriver().browserVersion(config.browserVersion()).setup();
                return new FirefoxDriver();
            }
            default: {
                throw new RuntimeException("No such driver");
            }
        }
    }






}
