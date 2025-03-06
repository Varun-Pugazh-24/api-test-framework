package base;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import utils.SpotifyAuth;
import config.ConfigLoader;

public class BaseTest {
    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = ConfigLoader.get("SPOTIFY_API_BASE_URL");
    }

    public static String getAuthToken() {
        return "Bearer " + SpotifyAuth.getAccessToken();
    }
}
