package helpers;

import static io.restassured.RestAssured.given;
import static io.restassured.specification.ProxySpecification.auth;

public class Browserstack {

    // curl -u "maksimskomorokho_3reSti:C4Nqx2RgurSZCUaUqFMt" -X GET "https://api.browserstack.com/app-automate/sessions/<session-id>.json"
    // automation_session.video_url
    public static String videoUrl(String sessionId) {
//        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);
        String url = "https://api.browserstack.com/app-automate/sessions/" + sessionId + ".json";
        return given()
                .auth().basic("maksimskomorokho_3reSti", "C4Nqx2RgurSZCUaUqFMt")
                .get(url)
                .then()
                .log().status() // ??
                .log().body() // ???
                .statusCode(200)
                .extract().path("automation_session.video_url");

    }
}
