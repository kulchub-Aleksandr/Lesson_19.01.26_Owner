package config;

import com.codeborne.selenide.Configuration;
import config.web.WebConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;
import java.util.function.Supplier;

public class ProjectConfigurationNew implements Supplier<WebDriver> {

    private final WebConfig config;

    public ProjectConfigurationNew() {
        try {
            this.config = ConfigFactory.create(WebConfig.class, System.getProperties());
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize configuration", e);
        }
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

    public void setWebConfig(){

        Configuration.baseUrl = config.baseUrl();
        Configuration.browser = config.browser().toString();
        Configuration.browserVersion = config.browserVersion();
        Configuration.browserSize = config.browserSize();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

        if (config.isRemote()) {
            Configuration.remote = config.remoteUrl();
        }

    }


//    private final WebConfig webConfig3;
//
//    public ProjectConfigurationNew(WebConfig webConfig) {
//        this.webConfig3 = webConfig;
//    }

//    public void webConfig6() {
//
//
//        Configuration.baseUrl = webConfig3.baseUrl();
//        Configuration.browser = webConfig3.browser().toString();
//        Configuration.browserVersion = webConfig3.browserVersion();
//        Configuration.browserSize = webConfig3.browserSize();
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
//                "enableVNC", true,
//                "enableVideo", true
//        ));
//        Configuration.browserCapabilities = capabilities;
//
//        if (webConfig3.isRemote()) {
//            Configuration.remote = webConfig3.remoteUrl();
//        }
//
//
//    }

}
