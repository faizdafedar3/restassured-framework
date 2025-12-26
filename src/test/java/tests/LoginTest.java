package tests;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import base.BaseTest;
import pojo.LoginRequest;
import pojo.LoginResponse;
import specs.RequestSpec;
import specs.ResponseSpec;

public class LoginTest extends BaseTest {

    public static String token;

    @Test
    public void loginAndGetToken() {

        LoginRequest login =
                new LoginRequest("mor_2314", "83r5^_");

        LoginResponse response =
        given()
            .spec(RequestSpec.getRequestSpec())
            .body(login)
        .when()
            .post("/auth/login")
        .then()
            .spec(ResponseSpec.successResponse())
            .extract()
            .as(LoginResponse.class);

        token = response.getToken();
        System.out.println("TOKEN = " + token);
    }
}
