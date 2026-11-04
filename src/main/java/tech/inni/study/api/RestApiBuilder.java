package tech.inni.study.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.basic;

public class RestApiBuilder {

    private static final String BASE_URI = "http://localhost:8080";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "secret123";

    private static RequestSpecification baseSpec;

    public static RequestSpecification getBuilder() {
        if (baseSpec == null) {
            baseSpec = new RequestSpecBuilder()
                    .setBaseUri(BASE_URI)
                    .setContentType("application/json")
                    .setAuth(basic(USERNAME, PASSWORD))
                    .log(LogDetail.ALL)
                    .build();
        }
        return baseSpec;
    }
}