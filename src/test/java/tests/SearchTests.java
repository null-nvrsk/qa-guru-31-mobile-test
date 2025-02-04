package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SearchTests extends TestBase {

    String searchValue = "Appium";

    @Test
    @DisplayName("Проверить, что есть результаты поиска")
    void searchFieldTest() {
        mainScreen.openSearchModalWindow();

        searchScreen.searchValue(searchValue)
                .verifySearchResultNotEmpty();
    }

    @Test
    @DisplayName("Проверить, что найденная страница открывается")
    void openFoundPageTest() {
        mainScreen.openSearchModalWindow();

        searchScreen.searchValue(searchValue)
                .verifySearchResultNotEmpty();

        searchResultScreen.openFirstSearchResult()
                .checkErrorText();
    }
}
