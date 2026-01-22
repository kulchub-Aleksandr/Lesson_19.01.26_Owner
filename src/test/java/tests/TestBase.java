package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.ConfigReader;
import config.ProjectConfiguration;
import config.ProjectConfigurationNew;
import config.WebDriverProviderNew;
import config.web.WebConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import pages.RegistrationPage;
import pages.components.CalendarComponent;

public class TestBase {

    RegistrationPage steps = new RegistrationPage();
    TestData testData = new TestData();
    CalendarComponent calendarComponent = new CalendarComponent();

   // private static final WebConfig webConfig4 = ConfigReader.Instance.read();
    private WebDriver driver;
    ProjectConfigurationNew projectConfigurationNew = new ProjectConfigurationNew();

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());

//        ProjectConfiguration projectConfiguration = new ProjectConfiguration(webConfig4);
//        projectConfiguration.webConfig6();

        projectConfigurationNew.setWebConfig();

        driver = new ProjectConfigurationNew().get();

    }

    @BeforeAll
    static void beforeAll() {

//        ProjectConfiguration projectConfiguration = new ProjectConfiguration(webConfig4);
//        projectConfiguration.webConfig();
        //Configuration.browserSize = "1920x1080";
        //Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        //Configuration.holdBrowserOpen = true;
        //Configuration.timeout = 10000; // default 4000
//
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
//                "enableVNC", true,
//                "enableVideo", true
//        ));
//        Configuration.browserCapabilities = capabilities;
//
//        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }


//    @BeforeEach
//    public void startDriver() {
//        driver = new WebDriverProviderNew().get();
//    }

//    @BeforeEach
//    public void startDriver() {
//        driver = new WebDriverProvider().get();
//    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        driver.quit();

    }
//    @AfterEach
//    public void stopDriver() {
//        driver.quit();
//    }

}
