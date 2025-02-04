package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:remote.properties"
})
public interface BrowserstackConfig extends Config {
    @Key("browserstack.userName")
    String username();

    @Key("browserstack.accessKey")
    String accessKey();

    @Key("browserstack.url")
    String url();

    @Key("browserstack.projectName")
    String projectName();

    @Key("browserstack.platformName")
    String platformName();

    @Key("browserstack.platformVersion")
    String platformVersion();

    @Key("browserstack.deviceName")
    String deviceName();

    @Key("browserstack.app")
    String app();
}
