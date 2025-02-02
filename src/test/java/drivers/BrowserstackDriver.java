package drivers;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        String browserstackUser = "maksimskomorokho_3reSti";
        String browserstackKey = "C4Nqx2RgurSZCUaUqFMt";

        MutableCapabilities caps = new MutableCapabilities();

        // Set your access credentials
//        caps.setCapability("browserstack.user", browserstackUser);
//        caps.setCapability("browserstack.key", browserstackKey);

        // Set URL of the application under test
        //    caps.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");
        caps.setCapability("app", "bs://sample.app");

        // Specify device and os_version for testing
        caps.setCapability("device", "Google Pixel 3");
        caps.setCapability("os_version", "9.0");

        // Set other BrowserStack capabilities
        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "first_test");


        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        try {
            return new RemoteWebDriver(
//                    new URL("https://hub.browserstack.com/wd/hub"), caps);
                    new URL("https://" + browserstackUser + ":" + browserstackKey
                            + "@hub.browserstack.com/wd/hub"),
                    caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

    }
}
