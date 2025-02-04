package helpers;

import static config.ConfigsProvider.browserstackConfig;
import static io.restassured.RestAssured.given;

public class Browserstack {

    public static String videoUrl(String sessionId) {
        String url = "https://api.browserstack.com/app-automate/sessions/" + sessionId + ".json";
        return given()
                .auth().basic(browserstackConfig.username(), browserstackConfig.accessKey())
                .get(url)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("automation_session.video_url");
    }
}
