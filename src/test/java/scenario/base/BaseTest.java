package scenario.base;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.given;

public class BaseTest extends TestHelper {

    @BeforeClass
    public void setUp() {

        setEmail();
        setName();
        setRequestSpec();
        initToken();
    }

    public Response createPlanner(String email, String name, String gender, String status) {

        Response response = given()
                .spec(spec)
                .when()
                .contentType(ContentType.JSON)
                .body(plannerObject(email, name, gender, status))
                .post("/");

        response
                .then()
                .statusCode(200);

        return response;

    }

    public String plannerObject(String email, String name, String gender, String status) {
        JSONObject body = new JSONObject();
        body.put("email", email);
        body.put("name", name);
        body.put("gender", gender);
        body.put("status", status);
        return body.toString();
    }
}
