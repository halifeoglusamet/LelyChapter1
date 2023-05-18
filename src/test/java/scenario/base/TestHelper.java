package scenario.base;

import data.management.UserDataManagement;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

import java.util.Arrays;

public class TestHelper {

    protected static String email;
    protected static String name;
    protected static UserDataManagement userDataManagement = UserDataManagement.getInstance();
    protected static RequestSpecification spec;
    protected static final ThreadLocal<String> token = new ThreadLocal<>();

    protected static void setEmail() {

        email = userDataManagement.generateRandomUserEmail();
    }

    protected static void setName(){
        name = userDataManagement.generateRandomName();
    }

    protected static void setRequestSpec() {

        spec = new RequestSpecBuilder()
                .setBaseUri("https://gorest.co.in/public/v1")
                .addFilters(Arrays.asList(new RequestLoggingFilter(), new ResponseLoggingFilter())).build();

    }

    protected static void initToken(){
        token.set("1db9c9b6c959682be7c96f74ca532c3cb0bd331f46b86a92602f8d319481b6f5");
    }


}
