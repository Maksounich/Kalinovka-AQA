import io.restassured.response.Response;
import login.Login;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Specifications;
import static io.restassured.RestAssured.given;

public class LoginTests {
    private final String URL = "https://reqres.in/";

    @Test
    public void successesLoginTest(){
        final String token = "QpwL5tke4Pnpja7X4";
        Specifications.setSpecifications(Specifications.requestSpec(URL), Specifications.responseSpec(200));
        Login user = new Login("eve.holt@reqres.in", "cityslicka");
        Response response = given()
                .body(user)
                .when()
                .post("api/login")
                .then().log().all()
                .extract().response();
        String actTocken = response.jsonPath().get("token");
        Assert.assertEquals(actTocken, token);
    }

    @Test
    public void failedLoginTest(){
        Specifications.setSpecifications(Specifications.requestSpec(URL), Specifications.responseSpec(400));
        Login user = new Login("eve.holt@reqres.in", "");
        Response response = given()
                .body(user)
                .when()
                .post("api/login")
                .then().log().all()
                .extract().response();
        String error = response.jsonPath().get("error");
        Assert.assertEquals(error, "Missing password");
    }
}

