package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.back;

@DisplayName("Локальная проверка приложения Wikipedia (эмулятор)")
@Owner("Maksim Skomorokhov")
@Tag("local")
public class WikiLocalTests extends TestBase {

    final String firstPageHeader = "The Free Encyclopedia\n…in over 300 languages";
    final String firstPageText = "We’ve found the following on your device:";
    final String firstPageLanguages = "1.\t\tEnglish";

    final String secondPageHeader = "New ways to explore";
    final String secondPageText = "Dive down the Wikipedia rabbit hole with a constantly updating Explore feed. " +
            "\nCustomize the feed to your interests – whether it’s learning about historical events " +
            "On this day, or rolling the dice with Random.";

    final String thirdPageHeader = "Reading lists with sync";
    final String thirdPageText = "You can make reading lists from articles you want to read later, " +
            "even when you’re offline. \nLogin to your Wikipedia account to sync your reading lists. Join Wikipedia";

    final String fourthPageHeader = "Data & Privacy";
    final String fourthPageText = "We believe that you should not have to provide personal information to " +
            "participate in the free knowledge movement. Usage data collected for this app is anonymous. " +
            "Learn more about our privacy policy and terms of use.";

    @Test
    @DisplayName("Проверить окно приветствия")
    void onboardingScreensTest() {
        //first screen
        onboardingScreen
                .checkHeader(firstPageHeader)
                .checkText(firstPageText)
                .checkLanguageList(firstPageLanguages)
                .checkAddLanguageButton()
                .checkGetStartedButtonNotVisible()
                .checkSkipContinueButtonsVisible()
                .goNextScreen()

                //second screen
                .checkHeader(secondPageHeader)
                .checkText(secondPageText)
                .checkGetStartedButtonNotVisible()
                .checkSkipContinueButtonsVisible()
                .goNextScreen()

                //third screen
                .checkHeader(thirdPageHeader)
                .checkText(thirdPageText)
                .checkGetStartedButtonNotVisible()
                .checkSkipContinueButtonsVisible()
                .goNextScreen()

                //four screen
                .checkHeader(fourthPageHeader)
                .checkText(fourthPageText)
                .checkGetStartedButtonVisible()
                .checkSkipContinueNotVisible()
                .getStarted();
    }

    @DisplayName("Сохранить статью")
    @Test
    void saveArticleTest() {
        String searchValue = "Appium";

        back();
        mainScreen.openSearchModalWindow();
        searchScreen.searchValue(searchValue);
        searchResultScreen.openFirstSearchResult();
        articleScreen.saveArticle()
                .goBack();
        searchResultScreen.pressBack();
        mainScreen.goToSavedSection();
        savedScreen.openFirstGroup()
                .checkArticleByName(searchValue);
    }

    @Test
    @DisplayName("Проверить, что есть результаты поиска")
    void successfulSearchAppiumTest() {
        String searchValue = "Selenide";

        back();
        mainScreen.openSearchModalWindow();
        searchScreen.searchValue(searchValue)
                .verifySearchResultNotEmpty();
    }
}
