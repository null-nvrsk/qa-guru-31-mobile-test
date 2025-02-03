package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.FIRST)
@Config.Sources({
        "classpath:remote.properties"
})
public interface ProjectConfig extends Config {
    // todo: app name / project name
//    @Key("appUrl")
//    String appUrl();

    @Key("app")
    String app();

    @Key("login")
    String login();

    @Key("password")
    String password();

    @Key("android.deviceModel")
    String deviceModel();

    @Key("android.platformVersion")
    String platformVersion();
}
