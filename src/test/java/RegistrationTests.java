import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import register.Register;
import register.RegisterSuccess;
import utils.Specifications;

import static io.restassured.RestAssured.given;

public class RegistrationTests {
    private final String URL = "https://reqres.in/";

    @Test
    public void successesRegistrationTest(){
        final Integer id = 4;
        final String token = "QpwL5tke4Pnpja7X4";
        Specifications.setSpecifications(Specifications.requestSpec(URL), Specifications.responseSpec(200));
        Register user = new Register("eve.holt@reqres.in", "pistol");
        RegisterSuccess registerSuccess = given()
                .body(user)
                .when()
                .post("api/register")
                .then().log().all()
                .extract().as(RegisterSuccess.class);

        Assert.assertEquals(id, registerSuccess.getId());
        Assert.assertEquals(token, registerSuccess.getToken());
    }

    @Test
    public void failedRegistrationTest() {
        Specifications.setSpecifications(Specifications.requestSpec(URL), Specifications.responseSpec(400));
        Register user = new Register("sydney@fife", "");
        Response response = given()
                .body(user)
                .when()
                .post("api/register")
                .then().log().all()
                .extract().response();
        String error = response.jsonPath().get("error");
        Assert.assertEquals(error,"Missing password");
    }
}
