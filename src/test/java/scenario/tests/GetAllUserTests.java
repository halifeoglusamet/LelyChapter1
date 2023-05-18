package scenario.tests;

import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;
import scenario.base.BaseTest;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertTrue;

public class GetAllUserTests extends BaseTest {

    private final String PATH = "/users ";
    JSONObject jsonResponse;
    JSONArray dataArray;

    @Test
    public void getAllBookingTest() {
        Response response = given(spec)
                .when()
                .get(PATH);

        response
                .then()
                .statusCode(200);

        var responseBody = response.getBody().asString();

        jsonResponse = new JSONObject(responseBody);
        dataArray = jsonResponse.getJSONArray("data");

        boolean allIdsAre7Digits = true;

        for (int i = 0; i < dataArray.length(); i++) {
            var user = dataArray.getJSONObject(i);
            var id = user.getInt("id");
            if (String.valueOf(id).length() != 7) {
                allIdsAre7Digits = false;
                break;
            }
        }
        assertTrue(allIdsAre7Digits, "Not all data.id values are 7-digit integers.");
    }
}
