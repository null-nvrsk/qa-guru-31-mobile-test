package screens;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;

public class SearchResultScreen {

    private final ElementsCollection searchKeyWords = $$(id("org.wikipedia.alpha:id/page_list_item_title"));
    private final SelenideElement errorText = $(id("org.wikipedia.alpha:id/view_wiki_error_text")),
            goBack = $(accessibilityId("Navigate up")),
            articleDescriptionField = $(id("org.wikipedia.alpha:id/page_list_item_description"));

    @Step("Открыть первый результат поиска")
    public SearchResultScreen openFirstSearchResult() {
        searchKeyWords.first().click();
        return this;
    }

    @Step("Check error text")
    public SearchResultScreen checkErrorText() {
        errorText.shouldHave(text("An error occurred"));
        return this;
    }

    @Step("Нажмите на иконку \"Назад\"")
    public SearchResultScreen pressBack() {
        goBack.click();
        return this;
    }

    @Step("Проверьте описание первой статьи")
    public SearchResultScreen checkArticleDescription(String description) {
        articleDescriptionField.shouldHave(text(description));
        return this;
    }
}
