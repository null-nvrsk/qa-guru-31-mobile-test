package helpers;

import config.ProjectConfig;
import org.aeonbits.owner.ConfigFactory;

import java.net.MalformedURLException;
import java.net.URL;

import static io.restassured.RestAssured.given;

public class Browserstack {

    private static ProjectConfig config = ConfigFactory.create(ProjectConfig.class);

    public static URL getBrowserstackUrl() {
        try {
            // @hub-cloud.browserstack.com/wd/hub
            // //https://hub.browserstack.com/wd/hub
            return new URL("https://" + config.login() + ":" + config.password() + "@hub.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    // curl -u "maksimskomorokho_3reSti:C4Nqx2RgurSZCUaUqFMt" -X GET "https://api.browserstack.com/app-automate/sessions/<session-id>.json"
    // automation_session.video_url

    public static String videoUrl(String sessionId) {
        String url = "https://api.browserstack.com/app-automate/sessions/" + sessionId + ".json";
        return given()
                .auth().basic(config.login(), config.password())
                .get(url)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}
