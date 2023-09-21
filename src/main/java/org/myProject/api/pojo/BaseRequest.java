package org.example.pojo;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.example.pojo.service.AuthService;

public class BaseRequest {

    public static Response postReg(Object body, String endPoint) {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .body(body)
                .log().all()
                .when()
                .post(endPoint)
                .then().log().all()
                .extract().response();
    }
    public static Response postWithAuth(Object body, String endPoint) {
        return RestAssured
                .given()
                .header("Authorization", "Bearer " + AuthService.getToken())
                .contentType(ContentType.JSON)
                .body(body)
                .log().all()
                .when()
                .post(endPoint)
                .then().log().all()
                .extract().response();
    }


    public static Response putChange(Object password, String token) {
        return RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .body(password)
                .log().all()
                .when()
                .put("/user/password")
                .then().log().all()
                .extract().response();
    }

    public static Response getReq(String token, String end) {
        return RestAssured
                .given()
                .header("Authorization", "Bearer " + token)
                .log().all()
                .when()
                .get(end)
                .then().log().all()
                .extract().response();
    }



}
