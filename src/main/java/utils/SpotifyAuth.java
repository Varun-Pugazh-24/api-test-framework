package utils;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import java.util.Base64;

public class SpotifyAuth {
    private static String accessToken;

    public static String getAccessToken() {
        if (accessToken == null) {
            generateNewToken();
        }
        return accessToken;
    }

    private static void generateNewToken() {
        String clientId = config.ConfigLoader.get("SPOTIFY_CLIENT_ID");
        String clientSecret = config.ConfigLoader.get("SPOTIFY_CLIENT_SECRET");
        String tokenUrl = config.ConfigLoader.get("SPOTIFY_TOKEN_URL");

        String authHeader = "Basic " + Base64.getEncoder().encodeToString((clientId + ":" + clientSecret).getBytes());

        Response response = given()
                .header("Authorization", authHeader)
                .contentType("application/x-www-form-urlencoded")
                .formParam("grant_type", "client_credentials")
                .when()
                .post(tokenUrl)
                .then()
                .extract().response();

        accessToken = response.jsonPath().getString("access_token");
    }
}
