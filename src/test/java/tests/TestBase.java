package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.ConfigReader;
import config.ProjectConfiguration;
import config.web.WebConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.RegistrationPage;
import pages.components.CalendarComponent;

public class TestBase {

    RegistrationPage steps = new RegistrationPage();
    TestData testData = new TestData();
    CalendarComponent calendarComponent = new CalendarComponent();

    private static final WebConfig webConfig4 = ConfigReader.Instance.read();


    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        ProjectConfiguration projectConfiguration = new ProjectConfiguration(webConfig4);
        projectConfiguration.webConfig6();

    }


    @BeforeAll
    static void beforeAll() {
        Configuration.pageLoadStrategy = "eager";
    }


    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

    }
}
