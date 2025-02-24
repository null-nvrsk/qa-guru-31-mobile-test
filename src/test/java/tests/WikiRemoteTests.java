package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@DisplayName("Удаленная проверка приложения Wikipedia (эмулятор)")
@Owner("Maksim Skomorokhov")
@Tag("remote")
public class WikiRemoteTests extends TestBase {
    String searchValue = "Appium";
    public final String articleShortDescription = "Automation for Apps";

    @Test
    @DisplayName("Проверить, что есть результаты поиска")
    void successfulSearchAppiumTest() {
        mainScreen.openSearchModalWindow();
        searchScreen.searchValue(searchValue)
                .verifySearchResultNotEmpty();
    }

    @Test
    @DisplayName("Открыть первый результат поиска")
    void successfulSearchTest() {
        mainScreen.openSearchModalWindow();
        searchScreen.searchValue(searchValue)
                .verifySearchResultNotEmpty();
        searchResultScreen.openFirstSearchResult()
                .checkErrorText();
    }

    @DisplayName("Проверить кратное описание статьи")
    @Test
    void checkDescriptionTest() {
        mainScreen.openSearchModalWindow();
        searchScreen.searchValue(searchValue);
        searchResultScreen.checkArticleDescription(articleShortDescription);
    }
}
