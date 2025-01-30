package tests;

import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.*;

public class SearchTests extends TestBase {

    @Test
    void successfulSearchTest() throws MalformedURLException, InterruptedException {
        $(accessibilityId("Search Wikipedia")).click();
        $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium");
        $$(className("android.widget.TextView")).shouldHave(sizeGreaterThan(0));
    }
}
