package config;

import com.codeborne.selenide.Configuration;
import config.web.WebConfig;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class ProjectConfiguration {

    private final WebConfig webConfig3;

    public ProjectConfiguration(WebConfig webConfig) {
        this.webConfig3 = webConfig;
    }

    public void webConfig6() {
//        WebDriver driver = new FirefoxDriver();
//        driver.get(webConfig3.baseUrl());



        Configuration.baseUrl = webConfig3.baseUrl();
        Configuration.browser = webConfig3.browser().toString();
        Configuration.browserVersion = webConfig3.browserVersion();
        Configuration.browserSize = webConfig3.browserSize();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

        if (webConfig3.isRemote()) {
            Configuration.remote = webConfig3.remoteUrl();
        }

    }
}
