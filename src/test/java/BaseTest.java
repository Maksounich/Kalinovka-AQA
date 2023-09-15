import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseTest {


    @BeforeSuite
    public void beforeTEst() {
        RestAssured.baseURI = "http://192.168.68.233:4069/api/v1";
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .build();
}
    //TODO write properties
    public static void properties() {
        System.out.println("baseURI" + new BaseTest().getPropertiesValue("baseURI"));
        System.out.println("URL" + new BaseTest().getPropertiesValue("URL"));
        System.out.println("password" + new BaseTest().getPropertiesValue("password"));
        System.out.println("confirm_password" + new BaseTest().getPropertiesValue("confirm_password"));
        System.out.println("username" + new BaseTest().getPropertiesValue("username"));
        System.out.println("name" + new BaseTest().getPropertiesValue("name"));
        System.out.println("email" + new BaseTest().getPropertiesValue("email"));
        System.out.println("office" + new BaseTest().getPropertiesValue("office"));
        System.out.println("mentor" + new BaseTest().getPropertiesValue("mentor"));
        System.out.println("signed_up" + new BaseTest().getPropertiesValue("signed_up"));
    }

    public String getPropertiesValue(String propertyName) {
        String propertyValue = "";
        Properties properties = new Properties();

        try (InputStream inputStream = this.getClass().getResourceAsStream("app.properties")) {
            properties.load(inputStream);
            propertyValue = properties.getProperty(propertyName);
        } catch (IOException e) {
            System.out.println(e);
        }
        return propertyValue;

    }
}












