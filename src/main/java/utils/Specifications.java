package utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specifications {
    public static RequestSpecification requestSpec(String url){
        return new RequestSpecBuilder()
                .setBaseUri(url)
                .setContentType(ContentType.JSON)
                .build();
    }

    public static ResponseSpecification responseSpec(int expStatusCode){
        return new ResponseSpecBuilder()
                .expectStatusCode(expStatusCode)
                .build();
    }

    public static void setSpecifications(RequestSpecification request, ResponseSpecification response){
        RestAssured.requestSpecification = request;
        RestAssured.responseSpecification = response;
    }
}