package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserstackDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = BrowserstackDriver.class.getName();
        Configuration.browserSize = null;
        Configuration.timeout = 30_000;
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open();
    }

    @AfterEach
    void addAttachments() {
//        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
//        Attach.addVideo();
        closeWebDriver();
    }
}
