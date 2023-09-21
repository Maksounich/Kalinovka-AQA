import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import org.example.utils.PropertiesConfig;
import org.testng.annotations.BeforeSuite;

public class BaseTest {


    @BeforeSuite
    public void beforeTEst() {
        PropertiesConfig.setUpProperties();

        RestAssured.baseURI = PropertiesConfig.baseURI;
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .build();
    }
}












