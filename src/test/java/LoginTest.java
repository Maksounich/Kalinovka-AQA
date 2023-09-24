import login.Login;
import login.SuccessLogin;
import org.junit.Assert;
import org.junit.Test;
import registration.UnSuccessedReg;
import specifications.Specifications;

import java.time.LocalTime;

import static io.restassured.RestAssured.given;

public class LoginTest {
    private static final String URL = "https://reqres.in";
    @Test
    public void successLogin()
    {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpec(200));

        Login user = new Login("eve.holt@reqres.in", "cityslicka");

        SuccessLogin successLogin = given()
                .body(user)
                .when()
                .post("/api/login")
                .then().log().all()
                .extract().as(SuccessLogin.class);

        String token = "QpwL5tke4Pnpja7X4";

        Assert.assertEquals(token, successLogin.getToken());
    }

    @Test
    public void unSuccessLogin()
    {
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpec(400));

        Login user = new Login("eve.holt@reqres.in", "");

        UnSuccessedReg unSuccessedReg = given()
                .body(user)
                .when()
                .post("/api/login")
                .then().log().all()
                .extract().as(UnSuccessedReg.class);

        String error = "Missing password";

        Assert.assertEquals(unSuccessedReg.getError(), error);
    }
}
