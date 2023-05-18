package scenario.tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import scenario.base.BaseTest;
import scenario.models.ErrorResponse;
import scenario.models.User;
import scenario.models.UserResponse;

import static io.restassured.RestAssured.given;

public class CreateUserTests extends BaseTest {

    private final String MALE = "male";
    private final String ACTIVE = "active";
    private final String AUTHORIZATION = "Authorization";
    private final String BEARER = "Bearer ";
    private final String PATH = "/users ";
    UserResponse userResponse;
    ErrorResponse errorResponse;

    @Test
    public void createUser() {

        User planner = new User(name, email, MALE, ACTIVE);

        Response response = given(spec)
                .contentType(ContentType.JSON)
                .header(AUTHORIZATION, BEARER + token.get())
                .body(planner)
                .post(PATH);

        response
                .then()
                .statusCode(201);

        userResponse = response.as(UserResponse.class);

        Assert.assertEquals(email, userResponse.getData().getEmail());
        Assert.assertEquals(name, userResponse.getData().getName());
        Assert.assertEquals(MALE, userResponse.getData().getGender());
        Assert.assertEquals(ACTIVE, userResponse.getData().getStatus());
    }

    @Test(priority = 1)
    public void createUserWithDuplicateEmail() {

        String ERROR_MESSAGE = "has already been taken";

        User planner = new User(name, email, MALE, ACTIVE);

        var response = given(spec)
                .contentType(ContentType.JSON)
                .header(AUTHORIZATION, BEARER + token.get())
                .body(planner)
                .post(PATH);

        response
                .then()
                .statusCode(422);


        errorResponse = response.as(ErrorResponse.class);

        Assert.assertEquals(ERROR_MESSAGE, errorResponse.getData().get(0).getMessage());
    }
}
