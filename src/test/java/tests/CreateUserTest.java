package tests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;
import base.BaseTest;

public class CreateUserTest extends BaseTest {

    @Test
    public void createUser() {

        String payload =
                "{"
              + "\"email\":\"faiz@test.com\","
              + "\"username\":\"faizuser\","
              + "\"password\":\"pass123\","
              + "\"name\":{"
              +     "\"firstname\":\"Faiz\","
              +     "\"lastname\":\"Ahmed\""
              + "},"
              + "\"address\":{"
              +     "\"city\":\"Hyderabad\","
              +     "\"street\":\"Street 1\","
              +     "\"number\":10,"
              +     "\"zipcode\":\"500001\","
              +     "\"geolocation\":{"
              +         "\"lat\":\"17.3850\","
              +         "\"long\":\"78.4867\""
              +     "}"
              + "},"
              + "\"phone\":\"9999999999\""
              + "}";

        given()
            .header("Content-Type", "application/json")
            .body(payload)
            .log().all()
        .when()
            .post("/users")
        .then()
        .log().all()
        .statusCode(201)   // ✅ FIXED
        .body("id", notNullValue());

    }
}
