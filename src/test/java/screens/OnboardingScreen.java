package screens;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class OnboardingScreen {

    private final SelenideElement onboardingScreenHeader = $(id("org.wikipedia.alpha:id/primaryTextView")),
            onboardingScreenText = $(id("org.wikipedia.alpha:id/secondaryTextView")),
            continueButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")),
            skipButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_skip_button")),
            getStartedButton = $(id("org.wikipedia.alpha:id/fragment_onboarding_done_button")),
            addLanguageButton = $(id("org.wikipedia.alpha:id/addLanguageButton")),
            languageList = $(id("org.wikipedia.alpha:id/option_label"));

    @Step("Проверить, что в шапке есть текст \"{0}\"")
    public OnboardingScreen checkHeader(String header) {
        onboardingScreenHeader.shouldHave(text(header));
        return this;
    }

    @Step("Проверить, что на странице есть текст \"{0}\"")
    public OnboardingScreen checkText(String text) {
        onboardingScreenText.shouldHave(text(text));
        return this;
    }

    @Step("Проверить, что видны кнопки \"Skip\" и \"Continue\"")
    public OnboardingScreen checkSkipContinueButtonsVisible() {
        skipButton.shouldBe(Condition.visible);
        continueButton.shouldBe(Condition.visible);
        return this;
    }

    @Step("Проверить, что нет кнопок \"Skip\" и \"Continue\"")
    public OnboardingScreen checkSkipContinueNotVisible() {
        skipButton.shouldNotBe(Condition.visible);
        continueButton.shouldNotBe(Condition.visible);
        return this;
    }

    @Step("Перейти на следующую страницу")
    public OnboardingScreen goNextScreen() {
        continueButton.click();
        return this;
    }

    @Step("Проверить, что видна кнопка \"Get Started\"")
    public OnboardingScreen checkGetStartedButtonVisible() {
        getStartedButton.shouldBe(Condition.visible);
        return this;
    }

    @Step("Проверить, что нет кнопок \"Get Started\"")
    public OnboardingScreen checkGetStartedButtonNotVisible() {
        getStartedButton.shouldNotBe(Condition.visible);
        return this;
    }

    @Step("Нажать на кнопку \"Get Started\"")
    public OnboardingScreen getStarted() {
        getStartedButton.click();
        return this;
    }

    @Step("Проверить наличия языка в списке")
    public OnboardingScreen checkLanguageList(String languages) {
        languageList.shouldHave(text(languages));
        return this;
    }

    @Step("Проверить, что есть кнопка \"Add Language\"")
    public OnboardingScreen checkAddLanguageButton() {
        addLanguageButton.shouldBe(Condition.visible);
        return this;
    }
}
