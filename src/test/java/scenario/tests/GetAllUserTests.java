package scenario.tests;

import org.testng.annotations.Test;
import scenario.base.BaseTest;

import static io.restassured.RestAssured.given;

public class GetAllUserTests extends BaseTest {

    @Test
    public void getAllBookingTest() {
        given(spec)
                .when()
                .get("/users")
                .then()
                .statusCode(200);
    }
}
