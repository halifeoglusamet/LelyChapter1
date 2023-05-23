package scenario.tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import scenario.base.BaseTest;
import scenario.models.AllUserResponse;
import scenario.models.User;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetAllUserTests extends BaseTest {

    private final String PATH = "/users ";
    AllUserResponse allUserResponse;

    @Test
    public void getAllBookingTest() {
        Response response = given(spec)
                .when()
                .get(PATH);

        response
                .then()
                .statusCode(200);

        response.prettyPrint();

        allUserResponse = response.as(AllUserResponse.class);

        List<User> userList = allUserResponse.getData();
        for (User user : userList) {
            Assert.assertEquals(String.valueOf(user.getId()).length(),7);
        }
    }
}
