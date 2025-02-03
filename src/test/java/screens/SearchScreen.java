package screens;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.id;

public class SearchScreen {

    private final SelenideElement searchKeyWords = $(id("org.wikipedia.alpha:id/search_src_text"));
    private final ElementsCollection searchResults = $$(id("org.wikipedia.alpha:id/page_list_item_title"));

    @Step("Ввести в поле поиска \"{0}\"")
    public SearchScreen searchValue(String value) {
        searchKeyWords.sendKeys(value);
        return this;
    }

    @Step("Проверить, что есть результаты поиска")
    public SearchScreen verifySearchResultNotEmpty() {
        searchResults.shouldHave(sizeGreaterThan(0));
        return this;
    }
}
