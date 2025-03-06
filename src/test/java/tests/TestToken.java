package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestToken extends BaseTest {

    @Test
    public void testToken() {
        String token = getAuthToken();
        assertTrue(token.contains("Bearer"));
        System.out.println(token);
    }

}
