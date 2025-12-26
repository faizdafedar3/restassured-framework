package tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;
import base.BaseTest;

public class CreateOrderTest extends BaseTest {

    @Test
    public void createOrder() {

        String payload =
                "{"
              + "\"userId\":1,"
              + "\"date\":\"2025-12-26\","
              + "\"products\":["
              +     "{"
              +         "\"productId\":1,"
              +         "\"quantity\":2"
              +     "},"
              +     "{"
              +         "\"productId\":2,"
              +         "\"quantity\":1"
              +     "}"
              + "]"
              + "}";

        given()
            .header("Content-Type", "application/json")
            .body(payload)
            .log().all()
        .when()
            .post("/carts")
            .then()
            .log().all()
            .statusCode(201)   // ✅ FIXED
            .body("id", notNullValue());

    }
}
