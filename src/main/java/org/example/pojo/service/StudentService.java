package org.example.pojo.service;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.example.pojo.StudentPojo;
import org.example.pojo.StudentResponse;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.example.pojo.BaseRequest.postWithAuth;


public class StudentService {

    private static final List<StudentResponse> students = new ArrayList<>();

    public static StudentResponse createStudent(StudentPojo studentRequest, int status) {
        Response response = postWithAuth(studentRequest, "/student");

        Assert.assertEquals(response.getStatusCode(), status);

        StudentResponse studentResponse = response.as(StudentResponse.class);
        students.add(studentResponse);
        return studentResponse;
    }

    public static List<StudentResponse> getStudents() {
        return students;
    }

    public static void deleteStudent(StudentResponse studentResponse) {
        Map<String, Object> delete = new HashMap<>();
        delete.put("email", studentResponse.getEmail());
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + AuthService.getToken())
                .body(delete)
                .when()
                .delete("/student")
                .then().log().all()
                .extract().response();

        Assertions.assertThat(response.getStatusCode()).isEqualTo(200);
    }
}
