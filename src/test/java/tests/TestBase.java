package tests;

import com.codeborne.selenide.Configuration;
import drivers.BrowserstackDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        Configuration.browser = BrowserstackDriver.class.getName();
    }

    @AfterEach
    void addAttachments() {
        closeWebDriver();
    }
}
