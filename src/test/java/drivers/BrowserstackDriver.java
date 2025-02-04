package drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import static config.ConfigsProvider.browserstackConfig;

public class BrowserstackDriver implements WebDriverProvider {

    @Nonnull
    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();

        HashMap<String, Object> bstackOptions = new HashMap<String, Object>();
        bstackOptions.put("userName", browserstackConfig.username());
        bstackOptions.put("accessKey", browserstackConfig.accessKey());
        bstackOptions.put("projectName", browserstackConfig.projectName());
        caps.setCapability("bstack:options", bstackOptions);

        caps.setCapability("platformName", browserstackConfig.platformName());
        caps.setCapability("appium:platformVersion", browserstackConfig.platformVersion());
        caps.setCapability("appium:deviceName", browserstackConfig.deviceName());
        caps.setCapability("appium:app", browserstackConfig.app());

        try {
            return new AndroidDriver(new URL(browserstackConfig.url()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
