package screens;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.id;

public class SavedScreen {

    private final SelenideElement firstSavedGroup = $(id("org.wikipedia.alpha:id/item_title")),
            savedGroupTitle = $(id("org.wikipedia.alpha:id/item_title")),
            gotItButton = $(id("org.wikipedia.alpha:id/buttonView"));
    private final ElementsCollection articleTitle = $$(id("org.wikipedia.alpha:id/page_list_item_title"));

    @Step("Перейти в первую сохраненную группу")
    public SavedScreen openFirstGroup() {
        firstSavedGroup.click();
        gotItButton.click();
        savedGroupTitle.shouldHave(Condition.text("Saved"));
        return this;
    }

    @Step("Проверьте статью с названием \"{0}\"")
    public SavedScreen checkArticleByName(String articleName) {
        articleTitle.shouldHave(CollectionCondition.texts(articleName));
        return this;
    }

}
