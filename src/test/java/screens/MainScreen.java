package screens;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;

public class MainScreen {

    private final SelenideElement searchField = $(accessibilityId("Search Wikipedia")),
            savedArticlesIcon = $(id("org.wikipedia.alpha:id/nav_tab_reading_lists"));

    @Step("Открыть поисковое модальное окно")
    public MainScreen openSearchModalWindow() {
        searchField.click();
        return this;
    }

    @Step("Перейти в секцию \"Saved\"")
    public MainScreen goToSavedSection() {
        savedArticlesIcon.click();
        return this;
    }
}
