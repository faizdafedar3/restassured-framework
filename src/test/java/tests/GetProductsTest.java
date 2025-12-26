package tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;
import base.BaseTest;

public class GetProductsTest extends BaseTest {

    @Test
    public void getAllProducts() {

        given()
            .log().all()
        .when()
            .get("/products")
        .then()
            .log().all()
            .statusCode(200)
            .body("size()", greaterThan(0))
            .body("[0].title", notNullValue())
            .body("[0].price", greaterThan(0f));
    }
}
