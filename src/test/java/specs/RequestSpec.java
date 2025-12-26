package specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpec {

    public static RequestSpecification getRequestSpec() {

        return new RequestSpecBuilder()
                .setBaseUri("https://fakestoreapi.com")
                .setContentType("application/json")
                .log(io.restassured.filter.log.LogDetail.ALL)
                .build();
    }
}
