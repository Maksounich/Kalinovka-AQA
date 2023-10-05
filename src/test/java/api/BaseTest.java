package api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import org.myProject.api.utils.PropertiesConfig;
import org.testng.annotations.BeforeSuite;

public class BaseTest {


    @BeforeSuite
    public void beforeTest() {
        PropertiesConfig.setUpProperties();

        RestAssured.baseURI = PropertiesConfig.baseURI;
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .build();
    }
}












