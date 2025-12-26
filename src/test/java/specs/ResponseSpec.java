package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.*;

public class ResponseSpec {

    public static ResponseSpecification successResponse() {

        return new ResponseSpecBuilder()
                .expectStatusCode(anyOf(is(200), is(201)))
                .log(io.restassured.filter.log.LogDetail.ALL)
                .build();
    }
}
