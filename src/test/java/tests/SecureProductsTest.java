package tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;
import base.BaseTest;

public class SecureProductsTest extends BaseTest {

    @Test(dependsOnMethods = "tests.LoginTest.loginAndGetToken")
    public void getProductsWithToken() {

        given()
            .header("Authorization", "Bearer " + LoginTest.token)
            .log().all()
        .when()
            .get("/products")
        .then()
            .log().all()
            .statusCode(200)
            .body("size()", greaterThan(0));
    }
}
