package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigsProvider {
    public static final BrowserstackConfig browserstackConfig = ConfigFactory.create(BrowserstackConfig.class,
            System.getProperties());

    public static final LocalConfig localConfig = ConfigFactory.create(LocalConfig.class,
            System.getProperties());
}
